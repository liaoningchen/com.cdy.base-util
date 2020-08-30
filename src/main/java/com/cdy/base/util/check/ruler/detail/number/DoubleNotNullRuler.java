package com.cdy.base.util.check.ruler.detail.number;

import com.cdy.base.util.check.ruler.BaseRuler;
import com.cdy.base.util.exception.CheckException;
import com.cdy.base.util.util.NumberUtil;

import static com.cdy.base.util.check.ruler.CheckResultCodeEnum.*;

public class DoubleNotNullRuler extends BaseRuler<Double> {


    public DoubleNotNullRuler() {
        init(DOUBLE_NOT_NULL_FAIL.getCode(), DOUBLE_NOT_NULL_FAIL.getDesc());
    }

    public DoubleNotNullRuler(long failCode, String failDesc) {
        init(failCode, failDesc);
    }

    @Override
    public void check(Double checkTarget) {
        if (NumberUtil.isNotNull(checkTarget)) {
            return;
        }
        throw new CheckException(failCode, failDesc);
    }

}
