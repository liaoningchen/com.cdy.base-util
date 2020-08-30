package com.cdy.base.util.check.ruler.detail.string;

import com.daojia.khpt.util.base.check.CheckException;
import com.daojia.khpt.util.base.check.ruler.BaseRuler;
import com.daojia.khpt.util.base.util.StringUtil;

import static com.daojia.khpt.util.base.check.CheckResultCodeEnum.STR_CHINESE_NAME_FAIL;

/**
 * @author: liurenpeng
 * @date: Created in 2017-11-12
 */
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
        if (StringUtil.isChineseName(checkTarget)) {
            return;
        }
        throw new CheckException(failCode, failDesc);
    }

}
