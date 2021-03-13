package com.ujs.boat.Socket;

import com.ujs.boat.Enity.*;
import com.ujs.boat.Service.DeviceService;
import com.ujs.boat.Service.LogService;
import com.ujs.boat.Service.MsgService;
import com.ujs.boat.common.SpringUtil;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;


public class ServerThread2 extends  Thread {

    MsgService msgService = SpringUtil.getBean(MsgService.class);
    DeviceService deviceService = SpringUtil.getBean(DeviceService.class);
    private SocketUser user;
    private List<SocketUser> list;


    public ServerThread2(SocketUser user, List<SocketUser> list) {
        this.user = user;
        this.list = list;
    }

    public void run() {
        try {
            while (true) {
                //不断地读取客户端发过来的信息
                String msg = user.getBr().readLine();
                //String string = "AAA0000:003000425850500C20353555,9000.0000000N,18000.0000000E,0000,0000.0000000N,00000.0000000E,800,E000.0,N000.0,225.0,+0.00,+000.0,E000.0,N000.0,E000.0,N000.0,000.0,24.6,00.2,79.1,00000000";
                Msg rec=new Msg();
                Device device=new Device();
                //System.out.println(msg);
                if (msg.length()==194){
                    rec=data_processing(msg,rec);
                    setname(user,rec.getId());
                    device=deviceService.selectById(rec.getId());
                    if (device!=null){
                        deviceService.update_status("上线",device.getDevice_name());
                        SimpleDateFormat dateFormat1 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
                        String time=dateFormat1.format(new Date());
                        deviceService.Updatetime(rec.getId(),time);
                    }
                    else{
                        Device creat=new Device();
                        creat.setDevice_name(rec.getId());
                        SimpleDateFormat dateFormat1 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
                        String time=dateFormat1.format(new Date());
                        creat.setCreateTime(time);
                        creat.setLastVisitTime(time);
                        creat.setStatus("上线");
                        deviceService.insert(creat);
                    }
                    msgService.insert(rec);
                }
                //System.out.println("消息接收完成");
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

    private Msg data_processing(String str,Msg msg){
        String substring = str.substring(0, str.length() - 1);
        //以逗号分割，得出的数据存到 result 里面
        String result = str.replace(":",",");
        String[] result1 = result.split(",");
//        System.out.println("系统版本: " + result1[0]);
//        System.out.println("产品唯一标识: " + result1[1]);
//        System.out.println("原点经度: " + result1[3]);
//        System.out.println("原点纬度: " + result1[2]);
//        System.out.println("工作状态: " + result1[4]);
//        System.out.println("当前经度: " + result1[6]);
//        System.out.println("当前经度: " + result1[5]);
//        System.out.println("GPS接收机状态: " + result1[7]);
//        System.out.println("当前X坐标: " + result1[8]+"m");
//        System.out.println("当前Y坐标: " + result1[9]+"m");
//        System.out.println("当前航向角: " + result1[10]+"°");
//        System.out.println("当前船速: " + result1[11]+"m/s");
//        System.out.println("当前转速: " + result1[12]+"°/s");
//        System.out.println("巡航第一目标点X坐标: " + result1[13]);
//        System.out.println("巡航第一目标点Y坐标: " + result1[14]);
//        System.out.println("巡航第二目标点X坐标: " + result1[15]);
//        System.out.println("巡航第二目标点Y坐标: " + result1[16]);
//        System.out.println("料仓余料: " + result1[17]+"kg");
//        System.out.println("电池电压: " + result1[18]+"V");
//        System.out.println("电池放电电流: " + result1[19]+"A");
//        System.out.println("电池剩余电量估计: " + result1[20]+"%");
//        System.out.println("地图校验码: " + result1[21]);

        msg.setVersion(result1[0]);
        msg.setId(result1[1]);
        msg.setOrigin_longitude(result1[3]);
        msg.setOrigin_latitude(result1[2]);
        msg.setStatus(result1[4]);
        msg.setLongitude(result1[6]);
        msg.setLatitude(result1[5]);
        msg.setGPS(result1[7]);
        msg.setX_coordinate(result1[8]);
        msg.setY_coordinate(result1[9]);
        msg.setHeading_angle(result1[10]);
        msg.setSpeed(result1[11]);
        msg.setRevolution(result1[12]);
        msg.setX_first_point(result1[13]);
        msg.setY_first_point(result1[14]);
        msg.setX_second_point(result1[15]);
        msg.setY_second_point(result1[16]);
        msg.setClout(result1[17]);
        msg.setVoltage(result1[18]);
        msg.setCurrent(result1[19]);
        msg.setQuantity(result1[20]);
        msg.setCheck_code(result1[21]);
        SimpleDateFormat dateFormat1 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String time=dateFormat1.format(new Date());
        msg.setTime(time);
        return msg;
    }
}