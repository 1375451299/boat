package com.ujs.boat.Mapper;

import com.ujs.boat.Enity.Msg;
import org.apache.ibatis.annotations.Insert;
import org.mapstruct.Mapper;
import org.springframework.stereotype.Component;

@Component(value ="msgMapper")
@Mapper
public interface MsgMapper {

    @Insert("INSERT INTO status(version,id,origin_longitude,origin_latitude,status,longitude,latitude,GPS,X_coordinate,Y_coordinate,Heading_angle,speed,revolution,X_first_point,Y_first_point,X_second_point,Y_second_point,clout,Voltage,Current,Quantity,check_code) VALUES(#{version},#{id},#{origin_longitude},#{origin_latitude},#{status},#{longitude},#{latitude},#{GPS},#{X_coordinate},#{Y_coordinate},#{Heading_angle},#{speed},#{revolution},#{X_first_point},#{Y_first_point},#{X_second_point},#{Y_second_point},#{clout},#{Voltage},#{Current},#{Quantity},#{check_code})")
    void insert(Msg msg);
}
