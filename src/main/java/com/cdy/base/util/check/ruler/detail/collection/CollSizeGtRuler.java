package com.cdy.base.util.check.ruler.detail.collection;

import com.cdy.base.util.check.ruler.BaseRuler;
import com.cdy.base.util.exception.CheckException;
import com.cdy.base.util.util.CollectionUtil;
import java.util.Collection;
import static com.cdy.base.util.check.ruler.CheckResultCodeEnum.*;

public class CollSizeGtRuler extends BaseRuler<Collection> {

    private int norm;

    public CollSizeGtRuler(int norm) {
        init(norm, COLL_SIZE_GT_FAIL.getCode(), COLL_SIZE_GT_FAIL.getDesc());
    }

    public CollSizeGtRuler(int norm, long failCode, String failDesc) {
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
        if (CollectionUtil.isSizeGt(checkTarget, norm)) {
            return;
        }
        throw new CheckException(failCode, String.format(failDesc, norm));
    }

}
