package com.cdy.base.util.check.ruler.detail.number;

import com.cdy.base.util.check.ruler.BaseRuler;
import com.cdy.base.util.exception.CheckException;
import com.cdy.base.util.util.NumberUtil;

import static com.cdy.base.util.check.ruler.CheckResultCodeEnum.*;

public class LongNotNullRuler extends BaseRuler<Long> {


    public LongNotNullRuler() {
        init(LONG_NOT_NULL_FAIL.getCode(), LONG_NOT_NULL_FAIL.getDesc());
    }

    public LongNotNullRuler(long failCode, String failDesc) {
        init(failCode, failDesc);
    }

    @Override
    public void check(Long checkTarget) {
        if (NumberUtil.isNotNull(checkTarget)) {
            return;
        }
        throw new CheckException(failCode, failDesc);
    }

}
