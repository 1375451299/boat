package com.ujs.boat.Mapper;

import com.ujs.boat.Enity.Log;
import org.apache.ibatis.annotations.Insert;
import org.mapstruct.Mapper;
import org.springframework.stereotype.Component;

@Component(value ="logMapper")
@Mapper
public interface LogMapper {

    @Insert("INSERT INTO log(device_name,time,Instruction) VALUES(#{device_name},#{time},#{Instruction})")
    void insert(Log log);
}
