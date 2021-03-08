package com.ujs.boat.Socket;

import com.ujs.boat.Enity.Log;
import com.ujs.boat.Enity.SocketUser;
import com.ujs.boat.Service.LogService;
import com.ujs.boat.common.SpringUtil;
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

    //LogService logService = (LogService) SpringUtil.getBean(LogService.class);
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
                //System.out.println(list);
                //System.out.println("客户端的IP："+socket.getInetAddress().getHostAddress());
                new ServerThread2(user,list).start();//开启输入和输出的多线程
            }
        }catch (IOException exception){
            exception.printStackTrace();
        }
    }
    public String stop(String username){
        for (SocketUser user : list) {
            System.out.println(user.toString());
            if (user.getName().equals(username)){
                try {
                    PrintWriter pw =user.getPw();
                    pw.println("AAA000101");
                    pw.flush();

                    Log log =new Log();
                    log.setDevice_name(username);
                    log.setInstruction("AAA000101");
                    log.setTime(new Date());
                    logService.insert(log);

                    System.out.println("消息转发成功！");
                } catch (Exception e) {
                    e.printStackTrace();
                }

            }
        }
        return "成功";
    }



}