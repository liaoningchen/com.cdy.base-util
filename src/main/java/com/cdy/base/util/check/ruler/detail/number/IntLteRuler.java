package com.cdy.base.util.check.ruler.detail.number;

import com.daojia.khpt.util.base.check.CheckException;
import com.daojia.khpt.util.base.check.ruler.BaseRuler;
import com.daojia.khpt.util.base.util.NumberUtil;

import static com.daojia.khpt.util.base.check.CheckResultCodeEnum.*;
import static com.daojia.khpt.util.base.check.CheckResultCodeEnum.INT_LTE_FAIL;

/**
 * @author: liurenpeng
 * @date: Created in 2017-11-12
 */
public class IntLteRuler extends BaseRuler<Integer> {

    private Integer norm;

    public IntLteRuler(Integer norm) {
        init(norm, INT_LTE_FAIL.getCode(), INT_LTE_FAIL.getDesc());
    }

    public IntLteRuler(Integer norm, long failCode, String failDesc) {
        init(norm, failCode, failDesc);
    }

    private void init(Integer norm, long failCode, String failDesc) {
        this.norm = norm;
        init(failCode, failDesc);
    }

    @Override
    public void check(Integer checkTarget) {
        if (null == checkTarget) {
            return;
        }
        if (NumberUtil.isLte(checkTarget, norm)) {
            return;
        }
        throw new CheckException(failCode, String.format(failDesc, norm));
    }

}
