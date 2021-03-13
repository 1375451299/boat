package com.ujs.boat.Service;

import com.ujs.boat.Enity.Msg;
import com.ujs.boat.Enity.User;
import com.ujs.boat.Mapper.MsgMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

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
     * 查看指定时间信息
     */
    public Msg retrieval(String id, Date time){
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
}
