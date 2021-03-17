package com.ujs.boat.Mapper;

import com.ujs.boat.Enity.Device;
import org.apache.ibatis.annotations.*;
import org.mapstruct.Mapper;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.List;

@Component(value ="deviceMapper")
@Mapper
public interface DeviceMapper {

    @Insert("INSERT INTO device(device_name,createTime,lastVisitTime,status) VALUES(#{device_name},#{createTime},#{lastVisitTime},#{status})")
    void insert(Device device);

    @Select("SELECT * FROM device WHERE device_name = #{id}")
    Device check_status(@Param("id") String id);

    @Update("UPDATE device SET LASTVISITTIME =#{lastVisitTime}WHERE device_name= #{id}")
    void  updateTime(@Param("id") String id,@Param("lastVisitTime") String lastVisitTime);

    @Update("UPDATE device SET user_name =#{user_name}WHERE device_name= #{id}")
    void  addUser(@Param("id") String openid,@Param("user_name") String user_name);

    @Select("SELECT * FROM device WHERE device_name = #{id}")
    Device selectById(@Param("id") String id);

    @Update("UPDATE device SET status =#{status}")
    void change_status(@Param("status") String status);

    @Update("UPDATE device SET status =#{status}  WHERE device_name = #{id}")
    void update_status(@Param("status") String status,@Param("id") String id);

    @Select("SELECT * FROM device LIMIT #{start},#{limit}")
    List<Device> getDevice(@Param("start") int start, @Param("limit") int limit);

    @Select("SELECT count(1) FROM device")
    int device_num();

    @Select("SELECT count(1) FROM device WHERE status =#{status}")
    int num_on(@Param("status") String status);

    @Select("SELECT device_name FROM device WHERE status ='上线'")
    List<String> device_online();

    @Delete("Delete FROM device WHERE Device_name = #{device_name}")
    void deleteByIddevice(@Param("device_name") String device_name);

    @Update("UPDATE device SET user_name =#{user_name} WHERE Device_name= #{device_name}")
    void  updateByIduser(@Param("user_name") String user_name,@Param("device_name") String device_name);
}
