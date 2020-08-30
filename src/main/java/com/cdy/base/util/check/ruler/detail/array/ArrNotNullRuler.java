package com.cdy.base.util.check.ruler.detail.array;

import com.cdy.base.util.check.ruler.BaseRuler;
import com.cdy.base.util.exception.CheckException;
import com.cdy.base.util.util.ArrayUtil;

import static com.cdy.base.util.check.ruler.CheckResultCodeEnum.*;

public class ArrNotNullRuler extends BaseRuler<Object[]> {


    public ArrNotNullRuler() {
        init(ARR_NOT_NULL_FAIL.getCode(), ARR_NOT_NULL_FAIL.getDesc());
    }

    public ArrNotNullRuler(long failCode, String failDesc) {
        init(failCode, failDesc);
    }

    @Override
    public void check(Object[] checkTarget) {
        if (ArrayUtil.isNotNull(checkTarget)) {
            return;
        }
        throw new CheckException(failCode, failDesc);
    }

}
