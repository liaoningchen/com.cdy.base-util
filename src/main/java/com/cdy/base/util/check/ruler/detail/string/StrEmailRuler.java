package com.cdy.base.util.check.ruler.detail.string;

import com.cdy.base.util.check.ruler.BaseRuler;
import com.cdy.base.util.exception.CheckException;
import com.cdy.base.util.util.StrUtil;

import static com.cdy.base.util.check.ruler.CheckResultCodeEnum.*;

public class StrEmailRuler extends BaseRuler<String> {


    public StrEmailRuler() {
        init(STR_EMAIL_FAIL.getCode(), STR_EMAIL_FAIL.getDesc());
    }

    public StrEmailRuler(long failCode, String failDesc) {
        init(failCode, failDesc);
    }

    @Override
    public void check(String checkTarget) {
        if (null == checkTarget) {
            return;
        }
        if (StrUtil.isEmail(checkTarget)) {
            return;
        }
        throw new CheckException(failCode, failDesc);
    }

}
