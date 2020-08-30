package com.cdy.base.util.check.ruler.detail.date;

import com.daojia.khpt.util.base.check.CheckException;
import com.daojia.khpt.util.base.check.ruler.BaseRuler;
import com.daojia.khpt.util.base.util.DateUtil;

import java.util.Date;

import static com.daojia.khpt.util.base.check.CheckResultCodeEnum.*;
import static com.daojia.khpt.util.base.check.CheckResultCodeEnum.DATE_BEFORE_OR_EQ_FAIL;

/**
 * @author: liurenpeng
 * @date: Created in 2017-11-12
 */
public class DateBeforeOrEqRuler extends BaseRuler<Date> {

    private Date norm;

    public DateBeforeOrEqRuler(Date norm) {
        init(norm, DATE_BEFORE_OR_EQ_FAIL.getCode(), DATE_BEFORE_OR_EQ_FAIL.getDesc());
    }

    public DateBeforeOrEqRuler(Date norm, long failCode, String failDesc) {
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
        if (DateUtil.isBeforeOrEq(checkTarget, norm)) {
            return;
        }
        throw new CheckException(failCode, String.format(failDesc, norm, norm));
    }

}
