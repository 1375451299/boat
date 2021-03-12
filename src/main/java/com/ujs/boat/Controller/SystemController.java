package com.ujs.boat.Controller;

import com.ujs.boat.Enity.Device;
import com.ujs.boat.Enity.Msg;
import com.ujs.boat.Mapper.MsgMapper;
import com.ujs.boat.Service.DeviceService;
import com.ujs.boat.Service.MsgService;
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

    @PostMapping("/system/device")
    @ApiOperation(value = "查询设备信息", notes = "查询已有的设备列表信息")
    public GlobalResult device(int start, int end) {
        List<Device> devices = deviceService.devices(start, end);
        GlobalResult result = GlobalResult.build(200, "信息查询成功", devices);
        return result;
    }

    @PostMapping("/system/msg")
    @ApiOperation(value = "查询历史信息", notes = "依据区间来查询指定长度的信息")
    public GlobalResult msg(int start, int end) {
        List<Msg> msg=msgService.rec_msg(start,end);
        GlobalResult result = GlobalResult.build(200, "信息查询成功", msg);
        return result;
    }
}
