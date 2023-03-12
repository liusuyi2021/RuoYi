package com.ruoyi.project.traffic.view;

import com.ruoyi.framework.web.controller.BaseController;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
@Controller
@RequestMapping("/traffic/view")
public class viewController extends BaseController{
        private String prefix = "traffic/view";
        @RequiresPermissions("traffic:view")
        @GetMapping("")
        public String view()
        {
            return prefix+"/index.html";
        }
}
