package com.cdy.base.util.check.ruler.detail.map;

import com.daojia.khpt.util.base.check.CheckException;
import com.daojia.khpt.util.base.check.ruler.BaseRuler;
import com.daojia.khpt.util.base.util.MapUtil;

import java.util.Map;

import static com.daojia.khpt.util.base.check.CheckResultCodeEnum.*;
import static com.daojia.khpt.util.base.check.CheckResultCodeEnum.MAP_KEY_NOT_CONTAINS_FAIL;

/**
 * @author: liurenpeng
 * @date: Created in 2017-11-12
 */
public class MapKeyNotContainsRuler extends BaseRuler<Map> {

    private Object norm;

    public MapKeyNotContainsRuler(Object norm) {
        init(norm, MAP_KEY_NOT_CONTAINS_FAIL.getCode(), MAP_KEY_NOT_CONTAINS_FAIL.getDesc());
    }

    public MapKeyNotContainsRuler(Object norm, long failCode, String failDesc) {
        init(norm, failCode, failDesc);
    }

    private void init(Object norm, long failCode, String failDesc) {
        this.norm = norm;
        init(failCode, failDesc);
    }

    @Override
    public void check(Map checkTarget) {
        if (null == checkTarget) {
            return;
        }
        if (MapUtil.isKeyNotContains(checkTarget, norm)) {
            return;
        }
        throw new CheckException(failCode, String.format(failDesc, norm));
    }

}
