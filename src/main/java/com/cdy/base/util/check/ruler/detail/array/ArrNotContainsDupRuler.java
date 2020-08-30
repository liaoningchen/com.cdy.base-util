package com.cdy.base.util.check.ruler.detail.array;

import com.cdy.base.util.check.ruler.BaseRuler;
import com.cdy.base.util.exception.CheckException;
import com.cdy.base.util.util.ArrayUtil;

import static com.cdy.base.util.check.ruler.CheckResultCodeEnum.*;

public class ArrNotContainsDupRuler extends BaseRuler<Object[]> {


    public ArrNotContainsDupRuler() {
        init(ARR_NOT_CONTAINS_DUP_FAIL.getCode(), ARR_NOT_CONTAINS_DUP_FAIL.getDesc());
    }

    public ArrNotContainsDupRuler(long failCode, String failDesc) {
        init(failCode, failDesc);
    }

    @Override
    public void check(Object[] checkTarget) {
        if (null == checkTarget) {
            return;
        }
        if (ArrayUtil.isNotContainsDup(checkTarget)) {
            return;
        }
        throw new CheckException(failCode, failDesc);
    }

}
