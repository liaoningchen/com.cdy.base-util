package com.cdy.base.util.check.ruler.detail.array;


import com.cdy.base.util.check.ruler.BaseRuler;
import com.cdy.base.util.exception.CheckException;
import org.apache.commons.lang3.ArrayUtils;

import static com.cdy.base.util.check.ruler.CheckResultCodeEnum.ARR_CONTAINS_FAIL;

public class ArrContainsRuler extends BaseRuler<Object[]> {

    private Object norm;

    public ArrContainsRuler(Object norm) {
        init(norm, ARR_CONTAINS_FAIL.getCode(), ARR_CONTAINS_FAIL.getDesc());
    }

    public ArrContainsRuler(Object norm, long failCode, String failDesc) {
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
        if (ArrayUtils.contains(checkTarget, norm)) {
            return;
        }
        throw new CheckException(failCode, String.format(failDesc, norm));
    }

}
