package com.cdy.base.util.check.ruler.detail.array;

import com.daojia.khpt.util.base.check.CheckException;
import com.daojia.khpt.util.base.check.ruler.BaseRuler;
import com.daojia.khpt.util.base.util.ArrayUtil;

import static com.daojia.khpt.util.base.check.CheckResultCodeEnum.*;
import static com.daojia.khpt.util.base.check.CheckResultCodeEnum.ARR_NOT_CONTAINS_NULL_FAIL;

/**
 * @author: liurenpeng
 * @date: Created in 2017-11-12
 */
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
