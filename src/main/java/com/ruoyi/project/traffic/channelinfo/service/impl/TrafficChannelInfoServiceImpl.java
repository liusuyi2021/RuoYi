package com.ruoyi.project.traffic.channelinfo.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;
import com.ruoyi.project.traffic.channelinfo.mapper.TrafficChannelInfoMapper;
import com.ruoyi.project.traffic.channelinfo.domain.TrafficChannelInfo;
import com.ruoyi.project.traffic.channelinfo.service.ITrafficChannelInfoService;

import javax.annotation.Resource;

/**
 * 通道信息Service业务层处理
 * 
 * @author 刘苏义
 * @date 2022-05-17
 */
@Service
public class TrafficChannelInfoServiceImpl implements ITrafficChannelInfoService 
{
    @Resource
    private TrafficChannelInfoMapper trafficChannelInfoMapper;

    /**
     * 查询通道信息
     * 
     * @param channelId 通道信息主键
     * @return 通道信息
     */
    @Override
    public TrafficChannelInfo selectTrafficChannelInfoById(Long channelId)
    {
        return trafficChannelInfoMapper.selectTrafficChannelInfoById(channelId);
    }

    /**
     * 查询通道信息列表
     * 
     * @param trafficChannelInfo 通道信息
     * @return 通道信息
     */
    @Override
    public List<TrafficChannelInfo> selectTrafficChannelInfoList(TrafficChannelInfo trafficChannelInfo)
    {
        return trafficChannelInfoMapper.selectTrafficChannelInfoList(trafficChannelInfo);
    }
    /**
     * 删除设备信息信息
     *
     * @param deviceId 设备信息主键
     * @return 结果
     */
    @Override
    public int deleteTrafficChannelInfoByDeviceId(Long deviceId) {
        int row = trafficChannelInfoMapper.deleteTrafficChannelInfoByDeviceId(deviceId);
        return row;
    }
}
