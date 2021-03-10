package com.ujs.boat.Enity.Insruction;

import lombok.Data;

@Data
public class Automatic {
    /**
     * 目标点X坐标
     */
    private String X_coordinate;
    /**
     * 目标点Y坐标
     */
    private String Y_coordinate;
    /**
     * 投饵抛盘占空比
     */
    private String Feed;
    /**
     * 下料占空比
     */
    private String Blanking;
    /**
     * 施药阀门占空比
     */
    private String valve;
    /**
     * 施药液泵占空比
     */
    private String pump;
    /**
     * 设备名字
     */
    private String device_name;
}
