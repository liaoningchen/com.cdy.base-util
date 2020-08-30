package com.cdy.base.util.check.ruler.detail.array;

import com.daojia.khpt.util.base.check.CheckException;
import com.daojia.khpt.util.base.check.ruler.BaseRuler;
import com.daojia.khpt.util.base.util.ArrayUtil;

import static com.daojia.khpt.util.base.check.CheckResultCodeEnum.*;
import static com.daojia.khpt.util.base.check.CheckResultCodeEnum.ARR_LENGTH_GTE_FAIL;

/**
 * @author: liurenpeng
 * @date: Created in 2017-11-12
 */
public class ArrLengthGteRuler extends BaseRuler<Object[]> {

    private int norm;

    public ArrLengthGteRuler(int norm) {
        init(norm, ARR_LENGTH_GTE_FAIL.getCode(), ARR_LENGTH_GTE_FAIL.getDesc());
    }

    public ArrLengthGteRuler(int norm, long failCode, String failDesc) {
        init(norm, failCode, failDesc);
    }

    private void init(int norm, long failCode, String failDesc) {
        this.norm = norm;
        init(failCode, failDesc);
    }

    @Override
    public void check(Object[] checkTarget) {
        if (null == checkTarget) {
            return;
        }
        if (ArrayUtil.isLengthGte(checkTarget, norm)) {
            return;
        }
        throw new CheckException(failCode, String.format(failDesc, norm));
    }

}
