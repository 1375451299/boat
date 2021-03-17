package com.ujs.boat.Controller;

import com.ujs.boat.Enity.Device;
import com.ujs.boat.Enity.Insruction.Manual;
import com.ujs.boat.Enity.Insruction.Times;
import com.ujs.boat.Enity.Log;
import com.ujs.boat.Enity.Msg;
import com.ujs.boat.Enity.User;
import com.ujs.boat.Service.DeviceService;
import com.ujs.boat.Service.LogService;
import com.ujs.boat.Service.MsgService;
import com.ujs.boat.Service.UserService;
import com.ujs.boat.common.GlobalResult;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@Api(tags = "后台信息查询")
@RestController
@CrossOrigin
public class SystemController {

    @Autowired
    MsgService msgService;
    @Autowired
    DeviceService deviceService;
    @Autowired
    UserService userService;
    @Autowired
    LogService logService;

    @PostMapping("/system/device")
    @ApiOperation(value = "查询船只信息", notes = "查询已有的设备列表信息")
    public GlobalResult device(int start, int end) {
        int limit=end-start;
        List<Device> devices = deviceService.devices(start, limit);
        GlobalResult result = GlobalResult.build(200, "信息查询成功", devices);
        return result;
    }

    @PostMapping("/system/msg")
    @ApiOperation(value = "查询历史信息", notes = "依据区间来查询指定长度的信息")
    public GlobalResult msg(int start, int end) {
        int limit=end-start;
        List<Msg> msg=msgService.rec_msg(start,limit);
        GlobalResult result = GlobalResult.build(200, "信息查询成功", msg);
        return result;
    }

    @PostMapping("/system/log")
    @ApiOperation(value = "查询日志信息", notes = "依据区间来查询指定长度的日志信息")
    public GlobalResult log(int start, int end) {
        int limit=end-start;
        List<Log> log=logService.logs(start,limit);
        GlobalResult result = GlobalResult.build(200, "信息查询成功", log);
        return result;
    }

    @PostMapping("/system/deletelog")
    @ApiOperation(value = "删除日志信息", notes = "依据id来删除日志信息")
    public GlobalResult deletelog(int row) {
        try {
            logService.deletelog(row);
            GlobalResult result = GlobalResult.build(200, "删除日志成功", null);
            return result;
        }
        catch (Exception e){
            e.printStackTrace();
            GlobalResult result = GlobalResult.build(500, "删除日志失败", null);
            return result;
        }
    }

    @PostMapping("/system/deletemsg")
    @ApiOperation(value = "删除上行数据信息", notes = "依据id来删除数据信息")
    public GlobalResult deletemsg(int row) {
        try {
            msgService.deletemsg(row);
            GlobalResult result = GlobalResult.build(200, "删除日志成功", null);
            return result;
        }
        catch (Exception e){
            e.printStackTrace();
            GlobalResult result = GlobalResult.build(500, "删除日志失败", null);
            return result;
        }
    }

    @PostMapping("/system/deleteByIddevice")
    @ApiOperation(value = "依据船的id删除设备", notes = "依据船的id删除设备")
    public GlobalResult deleteByIddevice(String device_name) {
        try {
            deviceService.deleteByIddevice(device_name);
            GlobalResult result = GlobalResult.build(200, "设备删除成功", null);
            return result;
        }
        catch (Exception e){
            e.printStackTrace();
            GlobalResult result = GlobalResult.build(500, "设备删除失败", null);
            return result;
        }
    }

    @PostMapping("/system/updateByIduser")
    @ApiOperation(value = "依据船的id修改设备主人", notes = "依据船的id修改设备主人")
    public GlobalResult updateByIduser(String user_name,String device_name) {
        try {
            deviceService.updateByIduser(user_name,device_name);
            GlobalResult result = GlobalResult.build(200, "船主修改成功", null);
            return result;
        }
        catch (Exception e){
            e.printStackTrace();
            GlobalResult result = GlobalResult.build(500, "船主修改失败", null);
            return result;
        }
    }

    @GetMapping("/system/msg_num")
    @ApiOperation(value = "查询信息长度", notes = "查询信息长度")
    public GlobalResult msg_num() {
        int num =msgService.msg_num();
        GlobalResult result = GlobalResult.build(200, "信息查询成功", num);
        return result;
    }

    @GetMapping("/system/device_num")
    @ApiOperation(value = "获取船只的数量", notes = "获取船只的数量")
    public GlobalResult device_num() {
        int num =deviceService.device_num();
        GlobalResult result = GlobalResult.build(200, "信息查询成功", num);
        return result;
    }

    @GetMapping("/system/device_num_on")
    @ApiOperation(value = "获取在线船只的数量", notes = "获取在线船只的数量")
    public GlobalResult device_num_on() {
        int num =deviceService.num_on();
        GlobalResult result = GlobalResult.build(200, "信息查询成功", num);
        return result;
    }

    @GetMapping("/system/log_num")
    @ApiOperation(value = "查询日志信息长度", notes = "查询日志信息长度")
    public GlobalResult log_num() {
        int num =logService.log_num();
        GlobalResult result = GlobalResult.build(200, "信息查询成功", num);
        return result;
    }

    @GetMapping("/system/log_num_today")
    @ApiOperation(value = "查询今天日志信息数量", notes = "查询今日日志信息长度")
    public GlobalResult log_num_today() {
        int num =logService.log_num_today();
        GlobalResult result = GlobalResult.build(200, "信息查询成功", num);
        return result;
    }

    @GetMapping("/system/msg_num_today")
    @ApiOperation(value = "查询今天上行数据信息数量", notes = "查询今日上行信息长度")
    public GlobalResult msg_num_today() {
        int num =msgService.msg_num_today();
        GlobalResult result = GlobalResult.build(200, "信息查询成功", num);
        return result;
    }

    @GetMapping("/system/log_num_detail")
    @ApiOperation(value = "查询今天下行数据详细信息数量", notes = "查询今日下行信息详细长度")
    public GlobalResult log_num_detail() {
        List<Times> times =logService.log_num_datail();
        GlobalResult result = GlobalResult.build(200, "信息查询成功", times);
        return result;
    }

    @GetMapping("/system/msg_num_detail")
    @ApiOperation(value = "查询今天上行数据详细信息数量", notes = "查询今日上行信息详细长度")
    public GlobalResult msg_num_detail() {
        List<Times> times =msgService.msg_num_detail();
        GlobalResult result = GlobalResult.build(200, "信息查询成功", times);
        return result;
    }

    @GetMapping("/system/device_locate")
    @ApiOperation(value = "获取在线船只的位置及信息", notes = "获取在线船只的位置及信息")
    public GlobalResult device_locate() {
        List<String> devices=deviceService.device_online();
        Msg msg = null;
        ArrayList<Msg> msgs = new ArrayList<Msg>();
        try {
            for (String device:devices){
                msg=msgService.msg_device_detail(device);
                if (msg!=null)
                msgs.add(msg);
            }
            System.out.println(msg);
            GlobalResult result = GlobalResult.build(200, "信息查询成功", msgs);
            return result;
        }
        catch (Exception e){
            e.printStackTrace();
            GlobalResult result = GlobalResult.build(200, "无在线船只", null);
            return result;
        }


    }
}
