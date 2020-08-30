package com.cdy.base.util.check.ruler.detail.collection;

import com.cdy.base.util.check.ruler.BaseRuler;
import com.cdy.base.util.exception.CheckException;
import com.cdy.base.util.util.CollectionUtil;

import java.util.Collection;

import static com.cdy.base.util.check.ruler.CheckResultCodeEnum.*;

public class CollNotContainsNullRuler extends BaseRuler<Collection> {


    public CollNotContainsNullRuler() {
        init(COLL_NOT_CONTAINS_NULL_FAIL.getCode(), COLL_NOT_CONTAINS_NULL_FAIL.getDesc());
    }

    public CollNotContainsNullRuler(long failCode, String failDesc) {
        init(failCode, failDesc);
    }

    @Override
    public void check(Collection checkTarget) {
        if (null == checkTarget) {
            return;
        }
        if (CollectionUtil.isNotContainsNull(checkTarget)) {
            return;
        }
        throw new CheckException(failCode, failDesc);
    }

}
