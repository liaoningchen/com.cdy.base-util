package com.cdy.base.util.ruler;

public abstract class BaseRuler<T> implements Ruler<T>{
    public int errorCode;
    public String errorDesc;

    protected void init(int errorCode, String errorDesc) {
        this.errorCode = errorCode;
        this.errorDesc = errorDesc;
    }

}
