package com.ruoyi.project.traffic.alarmInfo.controller;

import java.sql.Timestamp;
import java.util.List;
import java.util.TimeZone;

import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import com.ruoyi.framework.aspectj.lang.annotation.Log;
import com.ruoyi.framework.aspectj.lang.enums.BusinessType;
import com.ruoyi.project.traffic.alarmInfo.domain.TrafficVehicleAlarm;
import com.ruoyi.project.traffic.alarmInfo.service.ITrafficVehicleAlarmService;
import com.ruoyi.framework.web.controller.BaseController;
import com.ruoyi.framework.web.domain.AjaxResult;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.framework.web.page.TableDataInfo;

import javax.annotation.Resource;

/**
 * 违法过车Controller
 * 
 * @author 刘苏义
 * @date 2022-05-22
 */
@Controller
@RequestMapping("/traffic/alarmInfo")
public class TrafficVehicleAlarmController extends BaseController
{
    private String prefix = "traffic/alarmInfo";

    @Resource
    private ITrafficVehicleAlarmService trafficVehicleAlarmService;

    @RequiresPermissions("traffic:alarmInfo:view")
    @GetMapping()
    public String alarmInfo()
    {
        return prefix + "/alarmInfo";
    }

    /**
     * 查询违法过车列表
     */
    @RequiresPermissions("traffic:alarmInfo:list")
    @PostMapping("/list")
    @ResponseBody
    public TableDataInfo list(TrafficVehicleAlarm trafficVehicleAlarm)
    {
        long current = System.currentTimeMillis();
        long zero=current/(1000*3600*24)*(1000*3600*24)- TimeZone.getDefault().getRawOffset();//今天零点零分零秒的毫秒数
        long twelve=zero+24*60*60*1000-1;//今天23点59分59秒的毫秒数
        startPage();
        trafficVehicleAlarm.setAlarmTimeStart(new Timestamp(zero));
        trafficVehicleAlarm.setAlarmTimeStop(new Timestamp(twelve));
        List<TrafficVehicleAlarm> list = trafficVehicleAlarmService.selectTrafficVehicleAlarmList(trafficVehicleAlarm);
        return getDataTable(list);
    }

    /**
     * 导出违法过车列表
     */
    @RequiresPermissions("traffic:alarmInfo:export")
    @Log(title = "违法过车", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(TrafficVehicleAlarm trafficVehicleAlarm)
    {
        List<TrafficVehicleAlarm> list = trafficVehicleAlarmService.selectTrafficVehicleAlarmList(trafficVehicleAlarm);
        ExcelUtil<TrafficVehicleAlarm> util = new ExcelUtil<TrafficVehicleAlarm>(TrafficVehicleAlarm.class);
        return util.exportExcel(list, "违法过车数据");
    }
    /**
     * 选择导出违法过车列表
     */
    @RequiresPermissions("traffic:alarmInfo:export")
    @Log(title = "违法过车", businessType = BusinessType.EXPORT)
    @PostMapping("/selectExport")
    @ResponseBody
    public AjaxResult selectExport(TrafficVehicleAlarm trafficVehicleAlarm)
    {
        List<TrafficVehicleAlarm> list = trafficVehicleAlarmService.selectTrafficVehicleAlarmList(trafficVehicleAlarm);
        ExcelUtil<TrafficVehicleAlarm> util = new ExcelUtil<TrafficVehicleAlarm>(TrafficVehicleAlarm.class);
        return util.exportExcel(list, "违法过车数据");
    }
    /**
     * 新增违法过车
     */
    @GetMapping("/add")
    public String add()
    {
        return prefix + "/add";
    }

    /**
     * 新增保存违法过车
     */
    @RequiresPermissions("traffic:alarmInfo:add")
    @Log(title = "违法过车", businessType = BusinessType.INSERT)
    @PostMapping("/add")
    @ResponseBody
    public AjaxResult addSave(TrafficVehicleAlarm trafficVehicleAlarm)
    {
        return toAjax(trafficVehicleAlarmService.insertTrafficVehicleAlarm(trafficVehicleAlarm));
    }

    /**
     * 修改违法过车
     */
    @RequiresPermissions("traffic:alarmInfo:edit")
    @GetMapping("/edit/{alarmId}")
    public String edit(@PathVariable("alarmId") Long alarmId, ModelMap mmap)
    {
        TrafficVehicleAlarm trafficVehicleAlarm = trafficVehicleAlarmService.selectTrafficVehicleAlarmByAlarmId(alarmId);
        mmap.put("trafficVehicleAlarm", trafficVehicleAlarm);
        return prefix + "/edit";
    }

    /**
     * 修改保存违法过车
     */
    @RequiresPermissions("traffic:alarmInfo:edit")
    @Log(title = "违法过车", businessType = BusinessType.UPDATE)
    @PostMapping("/edit")
    @ResponseBody
    public AjaxResult editSave(TrafficVehicleAlarm trafficVehicleAlarm)
    {
        return toAjax(trafficVehicleAlarmService.updateTrafficVehicleAlarm(trafficVehicleAlarm));
    }

    /**
     * 删除违法过车
     */
    @RequiresPermissions("traffic:alarmInfo:remove")
    @Log(title = "违法过车", businessType = BusinessType.DELETE)
    @PostMapping( "/remove")
    @ResponseBody
    public AjaxResult remove(String ids)
    {
        return toAjax(trafficVehicleAlarmService.deleteTrafficVehicleAlarmByAlarmIds(ids));
    }
}
