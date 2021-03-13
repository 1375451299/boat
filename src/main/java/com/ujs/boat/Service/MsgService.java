package com.ujs.boat.Service;

import com.ujs.boat.Enity.Insruction.Times;
import com.ujs.boat.Enity.Msg;
import com.ujs.boat.Enity.User;
import com.ujs.boat.Mapper.MsgMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Timer;

@Service
public class MsgService {
    @Autowired
    MsgMapper msgMapper;

    /**
     * 设备信息上传
     */
    public void insert(Msg msg){
        msgMapper.insert(msg);
    }
    /**
     * 查看指定时间信息（用于查看当前设备信息）
     */
    public Msg retrieval(String id, String time){
        Msg msg=new Msg();
        msg=msgMapper.retrieval(id,time);
        return msg;
    }
    /**
     * 查看指定区间的信息
     */
    public List<Msg> rec_msg(int start, int limit){
        List<Msg> msg;
        msg=msgMapper.rec_msg(start,limit);
        return msg;
    }
    /**
     * 获取信息的长度
     */
    public int msg_num(){
        return msgMapper.msg_num();
    }

    /**
     * 获取今天数据的数量
     */
    public int msg_num_today(){
        SimpleDateFormat dateFormat1 = new SimpleDateFormat("yyyy-MM-dd");
        String time=dateFormat1.format(new Date());
        String start=" 00:00:00";
        String end=" 23:59:59";
        return msgMapper.getMsg_today(time+start,time+end);
    }
    /**
     * 获取今天数据分区段详细数量
     */
    public List<Times> msg_num_detail(){
        SimpleDateFormat dateFormat1 = new SimpleDateFormat("yyyy-MM-dd");
        String time=dateFormat1.format(new Date());
        String start=" 00:00:00";
        String end=" 23:59:59";
        return msgMapper.msg_num_detail(time+start,time+end);
    }
}
