package com.cdy.base.util.check.ruler.detail.array;

import com.cdy.base.util.check.ruler.BaseRuler;
import com.cdy.base.util.exception.CheckException;
import com.cdy.base.util.util.ArrayUtil;

import static com.cdy.base.util.check.ruler.CheckResultCodeEnum.*;

public class ArrNotContainsNullRuler extends BaseRuler<Object[]> {


    public ArrNotContainsNullRuler() {
        init(ARR_NOT_CONTAINS_NULL_FAIL.getCode(), ARR_NOT_CONTAINS_NULL_FAIL.getDesc());
    }

    public ArrNotContainsNullRuler(long failCode, String failDesc) {
        init(failCode, failDesc);
    }

    @Override
    public void check(Object[] checkTarget) {
        if (null == checkTarget) {
            return;
        }
        if (ArrayUtil.isNotContainsNull(checkTarget)) {
            return;
        }
        throw new CheckException(failCode, failDesc);
    }

}
