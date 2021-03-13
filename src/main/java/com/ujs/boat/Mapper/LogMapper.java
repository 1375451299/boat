package com.ujs.boat.Mapper;

import com.ujs.boat.Enity.Device;
import com.ujs.boat.Enity.Log;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.mapstruct.Mapper;
import org.springframework.stereotype.Component;

import java.util.List;

@Component(value ="logMapper")
@Mapper
public interface LogMapper {

    @Insert("INSERT INTO log(device_name,time,Instruction) VALUES(#{device_name},#{time},#{Instruction})")
    void insert(Log log);

    @Select("SELECT * FROM log LIMIT #{start},#{limit}")
    List<Log> getLog(@Param("start") int start, @Param("limit") int limit);

    @Select("SELECT count(1) FROM log")
    int log_num();
}
