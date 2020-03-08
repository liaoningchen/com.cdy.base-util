package com.cdy.base.util.exception.enums;

public enum  ErrorCodeEnum {
    STR_NOT_EMPTY_FAIL(-1, "不能为空");
    private int code;
    private String desc;

    private ErrorCodeEnum(int code, String desc) {
        this.code = code;
        this.desc = desc;
    }

    public int getCode() {
        return this.code;
    }

    public String getDesc() {
        return this.desc;
    }
}
