package com.cdy.base.util.check.ruler.detail.array;

import com.daojia.khpt.util.base.check.CheckException;
import com.daojia.khpt.util.base.check.ruler.BaseRuler;
import com.daojia.khpt.util.base.util.ArrayUtil;

import static com.daojia.khpt.util.base.check.CheckResultCodeEnum.*;
import static com.daojia.khpt.util.base.check.CheckResultCodeEnum.ARR_NOT_CONTAINS_DUP_FAIL;

/**
 * @author: liurenpeng
 * @date: Created in 2017-11-12
 */
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
