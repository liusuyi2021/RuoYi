package com.ruoyi.project.traffic.passInfo.service.impl;

import java.util.List;
import com.ruoyi.common.utils.DateUtils;
import com.ruoyi.project.traffic.crossinginfo.mapper.TrafficCrossingInfoMapper;
import org.springframework.stereotype.Service;
import com.ruoyi.project.traffic.passInfo.mapper.TrafficVehiclePassMapper;
import com.ruoyi.project.traffic.passInfo.domain.TrafficVehiclePass;
import com.ruoyi.project.traffic.passInfo.service.ITrafficVehiclePassService;
import com.ruoyi.common.utils.text.Convert;

import javax.annotation.Resource;

/**
 * 卡口过车Service业务层处理
 * 
 * @author 刘苏义
 * @date 2022-05-21
 */
@Service
public class TrafficVehiclePassServiceImpl implements ITrafficVehiclePassService 
{
    @Resource
    private TrafficVehiclePassMapper trafficVehiclePassMapper;
    @Resource
    private TrafficCrossingInfoMapper trafficCrossingInfoMapper;

    /**
     * 查询卡口过车
     * 
     * @param passId 卡口过车主键
     * @return 卡口过车
     */
    @Override
    public TrafficVehiclePass selectTrafficVehiclePassByPassId(Long passId)
    {
        return trafficVehiclePassMapper.selectTrafficVehiclePassByPassId(passId);
    }

    /**
     * 查询卡口过车列表
     * 
     * @param trafficVehiclePass 卡口过车
     * @return 卡口过车
     */
    @Override
    public List<TrafficVehiclePass> selectTrafficVehiclePassList(TrafficVehiclePass trafficVehiclePass)
    {
        if(trafficVehiclePass.getParams().size()>0&&trafficVehiclePass.getParams().get("passTime").toString()!="") {
            String[] passTimes =trafficVehiclePass.getParams().get("passTime").toString().split("~");
            String startTime = passTimes[0].trim();
            String stopTime = passTimes[1].trim();
            trafficVehiclePass.setPassTimeStart(DateUtils.parseDate(startTime));
            trafficVehiclePass.setPassTimeStop(DateUtils.parseDate(stopTime));
        }
        return trafficVehiclePassMapper.selectTrafficVehiclePassList(trafficVehiclePass);
    }

    /**
     * 新增卡口过车
     * 
     * @param trafficVehiclePass 卡口过车
     * @return 结果
     */
    @Override
    public int insertTrafficVehiclePass(TrafficVehiclePass trafficVehiclePass)
    {
        trafficVehiclePass.setCreateTime(DateUtils.getNowDate());
        return trafficVehiclePassMapper.insertTrafficVehiclePass(trafficVehiclePass);
    }

    /**
     * 修改卡口过车
     * 
     * @param trafficVehiclePass 卡口过车
     * @return 结果
     */
    @Override
    public int updateTrafficVehiclePass(TrafficVehiclePass trafficVehiclePass)
    {
        return trafficVehiclePassMapper.updateTrafficVehiclePass(trafficVehiclePass);
    }

    /**
     * 批量删除卡口过车
     * 
     * @param passIds 需要删除的卡口过车主键
     * @return 结果
     */
    @Override
    public int deleteTrafficVehiclePassByPassIds(String passIds)
    {
        return trafficVehiclePassMapper.deleteTrafficVehiclePassByPassIds(Convert.toStrArray(passIds));
    }

    /**
     * 删除卡口过车信息
     * 
     * @param passId 卡口过车主键
     * @return 结果
     */
    @Override
    public int deleteTrafficVehiclePassByPassId(Long passId)
    {
        return trafficVehiclePassMapper.deleteTrafficVehiclePassByPassId(passId);
    }
}
