package com.ujs.boat.Socket;

import com.ujs.boat.Enity.Msg;
import com.ujs.boat.Enity.SocketUser;
import com.ujs.boat.Enity.User;
import com.ujs.boat.Service.UserService;
import com.ujs.boat.common.SpringUtil;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;


public class ServerThread2 extends  Thread {

    UserService userService = (UserService) SpringUtil.getBean(UserService.class);

    private SocketUser user;
    private List<SocketUser> list;


    public ServerThread2(SocketUser user, List<SocketUser> list) {
        this.user = user;
        this.list = list;
    }

    public void run() {
        try {
            while (true) {
                // 信息的格式：(add||remove||chat),收件人,...,收件人,发件人,信息体
                //不断地读取客户端发过来的信息
                Msg rec=new Msg();
                String msg = user.getBr().readLine();
                System.out.println(msg);
                String[] str = msg.split(",");
                setname(user,"sss");
                int i=str.length;
                System.out.println(i);
                try {
                    User users = new User();
                    users.setOpenId("sss");
                    userService.insert(users);
                }
                catch (Exception e){
                    e.printStackTrace();
                }
                //转发消息
//                switch (str[0]) {
//                    case "remove":
//                        remove(user);// 移除用户，此处仅仅只是从list中移除用户
//                        break;
//                    case "chat":
//                        // 转发信息给特定的用户，单发或群发
//                        for (int a=1;a<=i-3;a++) {
//                            sendToClient(str[a], msg);
//                        }
//                        break;
//                    case "add":
//                        addUser(user);//添加用户，此处仅仅是list中添加用户
//                    default:
//                        break;
//                }
            }
        } catch (Exception e) {
            System.out.println("用户断开连接");
            remove(user);
        } finally {
            try {
                user.getBr().close();
                user.getSocket().close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
    //在用户列表中添加用户信息
    private void addUser(SocketUser user) {
        list.add(user);
        System.out.println(list);
    }

    //转发消息
    private void sendToClient(String username, String msg) {

        for (SocketUser user : list) {
            if (user.getName().equals(username)) {
                try {
                    PrintWriter pw =user.getPw();
                    pw.println(msg);
                    pw.flush();
                    System.out.println("消息转发成功！");
                    break;
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
    }
    //从用户列表中删除用户
    private void remove(SocketUser user2) {
        list.remove(user2);
        System.out.println(list);
    }

    private void setname(SocketUser user,String name){

        for (SocketUser users : list) {
            if (users.getName()==user.getName()){
                user.setName(name);
                list.remove(users);
                list.add(user);
            }
        }
    }
}