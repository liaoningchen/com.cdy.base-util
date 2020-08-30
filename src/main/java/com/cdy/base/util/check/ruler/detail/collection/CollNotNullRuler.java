package com.cdy.base.util.check.ruler.detail.collection;

import com.cdy.base.util.check.ruler.BaseRuler;
import com.cdy.base.util.exception.CheckException;
import com.cdy.base.util.util.CollectionUtil;
import java.util.Collection;
import static com.cdy.base.util.check.ruler.CheckResultCodeEnum.*;

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
