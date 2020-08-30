package com.cdy.base.util.check.ruler;


/**
 * @author: liurenpeng
 * @date: Created in 18-6-27
 */
public abstract class BaseRuler<T> implements Ruler<T> {

    protected long failCode;
    protected String failDesc;


    protected void init(long failCode, String failDesc) {
        this.failCode = failCode;
        this.failDesc = failDesc;
    }

    @Override
    public Ruler<T> failCode(long failCode) {
        this.failCode = failCode;
        return this;
    }

    @Override
    public Ruler<T> failDesc(String failDesc) {
        this.failDesc = failDesc;
        return this;
    }

    @Override
    public Ruler<T> fail(long failCode, String failDesc) {
        this.failCode = failCode;
        this.failDesc = failDesc;
        return this;
    }

    @Override
    public Ruler<T> fail(IFailMessage failMessage) {
        this.fail(failMessage.getCode(), failMessage.getDesc());
        return this;
    }
}
