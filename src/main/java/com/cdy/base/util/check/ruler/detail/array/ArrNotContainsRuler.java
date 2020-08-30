package com.cdy.base.util.check.ruler.detail.array;
import com.cdy.base.util.check.ruler.BaseRuler;
import com.cdy.base.util.exception.CheckException;
import com.cdy.base.util.util.ArrayUtil;

import static com.cdy.base.util.check.ruler.CheckResultCodeEnum.*;

public class ArrNotContainsRuler extends BaseRuler<Object[]> {

    private Object norm;

    public ArrNotContainsRuler(Object norm) {
        init(norm, ARR_NOT_CONTAINS_FAIL.getCode(), ARR_NOT_CONTAINS_FAIL.getDesc());
    }

    public ArrNotContainsRuler(Object norm, long failCode, String failDesc) {
        init(norm, failCode, failDesc);
    }

    private void init(Object norm, long failCode, String failDesc) {
        this.norm = norm;
        init(failCode, failDesc);
    }

    @Override
    public void check(Object[] checkTarget) {
        if (null == checkTarget) {
            return;
        }
        if (ArrayUtil.isNotContains(checkTarget, norm)) {
            return;
        }
        throw new CheckException(failCode, String.format(failDesc, norm));
    }

}
