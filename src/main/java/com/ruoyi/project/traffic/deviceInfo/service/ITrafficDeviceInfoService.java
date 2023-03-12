package com.ruoyi.project.traffic.deviceInfo.service;

import java.util.List;

import com.ruoyi.project.traffic.deviceInfo.domain.TrafficDeviceInfo;

/**
 * 设备信息Service接口
 * 
 * @author 刘苏义
 * @date 2022-05-12
 */
public interface ITrafficDeviceInfoService 
{
    /**
     * 查询设备信息
     * 
     * @param deviceId 设备信息主键
     * @return 设备信息
     */
    public TrafficDeviceInfo selectTrafficDeviceInfoById(Long deviceId);

    /**
     * 查询设备信息列表
     * 
     * @param trafficDeviceInfo 设备信息
     * @return 设备信息集合
     */
    public List<TrafficDeviceInfo> selectTrafficDeviceInfoList(TrafficDeviceInfo trafficDeviceInfo);

    /**
     * 新增设备信息
     * 
     * @param trafficDeviceInfo 设备信息
     * @return 结果
     */
    public int insertTrafficDeviceInfo(TrafficDeviceInfo trafficDeviceInfo);

    /**
     * 修改设备信息
     * 
     * @param trafficDeviceInfo 设备信息
     * @return 结果
     */
    public int updateTrafficDeviceInfo(TrafficDeviceInfo trafficDeviceInfo);

    /**
     * 批量删除设备信息
     * 
     * @param deviceIds 需要删除的设备信息主键集合
     * @return 结果
     */
    public int deleteTrafficDeviceInfoByIds(Long[] deviceIds);

    /**
     * 删除设备信息信息
     * 
     * @param deviceId 设备信息主键
     * @return 结果
     */
    public int deleteTrafficDeviceInfoById(Long deviceId);

    /**
     * 根据设备信息信息
     *
     * @return 设备信息集合信息
     */
    public List<TrafficDeviceInfo> selectTrafficDeviceInfoAll();
    /**
     * 校验设备编号是否唯一
     *
     * @param deviceBh 用户名
     * @return
     */
    public String checkDeviceBhUnique(String deviceBh);
}
