package com.ruoyi.project.traffic.map;

import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.ruoyi.framework.web.controller.BaseController;
@Controller
@RequestMapping("/traffic/map")
public class mapController extends BaseController {		
	 private String prefix = "traffic/map";	
	
	 @RequiresPermissions("traffic:map:list")
	 @GetMapping("/index")
	 public String map()
	 {
	    return prefix+"/index";
	 }
}
