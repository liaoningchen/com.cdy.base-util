package com.cdy.base.util.check.ruler.detail.string;

import com.daojia.khpt.util.base.check.CheckException;
import com.daojia.khpt.util.base.check.ruler.BaseRuler;
import com.daojia.khpt.util.base.util.StringUtil;

import static com.daojia.khpt.util.base.check.CheckResultCodeEnum.STR_ENGLISH_NAME_FAIL;

/**
 * @author: liurenpeng
 * @date: Created in 2017-11-12
 */
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
