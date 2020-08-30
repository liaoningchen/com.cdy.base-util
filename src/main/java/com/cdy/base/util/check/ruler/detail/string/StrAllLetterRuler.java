package com.cdy.base.util.check.ruler.detail.string;

import com.cdy.base.util.check.ruler.BaseRuler;
import com.cdy.base.util.exception.CheckException;
import com.cdy.base.util.util.StrUtil;

import static com.cdy.base.util.check.ruler.CheckResultCodeEnum.*;

public class StrAllLetterRuler extends BaseRuler<String> {


    public StrAllLetterRuler() {
        init(STR_ALL_LETTER_FAIL.getCode(), STR_ALL_LETTER_FAIL.getDesc());
    }

    public StrAllLetterRuler(long failCode, String failDesc) {
        init(failCode, failDesc);
    }

    @Override
    public void check(String checkTarget) {
        if (null == checkTarget) {
            return;
        }
        if (StrUtil.isAllLetter(checkTarget)) {
            return;
        }
        throw new CheckException(failCode, failDesc);
    }

}
