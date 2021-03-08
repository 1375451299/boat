package com.ujs.boat.Socket;

import com.ujs.boat.Enity.Msg;
import com.ujs.boat.Enity.SocketUser;
import com.ujs.boat.Enity.User;
import com.ujs.boat.Service.MsgService;
import com.ujs.boat.common.SpringUtil;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;


public class ServerThread2 extends  Thread {

    MsgService msgService = (MsgService) SpringUtil.getBean(MsgService.class);
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
                String msg = user.getBr().readLine();
                System.out.println(msg);

                Msg rec=new Msg();
                msgService.insert(rec);
                try {
                    User users = new User();
                    users.setOpenId("sss");
                }
                catch (Exception e){
                    e.printStackTrace();
                }
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