package com.cdy.base.util.check.ruler.summary;

import com.cdy.base.util.check.ruler.Ruler;
import com.cdy.base.util.check.ruler.detail.array.*;

public class ArrRuler {

    public static Ruler<Object[]> notEmpty() {
        return new ArrNotEmptyRuler();
    }

    public static Ruler<Object[]> notEmpty(long failCode, String failDesc) {
        return new ArrNotEmptyRuler(failCode, failDesc);
    }

    public static Ruler<Object[]> lengthEq(int norm) {
        return new ArrLengthEqRuler(norm);
    }

    public static Ruler<Object[]> lengthEq(int norm, long failCode, String failDesc) {
        return new ArrLengthEqRuler(norm, failCode, failDesc);
    }

    public static Ruler<Object[]> lengthGt(int norm) {
        return new ArrLengthGtRuler(norm);
    }

    public static Ruler<Object[]> lengthGt(int norm, long failCode, String failDesc) {
        return new ArrLengthGtRuler(norm, failCode, failDesc);
    }

    public static Ruler<Object[]> lengthGte(int norm) {
        return new ArrLengthGteRuler(norm);
    }

    public static Ruler<Object[]> lengthGte(int norm, long failCode, String failDesc) {
        return new ArrLengthGteRuler(norm, failCode, failDesc);
    }

    public static Ruler<Object[]> lengthLt(int norm) {
        return new ArrLengthLtRuler(norm);
    }

    public static Ruler<Object[]> lengthLt(int norm, long failCode, String failDesc) {
        return new ArrLengthLtRuler(norm, failCode, failDesc);
    }

    public static Ruler<Object[]> lengthLte(int norm) {
        return new ArrLengthLteRuler(norm);
    }

    public static Ruler<Object[]> lengthLte(int norm, long failCode, String failDesc) {
        return new ArrLengthLteRuler(norm, failCode, failDesc);
    }

    public static Ruler<Object[]> notContainsNull() {
        return new ArrNotContainsNullRuler();
    }

    public static Ruler<Object[]> notContainsNull(long failCode, String failDesc) {
        return new ArrNotContainsNullRuler(failCode, failDesc);
    }

    public static Ruler<Object[]> notContainsDup() {
        return new ArrNotContainsDupRuler();
    }

    public static Ruler<Object[]> notContainsDup(long failCode, String failDesc) {
        return new ArrNotContainsDupRuler(failCode, failDesc);
    }

    public static Ruler<Object[]> notNull() {
        return new ArrNotNullRuler();
    }

    public static Ruler<Object[]> notNull(long failCode, String failDesc) {
        return new ArrNotNullRuler(failCode, failDesc);
    }

    public static Ruler<Object[]> contains(Object norm) {
        return new ArrContainsRuler(norm);
    }

    public static Ruler<Object[]> contains(Object norm, long failCode, String failDesc) {
        return new ArrContainsRuler(norm, failCode, failDesc);
    }

    public static Ruler<Object[]> notContains(Object norm) {
        return new ArrNotContainsRuler(norm);
    }

    public static Ruler<Object[]> notContains(Object norm, long failCode, String failDesc) {
        return new ArrNotContainsRuler(norm, failCode, failDesc);
    }

}
