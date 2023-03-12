package com.ruoyi.project.traffic.alarmInfo.service.impl;

import java.util.List;
import com.ruoyi.common.utils.DateUtils;
import org.springframework.stereotype.Service;
import com.ruoyi.project.traffic.alarmInfo.mapper.TrafficVehicleAlarmMapper;
import com.ruoyi.project.traffic.alarmInfo.domain.TrafficVehicleAlarm;
import com.ruoyi.project.traffic.alarmInfo.service.ITrafficVehicleAlarmService;
import com.ruoyi.common.utils.text.Convert;

import javax.annotation.Resource;

/**
 * 违法过车Service业务层处理
 * 
 * @author 刘苏义
 * @date 2022-05-22
 */
@Service
public class TrafficVehicleAlarmServiceImpl implements ITrafficVehicleAlarmService 
{
    @Resource
    private TrafficVehicleAlarmMapper trafficVehicleAlarmMapper;

    /**
     * 查询违法过车
     * 
     * @param alarmId 违法过车主键
     * @return 违法过车
     */
    @Override
    public TrafficVehicleAlarm selectTrafficVehicleAlarmByAlarmId(Long alarmId)
    {
        return trafficVehicleAlarmMapper.selectTrafficVehicleAlarmByAlarmId(alarmId);
    }

    /**
     * 查询违法过车列表
     * 
     * @param trafficVehicleAlarm 违法过车
     * @return 违法过车
     */
    @Override
    public List<TrafficVehicleAlarm> selectTrafficVehicleAlarmList(TrafficVehicleAlarm trafficVehicleAlarm)
    {
        if(trafficVehicleAlarm.getParams().size()>0&&trafficVehicleAlarm.getParams().get("alarmTime").toString()!="") {

            String[] passTimes =trafficVehicleAlarm.getParams().get("alarmTime").toString().split("~");
            String startTime = passTimes[0].trim();
            String stopTime = passTimes[1].trim();
            trafficVehicleAlarm.setAlarmTimeStart(DateUtils.parseDate(startTime));
            trafficVehicleAlarm.setAlarmTimeStop(DateUtils.parseDate(stopTime));

        }
        return trafficVehicleAlarmMapper.selectTrafficVehicleAlarmList(trafficVehicleAlarm);
    }

    /**
     * 新增违法过车
     * 
     * @param trafficVehicleAlarm 违法过车
     * @return 结果
     */
    @Override
    public int insertTrafficVehicleAlarm(TrafficVehicleAlarm trafficVehicleAlarm)
    {
        trafficVehicleAlarm.setCreateTime(DateUtils.getNowDate());
        return trafficVehicleAlarmMapper.insertTrafficVehicleAlarm(trafficVehicleAlarm);
    }

    /**
     * 修改违法过车
     * 
     * @param trafficVehicleAlarm 违法过车
     * @return 结果
     */
    @Override
    public int updateTrafficVehicleAlarm(TrafficVehicleAlarm trafficVehicleAlarm)
    {
        return trafficVehicleAlarmMapper.updateTrafficVehicleAlarm(trafficVehicleAlarm);
    }

    /**
     * 批量删除违法过车
     * 
     * @param alarmIds 需要删除的违法过车主键
     * @return 结果
     */
    @Override
    public int deleteTrafficVehicleAlarmByAlarmIds(String alarmIds)
    {
        return trafficVehicleAlarmMapper.deleteTrafficVehicleAlarmByAlarmIds(Convert.toStrArray(alarmIds));
    }

    /**
     * 删除违法过车信息
     * 
     * @param alarmId 违法过车主键
     * @return 结果
     */
    @Override
    public int deleteTrafficVehicleAlarmByAlarmId(Long alarmId)
    {
        return trafficVehicleAlarmMapper.deleteTrafficVehicleAlarmByAlarmId(alarmId);
    }
    /**
     * 查询违法行为统计列表
     *
     * @return 结果
     */
    @Override
    public List<TrafficVehicleAlarm> selectTrafficVehicleAlarmCodeList() {
        return trafficVehicleAlarmMapper.selectTrafficVehicleAlarmCodeList();
    }
}
