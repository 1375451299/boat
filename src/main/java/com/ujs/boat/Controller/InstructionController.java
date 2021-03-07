package com.ujs.boat.Controller;

import com.ujs.boat.Socket.ServerSocket1;
import io.swagger.annotations.Api;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;


@Api(value="/test",tags = "控制船")
@RestController
public class InstructionController {
    @Resource(name = "serverSocket1")
    private  ServerSocket1 serverSocket1;
    @PostMapping("/stop")
    public void stop(String userName) {
        serverSocket1.stop(userName);
    }
}
