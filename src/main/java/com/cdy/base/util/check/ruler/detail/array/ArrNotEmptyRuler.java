package com.cdy.base.util.check.ruler.detail.array;

import com.cdy.base.util.check.ruler.BaseRuler;
import com.cdy.base.util.exception.CheckException;
import com.cdy.base.util.util.ArrayUtil;

import static com.cdy.base.util.check.ruler.CheckResultCodeEnum.*;

public class ArrNotEmptyRuler extends BaseRuler<Object[]> {


    public ArrNotEmptyRuler() {
        init(ARR_NOT_EMPTY_FAIL.getCode(), ARR_NOT_EMPTY_FAIL.getDesc());
    }

    public ArrNotEmptyRuler(long failCode, String failDesc) {
        init(failCode, failDesc);
    }

    @Override
    public void check(Object[] checkTarget) {
        if (null == checkTarget) {
            return;
        }
        if (ArrayUtil.isNotEmpty(checkTarget)) {
            return;
        }
        throw new CheckException(failCode, failDesc);
    }

}
