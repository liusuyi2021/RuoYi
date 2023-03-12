package com.ruoyi.project.traffic.laneinfo.service;

import com.ruoyi.framework.web.domain.Ztree;
import com.ruoyi.project.traffic.channelinfo.domain.TrafficChannelInfo;
import com.ruoyi.project.traffic.deviceInfo.domain.TrafficDeviceInfo;

import java.util.List;

/**
 * 通道信息Service接口
 * 
 * @author 刘苏义
 * @date 2022-05-17
 */
public interface ITrafficLaneInfoService {


    /**
     * 查询线路关联树
     * @param crossingId 部门信息
     * @param dev  设备信息
     * @param chan 通道信息
     * @return 所有通道信息
     */
    public List<Ztree> selectLaneTree(Long crossingId,TrafficDeviceInfo dev,TrafficChannelInfo chan);
    /**
     * 插入线路
     * @param crossingId 卡口ID
     * @param jsonstr   选中的设备通道json数组
     * @return 所有通道信息
     */
    public void SetLaneInfo(Long crossingId,String jsonstr);
}


