package com.cdy.base.util.check.ruler.detail.collection;

import com.cdy.base.util.check.ruler.BaseRuler;
import com.cdy.base.util.exception.CheckException;
import com.cdy.base.util.util.CollectionUtil;

import java.util.Collection;

import static com.cdy.base.util.check.ruler.CheckResultCodeEnum.*;

public class CollNotContainsRuler extends BaseRuler<Collection> {

    private Object norm;

    public CollNotContainsRuler(Object norm) {
        init(norm, COLL_NOT_CONTAINS_FAIL.getCode(), COLL_NOT_CONTAINS_FAIL.getDesc());
    }

    public CollNotContainsRuler(Object norm, long failCode, String failDesc) {
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
        if (CollectionUtil.isNotContains(checkTarget, norm)) {
            return;
        }
        throw new CheckException(failCode, String.format(failDesc, norm));
    }

}
