package com.cdy.base.util.check.ruler.detail.string;

import com.cdy.base.util.check.ruler.BaseRuler;
import com.cdy.base.util.exception.CheckException;
import com.cdy.base.util.util.StringUtil;

import static com.cdy.base.util.check.ruler.CheckResultCodeEnum.*;

public class StrStandardDatetimeRuler extends BaseRuler<String> {


    public StrStandardDatetimeRuler() {
        init(STR_STANDARD_DATETIME_FAIL.getCode(), STR_STANDARD_DATETIME_FAIL.getDesc());
    }

    public StrStandardDatetimeRuler(long failCode, String failDesc) {
        init(failCode, failDesc);
    }

    @Override
    public void check(String checkTarget) {
        if (null == checkTarget) {
            return;
        }
        if (StringUtil.isStandardDatetime(checkTarget)) {
            return;
        }
        throw new CheckException(failCode, failDesc);
    }

}
