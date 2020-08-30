package com.cdy.base.util.check.ruler.detail.string;

import com.daojia.khpt.util.base.check.CheckException;
import com.daojia.khpt.util.base.check.ruler.BaseRuler;
import com.daojia.khpt.util.base.util.StringUtil;

import static com.daojia.khpt.util.base.check.CheckResultCodeEnum.*;
import static com.daojia.khpt.util.base.check.CheckResultCodeEnum.STR_NUM_FAIL;

/**
 * @author: liurenpeng
 * @date: Created in 2017-11-12
 */
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
        if (StringUtil.isNum(checkTarget)) {
            return;
        }
        throw new CheckException(failCode, failDesc);
    }

}
