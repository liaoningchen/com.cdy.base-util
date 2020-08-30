package com.cdy.base.util.check.ruler.detail.string;

import com.daojia.khpt.util.base.check.CheckException;
import com.daojia.khpt.util.base.check.ruler.BaseRuler;
import com.daojia.khpt.util.base.util.StringUtil;

import static com.daojia.khpt.util.base.check.CheckResultCodeEnum.*;
import static com.daojia.khpt.util.base.check.CheckResultCodeEnum.STR_ALL_LETTER_FAIL;

/**
 * @author: liurenpeng
 * @date: Created in 2017-11-12
 */
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
        if (StringUtil.isAllLetter(checkTarget)) {
            return;
        }
        throw new CheckException(failCode, failDesc);
    }

}
