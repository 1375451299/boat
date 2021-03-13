package com.ujs.boat.Service;

import com.ujs.boat.Enity.Device;
import com.ujs.boat.Enity.Insruction.Times;
import com.ujs.boat.Enity.Log;
import com.ujs.boat.Mapper.LogMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.Date;
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
    /**
     * 获取今天日志的数量
     */
    public int log_num_today(){
        SimpleDateFormat dateFormat1 = new SimpleDateFormat("yyyy-MM-dd");
        String time=dateFormat1.format(new Date());
        String start=" 00:00:00";
        String end=" 23:59:59";
        return logMapper.getLog_today(time+start,time+end);
    }

    /**
     * 获取今天日志分区段数量
     */
    public List<Times> log_num_datail(){
        SimpleDateFormat dateFormat1 = new SimpleDateFormat("yyyy-MM-dd");
        String time=dateFormat1.format(new Date());
        String start=" 00:00:00";
        String end=" 23:59:59";
        return logMapper.log_num_detail(time+start,time+end);
    }
}
