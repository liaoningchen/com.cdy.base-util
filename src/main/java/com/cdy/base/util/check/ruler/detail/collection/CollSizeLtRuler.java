package com.cdy.base.util.check.ruler.detail.collection;

import com.daojia.khpt.util.base.check.CheckException;
import com.daojia.khpt.util.base.check.ruler.BaseRuler;
import com.daojia.khpt.util.base.util.CollectionUtil;

import java.util.Collection;

import static com.daojia.khpt.util.base.check.CheckResultCodeEnum.*;
import static com.daojia.khpt.util.base.check.CheckResultCodeEnum.COLL_SIZE_LT_FAIL;

/**
 * @author: liurenpeng
 * @date: Created in 2017-11-12
 */
public class CollSizeLtRuler extends BaseRuler<Collection> {

    private int norm;

    public CollSizeLtRuler(int norm) {
        init(norm, COLL_SIZE_LT_FAIL.getCode(), COLL_SIZE_LT_FAIL.getDesc());
    }

    public CollSizeLtRuler(int norm, long failCode, String failDesc) {
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
        if (CollectionUtil.isSizeLt(checkTarget, norm)) {
            return;
        }
        throw new CheckException(failCode, String.format(failDesc, norm));
    }

}
