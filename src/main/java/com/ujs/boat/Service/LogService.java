package com.ujs.boat.Service;

import com.ujs.boat.Enity.Device;
import com.ujs.boat.Enity.Log;
import com.ujs.boat.Mapper.LogMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

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
    /**
     * 获取日志信息
     */
    public List<Log> logs(int start, int limit){
        return  logMapper.getLog(start,limit);
    }
    /**
     * 获取日志的数量
     */
    public int log_num(){
        return logMapper.log_num();
    }
}
