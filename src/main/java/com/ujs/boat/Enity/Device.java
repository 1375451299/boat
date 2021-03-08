package com.ujs.boat.Enity;

import lombok.Data;

import java.util.Date;

@Data
public class Device {
    private String device_name;
    private String user_name;
    private Date createTime;
    private Date lastVisitTime;
    private String status;

    public void setDevice_name(String device_name) {
        this.device_name = device_name;
    }

    public String getDevice_name() {
        return device_name;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getStatus() {
        return status;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public Date getLastVisitTime() {
        return lastVisitTime;
    }

    public String getUser_name() {
        return user_name;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public void setLastVisitTime(Date lastVisitTime) {
        this.lastVisitTime = lastVisitTime;
    }

    public void setUser_name(String user_name) {
        this.user_name = user_name;
    }
}
