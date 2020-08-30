package com.cdy.base.util.check.ruler.detail.date;

import com.cdy.base.util.check.ruler.BaseRuler;
import com.cdy.base.util.exception.CheckException;
import com.cdy.base.util.util.DateUtil;

import java.util.Date;

import static com.cdy.base.util.check.ruler.CheckResultCodeEnum.DATE_EQ_FAIL;


public class DateEqRuler extends BaseRuler<Date> {

    private Date norm;

    public DateEqRuler(Date norm) {
        init(norm, DATE_EQ_FAIL.getCode(), DATE_EQ_FAIL.getDesc());
    }

    public DateEqRuler(Date norm, long failCode, String failDesc) {
        init(norm, failCode, failDesc);
    }

    private void init(Date norm, long failCode, String failDesc) {
        this.norm = norm;
        init(failCode, failDesc);
    }

    @Override
    public void check(Date checkTarget) {
        if (null == checkTarget) {
            return;
        }
        if (DateUtil.isEq(checkTarget, norm)) {
            return;
        }
        throw new CheckException(failCode, String.format(failDesc, norm, norm));
    }

}
