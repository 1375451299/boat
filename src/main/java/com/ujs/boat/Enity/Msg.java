package com.ujs.boat.Enity;

import lombok.Data;

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
    private String time;
    /**
     * 行数
     */
    private String line;

}

