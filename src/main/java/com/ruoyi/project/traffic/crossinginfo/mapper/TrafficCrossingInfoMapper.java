package com.ruoyi.project.traffic.crossinginfo.mapper;

import java.util.List;
import com.ruoyi.project.traffic.crossinginfo.domain.TrafficCrossingInfo;

/**
 * 卡口信息Mapper接口
 * 
 * @author 刘苏义
 * @date 2022-05-15
 */
public interface TrafficCrossingInfoMapper 
{
    /**
     * 查询卡口信息
     * 
     * @param crossingId 卡口信息主键
     * @return 卡口信息
     */
    public TrafficCrossingInfo selectTrafficCrossingInfoByCrossingId(Long crossingId);
    /**
     * 查询卡口信息
     *
     * @param crossingName 卡口信息主键
     * @return 卡口信息
     */
    public TrafficCrossingInfo selectTrafficCrossingInfoByCrossingName(String crossingName);
    /**
     * 查询卡口信息列表
     * 
     * @param trafficCrossingInfo 卡口信息
     * @return 卡口信息集合
     */
    public List<TrafficCrossingInfo> selectTrafficCrossingInfoList(TrafficCrossingInfo trafficCrossingInfo);
    /**
     * 查询所有卡口信息列表
     *
     * @return 卡口信息集合
     */
    public List<TrafficCrossingInfo>  selectTrafficCrossingInfoAll();
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
     * 删除卡口信息
     * 
     * @param crossingId 卡口信息主键
     * @return 结果
     */
    public int deleteTrafficCrossingInfoByCrossingId(Long crossingId);

    /**
     * 批量删除卡口信息
     * 
     * @param crossingIds 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteTrafficCrossingInfoByCrossingIds(Long[] crossingIds);
    /**
     * 查询卡口过车流量
     * @return 结果
     */
    public List<TrafficCrossingInfo> selectTrafficCrossingInfoPassDataCount();
    /**
     * 查询违法车流量
     * @return 结果
     */
    public List<TrafficCrossingInfo> selectTrafficCrossingInfoAlarmDataCount();

    /**
     * 校验卡口编号是否唯一
     *
     * @param crossingBh 登录名称
     * @return 结果
     */
    public int checkCrossingBhUnique(String crossingBh);
}
