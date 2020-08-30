package com.cdy.base.util.check.ruler.detail.map;

import com.daojia.khpt.util.base.check.CheckException;
import com.daojia.khpt.util.base.check.ruler.BaseRuler;
import com.daojia.khpt.util.base.util.MapUtil;

import java.util.Map;

import static com.daojia.khpt.util.base.check.CheckResultCodeEnum.*;
import static com.daojia.khpt.util.base.check.CheckResultCodeEnum.MAP_VALUE_NOT_CONTAINS_FAIL;

/**
 * @author: liurenpeng
 * @date: Created in 2017-11-12
 */
public class MapValueNotContainsRuler extends BaseRuler<Map> {

    private Object norm;

    public MapValueNotContainsRuler(Object norm) {
        init(norm, MAP_VALUE_NOT_CONTAINS_FAIL.getCode(), MAP_VALUE_NOT_CONTAINS_FAIL.getDesc());
    }

    public MapValueNotContainsRuler(Object norm, long failCode, String failDesc) {
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
        if (MapUtil.isValueNotContains(checkTarget, norm)) {
            return;
        }
        throw new CheckException(failCode, String.format(failDesc, norm));
    }

}
