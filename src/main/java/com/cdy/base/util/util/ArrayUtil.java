package com.cdy.base.util.util;

import org.apache.commons.lang3.ArrayUtils;

import java.util.HashSet;
import java.util.Set;

public class ArrayUtil extends ArrayUtils {

    private ArrayUtil() {
    }

    public static boolean isNotNull(Object[] target) {
        return null != target;
    }

    public static boolean isContains(Object[] target, Object norm) {
        return ArrayUtil.contains(target, norm);
    }

    public static boolean isNotContains(Object[] target, Object norm) {
        return !isContains(target, norm);
    }

    public static boolean isContainsNull(Object[] target) {
        return ArrayUtil.contains(target, null);
    }

    public static boolean isNotContainsNull(Object[] target) {
        return !isContainsNull(target);
    }

    public static boolean isContainsDup(Object[] target) {
        Set<Object> targetSet = new HashSet<>();
        CollectionUtil.addAll(targetSet, target);
        return targetSet.size() != target.length;
    }

    public static boolean isNotContainsDup(Object[] target) {
        return !isContainsDup(target);
    }

    public static boolean isLengthEq(Object[] target, int norm) {
        return target.length == norm;
    }

    public static boolean isLengthGt(Object[] target, int norm) {
        return target.length > norm;
    }

    public static boolean isLengthGte(Object[] target, int norm) {
        return target.length >= norm;
    }

    public static boolean isLengthLt(Object[] target, int norm) {
        return target.length < norm;
    }

    public static boolean isLengthLte(Object[] target, int norm) {
        return target.length <= norm;
    }

}
