package com.ujs.boat.Controller;

import com.ujs.boat.Enity.User;
import com.ujs.boat.Service.UserService;
import com.ujs.boat.common.GlobalResult;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@Api(tags = "用户操作")
@RestController
@CrossOrigin
public class UserController {
    @Autowired
    UserService userService;

    @PostMapping("/user/register")
    @ApiOperation(value = "用户注册", notes = "用户注册")
    public GlobalResult register(@RequestBody User user) {
        User ret_user=new User();
        ret_user=userService.selectById(user.getId());
        if (ret_user==null){
            SimpleDateFormat dateFormat1 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            String time=dateFormat1.format(new Date());
            user.setCreateTime(time);
            userService.insert(user);
            GlobalResult result = GlobalResult.build(200, "用户创建成功", null);
            return result;
        }
        else{
            GlobalResult result = GlobalResult.build(500, "用户已存在", null);
            return result;
        }
    }

    @PostMapping("/user/login")
    @ApiOperation(value = "用户登录", notes = "用户登录")
    public GlobalResult login(String id,String password) {
        User ret_user=new User();
        ret_user=userService.selectById(id);
        if (ret_user==null){
            GlobalResult result = GlobalResult.build(500, "用户不存在", null);
            return result;
        }
        else{
            if (ret_user.getPassword().equals(password)) {
                SimpleDateFormat dateFormat1 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
                String time=dateFormat1.format(new Date());
                userService.update_status("上线",id);
                userService.updateTime(id,time);
                GlobalResult result = GlobalResult.build(200, "用户登录成功", null);
                return result;
            }
            else{
                GlobalResult result = GlobalResult.build(500, "用户密码错误", null);
                return result;
            }
        }
    }

    @PostMapping("/user/user_msg")
    @ApiOperation(value = "查询用户信息", notes = "依据区间来查询指定长度的用户信息")
    public GlobalResult user(int start, int end) {
        int limit=end-start;
        List<User> user=userService.users(start,limit);
        GlobalResult result = GlobalResult.build(200, "信息查询成功", user);
        return result;
    }

    @PostMapping("/user/deleteByIduser")
    @ApiOperation(value = "删除用户", notes = "依据id删除用户")
    public GlobalResult deleteByIduser(String id) {
        try {
            userService.deleteByIduser(id);
            GlobalResult result = GlobalResult.build(200, "删除用户成功", null);
            return result;
        }
        catch (Exception e){
            e.printStackTrace();
            GlobalResult result = GlobalResult.build(500, "删除用户失败", null);
            return result;
        }
    }

    @PostMapping("/user/updateById")
    @ApiOperation(value = "更新用户信息", notes = "提交用户表更新信息")
    public GlobalResult updateById(@RequestBody User user) {
        try {
            userService.updateById(user);
            GlobalResult result = GlobalResult.build(200, "更新用户信息成功", null);
            return result;
        }
        catch (Exception e){
            e.printStackTrace();
            GlobalResult result = GlobalResult.build(500, "更新用户信息失败", null);
            return result;
        }
    }

    @GetMapping("/user/user_num")
    @ApiOperation(value = "查询全部用户人数", notes = "查询全部用户数量长度")
    public GlobalResult user_num() {
        int num =userService.user_num();
        GlobalResult result = GlobalResult.build(200, "信息查询成功", num);
        return result;
    }

    @GetMapping("/user/user_num_on")
    @ApiOperation(value = "查询在线用户人数", notes = "查询在线用户数量长度")
    public GlobalResult user_num_on() {
        int num =userService.num_on();
        GlobalResult result = GlobalResult.build(200, "信息查询成功", num);
        return result;
    }
}
