package com.cdy.base.util.check.ruler.detail.string;

import com.cdy.base.util.check.ruler.BaseRuler;
import com.cdy.base.util.exception.CheckException;
import com.cdy.base.util.util.StrUtil;


import static com.cdy.base.util.check.ruler.CheckResultCodeEnum.*;

public class StrEmptyRuler extends BaseRuler<String> {


    public StrEmptyRuler() {
        init(STR_EMPTY_FAIL.getCode(), STR_EMPTY_FAIL.getDesc());
    }

    public StrEmptyRuler(long failCode, String failDesc) {
        init(failCode, failDesc);
    }

    @Override
    public void check(String checkTarget) {
        if (null == checkTarget) {
            return;
        }
        if (StrUtil.isEmpty(checkTarget)) {
            return;
        }
        throw new CheckException(failCode, failDesc);
    }

}
