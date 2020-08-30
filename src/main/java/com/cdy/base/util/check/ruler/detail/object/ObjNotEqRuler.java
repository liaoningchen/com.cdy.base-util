package com.cdy.base.util.check.ruler.detail.object;

import com.cdy.base.util.check.ruler.BaseRuler;
import com.cdy.base.util.exception.CheckException;
import com.cdy.base.util.util.ObjectUtil;

import static com.cdy.base.util.check.ruler.CheckResultCodeEnum.*;

public class ObjNotEqRuler extends BaseRuler<Object> {

    private Object norm;

    public ObjNotEqRuler(Object norm) {
        init(norm, OBJ_NOT_EQ_FAIL.getCode(), OBJ_NOT_EQ_FAIL.getDesc());
    }

    public ObjNotEqRuler(Object norm, long failCode, String failDesc) {
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
        if (ObjectUtil.isNotEq(checkTarget, norm)) {
            return;
        }
        throw new CheckException(failCode, String.format(failDesc, norm));
    }

}
