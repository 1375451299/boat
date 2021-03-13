package com.ujs.boat.Mapper;

import com.ujs.boat.Enity.Device;
import com.ujs.boat.Enity.Msg;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.mapstruct.Mapper;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.List;

@Component(value ="msgMapper")
@Mapper
public interface MsgMapper {

    @Insert("INSERT INTO msg(version,id,origin_longitude,origin_latitude,status,longitude,latitude,GPS,X_coordinate,Y_coordinate,Heading_angle,speed,revolution,X_first_point,Y_first_point,X_second_point,Y_second_point,clout,Voltage,Current,Quantity,check_code,time) VALUES(#{version},#{id},#{origin_longitude},#{origin_latitude},#{status},#{longitude},#{latitude},#{GPS},#{X_coordinate},#{Y_coordinate},#{Heading_angle},#{speed},#{revolution},#{X_first_point},#{Y_first_point},#{X_second_point},#{Y_second_point},#{clout},#{Voltage},#{Current},#{Quantity},#{check_code},#{time})")
    void insert(Msg msg);

    @Select("SELECT * FROM msg WHERE id,time = #{id},#{time}")
    Msg retrieval(@Param("id") String id,@Param("time") Date time);

    @Select("SELECT * FROM msg LIMIT #{start},#{limit}")
    List<Msg> rec_msg(@Param("start") int start, @Param("limit") int limit);

    @Select("SELECT count(1) FROM msg")
    int msg_num();
}
