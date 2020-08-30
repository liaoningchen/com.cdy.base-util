package com.cdy.base.util.check.ruler.detail.map;

import com.daojia.khpt.util.base.check.CheckException;
import com.daojia.khpt.util.base.check.ruler.BaseRuler;
import com.daojia.khpt.util.base.util.MapUtil;

import java.util.Map;

import static com.daojia.khpt.util.base.check.CheckResultCodeEnum.*;
import static com.daojia.khpt.util.base.check.CheckResultCodeEnum.MAP_KEY_NOT_CONTAINS_NULL_FAIL;

/**
 * @author: liurenpeng
 * @date: Created in 2017-11-12
 */
public class MapKeyNotContainsNullRuler extends BaseRuler<Map> {


    public MapKeyNotContainsNullRuler() {
        init(MAP_KEY_NOT_CONTAINS_NULL_FAIL.getCode(), MAP_KEY_NOT_CONTAINS_NULL_FAIL.getDesc());
    }

    public MapKeyNotContainsNullRuler(long failCode, String failDesc) {
        init(failCode, failDesc);
    }

    @Override
    public void check(Map checkTarget) {
        if (null == checkTarget) {
            return;
        }
        if (MapUtil.isKeyNotContainsNull(checkTarget)) {
            return;
        }
        throw new CheckException(failCode, failDesc);
    }

}
