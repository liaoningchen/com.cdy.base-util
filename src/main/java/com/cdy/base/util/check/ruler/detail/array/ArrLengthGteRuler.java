package com.cdy.base.util.check.ruler.detail.array;

import com.cdy.base.util.check.ruler.BaseRuler;
import com.cdy.base.util.exception.CheckException;
import com.cdy.base.util.util.ArrayUtil;

import static com.cdy.base.util.check.ruler.CheckResultCodeEnum.ARR_LENGTH_GTE_FAIL;


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
