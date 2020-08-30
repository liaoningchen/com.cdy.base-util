package com.cdy.base.util.check.ruler.detail.number;

import com.daojia.khpt.util.base.check.CheckException;
import com.daojia.khpt.util.base.check.ruler.BaseRuler;
import com.daojia.khpt.util.base.util.NumberUtil;

import static com.daojia.khpt.util.base.check.CheckResultCodeEnum.*;
import static com.daojia.khpt.util.base.check.CheckResultCodeEnum.FLOAT_GT_FAIL;

/**
 * @author: liurenpeng
 * @date: Created in 2017-11-12
 */
public class FloatGtRuler extends BaseRuler<Float> {

    private Float norm;

    public FloatGtRuler(Float norm) {
        init(norm, FLOAT_GT_FAIL.getCode(), FLOAT_GT_FAIL.getDesc());
    }

    public FloatGtRuler(Float norm, long failCode, String failDesc) {
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
        if (NumberUtil.isGt(checkTarget, norm)) {
            return;
        }
        throw new CheckException(failCode, String.format(failDesc, norm));
    }

}
