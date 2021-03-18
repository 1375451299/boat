package com.ujs.boat.Service;





import com.ujs.boat.Enity.Device;
import com.ujs.boat.Enity.User;
import com.ujs.boat.Mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;


@Service
public class UserService {

  @Autowired
  UserMapper userMapper;
    /**
     * 检索用户信息
     */
    public User selectById(String openid) {
        User user=userMapper.selectById(openid);
        return user;
    }
    /**
     * 创建用户
     */
    public void insert(User user){
        userMapper.insert(user);
    }
    /**
     * 更改用户登录时间
     */
    public void updateTime(String id, String time){
        userMapper.updateTime(id,time);
    }
    /**
     * 获取所有用户信息
     */
    public List<User> users(int start, int limit){
        return  userMapper.user(start,limit);
    }
    /**
     * 获取用户的数量
     */
    public int user_num(){
        return userMapper.user_num();
    }
    /**
     * 获取在线用户的数量
     */
    public int num_on(){
        return userMapper.num_on("上线");
    }
    /**
     * 全部用户状态修改
     */
    public void Change_status(String status){
        userMapper.change_status(status);
    }
    /**
     * 单个用户状态修改
     */
    public void update_status(String status,String id){
        userMapper.update_status(status,id);
    }
    /**
     * 删除用户
     */
    public void deleteByIduser(String id){
        userMapper.deleteByIduser(id);
    }
    /**
     * 更新用户信息
     */
    public void updateById(User user){
        userMapper.updateById(user);
    }


}
