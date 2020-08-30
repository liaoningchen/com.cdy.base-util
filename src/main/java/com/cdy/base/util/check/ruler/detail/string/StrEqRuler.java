package com.cdy.base.util.check.ruler.detail.string;

import com.cdy.base.util.check.ruler.BaseRuler;
import com.cdy.base.util.exception.CheckException;
import com.cdy.base.util.util.StringUtil;

import static com.cdy.base.util.check.ruler.CheckResultCodeEnum.*;

public class StrEqRuler extends BaseRuler<String> {

    private String norm;

    public StrEqRuler(String norm) {
        init(norm, STR_EQ_FAIL.getCode(), STR_EQ_FAIL.getDesc());
    }

    public StrEqRuler(String norm, long failCode, String failDesc) {
        init(norm, failCode, failDesc);
    }

    private void init(String norm, long failCode, String failDesc) {
        this.norm = norm;
        init(failCode, failDesc);
    }

    @Override
    public void check(String checkTarget) {
        if (null == checkTarget) {
            return;
        }
        if (StringUtil.isEq(checkTarget, norm)) {
            return;
        }
        throw new CheckException(failCode, String.format(failDesc, norm));
    }

}
