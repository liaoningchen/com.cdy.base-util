package com.cdy.base.util.exception;

public class CheckException extends RuntimeException{
    private int code;
    private String desc;
    public CheckException(){

    }
    public CheckException(int code, String desc) {
        this.code = code;
        this.desc = desc;
    }

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
    public String getMessage() {
        return "code=" + this.code + ", desc=" + this.desc;
    }
}
