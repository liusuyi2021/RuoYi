package com.ruoyi.project.traffic.crossinginfo.controller;

import java.util.List;

import com.ruoyi.project.traffic.serverinfo.domain.TrafficServerInfo;
import com.ruoyi.project.traffic.serverinfo.service.ITrafficServerInfoService;
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
import com.ruoyi.project.traffic.crossinginfo.domain.TrafficCrossingInfo;
import com.ruoyi.project.traffic.crossinginfo.service.ITrafficCrossingInfoService;
import com.ruoyi.framework.web.controller.BaseController;
import com.ruoyi.framework.web.domain.AjaxResult;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.framework.web.page.TableDataInfo;

/**
 * 卡口信息Controller
 * 
 * @author 刘苏义
 * @date 2022-05-15
 */
@Controller
@RequestMapping("/traffic/crossing")
public class TrafficCrossingInfoController extends BaseController
{
    private String prefix = "traffic/crossing";

    @Autowired
    private ITrafficCrossingInfoService trafficCrossingInfoService;
    @Autowired
    private ITrafficServerInfoService trafficServerInfoService;
    @RequiresPermissions("traffic:crossing:view")
    @GetMapping()
    public String crossinginfo()
    {
        return prefix + "/crossingInfo";
    }

    /**
     * 查询卡口信息列表
     */
    @RequiresPermissions("traffic:crossing:list")
    @PostMapping("/list")
    @ResponseBody
    public TableDataInfo list(TrafficCrossingInfo trafficCrossingInfo)
    {
        startPage();
        List<TrafficCrossingInfo> list = trafficCrossingInfoService.selectTrafficCrossingInfoList(trafficCrossingInfo);
        return getDataTable(list);
    }

    /**
     * 导出卡口信息列表
     */
    @RequiresPermissions("traffic:crossing:export")
    @Log(title = "卡口信息", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(TrafficCrossingInfo trafficCrossingInfo)
    {
        List<TrafficCrossingInfo> list = trafficCrossingInfoService.selectTrafficCrossingInfoList(trafficCrossingInfo);
        ExcelUtil<TrafficCrossingInfo> util = new ExcelUtil<TrafficCrossingInfo>(TrafficCrossingInfo.class);
        return util.exportExcel(list, "卡口信息数据");
    }
    /**
     * 导出卡口信息列表
     */
    @RequiresPermissions("traffic:crossing:export")
    @Log(title = "卡口信息", businessType = BusinessType.EXPORT)
    @PostMapping("/selectExport")
    @ResponseBody
    public AjaxResult selectExport(TrafficCrossingInfo trafficCrossingInfo)
    {
        List<TrafficCrossingInfo> list = trafficCrossingInfoService.selectTrafficCrossingInfoList(trafficCrossingInfo);
        ExcelUtil<TrafficCrossingInfo> util = new ExcelUtil<TrafficCrossingInfo>(TrafficCrossingInfo.class);
        return util.exportExcel(list, "卡口信息数据");
    }
    /**
     * 新增卡口信息
     */
    @GetMapping("/add")
    public String add(ModelMap mmap)
    {
        List<TrafficServerInfo> tdasList = trafficServerInfoService.selectTrafficServerInfoListByServerType("1");
        mmap.put("tdasList",tdasList);
        return prefix + "/add";
    }

    /**
     * 新增保存卡口信息
     */
    @RequiresPermissions("traffic:crossing:add")
    @Log(title = "卡口信息", businessType = BusinessType.INSERT)
    @PostMapping("/add")
    @ResponseBody
    public AjaxResult addSave(TrafficCrossingInfo trafficCrossingInfo)
    {
        return toAjax(trafficCrossingInfoService.insertTrafficCrossingInfo(trafficCrossingInfo));
    }

    /**
     * 修改卡口信息
     */
    @RequiresPermissions("traffic:crossing:edit")
    @GetMapping("/edit/{crossingId}")
    public String edit(@PathVariable("crossingId") Long crossingId, ModelMap mmap)
    {
        TrafficCrossingInfo trafficCrossingInfo = trafficCrossingInfoService.selectTrafficCrossingInfoByCrossingId(crossingId);
        mmap.put("trafficCrossingInfo", trafficCrossingInfo);
        List<TrafficServerInfo> tdasList = trafficServerInfoService.selectTrafficServerInfoListByServerType("1");
        mmap.put("tdasList",tdasList);
        return prefix + "/edit";
    }

    /**
     * 修改保存卡口信息
     */
    @RequiresPermissions("traffic:crossing:edit")
    @Log(title = "卡口信息", businessType = BusinessType.UPDATE)
    @PostMapping("/edit")
    @ResponseBody
    public AjaxResult editSave(TrafficCrossingInfo trafficCrossingInfo)
    {
        return toAjax(trafficCrossingInfoService.updateTrafficCrossingInfo(trafficCrossingInfo));
    }

    /**
     * 删除卡口信息
     */
    @RequiresPermissions("traffic:crossing:remove")
    @Log(title = "卡口信息", businessType = BusinessType.DELETE)
    @PostMapping( "/remove")
    @ResponseBody
    public AjaxResult remove(Long[] ids)
    {
        return toAjax(trafficCrossingInfoService.deleteTrafficCrossingInfoByCrossingIds(ids));
    }


    /**
     * 通道详细
     */
    @RequiresPermissions("traffic:crossing:list")
    @GetMapping("/detail/{id}")
    public String detail(@PathVariable("id") Long id, ModelMap mmap)
    {
        mmap.put("crossing",trafficCrossingInfoService.selectTrafficCrossingInfoByCrossingId(id));
        return "traffic/lane/laneInfo";
    }

    /**
     * 校验卡口编号唯一
     */
    @PostMapping("/checkCrossingBhUnique")
    @ResponseBody
    public String checkCrossingBhUnique(TrafficCrossingInfo trafficCrossingInfo)
    {
        return trafficCrossingInfoService.checkCrossingBhUnique(trafficCrossingInfo.getCrossingBh());
    }
}
