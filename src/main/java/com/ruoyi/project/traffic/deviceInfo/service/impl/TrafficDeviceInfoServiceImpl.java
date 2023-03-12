package com.ruoyi.project.traffic.deviceInfo.service.impl;

import java.util.List;

import com.alibaba.fastjson.JSON;
import com.ruoyi.common.constant.TrafficConstants;
import com.ruoyi.common.utils.DateUtils;
import com.ruoyi.common.utils.mqtt.MqttPushClient;
import com.ruoyi.framework.aspectj.lang.annotation.DataScope;
import com.ruoyi.project.traffic.channelinfo.service.ITrafficChannelInfoService;
import org.springframework.stereotype.Service;
import com.ruoyi.project.traffic.deviceInfo.mapper.TrafficDeviceInfoMapper;
import com.ruoyi.project.traffic.deviceInfo.domain.TrafficDeviceInfo;
import com.ruoyi.project.traffic.deviceInfo.service.ITrafficDeviceInfoService;

import javax.annotation.Resource;

/**
 * 设备信息Service业务层处理
 *
 * @author 刘苏义
 * @date 2022-05-12
 */
@Service("TrafficDevice")
public class TrafficDeviceInfoServiceImpl implements ITrafficDeviceInfoService {
    @Resource
    private TrafficDeviceInfoMapper trafficDeviceInfoMapper;
    @Resource
    private MqttPushClient mqttPushClient;
    @Resource
    private ITrafficChannelInfoService trafficChannelInfoService;

    /**
     * 查询设备信息
     *
     * @param deviceId 设备信息主键
     * @return 设备信息
     */
    @Override
    public TrafficDeviceInfo selectTrafficDeviceInfoById(Long deviceId) {
        return trafficDeviceInfoMapper.selectTrafficDeviceInfoById(deviceId);
    }

    /**
     * 查询设备信息列表
     *
     * @param trafficDeviceInfo 设备信息
     * @return 设备信息
     */
    @Override
    @DataScope(deptAlias = "d", userAlias = "u")
    public List<TrafficDeviceInfo> selectTrafficDeviceInfoList(TrafficDeviceInfo trafficDeviceInfo) {
        return trafficDeviceInfoMapper.selectTrafficDeviceInfoList(trafficDeviceInfo);
    }

    /**
     * 新增设备信息
     *
     * @param trafficDeviceInfo 设备信息
     * @return 结果
     */
    @Override
    public int insertTrafficDeviceInfo(TrafficDeviceInfo trafficDeviceInfo) {
        trafficDeviceInfo.setCreateTime(DateUtils.getNowDate());
        int row = trafficDeviceInfoMapper.insertTrafficDeviceInfo(trafficDeviceInfo);
        if (row > 0) {
            trafficDeviceInfo.setFlag(1);
            String data = JSON.toJSONString(trafficDeviceInfo);
            mqttPushClient.publish(0, false, "addDevice", data);
        }
        return row;
    }

    /**
     * 修改设备信息
     *
     * @param trafficDeviceInfo 设备信息
     * @return 结果
     */
    @Override
    public int updateTrafficDeviceInfo(TrafficDeviceInfo trafficDeviceInfo) {
        trafficChannelInfoService.deleteTrafficChannelInfoByDeviceId(trafficDeviceInfo.getDeviceId());
        int row = trafficDeviceInfoMapper.updateTrafficDeviceInfo(trafficDeviceInfo);
        if (row > 0) {
            trafficDeviceInfo.setFlag(2);
            String data = JSON.toJSONString(trafficDeviceInfo);
            mqttPushClient.publish(0, false, "modDevice", data);
        }
        return row;
    }

    /**
     * 批量删除设备信息
     *
     * @param deviceIds 需要删除的设备信息主键
     * @return 结果
     */
    @Override
    public int deleteTrafficDeviceInfoByIds(Long[] deviceIds) {

        if (deviceIds.length > 0) {
            for (long id : deviceIds) {
                TrafficDeviceInfo trafficDeviceInfo = selectTrafficDeviceInfoById(id);
                trafficChannelInfoService.deleteTrafficChannelInfoByDeviceId(trafficDeviceInfo.getDeviceId());
                trafficDeviceInfo.setFlag(3);
                String data = JSON.toJSONString(trafficDeviceInfo);
                mqttPushClient.publish(0, false, "delDevice", data);
            }
        }
        return trafficDeviceInfoMapper.deleteTrafficDeviceInfoByIds(deviceIds);
    }

    /**
     * 删除设备信息信息
     *
     * @param deviceId 设备信息主键
     * @return 结果
     */
    @Override
    public int deleteTrafficDeviceInfoById(Long deviceId) {
        int row = trafficDeviceInfoMapper.deleteTrafficDeviceInfoById(deviceId);
        if (row > 0) {
            TrafficDeviceInfo trafficDeviceInfo = selectTrafficDeviceInfoById(deviceId);
            trafficDeviceInfo.setFlag(3);
            String data = JSON.toJSONString(trafficDeviceInfo);
            mqttPushClient.publish(0, false, "delDevice", data);
        }
        return row;
    }
    /**
     * 根据所有设备信息
     *
     * @return 设备信息集合信息
     */
    @Override
    public List<TrafficDeviceInfo> selectTrafficDeviceInfoAll()
    {
        return trafficDeviceInfoMapper.selectTrafficDeviceInfoAll();
    }


    /**
     * 校验设备编号是否唯一
     *
     * @param deviceBh 用户名
     * @return
     */
    @Override
    public String checkDeviceBhUnique(String deviceBh)
    {
        int count = trafficDeviceInfoMapper.checkDeviceBhUnique(deviceBh);
        if (count > 0)
        {
            return TrafficConstants.DEVICE_BH_NOT_UNIQUE;
        }
        return TrafficConstants.DEVICE_BH_UNIQUE;
    }
}
