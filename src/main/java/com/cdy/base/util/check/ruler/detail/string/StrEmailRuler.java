package com.cdy.base.util.check.ruler.detail.string;

import com.daojia.khpt.util.base.check.CheckException;
import com.daojia.khpt.util.base.check.ruler.BaseRuler;
import com.daojia.khpt.util.base.util.StringUtil;

import static com.daojia.khpt.util.base.check.CheckResultCodeEnum.*;
import static com.daojia.khpt.util.base.check.CheckResultCodeEnum.STR_EMAIL_FAIL;

/**
 * @author: liurenpeng
 * @date: Created in 2017-11-12
 */
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
        if (StringUtil.isEmail(checkTarget)) {
            return;
        }
        throw new CheckException(failCode, failDesc);
    }

}
