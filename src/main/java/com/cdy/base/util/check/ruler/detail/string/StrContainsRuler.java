package com.cdy.base.util.check.ruler.detail.string;

import com.daojia.khpt.util.base.check.CheckException;
import com.daojia.khpt.util.base.check.ruler.BaseRuler;
import com.daojia.khpt.util.base.util.StringUtil;

import static com.daojia.khpt.util.base.check.CheckResultCodeEnum.*;
import static com.daojia.khpt.util.base.check.CheckResultCodeEnum.STR_CONTAINS_FAIL;

/**
 * @author: liurenpeng
 * @date: Created in 2017-11-12
 */
public class StrContainsRuler extends BaseRuler<String> {

    private String norm;

    public StrContainsRuler(String norm) {
        init(norm, STR_CONTAINS_FAIL.getCode(), STR_CONTAINS_FAIL.getDesc());
    }

    public StrContainsRuler(String norm, long failCode, String failDesc) {
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
        if (StringUtil.isContains(checkTarget, norm)) {
            return;
        }
        throw new CheckException(failCode, String.format(failDesc, norm));
    }

}
