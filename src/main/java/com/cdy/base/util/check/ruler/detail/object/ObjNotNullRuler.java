package com.cdy.base.util.check.ruler.detail.object;

import com.cdy.base.util.check.ruler.BaseRuler;
import com.cdy.base.util.exception.CheckException;
import com.cdy.base.util.util.ObjectUtil;

import static com.cdy.base.util.check.ruler.CheckResultCodeEnum.*;

public class ObjNotNullRuler extends BaseRuler<Object> {


    public ObjNotNullRuler() {
        init(OBJ_NOT_NULL_FAIL.getCode(), OBJ_NOT_NULL_FAIL.getDesc());
    }

    public ObjNotNullRuler(long failCode, String failDesc) {
        init(failCode, failDesc);
    }

    @Override
    public void check(Object checkTarget) {
        if (ObjectUtil.isNotNull(checkTarget)) {
            return;
        }
        throw new CheckException(failCode, failDesc);
    }

}
