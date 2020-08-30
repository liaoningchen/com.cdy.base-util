package com.cdy.base.util.check.ruler.detail.string;

import com.cdy.base.util.check.ruler.BaseRuler;
import com.cdy.base.util.exception.CheckException;
import com.cdy.base.util.util.StringUtil;

import static com.cdy.base.util.check.ruler.CheckResultCodeEnum.*;

public class StrEnglishNameRuler extends BaseRuler<String> {


    public StrEnglishNameRuler() {
        init(STR_ENGLISH_NAME_FAIL.getCode(), STR_ENGLISH_NAME_FAIL.getDesc());
    }

    public StrEnglishNameRuler(long failCode, String failDesc) {
        init(failCode, failDesc);
    }

    @Override
    public void check(String checkTarget) {
        if (null == checkTarget) {
            return;
        }
        if (StringUtil.isEnglishName(checkTarget)) {
            return;
        }
        throw new CheckException(failCode, failDesc);
    }

}
