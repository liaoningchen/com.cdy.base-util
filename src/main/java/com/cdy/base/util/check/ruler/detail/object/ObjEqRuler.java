package com.cdy.base.util.check.ruler.detail.object;

import com.cdy.base.util.check.ruler.BaseRuler;
import com.cdy.base.util.exception.CheckException;
import com.cdy.base.util.util.ObjectUtil;

import static com.cdy.base.util.check.ruler.CheckResultCodeEnum.*;

public class ObjEqRuler extends BaseRuler<Object> {

    private Object norm;

    public ObjEqRuler(Object norm) {
        init(norm, OBJ_EQ_FAIL.getCode(), OBJ_EQ_FAIL.getDesc());
    }

    public ObjEqRuler(Object norm, long failCode, String failDesc) {
        init(norm, failCode, failDesc);
    }

    private void init(Object norm, long failCode, String failDesc) {
        this.norm = norm;
        init(failCode, failDesc);
    }

    @Override
    public void check(Object checkTarget) {
        if (null == checkTarget) {
            return;
        }
        if (ObjectUtil.isEq(checkTarget, norm)) {
            return;
        }
        throw new CheckException(failCode, String.format(failDesc, norm));
    }

}
