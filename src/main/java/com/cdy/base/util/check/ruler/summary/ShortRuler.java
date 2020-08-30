package com.cdy.base.util.check.ruler.summary;


import com.cdy.base.util.check.ruler.Ruler;
import com.cdy.base.util.check.ruler.detail.number.*;

public class ShortRuler {

    public static Ruler<Short> eq(Short norm) {
        return new ShortEqRuler(norm);
    }

    public static Ruler<Short> eq(Short norm, long failCode, String failDesc) {
        return new ShortEqRuler(norm, failCode, failDesc);
    }

    public static Ruler<Short> gt(Short norm) {
        return new ShortGtRuler(norm);
    }

    public static Ruler<Short> gt(Short norm, long failCode, String failDesc) {
        return new ShortGtRuler(norm, failCode, failDesc);
    }

    public static Ruler<Short> gte(Short norm) {
        return new ShortGteRuler(norm);
    }

    public static Ruler<Short> gte(Short norm, long failCode, String failDesc) {
        return new ShortGteRuler(norm, failCode, failDesc);
    }

    public static Ruler<Short> lt(Short norm) {
        return new ShortLtRuler(norm);
    }

    public static Ruler<Short> lt(Short norm, long failCode, String failDesc) {
        return new ShortLtRuler(norm, failCode, failDesc);
    }

    public static Ruler<Short> lte(Short norm) {
        return new ShortLteRuler(norm);
    }

    public static Ruler<Short> lte(Short norm, long failCode, String failDesc) {
        return new ShortLteRuler(norm, failCode, failDesc);
    }

    public static Ruler<Short> notNull() {
        return new ShortNotNullRuler();
    }

    public static Ruler<Short> notNull(long failCode, String failDesc) {
        return new ShortNotNullRuler(failCode, failDesc);
    }

    public static Ruler<Short> notEq(Short norm) {
        return new ShortNotEqRuler(norm);
    }

    public static Ruler<Short> notEq(Short norm, long failCode, String failDesc) {
        return new ShortNotEqRuler(norm, failCode, failDesc);
    }

}
