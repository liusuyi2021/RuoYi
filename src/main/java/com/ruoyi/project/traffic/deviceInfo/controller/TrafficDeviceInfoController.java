package com.ruoyi.project.traffic.deviceInfo.controller;

import java.util.List;

import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import com.ruoyi.framework.aspectj.lang.annotation.Log;
import com.ruoyi.framework.aspectj.lang.enums.BusinessType;
import com.ruoyi.project.traffic.deviceInfo.domain.TrafficDeviceInfo;
import com.ruoyi.project.traffic.deviceInfo.service.ITrafficDeviceInfoService;
import com.ruoyi.framework.web.controller.BaseController;
import com.ruoyi.framework.web.domain.AjaxResult;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.framework.web.page.TableDataInfo;

/**
 * 设备信息Controller
 *
 * @author 刘苏义
 * @date 2022-05-12
 */
@Controller
@RequestMapping("/traffic/device")
public class TrafficDeviceInfoController extends BaseController {
    private String prefix = "traffic/device";

    @Autowired
    private ITrafficDeviceInfoService trafficDeviceInfoService;

    @RequiresPermissions("traffic:device:view")
    @GetMapping()
    public String device() {
        return prefix + "/deviceInfo";
    }

    /**
     * 查询设备信息列表
     */
    @RequiresPermissions("traffic:device:list")
    @PostMapping("/list")
    @ResponseBody
    public TableDataInfo list(TrafficDeviceInfo trafficDeviceInfo) {
        startPage();
        List<TrafficDeviceInfo> list = trafficDeviceInfoService.selectTrafficDeviceInfoList(trafficDeviceInfo);
        return getDataTable(list);
    }

    /**
     * 导出设备信息列表
     */
    @RequiresPermissions("traffic:device:export")
    @Log(title = "设备信息", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(TrafficDeviceInfo trafficDeviceInfo) {
        List<TrafficDeviceInfo> list = trafficDeviceInfoService.selectTrafficDeviceInfoList(trafficDeviceInfo);
        ExcelUtil<TrafficDeviceInfo> util = new ExcelUtil<TrafficDeviceInfo>(TrafficDeviceInfo.class);
        return util.exportExcel(list, "设备信息数据");
    }
    /**
     * 选择导出服务器管理列表
     */
    @RequiresPermissions("traffic:device:export")
    @Log(title = "设备信息", businessType = BusinessType.EXPORT)
    @PostMapping("/selectExport")
    @ResponseBody
    public AjaxResult SelectExport(TrafficDeviceInfo trafficDeviceInfo)
    {
        List<TrafficDeviceInfo> list = trafficDeviceInfoService.selectTrafficDeviceInfoList(trafficDeviceInfo);
        ExcelUtil<TrafficDeviceInfo> util = new ExcelUtil<TrafficDeviceInfo>(TrafficDeviceInfo.class);
        return util.exportExcel(list, "设备信息数据");
    }
    /**
     * 新增设备信息
     */
    @GetMapping("/add")
    public String add() {
        return prefix + "/add";
    }

    /**
     * 新增保存设备信息
     */
    @RequiresPermissions("traffic:device:add")
    @Log(title = "设备信息", businessType = BusinessType.INSERT)
    @PostMapping("/add")
    @ResponseBody
    public AjaxResult addSave(TrafficDeviceInfo trafficDeviceInfo) {
        return toAjax(trafficDeviceInfoService.insertTrafficDeviceInfo(trafficDeviceInfo));
    }

    /**
     * 修改设备信息
     */
    @RequiresPermissions("traffic:device:edit")
    @GetMapping("/edit/{deviceId}")
    public String edit(@PathVariable("deviceId") Long deviceId, ModelMap mmap) {
        TrafficDeviceInfo trafficDeviceInfo = trafficDeviceInfoService.selectTrafficDeviceInfoById(deviceId);
        mmap.put("trafficDeviceInfo", trafficDeviceInfo);
        return prefix + "/edit";
    }

    /**
     * 修改保存设备信息
     */
    @RequiresPermissions("traffic:device:edit")
    @Log(title = "设备信息", businessType = BusinessType.UPDATE)
    @PostMapping("/edit")
    @ResponseBody
    public AjaxResult editSave(TrafficDeviceInfo trafficDeviceInfo) {
        return toAjax(trafficDeviceInfoService.updateTrafficDeviceInfo(trafficDeviceInfo));
    }

    /**
     * 删除设备信息
     */
    @Log(title = "设备信息", businessType = BusinessType.DELETE)
    @RequiresPermissions("traffic:device:remove")
    @PostMapping("/remove")
    @ResponseBody
    public AjaxResult remove(Long[] ids) {

        return toAjax(trafficDeviceInfoService.deleteTrafficDeviceInfoByIds(ids));
    }

    /**
     * 校验设备编号唯一
     */
    @PostMapping("/checkDeviceBhUnique")
    @ResponseBody
    public String checkDeviceBhUnique(TrafficDeviceInfo trafficDeviceInfo)
    {
        return trafficDeviceInfoService.checkDeviceBhUnique(trafficDeviceInfo.getDeviceIndex());
    }
}
