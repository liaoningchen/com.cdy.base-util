package com.cdy.base.util.check.ruler.detail.collection;

import com.cdy.base.util.check.ruler.BaseRuler;
import com.cdy.base.util.exception.CheckException;
import com.cdy.base.util.util.CollectionUtil;
import java.util.Collection;
import static com.cdy.base.util.check.ruler.CheckResultCodeEnum.*;

public class CollSizeEqRuler extends BaseRuler<Collection> {

    private int norm;

    public CollSizeEqRuler(int norm) {
        init(norm, COLL_SIZE_EQ_FAIL.getCode(), COLL_SIZE_EQ_FAIL.getDesc());
    }

    public CollSizeEqRuler(int norm, long failCode, String failDesc) {
        init(norm, failCode, failDesc);
    }

    private void init(int norm, long failCode, String failDesc) {
        this.norm = norm;
        init(failCode, failDesc);
    }

    @Override
    public void check(Collection checkTarget) {
        if (null == checkTarget) {
            return;
        }
        if (CollectionUtil.isSizeEq(checkTarget, norm)) {
            return;
        }
        throw new CheckException(failCode, String.format(failDesc, norm));
    }

}
