package com.cdy.base.util.check.ruler.summary;

import com.cdy.base.util.check.ruler.Ruler;
import com.cdy.base.util.check.ruler.detail.number.*;


public class FloatRuler {

    public static Ruler<Float> eq(Float norm) {
        return new FloatEqRuler(norm);
    }

    public static Ruler<Float> eq(Float norm, long failCode, String failDesc) {
        return new FloatEqRuler(norm, failCode, failDesc);
    }

    public static Ruler<Float> gt(Float norm) {
        return new FloatGtRuler(norm);
    }

    public static Ruler<Float> gt(Float norm, long failCode, String failDesc) {
        return new FloatGtRuler(norm, failCode, failDesc);
    }

    public static Ruler<Float> gte(Float norm) {
        return new FloatGteRuler(norm);
    }

    public static Ruler<Float> gte(Float norm, long failCode, String failDesc) {
        return new FloatGteRuler(norm, failCode, failDesc);
    }

    public static Ruler<Float> lt(Float norm) {
        return new FloatLtRuler(norm);
    }

    public static Ruler<Float> lt(Float norm, long failCode, String failDesc) {
        return new FloatLtRuler(norm, failCode, failDesc);
    }

    public static Ruler<Float> lte(Float norm) {
        return new FloatLteRuler(norm);
    }

    public static Ruler<Float> lte(Float norm, long failCode, String failDesc) {
        return new FloatLteRuler(norm, failCode, failDesc);
    }

    public static Ruler<Float> notNull() {
        return new FloatNotNullRuler();
    }

    public static Ruler<Float> notNull(long failCode, String failDesc) {
        return new FloatNotNullRuler(failCode, failDesc);
    }

    public static Ruler<Float> notEq(Float norm) {
        return new FloatNotEqRuler(norm);
    }

    public static Ruler<Float> notEq(Float norm, long failCode, String failDesc) {
        return new FloatNotEqRuler(norm, failCode, failDesc);
    }

}
