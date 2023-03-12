package com.ruoyi.project.traffic.deviceInfo.domain;

import com.ruoyi.project.system.dept.domain.Dept;
import com.ruoyi.framework.aspectj.lang.annotation.Excel;
import com.ruoyi.framework.web.domain.BaseEntity;

/**
 * 设备信息对象 traffic_device_info
 *
 * @author 刘苏义
 * @date 2022-05-12
 */
public class TrafficDeviceInfo extends BaseEntity {
    private static final long serialVersionUID = 1L;

    /**
     * 选择设备ID
     */
    private Long[] selectDeviceIds;
    /**
     * deviceId
     */
    private Long deviceId;

    /**
     * 设备编号
     */
    @Excel(name = "设备编号")
    private String deviceIndex;

    private Dept dept;
    /**
     * 部门ID
     */
    @Excel(name = "部门编号", type = Excel.Type.IMPORT)
    private Long deptId;

    /**
     * 设备名称
     */
    @Excel(name = "设备名称")
    private String deviceName;

    /**
     * 设备类型
     */
    @Excel(name = "设备类型")
    private String typeCode;

    /**
     * 设备ip
     */
    @Excel(name = "设备ip")
    private String ipAddr;

    /**
     * 设备端口
     */
    @Excel(name = "设备端口")
    private String port;

    /**
     * 用户名
     */
    @Excel(name = "用户名")
    private String userName;

    /**
     * 密码
     */
    @Excel(name = "密码")
    private String passWord;

    /**
     * 登录状态
     */
    @Excel(name = "登录状态")
    private Integer loginState;

    /**
     * 标识
     */
    @Excel(name = "标识")
    private Integer flag;

    /**
     * 登录id
     */
    @Excel(name = "登录id")
    private String loginId;

    /**
     * 设备序号
     */
    @Excel(name = "设备序号")
    private String serialNumber;

    /**
     * 通道数
     */
    @Excel(name = "通道数")
    private Integer chanNum;

    /**
     * chan_specs_num
     */
    private Integer chanSpecsNum;

    public Long getDeviceId() {
        return deviceId;
    }

    public void setDeviceId(Long deviceId) {
        this.deviceId = deviceId;
    }

    public String getDeviceIndex() {
        return deviceIndex;
    }

    public void setDeviceIndex(String deviceIndex) {
        this.deviceIndex = deviceIndex;
    }

    public void setDeptId(Long deptId) {
        this.deptId = deptId;
    }

    public Long getDeptId() {
        return deptId;
    }

    public void setDeviceName(String deviceName) {
        this.deviceName = deviceName;
    }

    public String getDeviceName() {
        return deviceName;
    }

    public void setTypeCode(String typeCode) {
        this.typeCode = typeCode;
    }

    public String getTypeCode() {
        return typeCode;
    }

    public void setIpAddr(String ipAddr) {
        this.ipAddr = ipAddr;
    }

    public String getIpAddr() {
        return ipAddr;
    }

    public void setPort(String port) {
        this.port = port;
    }

    public String getPort() {
        return port;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserName() {
        return userName;
    }

    public void setPassWord(String passWord) {
        this.passWord = passWord;
    }

    public String getPassWord() {
        return passWord;
    }

    public void setLoginState(Integer loginState) {
        this.loginState = loginState;
    }

    public Integer getLoginState() {
        return loginState;
    }

    public void setFlag(Integer flag) {
        this.flag = flag;
    }

    public Integer getFlag() {
        return flag;
    }

    public void setLoginId(String loginId) {
        this.loginId = loginId;
    }

    public String getLoginId() {
        return loginId;
    }

    public void setSerialNumber(String serialNumber) {
        this.serialNumber = serialNumber;
    }

    public String getSerialNumber() {
        return serialNumber;
    }

    public void setChanNum(Integer chanNum) {
        this.chanNum = chanNum;
    }

    public Integer getChanNum() {
        return chanNum;
    }

    public void setChanSpecsNum(Integer chanSpecsNum) {
        this.chanSpecsNum = chanSpecsNum;
    }

    public Integer getChanSpecsNum() {
        return chanSpecsNum;
    }

    public Dept getDept() {
        if (dept == null) {
            dept = new Dept();
        }
        return dept;
    }

    public void setDept(Dept dept) {
        this.dept = dept;
    }

    public Long[] getSelectDeviceIds() {
        return selectDeviceIds;
    }

    public void setSelectDeviceIds(Long[] selectDeviceIds) {
        this.selectDeviceIds = selectDeviceIds;
    }

    @Override
    public String toString() {
        return "TrafficDeviceInfo{" +
                "deviceId=" + deviceId +
                ", deviceIndex='" + deviceIndex + '\'' +
                ", dept=" + dept +
                ", deptId=" + deptId +
                ", deviceName='" + deviceName + '\'' +
                ", typeCode='" + typeCode + '\'' +
                ", ipAddr='" + ipAddr + '\'' +
                ", port='" + port + '\'' +
                ", userName='" + userName + '\'' +
                ", passWord='" + passWord + '\'' +
                ", loginState=" + loginState +
                ", flag=" + flag +
                ", loginId='" + loginId + '\'' +
                ", serialNumber='" + serialNumber + '\'' +
                ", chanNum=" + chanNum +
                ", chanSpecsNum=" + chanSpecsNum +
                '}';
    }
}
