package com.ruoyi.project.traffic.serverinfo.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.framework.aspectj.lang.annotation.Excel;
import com.ruoyi.framework.web.domain.BaseEntity;

/**
 * 服务器管理对象 traffic_server_info
 * 
 * @author 刘苏义
 * @date 2022-05-21
 */
public class TrafficServerInfo extends BaseEntity
{
    private static final long serialVersionUID = 1L;
    /** 选择服务器IDS */
    private Long[] selectIds;

    /** 服务器ID */
    @Excel(name = "服务器ID")
    private Long serverId;

    /** 服务器名称 */
    @Excel(name = "服务器名称")
    private String serverName;

    /** 服务器类型 */
    @Excel(name = "服务器类型")
    private String serverType;

    /** 服务器IP */
    @Excel(name = "服务器IP")
    private String ipAddr;

    /** 服务器端口 */
    @Excel(name = "服务器端口")
    private Integer port;

    /** 用户名 */
    @Excel(name = "用户名")
    private String username;

    /** 密码 */
    @Excel(name = "密码")
    private String password;

    /** 数据接入服务器ID */
    @Excel(name = "数据接入服务器ID")
    private Long tdhsServerId;

    /** 图片存储服务器ID */
    @Excel(name = "图片存储服务器ID")
    private Long minioServerId;

    public void setServerId(Long serverId)
    {
        this.serverId = serverId;
    }

    public Long getServerId()
    {
        return serverId;
    }
    public void setServerName(String serverName)
    {
        this.serverName = serverName;
    }

    public String getServerName()
    {
        return serverName;
    }
    public void setServerType(String serverType)
    {
        this.serverType = serverType;
    }

    public String getServerType()
    {
        return serverType;
    }
    public void setIpAddr(String ipAddr)
    {
        this.ipAddr = ipAddr;
    }

    public String getIpAddr()
    {
        return ipAddr;
    }
    public void setPort(Integer port)
    {
        this.port = port;
    }

    public Integer getPort()
    {
        return port;
    }
    public void setUsername(String username)
    {
        this.username = username;
    }

    public String getUsername()
    {
        return username;
    }
    public void setPassword(String password)
    {
        this.password = password;
    }

    public String getPassword()
    {
        return password;
    }
    public void setTdhsServerId(Long tdhsServerId)
    {
        this.tdhsServerId = tdhsServerId;
    }

    public Long getTdhsServerId()
    {
        return tdhsServerId;
    }
    public void setMinioServerId(Long minioServerId)
    {
        this.minioServerId = minioServerId;
    }

    public Long getMinioServerId()
    {
        return minioServerId;
    }

    public Long[] getSelectIds() {
        return selectIds;
    }

    public void setSelectIds(Long[] selectIds) {
        this.selectIds = selectIds;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("serverId", getServerId())
            .append("serverName", getServerName())
            .append("serverType", getServerType())
            .append("ipAddr", getIpAddr())
            .append("port", getPort())
            .append("username", getUsername())
            .append("password", getPassword())
            .append("tdhsServerId", getTdhsServerId())
            .append("minioServerId", getMinioServerId())
            .toString();
    }
}
