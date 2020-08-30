package com.cdy.base.util.check.ruler.detail.collection;

import com.daojia.khpt.util.base.check.CheckException;
import com.daojia.khpt.util.base.check.ruler.BaseRuler;
import com.daojia.khpt.util.base.util.CollectionUtil;

import java.util.Collection;

import static com.daojia.khpt.util.base.check.CheckResultCodeEnum.*;
import static com.daojia.khpt.util.base.check.CheckResultCodeEnum.COLL_NOT_NULL_FAIL;

/**
 * @author: liurenpeng
 * @date: Created in 2017-11-12
 */
public class CollNotNullRuler extends BaseRuler<Collection> {


    public CollNotNullRuler() {
        init(COLL_NOT_NULL_FAIL.getCode(), COLL_NOT_NULL_FAIL.getDesc());
    }

    public CollNotNullRuler(long failCode, String failDesc) {
        init(failCode, failDesc);
    }

    @Override
    public void check(Collection checkTarget) {
        if (CollectionUtil.isNotNull(checkTarget)) {
            return;
        }
        throw new CheckException(failCode, failDesc);
    }

}
