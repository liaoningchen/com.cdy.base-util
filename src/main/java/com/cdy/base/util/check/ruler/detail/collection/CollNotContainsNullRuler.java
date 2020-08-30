package com.cdy.base.util.check.ruler.detail.collection;

import com.daojia.khpt.util.base.check.CheckException;
import com.daojia.khpt.util.base.check.ruler.BaseRuler;
import com.daojia.khpt.util.base.util.CollectionUtil;

import java.util.Collection;

import static com.daojia.khpt.util.base.check.CheckResultCodeEnum.*;
import static com.daojia.khpt.util.base.check.CheckResultCodeEnum.COLL_NOT_CONTAINS_NULL_FAIL;

/**
 * @author: liurenpeng
 * @date: Created in 2017-11-12
 */
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
