package com.cdy.base.util.check.ruler.detail.collection;

import com.daojia.khpt.util.base.check.CheckException;
import com.daojia.khpt.util.base.check.ruler.BaseRuler;
import com.daojia.khpt.util.base.util.CollectionUtil;

import java.util.Collection;

import static com.daojia.khpt.util.base.check.CheckResultCodeEnum.*;
import static com.daojia.khpt.util.base.check.CheckResultCodeEnum.COLL_CONTAINS_FAIL;

/**
 * @author: liurenpeng
 * @date: Created in 2017-11-12
 */
public class CollContainsRuler extends BaseRuler<Collection> {

    private Object norm;

    public CollContainsRuler(Object norm) {
        init(norm, COLL_CONTAINS_FAIL.getCode(), COLL_CONTAINS_FAIL.getDesc());
    }

    public CollContainsRuler(Object norm, long failCode, String failDesc) {
        init(norm, failCode, failDesc);
    }

    private void init(Object norm, long failCode, String failDesc) {
        this.norm = norm;
        init(failCode, failDesc);
    }

    @Override
    public void check(Collection checkTarget) {
        if (null == checkTarget) {
            return;
        }
        if (CollectionUtil.isContains(checkTarget, norm)) {
            return;
        }
        throw new CheckException(failCode, String.format(failDesc, norm));
    }

}
