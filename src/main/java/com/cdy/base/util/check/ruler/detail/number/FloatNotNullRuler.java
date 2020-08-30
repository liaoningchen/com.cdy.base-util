package com.cdy.base.util.check.ruler.detail.number;

import com.daojia.khpt.util.base.check.CheckException;
import com.daojia.khpt.util.base.check.ruler.BaseRuler;
import com.daojia.khpt.util.base.util.NumberUtil;

import static com.daojia.khpt.util.base.check.CheckResultCodeEnum.*;
import static com.daojia.khpt.util.base.check.CheckResultCodeEnum.FLOAT_NOT_NULL_FAIL;

/**
 * @author: liurenpeng
 * @date: Created in 2017-11-12
 */
public class FloatNotNullRuler extends BaseRuler<Float> {


    public FloatNotNullRuler() {
        init(FLOAT_NOT_NULL_FAIL.getCode(), FLOAT_NOT_NULL_FAIL.getDesc());
    }

    public FloatNotNullRuler(long failCode, String failDesc) {
        init(failCode, failDesc);
    }

    @Override
    public void check(Float checkTarget) {
        if (NumberUtil.isNotNull(checkTarget)) {
            return;
        }
        throw new CheckException(failCode, failDesc);
    }

}
