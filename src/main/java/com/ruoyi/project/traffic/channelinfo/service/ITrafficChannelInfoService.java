package com.ruoyi.project.traffic.channelinfo.service;

import java.util.List;
import com.ruoyi.project.traffic.channelinfo.domain.TrafficChannelInfo;

/**
 * 通道信息Service接口
 * 
 * @author 刘苏义
 * @date 2022-05-17
 */
public interface ITrafficChannelInfoService {
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
     * 删除通道信息
     *
     * @param deviceId 设备ID
     * @return 结果
     */
    public int deleteTrafficChannelInfoByDeviceId(Long deviceId);


}


