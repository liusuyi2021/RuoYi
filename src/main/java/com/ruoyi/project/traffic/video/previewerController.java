package com.ruoyi.project.traffic.video;

import com.ruoyi.framework.web.controller.BaseController;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/traffic/video")
public class previewerController extends BaseController {
    private String prefix = "traffic/video";

    @RequiresPermissions("traffic:video:index")
    @GetMapping("/index")
    public String index() {
        return prefix + "/index.html";
    }

}