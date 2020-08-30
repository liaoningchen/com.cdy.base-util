package com.cdy.base.util.check.ruler.detail.string;

import com.cdy.base.util.check.ruler.BaseRuler;
import com.cdy.base.util.exception.CheckException;
import com.cdy.base.util.util.StrUtil;

import static com.cdy.base.util.check.ruler.CheckResultCodeEnum.*;

public class StrChineseNameRuler extends BaseRuler<String> {


    public StrChineseNameRuler() {
        init(STR_CHINESE_NAME_FAIL.getCode(), STR_CHINESE_NAME_FAIL.getDesc());
    }

    public StrChineseNameRuler(long failCode, String failDesc) {
        init(failCode, failDesc);
    }

    @Override
    public void check(String checkTarget) {
        if (null == checkTarget) {
            return;
        }
        if (StrUtil.isChineseName(checkTarget)) {
            return;
        }
        throw new CheckException(failCode, failDesc);
    }

}
