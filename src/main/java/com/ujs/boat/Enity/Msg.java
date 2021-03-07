package com.ujs.boat.Enity;

import lombok.Data;

@Data
public class Msg {
    private String version;
    private String id;
    private String origin_longitude;
    private String origin_latitude;
    private String status;
    private String longitude;
    private String latitude;
    private String GPS;
    private String X_coordinate;
    private String Y_coordinate;
    private String Heading_angle;
    private String speed;         //船速
    private String revolution;    //转速
    private String X_first_point;
    private String Y_first_point;
    private String X_second_point;
    private String Y_second_point;
    private String clout;
    private String Voltage;
    private String Current;
    private String Quantity;
    private String check_code;

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
}

