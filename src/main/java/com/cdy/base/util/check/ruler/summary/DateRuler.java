package com.cdy.base.util.check.ruler.summary;


import com.cdy.base.util.check.ruler.Ruler;
import com.cdy.base.util.check.ruler.detail.date.*;

import java.util.Date;

public class DateRuler {

    public static Ruler<Date> eq(Date norm) {
        return new DateEqRuler(norm);
    }

    public static Ruler<Date> eq(Date norm, long failCode, String failDesc) {
        return new DateEqRuler(norm, failCode, failDesc);
    }

    public static Ruler<Date> after(Date norm) {
        return new DateAfterRuler(norm);
    }

    public static Ruler<Date> after(Date norm, long failCode, String failDesc) {
        return new DateAfterRuler(norm, failCode, failDesc);
    }

    public static Ruler<Date> afterOrEq(Date norm) {
        return new DateAfterOrEqRuler(norm);
    }

    public static Ruler<Date> afterOrEq(Date norm, long failCode, String failDesc) {
        return new DateAfterOrEqRuler(norm, failCode, failDesc);
    }

    public static Ruler<Date> before(Date norm) {
        return new DateBeforeRuler(norm);
    }

    public static Ruler<Date> before(Date norm, long failCode, String failDesc) {
        return new DateBeforeRuler(norm, failCode, failDesc);
    }

    public static Ruler<Date> beforeOrEq(Date norm) {
        return new DateBeforeOrEqRuler(norm);
    }

    public static Ruler<Date> beforeOrEq(Date norm, long failCode, String failDesc) {
        return new DateBeforeOrEqRuler(norm, failCode, failDesc);
    }

    public static Ruler<Date> notNull() {
        return new DateNotNullRuler();
    }

    public static Ruler<Date> notNull(long failCode, String failDesc) {
        return new DateNotNullRuler(failCode, failDesc);
    }

    public static Ruler<Date> notEq(Date norm) {
        return new DateNotEqRuler(norm);
    }

    public static Ruler<Date> notEq(Date norm, long failCode, String failDesc) {
        return new DateNotEqRuler(norm, failCode, failDesc);
    }

}
