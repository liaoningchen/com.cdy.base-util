package com.cdy.base.util.check.ruler.detail.collection;

import com.daojia.khpt.util.base.check.CheckException;
import com.daojia.khpt.util.base.check.ruler.BaseRuler;
import com.daojia.khpt.util.base.util.CollectionUtil;

import java.util.Collection;

import static com.daojia.khpt.util.base.check.CheckResultCodeEnum.*;
import static com.daojia.khpt.util.base.check.CheckResultCodeEnum.COLL_NOT_CONTAINS_DUP_FAIL;

/**
 * @author: liurenpeng
 * @date: Created in 2017-11-12
 */
public class CollNotContainsDupRuler extends BaseRuler<Collection> {


    public CollNotContainsDupRuler() {
        init(COLL_NOT_CONTAINS_DUP_FAIL.getCode(), COLL_NOT_CONTAINS_DUP_FAIL.getDesc());
    }

    public CollNotContainsDupRuler(long failCode, String failDesc) {
        init(failCode, failDesc);
    }

    @Override
    public void check(Collection checkTarget) {
        if (null == checkTarget) {
            return;
        }
        if (CollectionUtil.isNotContainsDup(checkTarget)) {
            return;
        }
        throw new CheckException(failCode, failDesc);
    }

}
