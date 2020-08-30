package com.cdy.base.util.check.ruler.detail.number;

import com.cdy.base.util.check.ruler.BaseRuler;
import com.cdy.base.util.exception.CheckException;
import com.cdy.base.util.util.NumberUtil;

import static com.cdy.base.util.check.ruler.CheckResultCodeEnum.*;

public class ShortLteRuler extends BaseRuler<Short> {

    private Short norm;

    public ShortLteRuler(Short norm) {
        init(norm, SHORT_LTE_FAIL.getCode(), SHORT_LTE_FAIL.getDesc());
    }

    public ShortLteRuler(Short norm, long failCode, String failDesc) {
        init(norm, failCode, failDesc);
    }

    private void init(Short norm, long failCode, String failDesc) {
        this.norm = norm;
        init(failCode, failDesc);
    }

    @Override
    public void check(Short checkTarget) {
        if (null == checkTarget) {
            return;
        }
        if (NumberUtil.isLte(checkTarget, norm)) {
            return;
        }
        throw new CheckException(failCode, String.format(failDesc, norm));
    }

}
