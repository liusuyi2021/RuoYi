package com.ruoyi.project.traffic.alarmInfo.domain;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.ruoyi.project.traffic.crossinginfo.domain.TrafficCrossingInfo;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.framework.aspectj.lang.annotation.Excel;
import com.ruoyi.framework.web.domain.BaseEntity;

/**
 * 违法过车对象 traffic_vehicle_alarm
 *
 * @author 刘苏义
 * @date 2022-05-22
 */
public class TrafficVehicleAlarm extends BaseEntity {
    private static final long serialVersionUID = 1L;
    /**
     * 选择违法IDS
     */
    private Long[] selectAlarmIds;
    /**
     * 违法ID
     */
    @Excel(name = "违法ID")
    private Long alarmId;
    /**
     * 卡口ID
     */
    @Excel(name = "卡口ID")
    private Long crossingId;

    /**
     * 卡口名称
     */
    private String crossingName;

    /**
     * 卡口信息
     */
    private TrafficCrossingInfo crossingInfo;

    /**
     * 违法时间
     */
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss.SSS")
    @Excel(name = "违法时间", width = 30, dateFormat = "yyyy-MM-dd HH:mm:ss.SSS")
    private Date alarmTime;

    /**
     * 过车时间开始
     */
    private Date alarmTimeStart;

    /**
     * 过车时间开始
     */
    private Date alarmTimeStop;

    /**
     * 车牌号码
     */
    @Excel(name = "车牌号码")
    private String plateNo;

    /**
     * 车牌颜色
     */
    @Excel(name = "车牌颜色")
    private String plateColor;

    /**
     * 车牌类型
     */
    @Excel(name = "车牌类型")
    private String plateType;


    /**
     * 车身颜色
     */
    @Excel(name = "车身颜色")
    private String vehicleColor;

    /**
     * 车辆类型
     */
    @Excel(name = "车辆类型")
    private String vehicleType;

    /**
     * 车道号
     */
    @Excel(name = "车道号")
    private String laneNo;

    /**
     * 方向
     */
    @Excel(name = "方向")
    private String direction;
    /**
     * 违法行为
     */
    @Excel(name = "违法行为")
    private String alarmCode;
    /**
     * 车牌图片
     */
    @Excel(name = "车牌图片")
    private String plateImage;

    /**
     * 车辆图片
     */
    @Excel(name = "车辆图片")
    private String vehicleImage;

    /**
     * 统计违法数据数量
     */
    private Long count;
    /**
     * 统计违法行为数量
     */
    private Long codeCount;

    public Long getCodeCount() {
        return codeCount;
    }

    public void setCodeCount(Long codeCount) {
        this.codeCount = codeCount;
    }

    public Long getCount() {
        return count;
    }

    public void setCount(Long count) {
        this.count = count;
    }

    public String getCrossingName() {
        return crossingName;
    }

    public void setCrossingName(String crossingName) {
        this.crossingName = crossingName;
    }

    public TrafficCrossingInfo getCrossingInfo() {
        return crossingInfo;
    }

    public void setCrossingInfo(TrafficCrossingInfo crossingInfo) {
        this.crossingInfo = crossingInfo;
    }

    public void setVehicleColor(String vehicleColor) {
        this.vehicleColor = vehicleColor;
    }

    public String getVehicleColor() {
        return vehicleColor;
    }

    public void setVehicleType(String vehicleType) {
        this.vehicleType = vehicleType;
    }

    public String getVehicleType() {
        return vehicleType;
    }

    public void setLaneNo(String laneNo) {
        this.laneNo = laneNo;
    }

    public String getLaneNo() {
        return laneNo;
    }

    public void setDirection(String direction) {
        this.direction = direction;
    }

    public String getDirection() {
        return direction;
    }

    public void setPlateImage(String plateImage) {
        this.plateImage = plateImage;
    }

    public String getPlateImage() {
        return plateImage;
    }

    public void setVehicleImage(String vehicleImage) {
        this.vehicleImage = vehicleImage;
    }

    public String getVehicleImage() {
        return vehicleImage;
    }

    public void setAlarmId(Long alarmId) {
        this.alarmId = alarmId;
    }

    public Long getAlarmId() {
        return alarmId;
    }

    public void setCrossingId(Long crossingId) {
        this.crossingId = crossingId;
    }

    public Long getCrossingId() {
        return crossingId;
    }

    public void setAlarmTime(Date alarmTime) {
        this.alarmTime = alarmTime;
    }

    public Date getAlarmTime() {
        return alarmTime;
    }

    public void setPlateNo(String plateNo) {
        this.plateNo = plateNo;
    }

    public String getPlateNo() {
        return plateNo;
    }

    public void setPlateColor(String plateColor) {
        this.plateColor = plateColor;
    }

    public String getPlateColor() {
        return plateColor;
    }

    public void setPlateType(String plateType) {
        this.plateType = plateType;
    }

    public String getPlateType() {
        return plateType;
    }

    public void setAlarmCode(String alarmCode) {
        this.alarmCode = alarmCode;
    }

    public String getAlarmCode() {
        return alarmCode;
    }

    public Date getAlarmTimeStart() {
        return alarmTimeStart;
    }

    public void setAlarmTimeStart(Date alarmTimeStart) {
        this.alarmTimeStart = alarmTimeStart;
    }

    public Date getAlarmTimeStop() {
        return alarmTimeStop;
    }

    public void setAlarmTimeStop(Date alarmTimeStop) {
        this.alarmTimeStop = alarmTimeStop;
    }

    public Long[] getSelectAlarmIds() {
        return selectAlarmIds;
    }

    public void setSelectAlarmIds(Long[] selectAlarmIds) {
        this.selectAlarmIds = selectAlarmIds;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this, ToStringStyle.MULTI_LINE_STYLE)
                .append("vehicleColor", getVehicleColor())
                .append("vehicleType", getVehicleType())
                .append("laneNo", getLaneNo())
                .append("direction", getDirection())
                .append("plateImage", getPlateImage())
                .append("vehicleImage", getVehicleImage())
                .append("alarmId", getAlarmId())
                .append("crossingId", getCrossingId())
                .append("alarmTime", getAlarmTime())
                .append("plateNo", getPlateNo())
                .append("plateColor", getPlateColor())
                .append("plateType", getPlateType())
                .append("alarmCode", getAlarmCode())
                .append("createTime", getCreateTime())
                .toString();
    }
}
