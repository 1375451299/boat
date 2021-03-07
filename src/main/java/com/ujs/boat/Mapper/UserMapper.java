package com.ujs.boat.Mapper;



import com.ujs.boat.Enity.User;
import org.apache.ibatis.annotations.*;
import org.mapstruct.Mapper;
import org.springframework.stereotype.Component;

import java.util.Date;

@Component(value ="userMapper")
@Mapper
public interface UserMapper {

    @Select("SELECT * FROM wechat_user WHERE OPENID = #{openid}")
    User selectById(@Param("openid") String openid);

    @Insert("INSERT INTO user(name) VALUES(#{openId})")
    void insert(User user);

    @Update("UPDATE wechat_user SET LASTVISITTIME =#{lastVisitTime}WHERE OPENID= #{openid}")
    void  updateById(@Param("openid") String openid,@Param("lastVisitTime") Date lastVisitTime);

}
