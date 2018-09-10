package com.xjliang.aspect.entity;

public class RespHead {

    private int code=0;
    private String desc;

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }
    @Override
    public String toString() {
        return "RespHead [code=" + code + ", desc=" + desc + "]";
    }
}
