package com.cdy.base.util.check.ruler.detail.number;

import com.daojia.khpt.util.base.check.CheckException;
import com.daojia.khpt.util.base.check.ruler.BaseRuler;
import com.daojia.khpt.util.base.util.NumberUtil;

import static com.daojia.khpt.util.base.check.CheckResultCodeEnum.*;
import static com.daojia.khpt.util.base.check.CheckResultCodeEnum.DOUBLE_LTE_FAIL;

/**
 * @author: liurenpeng
 * @date: Created in 2017-11-12
 */
public class DoubleLteRuler extends BaseRuler<Double> {

    private Double norm;

    public DoubleLteRuler(Double norm) {
        init(norm, DOUBLE_LTE_FAIL.getCode(), DOUBLE_LTE_FAIL.getDesc());
    }

    public DoubleLteRuler(Double norm, long failCode, String failDesc) {
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
        if (NumberUtil.isLte(checkTarget, norm)) {
            return;
        }
        throw new CheckException(failCode, String.format(failDesc, norm));
    }

}
