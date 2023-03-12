package com.ruoyi.project.traffic.channelinfo.domain;

import com.ruoyi.framework.aspectj.lang.annotation.Excel;
import com.ruoyi.framework.web.domain.BaseEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 通道信息对象 traffic_channel_info
 * 
 * @author 刘苏义
 * @date 2022-05-17
 */
@NoArgsConstructor
@AllArgsConstructor
@Data
public class TrafficChannelInfo extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    private  Long[] selectChannelIds;
    /** 通道ID */
    @Excel(name = "通道ID")
    private Long channelId;

    /** 设备ID */
    @Excel(name = "设备ID")
    private Long deviceId;

    /** 登录ID */
    private String loginId;

    /** 通道名称 */
    @Excel(name = "通道名称")
    private String chanName;

    /** 通道号 */
    @Excel(name = "通道号")
    private Long chanIndex;

}
