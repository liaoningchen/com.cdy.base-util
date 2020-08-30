package com.cdy.base.util.check.ruler.detail.date;

import com.cdy.base.util.check.ruler.BaseRuler;
import com.cdy.base.util.exception.CheckException;
import com.cdy.base.util.util.DateUtil;

import java.util.Date;

import static com.cdy.base.util.check.ruler.CheckResultCodeEnum.*;

public class DateNotNullRuler extends BaseRuler<Date> {


    public DateNotNullRuler() {
        init(DATE_NOT_NULL_FAIL.getCode(), DATE_NOT_NULL_FAIL.getDesc());
    }

    public DateNotNullRuler(long failCode, String failDesc) {
        init(failCode, failDesc);
    }

    @Override
    public void check(Date checkTarget) {
        if (DateUtil.isNotNull(checkTarget)) {
            return;
        }
        throw new CheckException(failCode, failDesc);
    }

}
