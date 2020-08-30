package com.cdy.base.util.check.ruler.detail.array;

import com.daojia.khpt.util.base.check.CheckException;
import com.daojia.khpt.util.base.check.ruler.BaseRuler;
import com.daojia.khpt.util.base.util.ArrayUtil;

import static com.daojia.khpt.util.base.check.CheckResultCodeEnum.*;
import static com.daojia.khpt.util.base.check.CheckResultCodeEnum.ARR_NOT_NULL_FAIL;

/**
 * @author: liurenpeng
 * @date: Created in 2017-11-12
 */
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
