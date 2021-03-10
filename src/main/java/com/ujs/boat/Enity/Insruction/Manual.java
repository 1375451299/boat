package com.ujs.boat.Enity.Insruction;

import lombok.Data;

@Data
public class Manual {
    /**
     * 左侧明轮正转占空比
     */
    private String Left_wheel;
    /**
     * 右侧明轮正转占空比
     */
    private String Right_wheel;
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
