package com.cdy.base.util.check.ruler.detail.string;

import com.cdy.base.util.check.ruler.BaseRuler;
import com.cdy.base.util.exception.CheckException;
import com.cdy.base.util.util.StringUtil;

import static com.cdy.base.util.check.ruler.CheckResultCodeEnum.*;

public class StrLengthLteRuler extends BaseRuler<String> {

    private int norm;

    public StrLengthLteRuler(int norm) {
        init(norm, STR_LENGTH_LTE_FAIL.getCode(), STR_LENGTH_LTE_FAIL.getDesc());
    }

    public StrLengthLteRuler(int norm, long failCode, String failDesc) {
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
        if (StringUtil.isLengthLte(checkTarget, norm)) {
            return;
        }
        throw new CheckException(failCode, String.format(failDesc, norm));
    }

}
