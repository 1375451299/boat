package com.ujs.boat.Mapper;

import com.ujs.boat.Enity.Insruction.Times;
import com.ujs.boat.Enity.Msg;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.mapstruct.Mapper;
import org.springframework.stereotype.Component;

import java.util.List;

@Component(value ="msgMapper")
@Mapper
public interface MsgMapper {

    @Insert("INSERT INTO msg(version,id,origin_longitude,origin_latitude,status,longitude,latitude,GPS,X_coordinate,Y_coordinate,Heading_angle,speed,revolution,X_first_point,Y_first_point,X_second_point,Y_second_point,clout,Voltage,Current,Quantity,check_code,time) VALUES(#{version},#{id},#{origin_longitude},#{origin_latitude},#{status},#{longitude},#{latitude},#{GPS},#{X_coordinate},#{Y_coordinate},#{Heading_angle},#{speed},#{revolution},#{X_first_point},#{Y_first_point},#{X_second_point},#{Y_second_point},#{clout},#{Voltage},#{Current},#{Quantity},#{check_code},#{time})")
    void insert(Msg msg);

    @Select("SELECT * FROM msg WHERE id,time = #{id},#{time}")
    Msg retrieval(@Param("id") String id,@Param("time") String time);

    @Select("SELECT * FROM msg LIMIT #{start},#{limit}")
    List<Msg> rec_msg(@Param("start") int start, @Param("limit") int limit);

    @Select("SELECT count(1) FROM msg")
    int msg_num();

    @Select("SELECT count(1) FROM msg where time BETWEEN #{start} and #{end}  ")
    int getMsg_today(@Param("start") String start, @Param("end") String end);

    @Select("SELECT DATE_FORMAT(time, '%Y-%m-%d %H:00:00') AS times, COUNT(*) AS num FROM msg where time BETWEEN #{start} and #{end} GROUP BY times ORDER BY times")
    List<Times> msg_num_detail(@Param("start") String start, @Param("end") String end);

    @Select("SELECT * FROM msg where id=#{id} ORDER BY time DESC LIMIT 1;")
    Msg msg_device_detail(@Param("id") String id);

    @Delete("Delete FROM msg WHERE line = #{id}")
    void deletemsg(@Param("id") int id);

}
