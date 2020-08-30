package com.cdy.base.util.check.ruler.detail.string;

import com.daojia.khpt.util.base.check.CheckException;
import com.daojia.khpt.util.base.check.ruler.BaseRuler;
import com.daojia.khpt.util.base.util.StringUtil;

import static com.daojia.khpt.util.base.check.CheckResultCodeEnum.*;
import static com.daojia.khpt.util.base.check.CheckResultCodeEnum.STR_STANDARD_DATE_FAIL;

/**
 * @author: liurenpeng
 * @date: Created in 2017-11-12
 */
public class StrStandardDateRuler extends BaseRuler<String> {


    public StrStandardDateRuler() {
        init(STR_STANDARD_DATE_FAIL.getCode(), STR_STANDARD_DATE_FAIL.getDesc());
    }

    public StrStandardDateRuler(long failCode, String failDesc) {
        init(failCode, failDesc);
    }

    @Override
    public void check(String checkTarget) {
        if (null == checkTarget) {
            return;
        }
        if (StringUtil.isStandardDate(checkTarget)) {
            return;
        }
        throw new CheckException(failCode, failDesc);
    }

}
