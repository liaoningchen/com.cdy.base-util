package com.cdy.base.util.check.ruler.detail.number;


import com.cdy.base.util.check.ruler.BaseRuler;
import com.cdy.base.util.exception.CheckException;
import com.cdy.base.util.util.NumberUtil;

import static com.cdy.base.util.check.ruler.CheckResultCodeEnum.*;

public class LongGteRuler extends BaseRuler<Long> {

    private Long norm;

    public LongGteRuler(Long norm) {
        init(norm, LONG_GTE_FAIL.getCode(), LONG_GTE_FAIL.getDesc());
    }

    public LongGteRuler(Long norm, long failCode, String failDesc) {
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
        if (NumberUtil.isGte(checkTarget, norm)) {
            return;
        }
        throw new CheckException(failCode, String.format(failDesc, norm));
    }

}
