package com.ruoyi.project.traffic.laneinfo.controller;

import com.ruoyi.framework.web.controller.BaseController;
import com.ruoyi.framework.web.domain.AjaxResult;
import com.ruoyi.framework.web.domain.Ztree;
import com.ruoyi.project.traffic.channelinfo.domain.TrafficChannelInfo;
import com.ruoyi.project.traffic.deviceInfo.domain.TrafficDeviceInfo;
import com.ruoyi.project.traffic.laneinfo.service.ITrafficLaneInfoService;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

/**
 * 通道信息Controller
 * 
 * @author 刘苏义
 * @date 2022-05-17
 */
@Controller
@RequestMapping("/traffic/lane")
public class TrafficLaneInfoController extends BaseController
{
    @Resource
    private ITrafficLaneInfoService trafficLaneInfoService;

    private String prefix = "traffic/lane";

    @RequiresPermissions("traffic:lane:view")
    @GetMapping()
    public String laneinfo()
    {
        return prefix + "/laneInfo";
    }

    @Autowired
    private ITrafficLaneInfoService laneService;
    /**
     * 加载设备列表树
     */
    @ResponseBody
    @GetMapping("/treeData/{crossingId}")
    public List<Ztree> treeData(@PathVariable("crossingId") Long crossingId)
    {
        List<Ztree> ztrees = laneService.selectLaneTree(crossingId,new TrafficDeviceInfo(),new TrafficChannelInfo());
        return ztrees;
    }
    @ResponseBody
    @RequiresPermissions("traffic:lane:save")
    @PostMapping("/save")
    public AjaxResult ChanToCrossingInfo(Long crossingId,String lane)
    {
       trafficLaneInfoService.SetLaneInfo(crossingId,lane);
       return success();
    }
}
