package com.ruoyi.project.traffic.deviceInfo.mapper;

import java.util.List;

import com.ruoyi.project.system.dept.domain.Dept;
import com.ruoyi.project.traffic.deviceInfo.domain.TrafficDeviceInfo;

/**
 * 设备信息Mapper接口
 * 
 * @author 刘苏义
 * @date 2022-05-12
 */
public interface TrafficDeviceInfoMapper 
{
    /**
     * 查询设备信息
     * 
     * @param DeviceId 设备信息主键
     * @return 设备信息
     */
    public TrafficDeviceInfo selectTrafficDeviceInfoById(Long DeviceId);

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
     * 删除设备信息
     * 
     * @param DeviceId 设备信息主键
     * @return 结果
     */
    public int deleteTrafficDeviceInfoById(Long DeviceId);

    /**
     * 批量删除设备信息
     * 
     * @param DeviceIds 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteTrafficDeviceInfoByIds(Long[] DeviceIds);

    /**
     * 根据所有设备信息
     *
     * @return 设备信息集合信息
     */
    public List<TrafficDeviceInfo> selectTrafficDeviceInfoAll();

    /**
     * 校验设备编号是否唯一
     *
     * @param deviceBh 登录名称
     * @return 结果
     */
    public int checkDeviceBhUnique(String deviceBh);
    /**
     * 查询设备集合转成组织模式
     *
     * @return 结果
     */
    public List<Dept> selectTrafficDeviceInfoToDept();
}
