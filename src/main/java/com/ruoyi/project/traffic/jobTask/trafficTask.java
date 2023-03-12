package com.ruoyi.project.traffic.jobTask;

import org.springframework.stereotype.Component;

/**
 * 定时任务调度
 *
 * @author ruoyi
 */
@Component("trafficTask")
public class trafficTask {
    public void ScanfDeviceStatus(String params)
    {
        System.out.println("扫描设备状态：" + params);
    }
}
