package com.cdy.base.util.check.ruler.detail.number;

import com.cdy.base.util.check.ruler.BaseRuler;
import com.cdy.base.util.exception.CheckException;
import com.cdy.base.util.util.NumberUtil;

import static com.cdy.base.util.check.ruler.CheckResultCodeEnum.*;

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
