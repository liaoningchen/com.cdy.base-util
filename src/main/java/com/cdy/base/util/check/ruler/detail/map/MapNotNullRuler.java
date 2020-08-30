package com.cdy.base.util.check.ruler.detail.map;

import com.daojia.khpt.util.base.check.CheckException;
import com.daojia.khpt.util.base.check.ruler.BaseRuler;
import com.daojia.khpt.util.base.util.MapUtil;

import java.util.Map;

import static com.daojia.khpt.util.base.check.CheckResultCodeEnum.*;
import static com.daojia.khpt.util.base.check.CheckResultCodeEnum.MAP_NOT_NULL_FAIL;

/**
 * @author: liurenpeng
 * @date: Created in 2017-11-12
 */
public class MapNotNullRuler extends BaseRuler<Map> {


    public MapNotNullRuler() {
        init(MAP_NOT_NULL_FAIL.getCode(), MAP_NOT_NULL_FAIL.getDesc());
    }

    public MapNotNullRuler(long failCode, String failDesc) {
        init(failCode, failDesc);
    }

    @Override
    public void check(Map checkTarget) {
        if (MapUtil.isNotNull(checkTarget)) {
            return;
        }
        throw new CheckException(failCode, failDesc);
    }

}
