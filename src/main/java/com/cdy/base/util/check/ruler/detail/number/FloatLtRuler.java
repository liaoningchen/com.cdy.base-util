package com.cdy.base.util.check.ruler.detail.number;

import com.cdy.base.util.check.ruler.BaseRuler;
import com.cdy.base.util.exception.CheckException;
import com.cdy.base.util.util.NumberUtil;

import static com.cdy.base.util.check.ruler.CheckResultCodeEnum.*;

public class FloatLtRuler extends BaseRuler<Float> {

    private Float norm;

    public FloatLtRuler(Float norm) {
        init(norm, FLOAT_LT_FAIL.getCode(), FLOAT_LT_FAIL.getDesc());
    }

    public FloatLtRuler(Float norm, long failCode, String failDesc) {
        init(norm, failCode, failDesc);
    }

    private void init(Float norm, long failCode, String failDesc) {
        this.norm = norm;
        init(failCode, failDesc);
    }

    @Override
    public void check(Float checkTarget) {
        if (null == checkTarget) {
            return;
        }
        if (NumberUtil.isLt(checkTarget, norm)) {
            return;
        }
        throw new CheckException(failCode, String.format(failDesc, norm));
    }

}
