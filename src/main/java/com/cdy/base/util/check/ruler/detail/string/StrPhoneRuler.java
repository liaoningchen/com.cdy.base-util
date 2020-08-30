package com.cdy.base.util.check.ruler.detail.string;

import com.cdy.base.util.check.ruler.BaseRuler;
import com.cdy.base.util.exception.CheckException;
import com.cdy.base.util.util.StringUtil;

import static com.cdy.base.util.check.ruler.CheckResultCodeEnum.*;

public class StrPhoneRuler extends BaseRuler<String> {


    public StrPhoneRuler() {
        init(STR_PHONE_FAIL.getCode(), STR_PHONE_FAIL.getDesc());
    }

    public StrPhoneRuler(long failCode, String failDesc) {
        init(failCode, failDesc);
    }

    @Override
    public void check(String checkTarget) {
        if (null == checkTarget) {
            return;
        }
        if (StringUtil.isPhone(checkTarget)) {
            return;
        }
        throw new CheckException(failCode, failDesc);
    }

}
