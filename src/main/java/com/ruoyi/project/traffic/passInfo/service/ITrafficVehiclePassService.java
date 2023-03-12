package com.ruoyi.project.traffic.passInfo.service;

import java.util.List;
import com.ruoyi.project.traffic.passInfo.domain.TrafficVehiclePass;

/**
 * 卡口过车Service接口
 * 
 * @author 刘苏义
 * @date 2022-05-21
 */
public interface ITrafficVehiclePassService 
{
    /**
     * 查询卡口过车
     * 
     * @param passId 卡口过车主键
     * @return 卡口过车
     */
    public TrafficVehiclePass selectTrafficVehiclePassByPassId(Long passId);

    /**
     * 查询卡口过车列表
     * 
     * @param trafficVehiclePass 卡口过车
     * @return 卡口过车集合
     */
    public List<TrafficVehiclePass> selectTrafficVehiclePassList(TrafficVehiclePass trafficVehiclePass);

    /**
     * 新增卡口过车
     * 
     * @param trafficVehiclePass 卡口过车
     * @return 结果
     */
    public int insertTrafficVehiclePass(TrafficVehiclePass trafficVehiclePass);

    /**
     * 修改卡口过车
     * 
     * @param trafficVehiclePass 卡口过车
     * @return 结果
     */
    public int updateTrafficVehiclePass(TrafficVehiclePass trafficVehiclePass);

    /**
     * 批量删除卡口过车
     * 
     * @param passIds 需要删除的卡口过车主键集合
     * @return 结果
     */
    public int deleteTrafficVehiclePassByPassIds(String passIds);

    /**
     * 删除卡口过车信息
     * 
     * @param passId 卡口过车主键
     * @return 结果
     */
    public int deleteTrafficVehiclePassByPassId(Long passId);
}
