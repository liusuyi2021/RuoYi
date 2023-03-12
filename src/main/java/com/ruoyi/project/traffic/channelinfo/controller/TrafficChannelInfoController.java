package com.ruoyi.project.traffic.channelinfo.controller;

import java.util.List;

import com.ruoyi.project.traffic.deviceInfo.domain.TrafficDeviceInfo;
import com.ruoyi.project.traffic.deviceInfo.service.ITrafficDeviceInfoService;
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
import com.ruoyi.project.traffic.channelinfo.domain.TrafficChannelInfo;
import com.ruoyi.project.traffic.channelinfo.service.ITrafficChannelInfoService;
import com.ruoyi.framework.web.controller.BaseController;
import com.ruoyi.framework.web.domain.AjaxResult;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.framework.web.page.TableDataInfo;

import javax.annotation.Resource;

/**
 * 通道信息Controller
 * 
 * @author 刘苏义
 * @date 2022-05-17
 */
@Controller
@RequestMapping("/traffic/channel")
public class TrafficChannelInfoController extends BaseController
{
    private String prefix = "traffic/channel";

    @Resource
    private ITrafficChannelInfoService trafficChannelInfoService;
    @Autowired
    private ITrafficDeviceInfoService trafficDeviceInfoService;

    @RequiresPermissions("traffic:channel:view")
    @GetMapping()
    public String channelinfo()
    {
        return prefix + "/channelInfo";
    }

    /**
     * 查询通道信息列表
     */
    @RequiresPermissions("traffic:channel:list")
    @PostMapping("/list")
    @ResponseBody
    public TableDataInfo list(TrafficChannelInfo trafficChannelInfo)
    {
        startPage();
        List<TrafficChannelInfo> list = trafficChannelInfoService.selectTrafficChannelInfoList(trafficChannelInfo);
        return getDataTable(list);
    }

    /**
     * 导出通道信息列表
     */
    @RequiresPermissions("traffic:channel:export")
    @Log(title = "通道信息", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(TrafficChannelInfo trafficChannelInfo)
    {
        List<TrafficChannelInfo> list = trafficChannelInfoService.selectTrafficChannelInfoList(trafficChannelInfo);
        ExcelUtil<TrafficChannelInfo> util = new ExcelUtil<TrafficChannelInfo>(TrafficChannelInfo.class);
        return util.exportExcel(list, "通道信息数据");
    }
    /**
     * 导出通道信息列表
     */
    @RequiresPermissions("traffic:channel:export")
    @Log(title = "通道信息", businessType = BusinessType.EXPORT)
    @PostMapping("/selectExport")
    @ResponseBody
    public AjaxResult selectExport(TrafficChannelInfo trafficChannelInfo)
    {
        List<TrafficChannelInfo> list = trafficChannelInfoService.selectTrafficChannelInfoList(trafficChannelInfo);
        ExcelUtil<TrafficChannelInfo> util = new ExcelUtil<TrafficChannelInfo>(TrafficChannelInfo.class);
        return util.exportExcel(list, "通道信息数据");
    }
    /**
     * 查询通道详细
     */
    @RequiresPermissions("traffic:channel:list")
    @GetMapping("/detail/{deviceId}")
    public String detail(@PathVariable("deviceId") Long deviceId, ModelMap mmap) {
        TrafficDeviceInfo trafficDeviceInfo = trafficDeviceInfoService.selectTrafficDeviceInfoById(deviceId);
        mmap.put("device", trafficDeviceInfo);
        List<TrafficDeviceInfo> trafficDeviceInfos = trafficDeviceInfoService.selectTrafficDeviceInfoAll();
        mmap.put("deviceList", trafficDeviceInfos);
        return prefix+"/channelInfo";
    }

}
