package com.ujs.boat.Config;

import com.ujs.boat.Service.DeviceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.text.SimpleDateFormat;
import java.util.Date;

@Component
public class TaskTimer {

    @Autowired
    DeviceService deviceService;

    @Scheduled(cron = "0 */5 * * * ?")
    public void setStatus(){
        deviceService.Change_time("下线");
        SimpleDateFormat dateFormat1 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        System.out.println(dateFormat1.format(new Date()));
    }

}
