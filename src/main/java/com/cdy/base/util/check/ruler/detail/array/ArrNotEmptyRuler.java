package com.cdy.base.util.check.ruler.detail.array;

import com.daojia.khpt.util.base.check.CheckException;
import com.daojia.khpt.util.base.check.ruler.BaseRuler;
import com.daojia.khpt.util.base.util.ArrayUtil;

import static com.daojia.khpt.util.base.check.CheckResultCodeEnum.*;
import static com.daojia.khpt.util.base.check.CheckResultCodeEnum.ARR_NOT_EMPTY_FAIL;

/**
 * @author: liurenpeng
 * @date: Created in 2017-11-12
 */
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
