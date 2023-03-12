package com.ruoyi.project.traffic.serverinfo.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import com.alibaba.fastjson.JSON;
import com.ruoyi.common.constant.TrafficConstants;
import com.ruoyi.framework.web.domain.CxSelect;
import com.ruoyi.project.system.dict.domain.DictData;
import com.ruoyi.project.system.dict.service.IDictTypeService;
import com.ruoyi.project.traffic.serverinfo.domain.TrafficServerInfo;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import com.ruoyi.framework.aspectj.lang.annotation.Log;
import com.ruoyi.framework.aspectj.lang.enums.BusinessType;
import com.ruoyi.project.traffic.serverinfo.service.ITrafficServerInfoService;
import com.ruoyi.framework.web.controller.BaseController;
import com.ruoyi.framework.web.domain.AjaxResult;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.framework.web.page.TableDataInfo;

import javax.annotation.Resource;

/**
 * 服务器管理Controller
 * 
 * @author 刘苏义
 * @date 2022-05-21
 */
@Controller
@RequestMapping("/traffic/serverinfo")
public class TrafficServerInfoController extends BaseController
{
    private String prefix = "traffic/serverinfo";

    @Resource
    private ITrafficServerInfoService trafficServerInfoService;
    @Resource
    private IDictTypeService dictTypeService;


    @RequiresPermissions("traffic:serverinfo:view")
    @GetMapping()
    public String serverinfo()
    {
        return prefix + "/serverinfo";
    }

    /**
     * 查询服务器管理列表
     */
    @RequiresPermissions("traffic:serverinfo:list")
    @PostMapping("/list")
    @ResponseBody
    public TableDataInfo list(TrafficServerInfo trafficServerInfo)
    {
        startPage();
        List<TrafficServerInfo> list = trafficServerInfoService.selectTrafficServerInfoList(trafficServerInfo);
        return getDataTable(list);
    }

