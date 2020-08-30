package com.cdy.base.util.log;

import org.slf4j.Logger;

/**
 * @author:
 * @description: Logger装饰器接口.功能:参数自动收集;LogDesc;logId
 */
public interface LoggerDecorator extends Logger {

    /**
     * 清除
     */
    LoggerDecorator clear();

    /**
     * 注册参数
     */
    LoggerDecorator register(String key, Object val);

    /**
     * 设置前缀.可通过拦截器由{@link LogDesc#value()}提供
     */
    LoggerDecorator setBusinessPrefix(String prefix);

    /**
     * 获取前缀
     */
    String getBusinessPrefix();

    /**
     * 设置logId
     */
    LoggerDecorator setLogId(String logId);

    /**
     * 获取logId
     */
    String getLogId();

}
