package com.ujs.boat.Controller;


/**
 * @author ：zlf
 * @since ：Created in 2021/3/7
 */
import com.ujs.boat.Enity.Insruction.Automatic;
import com.ujs.boat.Enity.Insruction.Manual;
import com.ujs.boat.Socket.ServerSocket1;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;


@Api(tags = "控制船")
@RestController
public class InstructionController {
    @Resource(name = "serverSocket1")
    private  ServerSocket1 serverSocket1;


    @PostMapping("/boat/stop")
    @ApiOperation(value = "停车指令", notes = "根据设备的id来执行停车指令")
    public void stop(String deviceName) {
        serverSocket1.stop(deviceName);
    }

    @PostMapping("/boat/Baiting_endurance")
    @ApiOperation(value = "投饵续航指令", notes = "根据设备的id来执行投饵续航指令")
    public void Baiting_endurance(String deviceName) {
        serverSocket1.Baiting_endurance(deviceName);
    }

    @PostMapping("/boat/Spraying_Cruise")
    @ApiOperation(value = "施药巡航指令", notes = "根据设备的id来执行施药巡航指令")
    public void Spraying_Cruise(String deviceName) {
        serverSocket1.Spraying_Cruise(deviceName);
    }

    @PostMapping("/boat/Application_duration")
    @ApiOperation(value = "施药续航指令", notes = "根据设备的id来执行施药续航指令")
    public void Application_duration(String deviceName) {
        serverSocket1.Application_duration(deviceName);
    }

    @PostMapping("/boat/Cruise_pause")
    @ApiOperation(value = "巡航暂停指令", notes = "根据设备的id来执行巡航暂停指令")
    public void Cruise_pause(String deviceName) {
        serverSocket1.Cruise_pause(deviceName);
    }

    @PostMapping("/boat/Return")
    @ApiOperation(value = "返航指令", notes = "根据设备的id来执行返航指令")
    public void Return(String deviceName) {
        serverSocket1.Return(deviceName);
    }

    @PostMapping("/boat/Feeding_Cruise")
    @ApiOperation(value = "投饵巡航指令", notes = "根据设备的id来执行投饵巡航指令")
    public void Feeding_Cruise(String deviceName) {
        serverSocket1.Feeding_Cruise(deviceName);
    }

    @PostMapping("/boat/Origin_calibration")
    @ApiOperation(value = "原点校准指令", notes = "根据设备的id来执行原点校准指令")
    public void Origin_calibration(String deviceName) {
        serverSocket1.Origin_calibration(deviceName);
    }

    @PostMapping("/boat/Geomagnetic_calibration")
    @ApiOperation(value = "地磁校准指令", notes = "根据设备的id来执行地磁校准指令")
    public void Geomagnetic_calibration(String deviceName) {
        serverSocket1.Geomagnetic_calibration(deviceName);
    }

    @PostMapping("/boat/Manual_control")
    @ApiOperation(value = "手动控制指令", notes = "根据设备的id来执行手动控制指令")
    public void Manual_control(@RequestBody Manual manual) {
        serverSocket1.Manual_control(manual);
    }

    @PostMapping("/boat/Automatic_control")
    @ApiOperation(value = "自动控制指令", notes = "根据设备的id来执行自动控制指令")
    public void Automatic_control(@RequestBody Automatic automatic) {
        serverSocket1.Automatic_control(automatic);
    }

    @PostMapping("/boat/download")
    @ApiOperation(value = "差分数据下载指令", notes = "根据差分数据服务帐号密码下载指令")
    public void download(String devicename,String account) {
        serverSocket1.download(devicename,account);
    }
}
