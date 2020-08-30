package com.cdy.base.util.util;


public class ObjectUtil {

    private ObjectUtil() {
    }

    public static boolean isNotNull(Object target) {
        return null != target;
    }

    public static boolean isEq(Object target, Object norm) {
        return (null == target && null == norm) ||
                (null != target && null != norm && target.equals(norm));
    }

    public static boolean isNotEq(Object target, Object norm) {
        return !isEq(target, norm);
    }
}
