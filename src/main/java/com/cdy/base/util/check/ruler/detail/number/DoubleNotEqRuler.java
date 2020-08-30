package com.cdy.base.util.check.ruler.detail.number;
import com.cdy.base.util.check.ruler.BaseRuler;
import com.cdy.base.util.exception.CheckException;
import com.cdy.base.util.util.NumberUtil;

import static com.cdy.base.util.check.ruler.CheckResultCodeEnum.*;

public class DoubleNotEqRuler extends BaseRuler<Double> {

    private Double norm;

    public DoubleNotEqRuler(Double norm) {
        init(norm, DOUBLE_NOT_EQ_FAIL.getCode(), DOUBLE_NOT_EQ_FAIL.getDesc());
    }

    public DoubleNotEqRuler(Double norm, long failCode, String failDesc) {
        init(norm, failCode, failDesc);
    }

    private void init(Double norm, long failCode, String failDesc) {
        this.norm = norm;
        init(failCode, failDesc);
    }

    @Override
    public void check(Double checkTarget) {
        if (null == checkTarget) {
            return;
        }
        if (NumberUtil.isNotEq(checkTarget, norm)) {
            return;
        }
        throw new CheckException(failCode, String.format(failDesc, norm));
    }

}
