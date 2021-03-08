package com.ujs.boat.Enity;

import lombok.Data;

import java.util.Date;

@Data
public class Log {
    private String device_name;
    private Date time;
    private String Instruction;

    public Date getTime() {
        return time;
    }

    public String getDevice_name() {
        return device_name;
    }

    public String getInstruction() {
        return Instruction;
    }


    public void setDevice_name(String device_name) {
        this.device_name = device_name;
    }

    public void setInstruction(String instruction) {
        Instruction = instruction;
    }

    public void setTime(Date time) {
        this.time = time;
    }


}
