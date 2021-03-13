package com.ujs.boat.Mapper;

import com.ujs.boat.Enity.Device;
import com.ujs.boat.Enity.Insruction.Times;
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

    @Select("SELECT count(1) FROM log where time BETWEEN #{start} and #{end}  ")
    int getLog_today(@Param("start") String start, @Param("end") String end);

    @Select("SELECT DATE_FORMAT(time, '%Y-%m-%d %H:00:00') AS times, COUNT(*) AS num FROM log where time BETWEEN #{start} and #{end} GROUP BY times ORDER BY times")
    List<Times> log_num_detail(@Param("start") String start, @Param("end") String end);

}
