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
    /**
     * 添加设备
     */
    public void insert(Device device){
        deviceMapper.insert(device);
    }
    /**
     * 检查设备状态
     */
    public String check_status(String id){
        Device device=deviceMapper.check_status(id);
        return device.getStatus();
    }
    /**
     * 绑定设备主人
     */
    public void addUser(String id,String username){
        deviceMapper.addUser(id,username);
    }
    public void Updatetime(String id, Date time){
        deviceMapper.updateTime(id,time);
    }
    /**
     * 查看设备信息
     */
    public Device selectById(String id){
        Device device=deviceMapper.selectById(id);
        return device;
    }
    /**
     * 设备状态修改
     */
    public void Change_status(String status){
        deviceMapper.change_status(status);
    }
}
