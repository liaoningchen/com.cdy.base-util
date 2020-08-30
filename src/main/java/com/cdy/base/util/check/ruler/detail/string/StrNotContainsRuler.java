package com.cdy.base.util.check.ruler.detail.string;

import com.cdy.base.util.check.ruler.BaseRuler;
import com.cdy.base.util.exception.CheckException;
import com.cdy.base.util.util.StringUtil;

import static com.cdy.base.util.check.ruler.CheckResultCodeEnum.*;

public class StrNotContainsRuler extends BaseRuler<String> {

    private String norm;

    public StrNotContainsRuler(String norm) {
        init(norm, STR_NOT_CONTAINS_FAIL.getCode(), STR_NOT_CONTAINS_FAIL.getDesc());
    }

    public StrNotContainsRuler(String norm, long failCode, String failDesc) {
        init(norm, failCode, failDesc);
    }

    private void init(String norm, long failCode, String failDesc) {
        this.norm = norm;
        init(failCode, failDesc);
    }

    @Override
    public void check(String checkTarget) {
        if (null == checkTarget) {
            return;
        }
        if (StringUtil.isNotContains(checkTarget, norm)) {
            return;
        }
        throw new CheckException(failCode, String.format(failDesc, norm));
    }

}
