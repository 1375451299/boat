package com.ujs.boat.Controller;

import com.ujs.boat.Enity.Device;
import com.ujs.boat.Enity.Log;
import com.ujs.boat.Enity.Msg;
import com.ujs.boat.Enity.User;
import com.ujs.boat.Mapper.MsgMapper;
import com.ujs.boat.Service.DeviceService;
import com.ujs.boat.Service.LogService;
import com.ujs.boat.Service.MsgService;
import com.ujs.boat.Service.UserService;
import com.ujs.boat.common.GlobalResult;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

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

    @PostMapping("/system/user")
    @ApiOperation(value = "查询用户信息", notes = "依据区间来查询指定长度的用户信息")
    public GlobalResult user(int start, int end) {
        int limit=end-start;
        List<User> user=userService.users(start,limit);
        GlobalResult result = GlobalResult.build(200, "信息查询成功", user);
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

    @GetMapping("/system/user_num")
    @ApiOperation(value = "查询用户长度", notes = "查询用户数量长度")
    public GlobalResult user_num() {
        int num =userService.user_num();
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
}
