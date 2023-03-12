package com.ruoyi.project.traffic.serverinfo.service.impl;

import java.util.List;

import com.alibaba.fastjson.JSON;
import com.ruoyi.common.constant.TrafficConstants;
import com.ruoyi.common.utils.mqtt.MqttPushClient;
import org.springframework.stereotype.Service;
import com.ruoyi.project.traffic.serverinfo.mapper.TrafficServerInfoMapper;
import com.ruoyi.project.traffic.serverinfo.domain.TrafficServerInfo;
import com.ruoyi.project.traffic.serverinfo.service.ITrafficServerInfoService;
import javax.annotation.Resource;

/**
 * 服务器管理Service业务层处理
 * 
 * @author 刘苏义
 * @date 2022-05-21
 */
@Service("TrafficServer")
public class TrafficServerInfoServiceImpl implements ITrafficServerInfoService 
{
    @Resource
    private TrafficServerInfoMapper trafficServerInfoMapper;
    @Resource
    private MqttPushClient mqttPushClient;

    /**
     * 查询服务器管理
     * 
     * @param serverId 服务器管理主键
     * @return 服务器管理
     */
    @Override
    public TrafficServerInfo selectTrafficServerInfoByServerId(Long serverId)
    {
        return trafficServerInfoMapper.selectTrafficServerInfoByServerId(serverId);
    }

    /**
     * 查询服务器管理列表
     * 
     * @param trafficServerInfo 服务器管理
     * @return 服务器管理
     */
    @Override
    public List<TrafficServerInfo> selectTrafficServerInfoList(TrafficServerInfo trafficServerInfo)
    {
        return trafficServerInfoMapper.selectTrafficServerInfoList(trafficServerInfo);
    }
    /**
     * 根据服务器类型查询服务器管理
     *
     * @param ServerType 服务器类型
     * @return 参数键值
     */
    public List<TrafficServerInfo> selectTrafficServerInfoListByServerType(String ServerType)
    {
        return trafficServerInfoMapper.selectTrafficServerInfoListByServerType(ServerType);
    }
    /**
     * 新增服务器管理
     * 
     * @param trafficServerInfo 服务器管理
     * @return 结果
     */
    @Override
    public int insertTrafficServerInfo(TrafficServerInfo trafficServerInfo)
    {
        String data = JSON.toJSONString(trafficServerInfo);
        mqttPushClient.publish(0, false, "server", data);
        return trafficServerInfoMapper.insertTrafficServerInfo(trafficServerInfo);
    }

    /**
     * 修改服务器管理
     * 
     * @param trafficServerInfo 服务器管理
     * @return 结果
     */
    @Override
    public int updateTrafficServerInfo(TrafficServerInfo trafficServerInfo)
    {
        String data = JSON.toJSONString(trafficServerInfo);
        mqttPushClient.publish(0, false, "server", data);
        return trafficServerInfoMapper.updateTrafficServerInfo(trafficServerInfo);
    }

    /**
     * 批量删除服务器管理
     * 
     * @param serverIds 需要删除的服务器管理主键
     * @return 结果
     */
    @Override
    public int deleteTrafficServerInfoByServerIds(Long[] serverIds)
    {
        return trafficServerInfoMapper.deleteTrafficServerInfoByServerIds(serverIds);
    }

    /**
     * 删除服务器管理信息
     * 
     * @param serverId 服务器管理主键
     * @return 结果
     */
    @Override
    public int deleteTrafficServerInfoByServerId(Long serverId)
    {
        return trafficServerInfoMapper.deleteTrafficServerInfoByServerId(serverId);
    }
    /**
     * 校验tdhs是否唯一
     *
     * @param serverType 服务类型
     * @return
     */
    @Override
    public String checkServerTypeUnique(String serverType)
    {
        int count = trafficServerInfoMapper.checkServerTypeUnique(serverType);
        if (count > 0)
        {
            return TrafficConstants.SERVER_TYPE_NOT_UNIQUE;
        }
        return TrafficConstants.SERVER_TYPE_UNIQUE;
    }

}
