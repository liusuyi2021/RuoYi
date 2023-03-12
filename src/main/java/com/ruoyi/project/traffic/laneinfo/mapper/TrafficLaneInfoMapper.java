package com.ruoyi.project.traffic.laneinfo.mapper;

import java.util.List;
import com.ruoyi.project.traffic.laneinfo.domain.TrafficLaneInfo;

/**
 * 线路关联Mapper接口
 * 
 * @author 刘苏义
 * @date 2022-05-19
 */
public interface TrafficLaneInfoMapper 
{
    /**
     * 查询线路关联
     * 
     * @param laneId 线路关联主键
     * @return 线路关联
     */
    public TrafficLaneInfo selectTrafficLaneInfoByLaneId(String laneId);
    /**
     * 查询线路关联
     *
     * @param chanId 线路关联主键
     * @return 线路关联
     */
    public TrafficLaneInfo selectTrafficLaneInfoByChanId(Long chanId);
    /**
     * 通过卡口id查询关联的线路
     *
     * @param crossingId 线路关联主键
     * @return 线路关联
     */
    public TrafficLaneInfo selectTrafficLaneInfoByCrossingId(Long crossingId);
    /**
     * 查询线路关联列表
     * 
     * @return 线路关联集合
     */
    public List<TrafficLaneInfo> selectTrafficLaneInfoList();
    /**
     * 通过卡口id查询所有关联的线路
     *
     * @return 线路关联集合
     */
    public List<TrafficLaneInfo> selectTrafficLaneInfoListByCrossingId(Long crossingId);
    /**
     * 新增线路关联
     * 
     * @param trafficLaneInfo 线路关联
     * @return 结果
     */
    public int insertTrafficLaneInfo(TrafficLaneInfo trafficLaneInfo);

    /**
     * 修改线路关联
     * 
     * @param trafficLaneInfo 线路关联
     * @return 结果
     */
    public int updateTrafficLaneInfo(TrafficLaneInfo trafficLaneInfo);

    /**
     * 删除线路关联
     * 
     * @param laneId 线路关联主键
     * @return 结果
     */
    public int deleteTrafficLaneInfoByLaneId(String laneId);
    /**
     * 删除线路关联
     *
     * @param CrossingId 线路关联主键
     * @return 结果
     */
    public int deleteTrafficLaneInfoByCrossingId(Long CrossingId);
    /**
     * 批量删除线路关联
     * 
     * @param laneIds 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteTrafficLaneInfoByLaneIds(String[] laneIds);



}
