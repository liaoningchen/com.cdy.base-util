package com.cdy.base.util.check.ruler.detail.number;

import com.daojia.khpt.util.base.check.CheckException;
import com.daojia.khpt.util.base.check.ruler.BaseRuler;
import com.daojia.khpt.util.base.util.NumberUtil;

import static com.daojia.khpt.util.base.check.CheckResultCodeEnum.*;
import static com.daojia.khpt.util.base.check.CheckResultCodeEnum.FLOAT_LTE_FAIL;

/**
 * @author: liurenpeng
 * @date: Created in 2017-11-12
 */
public class FloatLteRuler extends BaseRuler<Float> {

    private Float norm;

    public FloatLteRuler(Float norm) {
        init(norm, FLOAT_LTE_FAIL.getCode(), FLOAT_LTE_FAIL.getDesc());
    }

    public FloatLteRuler(Float norm, long failCode, String failDesc) {
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
        if (NumberUtil.isLte(checkTarget, norm)) {
            return;
        }
        throw new CheckException(failCode, String.format(failDesc, norm));
    }

}
