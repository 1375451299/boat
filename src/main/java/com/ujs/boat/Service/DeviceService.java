package com.ujs.boat.Service;

import com.ujs.boat.Enity.Device;
import com.ujs.boat.Enity.Log;
import com.ujs.boat.Mapper.DeviceMapper;
import com.ujs.boat.Mapper.LogMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class DeviceService {
    @Autowired
    DeviceMapper deviceMapper;

    public void insert(Device device){
        deviceMapper.insert(device);
    }
    public String check_status(String id){
        Device device=deviceMapper.check_status(id);
        return device.getStatus();
    }
    public void addUser(String id,String username){
        deviceMapper.addUser(id,username);
    }
    public void Updatetime(String id, Date time){
        deviceMapper.updateTime(id,time);
    }
    public Device selectById(String id){
        Device device=deviceMapper.selectById(id);
        return device;
    }
}
