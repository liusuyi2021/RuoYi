package com.ruoyi.project.traffic.crossinginfo.service.impl;

import java.util.List;
import com.alibaba.fastjson.JSON;
import com.ruoyi.common.constant.TrafficConstants;
import com.ruoyi.common.utils.mqtt.MqttPushClient;
import com.ruoyi.framework.aspectj.lang.annotation.DataScope;
import com.ruoyi.project.traffic.laneinfo.domain.TrafficLaneInfo;
import com.ruoyi.project.traffic.laneinfo.mapper.TrafficLaneInfoMapper;
import org.springframework.stereotype.Service;
import com.ruoyi.project.traffic.crossinginfo.mapper.TrafficCrossingInfoMapper;
import com.ruoyi.project.traffic.crossinginfo.domain.TrafficCrossingInfo;
import com.ruoyi.project.traffic.crossinginfo.service.ITrafficCrossingInfoService;
import javax.annotation.Resource;

/**
 * 卡口信息Service业务层处理
 * 
 * @author 刘苏义
 * @date 2022-05-15
 */
@Service("TrafficCrossing")
public class TrafficCrossingInfoServiceImpl implements ITrafficCrossingInfoService 
{
    @Resource
    private TrafficCrossingInfoMapper trafficCrossingInfoMapper;
    @Resource
    private TrafficLaneInfoMapper trafficLaneInfoMapper;
    @Resource
    private MqttPushClient mqttPushClient;
    /**
     * 查询卡口信息
     * 
     * @param crossingId 卡口信息主键
     * @return 卡口信息
     */
    @Override
    public TrafficCrossingInfo selectTrafficCrossingInfoByCrossingId(Long crossingId)
    {
        return trafficCrossingInfoMapper.selectTrafficCrossingInfoByCrossingId(crossingId);
    }

    /**
     * 查询卡口信息列表
     * 
     * @param trafficCrossingInfo 卡口信息
     * @return 卡口信息
     */
    @Override
    @DataScope(deptAlias = "d", userAlias = "u")
    public List<TrafficCrossingInfo> selectTrafficCrossingInfoList(TrafficCrossingInfo trafficCrossingInfo)
    {
        return trafficCrossingInfoMapper.selectTrafficCrossingInfoList(trafficCrossingInfo);
    }
    /**
     * 查询所有卡口信息列表
     * @return 卡口信息
     */
    public List<TrafficCrossingInfo>  selectTrafficCrossingInfoAll()
    {
        return trafficCrossingInfoMapper.selectTrafficCrossingInfoAll();
    }
    /**
     * 新增卡口信息
     * 
     * @param trafficCrossingInfo 卡口信息
     * @return 结果
     */
    @Override
    public int insertTrafficCrossingInfo(TrafficCrossingInfo trafficCrossingInfo)
    {
        return trafficCrossingInfoMapper.insertTrafficCrossingInfo(trafficCrossingInfo);
    }

    /**
     * 修改卡口信息
     * 
     * @param trafficCrossingInfo 卡口信息
     * @return 结果
     */
    @Override
    public int updateTrafficCrossingInfo(TrafficCrossingInfo trafficCrossingInfo)
    {
        return trafficCrossingInfoMapper.updateTrafficCrossingInfo(trafficCrossingInfo);
    }

    /**
     * 批量删除卡口信息
     * 
     * @param crossingIds 需要删除的卡口信息主键
     * @return 结果
     */
    @Override
    public int deleteTrafficCrossingInfoByCrossingIds(Long[] crossingIds)
    {
        for (Long cossingid:crossingIds) {
            TrafficLaneInfo trafficLaneInfo = trafficLaneInfoMapper.selectTrafficLaneInfoByCrossingId(cossingid);
            if(trafficLaneInfo!=null) {
                trafficLaneInfo.setFlag(2);
                String data = JSON.toJSONString(trafficLaneInfo);
                mqttPushClient.publish(0, false, "deploy", data);
            }
            trafficLaneInfoMapper.deleteTrafficLaneInfoByCrossingId(cossingid);
        }
        return trafficCrossingInfoMapper.deleteTrafficCrossingInfoByCrossingIds(crossingIds);
    }

    /**
     * 删除卡口信息信息
     * 
     * @param crossingId 卡口信息主键
     * @return 结果
     */
    @Override
    public int deleteTrafficCrossingInfoByCrossingId(Long crossingId)
    {
        return trafficCrossingInfoMapper.deleteTrafficCrossingInfoByCrossingId(crossingId);
    }
    /**
     * 获取最近15分钟的卡口的流量
     */
    @Override
    public List<TrafficCrossingInfo> getTrafficCrossingInfoPassDataCount()
    {
        List<TrafficCrossingInfo> trafficCrossingInfos = trafficCrossingInfoMapper.selectTrafficCrossingInfoPassDataCount();
        return  trafficCrossingInfos;
    }
    /**
     * 获取最近15分钟的违法的流量
     */
    @Override
    public List<TrafficCrossingInfo> getTrafficCrossingInfoAlarmDataCount() {
        List<TrafficCrossingInfo> trafficCrossingInfos = trafficCrossingInfoMapper.selectTrafficCrossingInfoAlarmDataCount();
        return  trafficCrossingInfos;
    }

    /**
     * 校验卡口编号是否唯一
     *
     * @param crossingBh 用户名
     * @return
     */
    @Override
    public String checkCrossingBhUnique(String crossingBh)
    {
        int count = trafficCrossingInfoMapper.checkCrossingBhUnique(crossingBh);
        if (count > 0)
        {
            return TrafficConstants.CROSSING_BH_NOT_UNIQUE;
        }
        return TrafficConstants.CROSSING_BH_UNIQUE;
    }
}
