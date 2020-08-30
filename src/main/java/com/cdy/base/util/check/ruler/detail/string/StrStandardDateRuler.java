package com.cdy.base.util.check.ruler.detail.string;

import com.cdy.base.util.check.ruler.BaseRuler;
import com.cdy.base.util.exception.CheckException;
import com.cdy.base.util.util.StringUtil;

import static com.cdy.base.util.check.ruler.CheckResultCodeEnum.*;

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
