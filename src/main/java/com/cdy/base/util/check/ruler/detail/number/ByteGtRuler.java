package com.cdy.base.util.check.ruler.detail.number;

import com.cdy.base.util.check.ruler.BaseRuler;
import com.cdy.base.util.exception.CheckException;
import com.cdy.base.util.util.NumberUtil;

import static com.cdy.base.util.check.ruler.CheckResultCodeEnum.*;

public class ByteGtRuler extends BaseRuler<Byte> {

    private Byte norm;

    public ByteGtRuler(Byte norm) {
        init(norm, BYTE_GT_FAIL.getCode(), BYTE_GT_FAIL.getDesc());
    }

    public ByteGtRuler(Byte norm, long failCode, String failDesc) {
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
        if (NumberUtil.isGt(checkTarget, norm)) {
            return;
        }
        throw new CheckException(failCode, String.format(failDesc, norm));
    }

}
