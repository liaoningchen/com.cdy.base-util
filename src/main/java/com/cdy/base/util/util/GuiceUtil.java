package com.cdy.base.util.util;

import com.google.inject.Guice;
import com.google.inject.Injector;

public class GuiceUtil {

    private GuiceUtil() {
    }

    private static Injector injector;

    public static Injector getInjector(){
        if (null == injector){
            synchronized (GuiceUtil.class){
                if (null == injector){
                    injector = Guice.createInjector();
                }
            }
        }
        return injector;
    }
}