    /**
     * 导出服务器管理列表
     */
    @RequiresPermissions("traffic:serverinfo:export")
    @Log(title = "服务器管理", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(TrafficServerInfo trafficServerInfo)
    {
        List<TrafficServerInfo> list = trafficServerInfoService.selectTrafficServerInfoList(trafficServerInfo);
        ExcelUtil<TrafficServerInfo> util = new ExcelUtil<TrafficServerInfo>(TrafficServerInfo.class);
        return util.exportExcel(list, "服务器管理数据");
    }
    /**
     * 选择导出服务器管理列表
     */
    @RequiresPermissions("traffic:serverinfo:export")
    @Log(title = "服务器管理", businessType = BusinessType.EXPORT)
    @PostMapping("/selectExport")
    @ResponseBody
    public AjaxResult SelectExport(TrafficServerInfo trafficServerInfo)
    {
        List<TrafficServerInfo> list = trafficServerInfoService.selectTrafficServerInfoList(trafficServerInfo);
        ExcelUtil<TrafficServerInfo> util = new ExcelUtil<TrafficServerInfo>(TrafficServerInfo.class);
        return util.exportExcel(list, "服务器管理数据");
    }
    /**
     * 新增服务器管理
     */
    @GetMapping("/add")
    public String add(ModelMap mmap)
    {
        List<HashMap<String, Object>> tdhsMapList = new ArrayList<>();
        List<TrafficServerInfo> tdhsList = trafficServerInfoService.selectTrafficServerInfoListByServerType("2");
        for (TrafficServerInfo info:tdhsList) {
            HashMap<String, Object> map = new HashMap<>();
            map.put("id", info.getServerId());
            map.put("text",info.getServerName());
            tdhsMapList.add(map);
        }
        mmap.put("tdhsList", JSON.toJSON(tdhsMapList));

        List<HashMap<String, Object>> minioMapList = new ArrayList<>();
        List<TrafficServerInfo> minioList = trafficServerInfoService.selectTrafficServerInfoListByServerType("3");
        for (TrafficServerInfo info:minioList) {
            HashMap<String, Object> map = new HashMap<>();
            map.put("id", info.getServerId());
            map.put("text",info.getServerName());
            minioMapList.add(map);
        }
        mmap.put("minioList", JSON.toJSON(minioMapList));
        List<HashMap<String, Object>> serverTypeList = new ArrayList<>();
        List<DictData> dictDatas= dictTypeService.selectDictDataByType("server_type");
        for (DictData data:dictDatas) {
            HashMap<String, Object> map = new HashMap<>();
            map.put("id", data.getDictValue());
            map.put("text",data.getDictLabel());
            serverTypeList.add(map);
        }
        mmap.put("serverType", JSON.toJSON(serverTypeList));
        return prefix + "/add";
    }

    /**
     * 新增保存服务器管理
     */
    @RequiresPermissions("traffic:serverinfo:add")
    @Log(title = "服务器管理", businessType = BusinessType.INSERT)
    @PostMapping("/add")
    @ResponseBody
    public AjaxResult addSave(TrafficServerInfo trafficServerInfo, Model model)
    {
        return toAjax(trafficServerInfoService.insertTrafficServerInfo(trafficServerInfo));
    }

    @PostMapping("/ServerExsite")
    @ResponseBody
    public Integer tdhsServerExsite(TrafficServerInfo trafficServerInfo)
    {
        List<TrafficServerInfo> trafficServerInfos = trafficServerInfoService.selectTrafficServerInfoListByServerType("2");
        return trafficServerInfos.size();
    }
    /**
     * 校验服务类型是否唯一
     */
    @PostMapping("/checkServerTypeUnique")
    @ResponseBody
    public String checkServerTypeUnique(TrafficServerInfo trafficServerInfo)
    {
        if(!trafficServerInfo.getServerType().equals("1"))
        {
            return trafficServerInfoService.checkServerTypeUnique(trafficServerInfo.getServerType());
        }
        return TrafficConstants.SERVER_TYPE_UNIQUE;
    }
    /**
     * 修改服务器管理
     */
    @RequiresPermissions("traffic:serverinfo:edit")
    @GetMapping("/edit/{serverId}")
    public String edit(@PathVariable("serverId") Long serverId, ModelMap mmap)
    {
        /*服务器类型下拉数据*/
        List<HashMap<String, Object>> serverTypeList = new ArrayList<>();
        List<DictData> dictDatas= dictTypeService.selectDictDataByType("server_type");
        for (DictData data:dictDatas) {
            HashMap<String, Object> map = new HashMap<>();
            map.put("id", data.getDictValue());
            map.put("text",data.getDictLabel());
            serverTypeList.add(map);
        }
        mmap.put("serverType", JSON.toJSON(serverTypeList));
        /*tdhs服务器类型下拉数据*/
        List<HashMap<String, Object>> tdhsMapList = new ArrayList<>();
        List<TrafficServerInfo> tdhsList = trafficServerInfoService.selectTrafficServerInfoListByServerType("2");
        for (TrafficServerInfo data:tdhsList) {
            HashMap<String, Object> map = new HashMap<>();
            map.put("id", data.getServerId());
            map.put("text",data.getServerName());
            tdhsMapList.add(map);
        }
        mmap.put("tdhsList", JSON.toJSON(tdhsMapList));

        /*minio服务器类型下拉数据*/
        List<HashMap<String, Object>> minioMapList = new ArrayList<>();
        List<TrafficServerInfo> minioList = trafficServerInfoService.selectTrafficServerInfoListByServerType("3");
        for (TrafficServerInfo data:minioList) {
            HashMap<String, Object> map = new HashMap<>();
            map.put("id", data.getServerId());
            map.put("text",data.getServerName());
            minioMapList.add(map);
        }
        mmap.put("minioList", JSON.toJSON(minioMapList));

        /*根据服务器id查询服务器信息*/
        TrafficServerInfo trafficServerInfo = trafficServerInfoService.selectTrafficServerInfoByServerId(serverId);
        mmap.put("trafficServerInfo", trafficServerInfo);
        TrafficServerInfo tdhsInfo = trafficServerInfoService.selectTrafficServerInfoByServerId(trafficServerInfo.getTdhsServerId());
        if(tdhsInfo==null)
        {
            tdhsInfo=new TrafficServerInfo();
            tdhsInfo.setServerName("");
        }
        mmap.put("tdhsInfo", tdhsInfo);

        TrafficServerInfo minioInfo = trafficServerInfoService.selectTrafficServerInfoByServerId(trafficServerInfo.getMinioServerId());
        if(minioInfo==null) {
            minioInfo=new TrafficServerInfo();
            minioInfo.setServerName("");
        }
        mmap.put("minioInfo", minioInfo);

        return prefix + "/edit";
    }

    /**
     * 修改保存服务器管理
     */
    @RequiresPermissions("traffic:serverinfo:edit")
    @Log(title = "服务器管理", businessType = BusinessType.UPDATE)
    @PostMapping("/edit")
    @ResponseBody
    public AjaxResult editSave(TrafficServerInfo trafficServerInfo)
    {
        return toAjax(trafficServerInfoService.updateTrafficServerInfo(trafficServerInfo));
    }

    /**
     * 删除服务器管理
     */
    @RequiresPermissions("traffic:serverinfo:remove")
    @Log(title = "服务器管理", businessType = BusinessType.DELETE)
    @PostMapping( "/remove")
    @ResponseBody
    public AjaxResult remove(Long[] ids)
    {
        return toAjax(trafficServerInfoService.deleteTrafficServerInfoByServerIds(ids));
    }

    /**
     * 多级联动下拉
     */
    @RequiresPermissions("traffic:serverinfo:cxselect")
    @GetMapping("/cxselect")
    @ResponseBody
    public String cxselect(ModelMap mmap)
    {
        CxSelect cxSelectTB = new CxSelect();
        cxSelectTB.setN("淘宝");
        cxSelectTB.setV("taobao");
        CxSelect cxSelectTm = new CxSelect();
        cxSelectTm.setN("天猫");
        cxSelectTm.setV("tm");
        CxSelect cxSelectJhs = new CxSelect();
        cxSelectJhs.setN("聚划算");
        cxSelectJhs.setV("jhs");
        List<CxSelect> tmList = new ArrayList<CxSelect>();
        tmList.add(cxSelectTm);
        tmList.add(cxSelectJhs);
        cxSelectTB.setS(tmList);

        CxSelect cxSelectJD = new CxSelect();
        cxSelectJD.setN("京东");
        cxSelectJD.setV("jd");
        CxSelect cxSelectCs = new CxSelect();
        cxSelectCs.setN("京东超市");
        cxSelectCs.setV("jdcs");
        CxSelect cxSelectSx = new CxSelect();
        cxSelectSx.setN("京东生鲜");
        cxSelectSx.setV("jdsx");
        List<CxSelect> jdList = new ArrayList<CxSelect>();
        jdList.add(cxSelectCs);
        jdList.add(cxSelectSx);
        cxSelectJD.setS(jdList);

        List<CxSelect> cxList = new ArrayList<CxSelect>();
        cxList.add(cxSelectTB);
        cxList.add(cxSelectJD);

        mmap.put("data", JSON.toJSON(cxList));
        return prefix + "/add";
    }
}
