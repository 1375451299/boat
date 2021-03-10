package com.ujs.boat.Service;

import com.ujs.boat.Enity.Log;
import com.ujs.boat.Mapper.LogMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LogService {
    @Autowired
    LogMapper logMapper;
    /**
     * 指令日志
     */
    public void insert(Log log){
        logMapper.insert(log);
    }

}
