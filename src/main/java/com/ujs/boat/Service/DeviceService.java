package com.ujs.boat.Service;

import com.ujs.boat.Enity.Device;
import com.ujs.boat.Enity.Log;
import com.ujs.boat.Mapper.DeviceMapper;
import com.ujs.boat.Mapper.LogMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.lang.management.LockInfo;
import java.util.Date;
import java.util.List;

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
    /**
     * 记录上线时间
     */
    public void Updatetime(String id, String time){
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
     * 全部设备状态修改
     */
    public void Change_status(String status){
        deviceMapper.change_status(status);
    }
    /**
     * 单个设备状态修改
     */
    public void update_status(String status,String id){
        deviceMapper.update_status(status,id);
    }
    /**
     * 获取所有设备信息
     */
    public List<Device> devices(int start,int limit){
        return  deviceMapper.getDevice(start,limit);
    }
    /**
     * 获取船只的数量
     */
    public int device_num(){
        return deviceMapper.device_num();
    }
    /**
     * 获取在线船只的数量
     */
    public int num_on(){
        return deviceMapper.num_on("上线");
    }
    /**
     * 获取在线船只的id
     */
    public List<String> device_online(){
        return deviceMapper.device_online();
    }
    /**
     * 依据船的id删除设备
     */
    public void  deleteByIddevice(String device_name){
        deviceMapper.deleteByIddevice(device_name);
    }
    /**
     * 修改设备主人
     */
    public void  updateByIduser(String user_name,String device_name){
        deviceMapper.updateByIduser(user_name,device_name);
    }

}
