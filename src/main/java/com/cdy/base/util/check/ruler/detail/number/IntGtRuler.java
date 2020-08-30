package com.cdy.base.util.check.ruler.detail.number;

import com.cdy.base.util.check.ruler.BaseRuler;
import com.cdy.base.util.exception.CheckException;
import com.cdy.base.util.util.NumberUtil;

import static com.cdy.base.util.check.ruler.CheckResultCodeEnum.*;

public class IntGtRuler extends BaseRuler<Integer> {

    private Integer norm;

    public IntGtRuler(Integer norm) {
        init(norm, INT_GT_FAIL.getCode(), INT_GT_FAIL.getDesc());
    }

    public IntGtRuler(Integer norm, long failCode, String failDesc) {
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
        if (NumberUtil.isGt(checkTarget, norm)) {
            return;
        }
        throw new CheckException(failCode, String.format(failDesc, norm));
    }

}
