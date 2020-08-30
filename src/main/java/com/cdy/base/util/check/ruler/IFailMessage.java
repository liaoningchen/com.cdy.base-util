package com.cdy.base.util.check.ruler;

public interface IFailMessage {
    /**
     * 错误code
     *
     * @return
     */
    long getCode();

    /**
     * 错误提示
     *
     * @return
     */
    String getDesc();
}
