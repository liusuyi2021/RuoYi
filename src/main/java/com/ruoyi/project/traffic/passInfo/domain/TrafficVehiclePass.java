package com.ruoyi.project.traffic.passInfo.domain;
import java.util.Date;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.ruoyi.project.traffic.crossinginfo.domain.TrafficCrossingInfo;
import com.ruoyi.framework.aspectj.lang.annotation.Excel;
import com.ruoyi.framework.web.domain.BaseEntity;

/**
 * 卡口过车对象 traffic_vehicle_pass
 * 
 * @author 刘苏义
 * @date 2022-05-21
 */
public class TrafficVehiclePass extends BaseEntity
{
    private static final long serialVersionUID = 1L;
    /** 选择过车IDS */
    private Long[] selectPassIds;
    /** 过车ID */
    private Long passId;
    /** 卡口信息 */
    private TrafficCrossingInfo crossingInfo;
    /** 卡口ID */
    @Excel(name = "卡口ID")
    private Long crossingId;
    /** 卡口名称 */
    private String crossingName;
    /** 过车时间 */
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss.SSS")
    @Excel(name = "过车时间", width = 30, dateFormat = "yyyy mm dd hh:mm:ss.SSS")
    private Date passTime;

    /** 过车时间开始 */
    private Date passTimeStart;
    /** 过车时间开始 */
    private Date passTimeStop;

    /** 车牌号码 */
    @Excel(name = "车牌号码")
    private String plateNo;

    /** 车牌颜色 */
    @Excel(name = "车牌颜色")
    private String plateColor;

    /** 车牌类型 */
    @Excel(name = "车牌类型")
    private String plateType;

    /** 车身颜色 */
    @Excel(name = "车身颜色")
    private String vehicleColor;

    /** 车辆类型 */
    @Excel(name = "车辆类型")
    private String vehicleType;

    /** 车道号 */
    @Excel(name = "车道号")
    private String laneNo;

    /** 方向 */
    @Excel(name = "方向")
    private String direction;

    /** 车牌图片 */
    @Excel(name = "车牌图片")
    private String plateImage;

    /** 车辆图片 */
    @Excel(name = "车辆图片")
    private String vehicleImage;
    /** 数量 */
    private Long count;

    public Long getCount() {
        return count;
    }

    public void setCount(Long count) {
        this.count = count;
    }

    public TrafficCrossingInfo getCrossingInfo() {
        return crossingInfo;
    }

    public void setCrossingInfo(TrafficCrossingInfo crossingInfo) {
        this.crossingInfo = crossingInfo;
    }

    public void setPassId(Long passId)
    {
        this.passId = passId;
    }

    public Long getPassId()
    {
        return passId;
    }
    public void setCrossingId(Long crossingId)
    {
        this.crossingId = crossingId;
    }

    public Long getCrossingId()
    {
        return crossingId;
    }
    public void setPassTime(Date passTime)
    {
        this.passTime = passTime;
    }

    public Date getPassTime()
    {
        return passTime;
    }
    public void setPlateNo(String plateNo)
    {
        this.plateNo = plateNo;
    }

    public String getPlateNo()
    {
        return plateNo;
    }
    public void setPlateColor(String plateColor)
    {
        this.plateColor = plateColor;
    }

    public String getPlateColor()
    {
        return plateColor;
    }
    public void setPlateType(String plateType)
    {
        this.plateType = plateType;
    }

    public String getPlateType()
    {
        return plateType;
    }
    public void setVehicleColor(String vehicleColor)
    {
        this.vehicleColor = vehicleColor;
    }

    public String getVehicleColor()
    {
        return vehicleColor;
    }
    public void setVehicleType(String vehicleType)
    {
        this.vehicleType = vehicleType;
    }

    public String getVehicleType()
    {
        return vehicleType;
    }
    public void setLaneNo(String laneNo)
    {
        this.laneNo = laneNo;
    }

    public String getLaneNo()
    {
        return laneNo;
    }
    public void setDirection(String direction)
    {
        this.direction = direction;
    }

    public String getDirection()
    {
        return direction;
    }
    public void setPlateImage(String plateImage)
    {
        this.plateImage = plateImage;
    }

    public String getPlateImage()
    {
        return plateImage;
    }
    public void setVehicleImage(String vehicleImage)
    {
        this.vehicleImage = vehicleImage;
    }

    public String getVehicleImage()
    {
        return vehicleImage;
    }
    public Date getPassTimeStart() {
        return passTimeStart;
    }

    public void setPassTimeStart(Date passTimeStart) {
        this.passTimeStart = passTimeStart;
    }

    public Date getPassTimeStop() {
        return passTimeStop;
    }

    public void setPassTimeStop(Date passTimeStop) {
        this.passTimeStop = passTimeStop;
    }

    public String getCrossingName() {return crossingName;}

    public void setCrossingName(String crossingName) {this.crossingName = crossingName;}

    public Long[] getSelectPassIds() {
        return selectPassIds;
    }

    public void setSelectPassIds(Long[] selectPassIds) {
        this.selectPassIds = selectPassIds;
    }

    @Override
    public String toString() {
        return "TrafficVehiclePass{" +
                "passId=" + passId +
                ", crossingId=" + crossingId +
                ", crossingName='" + crossingName + '\'' +
                ", passTime=" + passTime +
                ", passTimeStart=" + passTimeStart +
                ", passTimeStop=" + passTimeStop +
                ", plateNo='" + plateNo + '\'' +
                ", plateColor='" + plateColor + '\'' +
                ", plateType='" + plateType + '\'' +
                ", vehicleColor='" + vehicleColor + '\'' +
                ", vehicleType='" + vehicleType + '\'' +
                ", laneNo='" + laneNo + '\'' +
                ", direction='" + direction + '\'' +
                ", plateImage='" + plateImage + '\'' +
                ", vehicleImage='" + vehicleImage + '\'' +
                '}';
    }
}
