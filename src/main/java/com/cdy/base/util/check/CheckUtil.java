package com.cdy.base.util.check;

import com.cdy.base.util.exception.CheckException;
import com.cdy.base.util.ruler.Ruler;

import java.util.Arrays;

public class CheckUtil {
    private CheckUtil (){}

    @SafeVarargs
    public static <T> CheckHandler check(final T target, Ruler<T> ... rulers){
        return CheckUtil.check(target,"",rulers);
    }
    @SafeVarargs
    public static <T> CheckHandler check(final T target, String desc, Ruler<T> ... rulers){
        return new CheckHandler().check(target,desc,rulers);
    }
    private static class CheckHandler {
        private CheckHandler() {
        }
        private <T> CheckHandler check(final T target, Ruler<T>... rulers){
            return this.check(target,"",rulers);
        }
        private <T> CheckHandler check(final T target, String desc, Ruler<T> ... rulers){
            try{
                Arrays.stream(rulers).forEach((ruler)->{
                    ruler.check(target);
                });
                return this;
            }catch (CheckException e){
                e.setDesc(desc+e.getDesc());
                throw e;
            }
        }
    }
}
