package com.cdy.base.util.check.ruler.summary;


import com.cdy.base.util.check.ruler.Ruler;
import com.cdy.base.util.check.ruler.detail.number.*;

public class LongRuler {

    public static Ruler<Long> eq(Long norm) {
        return new LongEqRuler(norm);
    }

    public static Ruler<Long> eq(Long norm, long failCode, String failDesc) {
        return new LongEqRuler(norm, failCode, failDesc);
    }

    public static Ruler<Long> gt(Long norm) {
        return new LongGtRuler(norm);
    }

    public static Ruler<Long> gt(Long norm, long failCode, String failDesc) {
        return new LongGtRuler(norm, failCode, failDesc);
    }

    public static Ruler<Long> gte(Long norm) {
        return new LongGteRuler(norm);
    }

    public static Ruler<Long> gte(Long norm, long failCode, String failDesc) {
        return new LongGteRuler(norm, failCode, failDesc);
    }

    public static Ruler<Long> lt(Long norm) {
        return new LongLtRuler(norm);
    }

    public static Ruler<Long> lt(Long norm, long failCode, String failDesc) {
        return new LongLtRuler(norm, failCode, failDesc);
    }

    public static Ruler<Long> lte(Long norm) {
        return new LongLteRuler(norm);
    }

    public static Ruler<Long> lte(Long norm, long failCode, String failDesc) {
        return new LongLteRuler(norm, failCode, failDesc);
    }

    public static Ruler<Long> notNull() {
        return new LongNotNullRuler();
    }

    public static Ruler<Long> notNull(long failCode, String failDesc) {
        return new LongNotNullRuler(failCode, failDesc);
    }

    public static Ruler<Long> notEq(Long norm) {
        return new LongNotEqRuler(norm);
    }

    public static Ruler<Long> notEq(Long norm, long failCode, String failDesc) {
        return new LongNotEqRuler(norm, failCode, failDesc);
    }

}
