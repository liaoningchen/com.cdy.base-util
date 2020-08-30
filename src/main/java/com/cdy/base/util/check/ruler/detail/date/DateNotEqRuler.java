package com.cdy.base.util.check.ruler.detail.date;

import com.cdy.base.util.check.ruler.BaseRuler;
import com.cdy.base.util.exception.CheckException;
import com.cdy.base.util.util.DateUtil;

import java.util.Date;

import static com.cdy.base.util.check.ruler.CheckResultCodeEnum.DATE_NOT_EQ_FAIL;

public class DateNotEqRuler extends BaseRuler<Date> {

    private Date norm;

    public DateNotEqRuler(Date norm) {
        init(norm, DATE_NOT_EQ_FAIL.getCode(), DATE_NOT_EQ_FAIL.getDesc());
    }

    public DateNotEqRuler(Date norm, long failCode, String failDesc) {
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
        if (DateUtil.isNotEq(checkTarget, norm)) {
            return;
        }
        throw new CheckException(failCode, String.format(failDesc, norm, norm));
    }

}
