package com.cdy.base.util.check.ruler.detail.string;

import com.cdy.base.util.check.ruler.BaseRuler;
import com.cdy.base.util.exception.CheckException;
import com.cdy.base.util.util.StringUtil;

import static com.cdy.base.util.check.ruler.CheckResultCodeEnum.*;

public class StrNotNullRuler extends BaseRuler<String> {


    public StrNotNullRuler() {
        init(STR_NOT_NULL_FAIL.getCode(), STR_NOT_NULL_FAIL.getDesc());
    }

    public StrNotNullRuler(long failCode, String failDesc) {
        init(failCode, failDesc);
    }

    @Override
    public void check(String checkTarget) {
        if (StringUtil.isNotNull(checkTarget)) {
            return;
        }
        throw new CheckException(failCode, failDesc);
    }

}
