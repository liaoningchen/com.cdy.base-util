package com.cdy.base.util.check.ruler.detail.number;

import com.daojia.khpt.util.base.check.CheckException;
import com.daojia.khpt.util.base.check.ruler.BaseRuler;
import com.daojia.khpt.util.base.util.NumberUtil;

import static com.daojia.khpt.util.base.check.CheckResultCodeEnum.*;
import static com.daojia.khpt.util.base.check.CheckResultCodeEnum.LONG_GT_FAIL;

/**
 * @author: liurenpeng
 * @date: Created in 2017-11-12
 */
public class LongGtRuler extends BaseRuler<Long> {

    private Long norm;

    public LongGtRuler(Long norm) {
        init(norm, LONG_GT_FAIL.getCode(), LONG_GT_FAIL.getDesc());
    }

    public LongGtRuler(Long norm, long failCode, String failDesc) {
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
        if (NumberUtil.isGt(checkTarget, norm)) {
            return;
        }
        throw new CheckException(failCode, String.format(failDesc, norm));
    }

}
