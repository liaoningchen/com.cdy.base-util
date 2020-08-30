package com.cdy.base.util.check.ruler.detail.number;

import com.daojia.khpt.util.base.check.CheckException;
import com.daojia.khpt.util.base.check.ruler.BaseRuler;
import com.daojia.khpt.util.base.util.NumberUtil;

import static com.daojia.khpt.util.base.check.CheckResultCodeEnum.*;
import static com.daojia.khpt.util.base.check.CheckResultCodeEnum.BYTE_NOT_EQ_FAIL;

/**
 * @author: liurenpeng
 * @date: Created in 2017-11-12
 */
public class ByteNotEqRuler extends BaseRuler<Byte> {

    private Byte norm;

    public ByteNotEqRuler(Byte norm) {
        init(norm, BYTE_NOT_EQ_FAIL.getCode(), BYTE_NOT_EQ_FAIL.getDesc());
    }

    public ByteNotEqRuler(Byte norm, long failCode, String failDesc) {
        init(norm, failCode, failDesc);
    }

    private void init(Byte norm, long failCode, String failDesc) {
        this.norm = norm;
        init(failCode, failDesc);
    }

    @Override
    public void check(Byte checkTarget) {
        if (null == checkTarget) {
            return;
        }
        if (NumberUtil.isNotEq(checkTarget, norm)) {
            return;
        }
        throw new CheckException(failCode, String.format(failDesc, norm));
    }

}
