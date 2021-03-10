package com.ujs.boat.Mapper;



import com.ujs.boat.Enity.User;
import org.apache.ibatis.annotations.*;
import org.mapstruct.Mapper;
import org.springframework.stereotype.Component;

import java.util.Date;

@Component(value ="userMapper")
@Mapper
public interface UserMapper {

    @Select("SELECT * FROM user WHERE Id = #{id}")
    User selectById(@Param("id") String id);

    @Insert("INSERT INTO user(user_name,age,sex,createTime,lastVisitTime,Id,password) VALUES(#{user_name},#{age},#{sex},#{createTime},#{lastVisitTime},#{Id},#{password})")
    void insert(User user);

    @Update("UPDATE user SET LASTVISITTIME =#{lastVisitTime}WHERE Id= #{id}")
    void  updateTime(@Param("id") String id,@Param("lastVisitTime") Date lastVisitTime);

}
