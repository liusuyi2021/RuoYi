package com.ruoyi.project.traffic.laneinfo.domain;

import com.ruoyi.project.traffic.channelinfo.domain.TrafficChannelInfo;
import com.ruoyi.project.traffic.crossinginfo.domain.TrafficCrossingInfo;
import com.ruoyi.project.traffic.deviceInfo.domain.TrafficDeviceInfo;
import com.ruoyi.project.traffic.serverinfo.domain.TrafficServerInfo;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.framework.aspectj.lang.annotation.Excel;
import com.ruoyi.framework.web.domain.BaseEntity;

/**
 * 线路关联对象 traffic_lane_info
 *
 * @author 刘苏义
 * @date 2022-05-19
 */
@NoArgsConstructor
@AllArgsConstructor
@Data
public class TrafficLaneInfo extends BaseEntity {
    private static final long serialVersionUID = 1L;

    /**
     * device_id
     */
    @Excel(name = "device_id")
    private Long deviceId;

    /**
     * lane_id
     */
    private Long laneId;

    /**
     * crossing_id
     */
    @Excel(name = "crossing_id")
    private Long crossingId;

    /**
     * channel_id
     */
    @Excel(name = "channel_id")
    private Long channelId;
    /**
     * state
     */
    @Excel(name = "state")
    private Integer state;
    /**
     * flag
     */
    @Excel(name = "flag")
    private Integer flag;

    /* 服务器信息*/
    private TrafficServerInfo trafficServerInfo;
    /* 设备信息*/
    private TrafficDeviceInfo trafficDeviceInfo;
    /* 卡口信息*/
    private TrafficCrossingInfo trafficCrossingInfo;
    /* 通道信息*/
    private TrafficChannelInfo trafficChannelInfo;
}
