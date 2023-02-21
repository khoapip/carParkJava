package com.example.carpark.exceptionHandler;

import java.util.Date;

public class ErrorMessage {
    int status;
    String  msg;
    String desc;
    public ErrorMessage(int status, String msg, String desc){
        this.status = status;
        this.msg = msg;
        this.desc = desc;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }
}
