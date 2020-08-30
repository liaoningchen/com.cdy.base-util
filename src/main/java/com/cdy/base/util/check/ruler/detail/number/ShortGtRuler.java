package com.cdy.base.util.check.ruler.detail.number;

import com.daojia.khpt.util.base.check.CheckException;
import com.daojia.khpt.util.base.check.ruler.BaseRuler;
import com.daojia.khpt.util.base.util.NumberUtil;

import static com.daojia.khpt.util.base.check.CheckResultCodeEnum.*;
import static com.daojia.khpt.util.base.check.CheckResultCodeEnum.SHORT_GT_FAIL;

/**
 * @author: liurenpeng
 * @date: Created in 2017-11-12
 */
public class ShortGtRuler extends BaseRuler<Short> {

    private Short norm;

    public ShortGtRuler(Short norm) {
        init(norm, SHORT_GT_FAIL.getCode(), SHORT_GT_FAIL.getDesc());
    }

    public ShortGtRuler(Short norm, long failCode, String failDesc) {
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
        if (NumberUtil.isGt(checkTarget, norm)) {
            return;
        }
        throw new CheckException(failCode, String.format(failDesc, norm));
    }

}
