package com.cdy.base.util.check.ruler.detail.number;

import com.cdy.base.util.check.ruler.BaseRuler;
import com.cdy.base.util.exception.CheckException;
import com.cdy.base.util.util.NumberUtil;

import static com.cdy.base.util.check.ruler.CheckResultCodeEnum.BYTE_EQ_FAIL;


public class ByteEqRuler extends BaseRuler<Byte> {

    private Byte norm;

    public ByteEqRuler(Byte norm) {
        init(norm, BYTE_EQ_FAIL.getCode(), BYTE_EQ_FAIL.getDesc());
    }

    public ByteEqRuler(Byte norm, long failCode, String failDesc) {
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
        if (NumberUtil.isEq(checkTarget, norm)) {
            return;
        }
        throw new CheckException(failCode, String.format(failDesc, norm));
    }

}
