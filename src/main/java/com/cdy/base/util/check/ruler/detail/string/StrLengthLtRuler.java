package com.cdy.base.util.check.ruler.detail.string;

import com.daojia.khpt.util.base.check.CheckException;
import com.daojia.khpt.util.base.check.ruler.BaseRuler;
import com.daojia.khpt.util.base.util.StringUtil;

import static com.daojia.khpt.util.base.check.CheckResultCodeEnum.*;
import static com.daojia.khpt.util.base.check.CheckResultCodeEnum.STR_LENGTH_LT_FAIL;

/**
 * @author: liurenpeng
 * @date: Created in 2017-11-12
 */
public class StrLengthLtRuler extends BaseRuler<String> {

    private int norm;

    public StrLengthLtRuler(int norm) {
        init(norm, STR_LENGTH_LT_FAIL.getCode(), STR_LENGTH_LT_FAIL.getDesc());
    }

    public StrLengthLtRuler(int norm, long failCode, String failDesc) {
        init(norm, failCode, failDesc);
    }

    private void init(int norm, long failCode, String failDesc) {
        this.norm = norm;
        init(failCode, failDesc);
    }

    @Override
    public void check(String checkTarget) {
        if (null == checkTarget) {
            return;
        }
        if (StringUtil.isLengthLt(checkTarget, norm)) {
            return;
        }
        throw new CheckException(failCode, String.format(failDesc, norm));
    }

}
