package com.cdy.base.util.check.ruler.detail.string;

import com.cdy.base.util.check.ruler.BaseRuler;
import com.cdy.base.util.exception.CheckException;
import com.cdy.base.util.util.StringUtil;

import static com.cdy.base.util.check.ruler.CheckResultCodeEnum.*;

public class StrIdCardRuler extends BaseRuler<String> {


    public StrIdCardRuler() {
        init(STR_ID_CARD_FAIL.getCode(), STR_ID_CARD_FAIL.getDesc());
    }

    public StrIdCardRuler(long failCode, String failDesc) {
        init(failCode, failDesc);
    }

    @Override
    public void check(String checkTarget) {
        if (null == checkTarget) {
            return;
        }
        if (StringUtil.isIdCard(checkTarget)) {
            return;
        }
        throw new CheckException(failCode, failDesc);
    }

}
