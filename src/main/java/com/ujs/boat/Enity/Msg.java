package com.ujs.boat.Enity;

import lombok.Data;

import java.util.Date;

@Data
public class Msg {
    /**
     * 版本
     */
    private String version;
    /**
     * 产品唯一标识
     */
    private String id;
    /**
     * 原点经度
     */
    private String origin_longitude;
    /**
     * 原点纬度
     */
    private String origin_latitude;
    /**
     * 工作状态
     */
    private String status;
    /**
     * 当前经度
     */
    private String longitude;
    /**
     * 当前纬度
     */
    private String latitude;
    /**
     * GPS接收机状态
     */
    private String GPS;
    /**
     * 当前X坐标
     */
    private String X_coordinate;
    /**
     * 当前Y坐标
     */
    private String Y_coordinate;
    /**
     * 当前航向角
     */
    private String Heading_angle;
    /**
     * 当前船速
     */
    private String speed;
    /**
     * 当前转速
     */
    private String revolution;
    /**
     * 巡航第一目标点X坐标
     */
    private String X_first_point;
    /**
     * 巡航第一目标点Y坐标
     */
    private String Y_first_point;
    /**
     * 巡航第二目标点X坐标
     */
    private String X_second_point;
    /**
     * 巡航第二目标点Y坐标
     */
    private String Y_second_point;
    /**
     * 料仓余料
     */
    private String clout;
    /**
     * 电池电压
     */
    private String Voltage;
    /**
     * 电池放电电流
     */
    private String Current;
    /**
     * 电池剩余电量估计
     */
    private String Quantity;
    /**
     * 地图校验码
     */
    private String check_code;
    /**
     * 时间
     */
    private Date time;

    public String getVersion() {
        return version;
    }

    public String getGPS() {
        return GPS;
    }

    public String getId() {
        return id;
    }

    public String getHeading_angle() {
        return Heading_angle;
    }

    public String getLatitude() {
        return latitude;
    }

    public String getLongitude() {
        return longitude;
    }

    public String getOrigin_latitude() {
        return origin_latitude;
    }

    public String getClout() {
        return clout;
    }

    public String getOrigin_longitude() {
        return origin_longitude;
    }

    public String getRevolution() {
        return revolution;
    }

    public String getSpeed() {
        return speed;
    }

    public String getStatus() {
        return status;
    }

    public String getX_coordinate() {
        return X_coordinate;
    }

    public String getX_first_point() {
        return X_first_point;
    }

    public String getCheck_code() {
        return check_code;
    }

    public String getCurrent() {
        return Current;
    }

    public String getQuantity() {
        return Quantity;
    }

    public String getVoltage() {
        return Voltage;
    }

    public String getX_second_point() {
        return X_second_point;
    }

    public String getY_coordinate() {
        return Y_coordinate;
    }

    public String getY_first_point() {
        return Y_first_point;
    }

    public void setClout(String clout) {
        this.clout = clout;
    }

    public String getY_second_point() {
        return Y_second_point;
    }

    public void setCurrent(String current) {
        Current = current;
    }

    public void setGPS(String GPS) {
        this.GPS = GPS;
    }

    public void setCheck_code(String check_code) {
        this.check_code = check_code;
    }

    public void setVersion(String version) {
        this.version = version;
    }

    public void setHeading_angle(String heading_angle) {
        Heading_angle = heading_angle;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setLatitude(String latitude) {
        this.latitude = latitude;
    }

    public void setOrigin_latitude(String origin_latitude) {
        this.origin_latitude = origin_latitude;
    }

    public void setLongitude(String longitude) {
        this.longitude = longitude;
    }

    public void setOrigin_longitude(String origin_longitude) {
        this.origin_longitude = origin_longitude;
    }

    public void setQuantity(String quantity) {
        Quantity = quantity;
    }

    public void setRevolution(String revolution) {
        this.revolution = revolution;
    }

    public void setSpeed(String speed) {
        this.speed = speed;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public void setVoltage(String voltage) {
        Voltage = voltage;
    }

    public void setX_coordinate(String x_coordinate) {
        X_coordinate = x_coordinate;
    }

    public void setX_first_point(String x_first_point) {
        X_first_point = x_first_point;
    }

    public void setX_second_point(String x_second_point) {
        X_second_point = x_second_point;
    }

    public void setY_coordinate(String y_coordinate) {
        Y_coordinate = y_coordinate;
    }

    public void setY_first_point(String y_first_point) {
        Y_first_point = y_first_point;
    }

    public void setY_second_point(String y_second_point) {
        Y_second_point = y_second_point;
    }

    public void setTime(Date time) {
        this.time = time;
    }

    public Date getTime() {
        return time;
    }
}

