package com.cdy.base.util.check.ruler.detail.number;

import com.cdy.base.util.check.ruler.BaseRuler;
import com.cdy.base.util.exception.CheckException;
import com.cdy.base.util.util.NumberUtil;

import static com.cdy.base.util.check.ruler.CheckResultCodeEnum.*;

public class ByteNotNullRuler extends BaseRuler<Byte> {


    public ByteNotNullRuler() {
        init(BYTE_NOT_NULL_FAIL.getCode(), BYTE_NOT_NULL_FAIL.getDesc());
    }

    public ByteNotNullRuler(long failCode, String failDesc) {
        init(failCode, failDesc);
    }

    @Override
    public void check(Byte checkTarget) {
        if (NumberUtil.isNotNull(checkTarget)) {
            return;
        }
        throw new CheckException(failCode, failDesc);
    }

}
