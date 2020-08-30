package com.cdy.base.util.check.ruler.detail.number;

import com.daojia.khpt.util.base.check.CheckException;
import com.daojia.khpt.util.base.check.ruler.BaseRuler;
import com.daojia.khpt.util.base.util.NumberUtil;

import static com.daojia.khpt.util.base.check.CheckResultCodeEnum.*;
import static com.daojia.khpt.util.base.check.CheckResultCodeEnum.INT_NOT_NULL_FAIL;

/**
 * @author: liurenpeng
 * @date: Created in 2017-11-12
 */
public class IntNotNullRuler extends BaseRuler<Integer> {


    public IntNotNullRuler() {
        init(INT_NOT_NULL_FAIL.getCode(), INT_NOT_NULL_FAIL.getDesc());
    }

    public IntNotNullRuler(long failCode, String failDesc) {
        init(failCode, failDesc);
    }

    @Override
    public void check(Integer checkTarget) {
        if (NumberUtil.isNotNull(checkTarget)) {
            return;
        }
        throw new CheckException(failCode, failDesc);
    }

}
