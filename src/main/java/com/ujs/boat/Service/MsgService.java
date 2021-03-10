package com.ujs.boat.Service;

import com.ujs.boat.Enity.Msg;
import com.ujs.boat.Enity.User;
import com.ujs.boat.Mapper.MsgMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;

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
     * 查看信息
     */
    public Msg retrieval(String id, Date time){
        Msg msg=new Msg();
        msg=msgMapper.retrieval(id,time);
        return msg;
    }
}
