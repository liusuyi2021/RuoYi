package com.ruoyi.project.traffic.channelinfo.mapper;

import java.util.List;

import com.ruoyi.project.traffic.channelinfo.domain.TrafficChannelInfo;

/**
 * 通道信息Mapper接口
 * 
 * @author 刘苏义
 * @date 2022-05-17
 */
public interface TrafficChannelInfoMapper 
{
    /**
     * 查询通道信息
     * 
     * @param channelId 通道信息主键
     * @return 通道信息
     */
    public TrafficChannelInfo selectTrafficChannelInfoById(Long channelId);

    /**
     * 查询通道信息列表
     * 
     * @param trafficChannelInfo 通道信息
     * @return 通道信息集合
     */
    public List<TrafficChannelInfo> selectTrafficChannelInfoList(TrafficChannelInfo trafficChannelInfo);

    /**
     * 根据设备ID查询通道数据
     *
     * @param deviceId 设备id
     * @return 通道数据集合信息
     */
    public List<TrafficChannelInfo> selectTrafficChannelInfoByDeviceId(String deviceId);

    /**
     * 删除通道信息
     *
     * @param deviceId 设备信息主键
     * @return 结果
     */
    public int deleteTrafficChannelInfoByDeviceId(Long deviceId);
}
