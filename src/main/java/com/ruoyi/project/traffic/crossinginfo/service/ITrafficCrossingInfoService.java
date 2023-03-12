package com.ruoyi.project.traffic.crossinginfo.service;

import java.util.List;
import com.ruoyi.project.traffic.crossinginfo.domain.TrafficCrossingInfo;

/**
 * 卡口信息Service接口
 * 
 * @author 刘苏义
 * @date 2022-05-15
 */
public interface ITrafficCrossingInfoService 
{
    /**
     * 查询卡口信息
     * 
     * @param crossingId 卡口信息主键
     * @return 卡口信息
     */
    public TrafficCrossingInfo selectTrafficCrossingInfoByCrossingId(Long crossingId);

    /**
     * 查询卡口信息列表
     * 
     * @param trafficCrossingInfo 卡口信息
     * @return 卡口信息集合
     */
    public List<TrafficCrossingInfo> selectTrafficCrossingInfoList(TrafficCrossingInfo trafficCrossingInfo);

    /**
     * 新增卡口信息
     * 
     * @param trafficCrossingInfo 卡口信息
     * @return 结果
     */
    public int insertTrafficCrossingInfo(TrafficCrossingInfo trafficCrossingInfo);

    /**
     * 修改卡口信息
     * 
     * @param trafficCrossingInfo 卡口信息
     * @return 结果
     */
    public int updateTrafficCrossingInfo(TrafficCrossingInfo trafficCrossingInfo);

    /**
     * 批量删除卡口信息
     * 
     * @param crossingIds 需要删除的卡口信息主键集合
     * @return 结果
     */
    public int deleteTrafficCrossingInfoByCrossingIds(Long[] crossingIds);

    /**
     * 删除卡口信息信息
     * 
     * @param crossingId 卡口信息主键
     * @return 结果
     */
    public int deleteTrafficCrossingInfoByCrossingId(Long crossingId);
    /**
     * 获取所有卡口的过车流量的统计
     * @return 结果
     */
    public List<TrafficCrossingInfo> getTrafficCrossingInfoPassDataCount();
    /**
     * 获取所有卡口的违法流量的统计
     * @return 结果
     */
    public List<TrafficCrossingInfo> getTrafficCrossingInfoAlarmDataCount();
    /**
     * 校验卡口编号是否唯一
     *
     * @param crossingBh 用户名
     * @return
     */
    public String checkCrossingBhUnique(String crossingBh);
}
