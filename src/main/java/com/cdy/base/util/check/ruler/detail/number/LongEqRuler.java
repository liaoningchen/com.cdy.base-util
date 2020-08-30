package com.cdy.base.util.check.ruler.detail.number;

import com.daojia.khpt.util.base.check.CheckException;
import com.daojia.khpt.util.base.check.ruler.BaseRuler;
import com.daojia.khpt.util.base.util.NumberUtil;

import static com.daojia.khpt.util.base.check.CheckResultCodeEnum.*;
import static com.daojia.khpt.util.base.check.CheckResultCodeEnum.LONG_EQ_FAIL;

/**
 * @author: liurenpeng
 * @date: Created in 2017-11-12
 */
public class LongEqRuler extends BaseRuler<Long> {

    private Long norm;

    public LongEqRuler(Long norm) {
        init(norm, LONG_EQ_FAIL.getCode(), LONG_EQ_FAIL.getDesc());
    }

    public LongEqRuler(Long norm, long failCode, String failDesc) {
        init(norm, failCode, failDesc);
    }

    private void init(Long norm, long failCode, String failDesc) {
        this.norm = norm;
        init(failCode, failDesc);
    }

    @Override
    public void check(Long checkTarget) {
        if (null == checkTarget) {
            return;
        }
        if (NumberUtil.isEq(checkTarget, norm)) {
            return;
        }
        throw new CheckException(failCode, String.format(failDesc, norm));
    }

}
