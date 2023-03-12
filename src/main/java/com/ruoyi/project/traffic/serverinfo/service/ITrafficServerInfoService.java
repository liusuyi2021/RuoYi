package com.ruoyi.project.traffic.serverinfo.service;

import java.util.List;

import com.ruoyi.project.traffic.serverinfo.domain.TrafficServerInfo;

/**
 * 服务器管理Service接口
 * 
 * @author 刘苏义
 * @date 2022-05-21
 */
public interface ITrafficServerInfoService 
{
    /**
     * 查询服务器管理
     * 
     * @param serverId 服务器管理主键
     * @return 服务器管理
     */
    public TrafficServerInfo selectTrafficServerInfoByServerId(Long serverId);

    /**
     * 查询服务器管理列表
     * 
     * @param trafficServerInfo 服务器管理
     * @return 服务器管理集合
     */
    public List<TrafficServerInfo> selectTrafficServerInfoList(TrafficServerInfo trafficServerInfo);
    /**
     * 根据服务器类型查询服务器管理
     *
     * @param ServerType 服务器类型
     * @return 参数键值
     */
    public List<TrafficServerInfo> selectTrafficServerInfoListByServerType(String ServerType);
    /**
     * 新增服务器管理
     * 
     * @param trafficServerInfo 服务器管理
     * @return 结果
     */
    public int insertTrafficServerInfo(TrafficServerInfo trafficServerInfo);

    /**
     * 修改服务器管理
     * 
     * @param trafficServerInfo 服务器管理
     * @return 结果
     */
    public int updateTrafficServerInfo(TrafficServerInfo trafficServerInfo);

    /**
     * 批量删除服务器管理
     * 
     * @param serverIds 需要删除的服务器管理主键集合
     * @return 结果
     */
    public int deleteTrafficServerInfoByServerIds(Long[] serverIds);

    /**
     * 删除服务器管理信息
     * 
     * @param serverId 服务器管理主键
     * @return 结果
     */
    public int deleteTrafficServerInfoByServerId(Long serverId);


    /**
     * 校验tdhs是否唯一
     *
     * @param serverType 用户名
     * @return
     */
    public String checkServerTypeUnique(String serverType);
}
