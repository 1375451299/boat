package com.ujs.boat.Service;





import com.ujs.boat.Enity.User;
import com.ujs.boat.Mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;


@Service
public class UserService {

  @Autowired
  UserMapper userMapper;

    public User selectById(String openid) {
        User user=userMapper.selectById(openid);
        return user;
    }

    public void insert(User user){
        userMapper.insert(user);
    }

    public void updateById(User user){
        System.out.println(user.getLastVisitTime());
        userMapper.updateById(user.getOpenId(),user.getLastVisitTime());
    }
}
