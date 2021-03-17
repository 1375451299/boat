package com.ujs.boat.Mapper;



import com.ujs.boat.Enity.Msg;
import com.ujs.boat.Enity.User;
import org.apache.ibatis.annotations.*;
import org.mapstruct.Mapper;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.List;

@Component(value ="userMapper")
@Mapper
public interface UserMapper {

    @Select("SELECT * FROM user WHERE Id = #{id}")
    User selectById(@Param("id") String id);

    @Insert("INSERT INTO user(user_name,age,sex,createTime,lastVisitTime,Id,password) VALUES(#{user_name},#{age},#{sex},#{createTime},#{lastVisitTime},#{Id},#{password})")
    void insert(User user);

    @Update("UPDATE user SET LASTVISITTIME =#{lastVisitTime}WHERE Id= #{id}")
    void  updateTime(@Param("id") String id,@Param("lastVisitTime") String lastVisitTime);

    @Update("UPDATE user SET status =#{status}")
    void change_status(@Param("status") String status);

    @Update("UPDATE user SET status =#{status}  WHERE Id = #{id}")
    void update_status(@Param("status") String status,@Param("id") String id);

    @Select("SELECT * FROM user LIMIT #{start},#{limit}")
    List<User> user(@Param("start") int start, @Param("limit") int limit);

    @Select("SELECT count(1) FROM user")
    int user_num();

    @Select("SELECT count(1) FROM user WHERE status =#{status}")
    int num_on(@Param("status") String status);

    @Delete("Delete  FROM user WHERE Id = #{id}")
    void deleteByIduser(@Param("id") String id);

    @Update("UPDATE user SET user_name =#{user_name}, age =#{age}, sex =#{sex}, Id =#{id}, Password =#{password} WHERE Id= #{id}")
    void  updateById(@Param("id") String id,@Param("user_name") String user_name,@Param("age") String age,@Param("sex") String sex,@Param("password") String password);


}
