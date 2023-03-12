package com.ruoyi.project.traffic.crossinginfo.domain;

import com.ruoyi.project.system.dept.domain.Dept;
import com.ruoyi.project.traffic.alarmInfo.domain.TrafficVehicleAlarm;
import com.ruoyi.project.traffic.passInfo.domain.TrafficVehiclePass;
import com.ruoyi.project.traffic.serverinfo.domain.TrafficServerInfo;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.framework.aspectj.lang.annotation.Excel;
import com.ruoyi.framework.web.domain.BaseEntity;

/**
 * 卡口信息对象 traffic_crossing_info
 *
 * @author 刘苏义
 * @date 2022-05-15
 */
public class TrafficCrossingInfo extends BaseEntity {
    private static final long serialVersionUID = 1L;
    /**
     * 选择卡口ID
     */
    private Long[] selectCrossingIds;
    /**
     * 卡口ID
     */
    private Long crossingId;

    /**
     * 卡口编号
     */
    @Excel(name = "卡口编号")
    private String crossingBh;
    /**
     * 部门
     */
    private Dept dept;
    /**
     * 部门ID
     */
    @Excel(name = "部门编号", type = Excel.Type.IMPORT)
    private Long deptId;

    /**
     * 卡口名称
     */
    @Excel(name = "卡口名称")
    private String crossingName;

    /**
     * 线路数
     */
    @Excel(name = "线路数")
    private Long laneNum;

    /**
     * 小车限速
     */
    @Excel(name = "小车限速")
    private Long smallLimitSpeed;

    /**
     * 大车限速
     */
    @Excel(name = "大车限速")
    private Long bigLimitSpeed;

    /**
     * 接入服务器ID
     */
    @Excel(name = "接入服务器ID")
    private Long tdasServerId;

    /**
     * 普通过车信息
     */
    private TrafficVehiclePass trafficVehiclePass;

    /**
     * 普通违法信息
     */
    private TrafficVehicleAlarm trafficVehicleAlarm;

    /**
     * 接入服务器
     */
    private TrafficServerInfo trafficServerInfo;

    public void setCrossingId(Long crossingId) {
        this.crossingId = crossingId;
    }

    public Long getCrossingId() {
        return crossingId;
    }

    public void setCrossingBh(String crossingBh) {
        this.crossingBh = crossingBh;
    }

    public String getCrossingBh() {
        return crossingBh;
    }

    public void setCrossingName(String crossingName) {
        this.crossingName = crossingName;
    }

    public String getCrossingName() {
        return crossingName;
    }

    public void setLaneNum(Long laneNum) {
        this.laneNum = laneNum;
    }

    public Long getLaneNum() {
        return laneNum;
    }

    public void setSmallLimitSpeed(Long smallLimitSpeed) {
        this.smallLimitSpeed = smallLimitSpeed;
    }

    public Long getSmallLimitSpeed() {
        return smallLimitSpeed;
    }

    public void setBigLimitSpeed(Long bigLimitSpeed) {
        this.bigLimitSpeed = bigLimitSpeed;
    }

    public Long getBigLimitSpeed() {
        return bigLimitSpeed;
    }

    public void setTdasServerId(Long tdasServerId) {
        this.tdasServerId = tdasServerId;
    }

    public Long getTdasServerId() {
        return tdasServerId;
    }

    public Long getDeptId() {
        return deptId;
    }

    public void setDeptId(Long deptId) {
        this.deptId = deptId;
    }

    public TrafficServerInfo getTrafficServerInfo() {
        return trafficServerInfo;
    }

    public void setTrafficServerInfo(TrafficServerInfo trafficServerInfo) {
        this.trafficServerInfo = trafficServerInfo;
    }

    public TrafficVehiclePass getTrafficVehiclePass() {
        return trafficVehiclePass;
    }

    public void setTrafficVehiclePass(TrafficVehiclePass trafficVehiclePass) {
        this.trafficVehiclePass = trafficVehiclePass;
    }

    public TrafficVehicleAlarm getTrafficVehicleAlarm() {
        return trafficVehicleAlarm;
    }

    public void setTrafficVehicleAlarm(TrafficVehicleAlarm trafficVehicleAlarm) {
        this.trafficVehicleAlarm = trafficVehicleAlarm;
    }

    public Dept getDept() {
        return dept;
    }

    public void setDept(Dept dept) {
        this.dept = dept;
    }

    public Long[] getSelectCrossingIds() {
        return selectCrossingIds;
    }

    public void setSelectCrossingIds(Long[] selectCrossingIds) {
        this.selectCrossingIds = selectCrossingIds;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this, ToStringStyle.MULTI_LINE_STYLE)
                .append("crossingId", getCrossingId())
                .append("crossingBh", getCrossingBh())
                .append("crossingName", getCrossingName())
                .append("laneNum", getLaneNum())
                .append("smallLimitSpeed", getSmallLimitSpeed())
                .append("bigLimitSpeed", getBigLimitSpeed())
                .append("tdasServerId", getTdasServerId())
                .append("deptId", getDeptId())
                .toString();
    }
}
