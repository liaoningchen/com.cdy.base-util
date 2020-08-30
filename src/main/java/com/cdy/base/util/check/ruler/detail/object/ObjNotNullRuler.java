package com.cdy.base.util.check.ruler.detail.object;

import com.daojia.khpt.util.base.check.CheckException;
import com.daojia.khpt.util.base.check.ruler.BaseRuler;
import com.daojia.khpt.util.base.util.ObjectUtil;

import static com.daojia.khpt.util.base.check.CheckResultCodeEnum.*;
import static com.daojia.khpt.util.base.check.CheckResultCodeEnum.OBJ_NOT_NULL_FAIL;

/**
 * @author: liurenpeng
 * @date: Created in 2017-11-12
 */
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
