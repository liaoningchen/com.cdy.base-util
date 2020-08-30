package com.cdy.base.util.check.ruler.summary;


import com.cdy.base.util.check.ruler.Ruler;
import com.cdy.base.util.check.ruler.detail.object.ObjEqRuler;
import com.cdy.base.util.check.ruler.detail.object.ObjNotEqRuler;
import com.cdy.base.util.check.ruler.detail.object.ObjNotNullRuler;

public class ObjRuler {

    public static Ruler<Object> notNull() {
        return new ObjNotNullRuler();
    }

    public static Ruler<Object> notNull(long failCode, String failDesc) {
        return new ObjNotNullRuler(failCode, failDesc);
    }

    public static Ruler<Object> eq(Object norm) {
        return new ObjEqRuler(norm);
    }

    public static Ruler<Object> eq(Object norm, long failCode, String failDesc) {
        return new ObjEqRuler(norm, failCode, failDesc);
    }

    public static Ruler<Object> notEq(Object norm) {
        return new ObjNotEqRuler(norm);
    }

    public static Ruler<Object> notEq(Object norm, long failCode, String failDesc) {
        return new ObjNotEqRuler(norm, failCode, failDesc);
    }

}
