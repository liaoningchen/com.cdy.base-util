package com.cdy.base.util.check.ruler.detail.string;

import com.cdy.base.util.check.ruler.BaseRuler;
import com.cdy.base.util.exception.CheckException;
import com.cdy.base.util.util.StrUtil;

import static com.cdy.base.util.check.ruler.CheckResultCodeEnum.*;

public class StrNumRuler extends BaseRuler<String> {


    public StrNumRuler() {
        init(STR_NUM_FAIL.getCode(), STR_NUM_FAIL.getDesc());
    }

    public StrNumRuler(long failCode, String failDesc) {
        init(failCode, failDesc);
    }

    @Override
    public void check(String checkTarget) {
        if (null == checkTarget) {
            return;
        }
        if (StrUtil.isNum(checkTarget)) {
            return;
        }
        throw new CheckException(failCode, failDesc);
    }

}
