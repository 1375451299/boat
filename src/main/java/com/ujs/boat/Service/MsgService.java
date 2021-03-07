package com.ujs.boat.Service;

import com.ujs.boat.Enity.Msg;
import com.ujs.boat.Enity.User;
import com.ujs.boat.Mapper.MsgMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MsgService {
    @Autowired
    MsgMapper msgMapper;

    public void insert(Msg msg){
        msgMapper.insert(msg);
    }

}
