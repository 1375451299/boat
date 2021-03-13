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
    public void updateTime(String id, Date time){
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
}
