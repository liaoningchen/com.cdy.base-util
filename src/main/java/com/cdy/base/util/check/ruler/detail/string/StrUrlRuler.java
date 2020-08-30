package com.cdy.base.util.check.ruler.detail.string;

import com.cdy.base.util.check.ruler.BaseRuler;
import com.cdy.base.util.exception.CheckException;
import com.cdy.base.util.util.StrUtil;

import static com.cdy.base.util.check.ruler.CheckResultCodeEnum.*;

public class StrUrlRuler extends BaseRuler<String> {


    public StrUrlRuler() {
        init(STR_URL_FAIL.getCode(), STR_URL_FAIL.getDesc());
    }

    public StrUrlRuler(long failCode, String failDesc) {
        init(failCode, failDesc);
    }

    @Override
    public void check(String checkTarget) {
        if (null == checkTarget) {
            return;
        }
        if (StrUtil.isUrl(checkTarget)) {
            return;
        }
        throw new CheckException(failCode, failDesc);
    }

}
