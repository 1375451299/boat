package com.ujs.boat.Socket;

import com.ujs.boat.Enity.Insruction.Automatic;
import com.ujs.boat.Enity.Insruction.Manual;
import com.ujs.boat.Enity.Log;
import com.ujs.boat.Enity.SocketUser;
import com.ujs.boat.Service.LogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Component("serverSocket1")
public class ServerSocket1 {

    @Autowired
    LogService logService;
    private ServerSocket serverSocket;
    private  List<SocketUser> list = new ArrayList<SocketUser>();
    public void ServerSocketDemo(){
        int count=0;
        try{
            //存放 连接上服务器的用户 列表
            serverSocket=new ServerSocket(5200);//开启服务的端口，需和客户端一致
            System.out.println("服务端已经启动，等待客户端连接");
            while (true){
                Socket socket=serverSocket.accept();
                count++;
                SocketUser user = new SocketUser("user" + count,socket);
                System.out.println(user.getName() + "正在登录。。。");
                list.add(user);//把新增的用户添加到list里面
                System.out.println(list);
                //System.out.println("客户端的IP："+socket.getInetAddress().getHostAddress());
                new ServerThread2(user,list).start();//开启输入和输出的多线程
            }
        }catch (IOException exception){
            exception.printStackTrace();
        }
    }

    /**
     * 发送指令
     */
    private void send(String devicename,String Instruction){
        for (SocketUser user : list) {
            if (user.getName().equals(devicename)){
                try {
                    PrintWriter pw =user.getPw();
                    pw.println(Instruction);
                    pw.flush();

                    Log log =new Log();
                    log.setDevice_name(devicename);
                    log.setInstruction(Instruction);
                    log.setTime(new Date());
                    logService.insert(log);
                    System.out.println("消息转发成功！");
                } catch (Exception e) {
                    e.printStackTrace();
                }

            }
        }
    }
    /**
     * 停船指令
     */
    public void stop(String devicename){
        send(devicename,"AAA0001:01");
    }
    /**
     * 手动控制指令
     */
    public void Manual_control(Manual manual){
        send(manual.getDevice_name(),"AAA0001:02"+","+manual.getLeft_wheel()+","+manual.getRight_wheel()+","+manual.getFeed()+","+manual.getBlanking()+","+manual.getValve()+","+manual.getPump());
    }
    /**
     * 自动控制指令
     */
    public void Automatic_control(Automatic automatic){
        send(automatic.getDevice_name(),"AAA0001:03"+","+automatic.getX_coordinate()+","+automatic.getY_coordinate()+","+automatic.getFeed()+","+automatic.getBlanking()+","+automatic.getValve()+","+automatic.getPump());
    }
    /**
     * 投饵续航指令
     */
    public void Baiting_endurance(String devicename){
        send(devicename,"AAA0001:05");
    }
    /**
     * 	施药巡航指令
     */
    public void Spraying_Cruise(String devicename){
        send(devicename,"AAA0001:06");
    }
    /**
     * 	施药续航指令
     */
    public void Application_duration(String devicename){
        send(devicename,"AAA0001:07");
    }
    /**
     * 	巡航暂停指令
     */
    public void Cruise_pause(String devicename){
        send(devicename,"AAA0001:08");
    }
    /**
     * 	返航指令
     */
    public void Return(String devicename){
        send(devicename,"AAA0001:09");
    }
    /**
     * 	投饵巡航指令
     */
    public void Feeding_Cruise(String devicename){
        send(devicename,"AAA0001:04");
    }
    /**
     * 	原点校准指令
     */
    public void Origin_calibration(String devicename){
        send(devicename,"AAA0001:10");
    }
    /**
     * 	地磁校准指令
     */
    public void Geomagnetic_calibration(String devicename){
        send(devicename,"AAA0001:11");
    }
    /**
     * 	地图下载指令
     */
    public void Map_download(){

    }
    /**
     * 	差分数据服务帐号密码下载指令
     */
    public void download(String devicename,String account){
        send(devicename,"AAA0001:13,"+account);
    }



}