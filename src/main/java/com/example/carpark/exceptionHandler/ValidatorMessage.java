package com.example.carpark.exceptionHandler;

import java.util.HashMap;
import java.util.Map;

public class ValidatorMessage {
    private int status;
    private Map<String, String> invalid;
    private String desc;
    public ValidatorMessage(int status, String desc){
        this.status = status;
        this.desc = desc;
        this.invalid = new HashMap<>();
    }

    public void addInvalid(String field, String msg){
        invalid.put(field, msg);
    }

    public Map<String, String> getInvalid() {
        return invalid;
    }

    public void setInvalid(Map<String, String> invalid) {
        this.invalid = invalid;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }


    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }
}
