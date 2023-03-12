package com.ruoyi.project.traffic.laneinfo.service.impl;


import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.ruoyi.common.utils.StringUtils;
import com.ruoyi.common.utils.mqtt.MqttPushClient;
import com.ruoyi.framework.aspectj.lang.annotation.DataScope;
import com.ruoyi.framework.web.domain.Ztree;
import com.ruoyi.project.system.dept.domain.Dept;
import com.ruoyi.project.system.dept.mapper.DeptMapper;
import com.ruoyi.project.traffic.channelinfo.domain.TrafficChannelInfo;
import com.ruoyi.project.traffic.channelinfo.mapper.TrafficChannelInfoMapper;
import com.ruoyi.project.traffic.crossinginfo.domain.TrafficCrossingInfo;
import com.ruoyi.project.traffic.crossinginfo.mapper.TrafficCrossingInfoMapper;
import com.ruoyi.project.traffic.deviceInfo.domain.TrafficDeviceInfo;
import com.ruoyi.project.traffic.deviceInfo.mapper.TrafficDeviceInfoMapper;
import com.ruoyi.project.traffic.laneinfo.domain.TrafficLaneInfo;
import com.ruoyi.project.traffic.laneinfo.mapper.TrafficLaneInfoMapper;
import com.ruoyi.project.traffic.laneinfo.service.ITrafficLaneInfoService;
import org.springframework.stereotype.Service;


import javax.annotation.Resource;
import java.util.*;

/**
 * 通道信息Service业务层处理
 *
 * @author 刘苏义
 * @date 2022-05-17
 */
@Service
public class TrafficLaneInfoServiceImpl implements ITrafficLaneInfoService {
    @Resource
    private TrafficChannelInfoMapper trafficChannelInfoMapper;
    @Resource
    private TrafficDeviceInfoMapper trafficDeviceInfoMapper;
    @Resource
    private TrafficCrossingInfoMapper trafficCrossingInfoMapper;
    @Resource
    private DeptMapper deptMapper;
    @Resource
    private TrafficLaneInfoMapper trafficLaneInfoMapper;
    @Resource
    private MqttPushClient mqttPushClient;

    /**
     * 对象转部门树
     *
     * @param DeptList 部门列表
     * @param DevList  部门列表
     * @param ChanList 通道列表
     * @return 树结构列表
     */
    public List<Ztree> initZtree(Long crossingId, List<Dept> DeptList, List<TrafficDeviceInfo> DevList, List<TrafficChannelInfo> ChanList) {
        List<TrafficLaneInfo> LaneList = trafficLaneInfoMapper.selectTrafficLaneInfoList();
        List<Long> deployLanes = new ArrayList<Long>();
        for (TrafficLaneInfo lane : LaneList) {
            deployLanes.add(lane.getChannelId());
        }
        List<Ztree> ztrees = new ArrayList<Ztree>();
        boolean isCheck = StringUtils.isNotNull(ChanList);
        for (Dept dept : DeptList) {/*组织树*/
            //Ztree ztree = new Ztree();
            //ztree.setId(dept.getDeptId());
            //ztree.setpId(dept.getParentId());
            //ztree.setName(dept.getDeptName());
            //ztree.setTitle(dept.getDeptName());
            //ztrees.add(ztree);
            for (TrafficDeviceInfo dev : DevList) {/*设备树*/
                if (dept.getDeptId().equals(dev.getDeptId())) {
                    Ztree devZtree = new Ztree();
                    devZtree.setId(dev.getDeviceId());
                    devZtree.setpId(dept.getDeptId());
                    devZtree.setName("设备：" + dev.getDeviceName());
                    devZtree.setTitle(dev.getDeviceName());
                    ztrees.add(devZtree);

                    for (TrafficChannelInfo chan : ChanList) {/*通道树*/
                        if (chan.getDeviceId().equals(dev.getDeviceId())) {

                            Ztree Chanztree = new Ztree();
                            Chanztree.setId(chan.getChannelId());
                            Chanztree.setpId(dev.getDeviceId());
                            Chanztree.setName("通道" + chan.getChanIndex() + "：" + chan.getChanName());
                            Chanztree.setTitle(chan.getChanName());
                            if (deployLanes.contains(chan.getChannelId())) {
                                Chanztree.setChecked(true);
                            } else {
                                Chanztree.setChecked(false);
                            }
                            ztrees.add(Chanztree);
                        }
                    }
                }
            }
        }
        return ztrees;
    }

    @Override
    @DataScope(deptAlias = "d")
    public List<Ztree> selectLaneTree(Long crossingId, TrafficDeviceInfo dev, TrafficChannelInfo chan) {

        TrafficCrossingInfo trafficCrossingInfo = trafficCrossingInfoMapper.selectTrafficCrossingInfoByCrossingId(crossingId);
        Dept dept = new Dept();
        dept.setDeptId(trafficCrossingInfo.getDeptId());
        List<Dept> deptList = deptMapper.selectDeptList(dept);
        List<TrafficDeviceInfo> devList = trafficDeviceInfoMapper.selectTrafficDeviceInfoList(dev);
        List<TrafficChannelInfo> chanList = trafficChannelInfoMapper.selectTrafficChannelInfoList(chan);
        List<Ztree> ztrees = initZtree(crossingId, deptList, devList, chanList);
        return ztrees;
    }

    /**
     * 插入线路
     *
     * @param crossingId 卡口ID
     * @param jsonstr    设备通道json数组
     * @return 所有通道信息
     */
    public void SetLaneInfo(Long crossingId, String jsonstr) {
        /*遍历已布防的通道*/
        List<TrafficLaneInfo> LaneInfos = trafficLaneInfoMapper.selectTrafficLaneInfoListByCrossingId(crossingId);
        for (TrafficLaneInfo LaneInfo : LaneInfos) {
            LaneInfo.setFlag(2);
            /*全部撤防*/
            mqttPushClient.publish(0, false, "deploy", JSON.toJSONString(LaneInfo));
        }
        /*清空对应卡口的线路*/
        trafficLaneInfoMapper.deleteTrafficLaneInfoByCrossingId(crossingId);
        /*重新获取已勾选的通道*/
        JSONArray jsonArray = JSONArray.parseArray((String) jsonstr);//将集合转成JSONArray
        for (int i = 0; i < jsonArray.size(); i++) {  //遍历JSONArray数组
            JSONObject object = JSONArray.parseObject(jsonArray.get(i).toString()); //将JSONArray数组转成JSONObject对象
            Long chanid = object.getLong("id");
            Long devid = object.getLong("pId");
            //入库
            TrafficLaneInfo laneInfo = new TrafficLaneInfo();
            laneInfo.setChannelId(chanid);
            laneInfo.setDeviceId(devid);
            laneInfo.setCrossingId(crossingId);
            laneInfo.setState(1);
            laneInfo.setFlag(1);
            trafficLaneInfoMapper.insertTrafficLaneInfo(laneInfo);
        }
        /*遍历已布防的通道*/
        List<TrafficLaneInfo> deployedLaneInfos = trafficLaneInfoMapper.selectTrafficLaneInfoListByCrossingId(crossingId);
        for (TrafficLaneInfo LaneInfo : deployedLaneInfos) {
            LaneInfo.setFlag(1);
            /*全部布防*/
            mqttPushClient.publish(0, false, "deploy", JSON.toJSONString(LaneInfo));
        }
    }
}
