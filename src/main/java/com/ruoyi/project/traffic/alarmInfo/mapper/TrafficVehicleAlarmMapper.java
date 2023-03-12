package com.ruoyi.project.traffic.alarmInfo.mapper;

import java.util.List;
import com.ruoyi.project.traffic.alarmInfo.domain.TrafficVehicleAlarm;

/**
 * 违法过车Mapper接口
 * 
 * @author 刘苏义
 * @date 2022-05-22
 */
public interface TrafficVehicleAlarmMapper 
{
    /**
     * 查询违法过车
     * 
     * @param alarmId 违法过车主键
     * @return 违法过车
     */
    public TrafficVehicleAlarm selectTrafficVehicleAlarmByAlarmId(Long alarmId);

    /**
     * 查询违法过车列表
     * 
     * @param trafficVehicleAlarm 违法过车
     * @return 违法过车集合
     */
    public List<TrafficVehicleAlarm> selectTrafficVehicleAlarmList(TrafficVehicleAlarm trafficVehicleAlarm);
    /**
     * 新增违法过车
     * 
     * @param trafficVehicleAlarm 违法过车
     * @return 结果
     */
    public int insertTrafficVehicleAlarm(TrafficVehicleAlarm trafficVehicleAlarm);

    /**
     * 修改违法过车
     * 
     * @param trafficVehicleAlarm 违法过车
     * @return 结果
     */
    public int updateTrafficVehicleAlarm(TrafficVehicleAlarm trafficVehicleAlarm);

    /**
     * 删除违法过车
     * 
     * @param alarmId 违法过车主键
     * @return 结果
     */
    public int deleteTrafficVehicleAlarmByAlarmId(Long alarmId);

    /**
     * 批量删除违法过车
     * 
     * @param alarmIds 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteTrafficVehicleAlarmByAlarmIds(String[] alarmIds);
    /**
     * 查询违法行为统计列表
     *
     * @return 结果
     */
     public List<TrafficVehicleAlarm>  selectTrafficVehicleAlarmCodeList();
}
