package com.ruoyi.project.traffic.passInfo.controller;

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
import com.ruoyi.project.traffic.passInfo.domain.TrafficVehiclePass;
import com.ruoyi.project.traffic.passInfo.service.ITrafficVehiclePassService;
import com.ruoyi.framework.web.controller.BaseController;
import com.ruoyi.framework.web.domain.AjaxResult;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.framework.web.page.TableDataInfo;

import javax.annotation.Resource;

/**
 * 卡口过车Controller
 * 
 * @author 刘苏义
 * @date 2022-05-21
 */
@Controller
@RequestMapping("/traffic/passInfo")
public class TrafficVehiclePassController extends BaseController
{
    private String prefix = "traffic/passInfo";

    @Resource
    private ITrafficVehiclePassService trafficVehiclePassService;

    @RequiresPermissions("traffic:passInfo:view")
    @GetMapping()
    public String passInfo()
    {
        return prefix + "/passInfo";
    }

    /**
     * 查询卡口过车列表
     */
    @RequiresPermissions("traffic:passInfo:list")
    @PostMapping("/list")
    @ResponseBody
    public TableDataInfo list(TrafficVehiclePass trafficVehiclePass)
    {
        startPage();
        long current = System.currentTimeMillis();
        long zero=current/(1000*3600*24)*(1000*3600*24)- TimeZone.getDefault().getRawOffset();//今天零点零分零秒的毫秒数
        long twelve=zero+24*60*60*1000-1;//今天23点59分59秒的毫秒数
        trafficVehiclePass.setPassTimeStart(new Timestamp(zero));
        trafficVehiclePass.setPassTimeStop(new Timestamp(twelve));
        List<TrafficVehiclePass> list = trafficVehiclePassService.selectTrafficVehiclePassList(trafficVehiclePass);
        return getDataTable(list);
    }

    /**
     * 导出卡口过车列表
     */
    @RequiresPermissions("traffic:passInfo:export")
    @Log(title = "卡口过车", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(TrafficVehiclePass trafficVehiclePass)
    {
        List<TrafficVehiclePass> list = trafficVehiclePassService.selectTrafficVehiclePassList(trafficVehiclePass);
        ExcelUtil<TrafficVehiclePass> util = new ExcelUtil<TrafficVehiclePass>(TrafficVehiclePass.class);
        return util.exportExcel(list, "卡口过车数据");
    }
    /**
     * 选择导出卡口过车列表
     */
    @RequiresPermissions("traffic:passInfo:export")
    @Log(title = "卡口过车", businessType = BusinessType.EXPORT)
    @PostMapping("/selectExport")
    @ResponseBody
    public AjaxResult selectExport(TrafficVehiclePass trafficVehiclePass)
    {
        List<TrafficVehiclePass> list = trafficVehiclePassService.selectTrafficVehiclePassList(trafficVehiclePass);
        ExcelUtil<TrafficVehiclePass> util = new ExcelUtil<TrafficVehiclePass>(TrafficVehiclePass.class);
        return util.exportExcel(list, "卡口过车数据");
    }
    /**
     * 新增卡口过车
     */
    @GetMapping("/add")
    public String add()
    {
        return prefix + "/add";
    }

    /**
     * 新增保存卡口过车
     */
    @RequiresPermissions("traffic:passInfo:add")
    @Log(title = "卡口过车", businessType = BusinessType.INSERT)
    @PostMapping("/add")
    @ResponseBody
    public AjaxResult addSave(TrafficVehiclePass trafficVehiclePass)
    {
        return toAjax(trafficVehiclePassService.insertTrafficVehiclePass(trafficVehiclePass));
    }

    /**
     * 修改卡口过车
     */
    @RequiresPermissions("traffic:passInfo:edit")
    @GetMapping("/edit/{passId}")
    public String edit(@PathVariable("passId") Long passId, ModelMap mmap)
    {
        TrafficVehiclePass trafficVehiclePass = trafficVehiclePassService.selectTrafficVehiclePassByPassId(passId);
        mmap.put("trafficVehiclePass", trafficVehiclePass);
        return prefix + "/edit";
    }

    /**
     * 修改保存卡口过车
     */
    @RequiresPermissions("traffic:passInfo:edit")
    @Log(title = "卡口过车", businessType = BusinessType.UPDATE)
    @PostMapping("/edit")
    @ResponseBody
    public AjaxResult editSave(TrafficVehiclePass trafficVehiclePass)
    {
        return toAjax(trafficVehiclePassService.updateTrafficVehiclePass(trafficVehiclePass));
    }

    /**
     * 删除卡口过车
     */
    @RequiresPermissions("traffic:passInfo:remove")
    @Log(title = "卡口过车", businessType = BusinessType.DELETE)
    @PostMapping( "/remove")
    @ResponseBody
    public AjaxResult remove(String ids)
    {
        return toAjax(trafficVehiclePassService.deleteTrafficVehiclePassByPassIds(ids));
    }
}
