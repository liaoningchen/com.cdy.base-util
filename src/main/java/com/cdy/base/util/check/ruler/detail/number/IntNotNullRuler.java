package com.cdy.base.util.check.ruler.detail.number;

import com.cdy.base.util.check.ruler.BaseRuler;
import com.cdy.base.util.exception.CheckException;
import com.cdy.base.util.util.NumberUtil;

import static com.cdy.base.util.check.ruler.CheckResultCodeEnum.*;

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
