package com.ujs.boat.Config;

import com.ujs.boat.Enity.Log;
import com.ujs.boat.Enity.SocketUser;
import com.ujs.boat.Service.DeviceService;
import com.ujs.boat.Service.UserService;
import com.ujs.boat.Socket.ServerSocket1;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;


@Component
public class TaskTimer {

    @Autowired
    DeviceService deviceService;
    @Autowired
    UserService userService;
    @Resource(name = "serverSocket1")
    private ServerSocket1 serverSocket1;

    @Scheduled(cron = "0 */1 * * * ?")
    public void setStatus(){
        deviceService.Change_status("下线");
    }
    @Scheduled(cron = "0 */30 * * * ?")
    public void setUserStatus(){
        userService.Change_status("下线");
    }
    @Scheduled(cron = "0 */1 * * * ?")
    public void getConnectedSockets(){
        for (SocketUser user : serverSocket1.list) {
            if (user.getSocket().isConnected())
            System.out.println("用户名"+user.getName());
            else
                serverSocket1.list.remove(user);
        }
    }
}
