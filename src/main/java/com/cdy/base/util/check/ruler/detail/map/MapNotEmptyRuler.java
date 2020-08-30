package com.cdy.base.util.check.ruler.detail.map;

import com.daojia.khpt.util.base.check.CheckException;
import com.daojia.khpt.util.base.check.ruler.BaseRuler;
import com.daojia.khpt.util.base.util.MapUtil;

import java.util.Map;

import static com.daojia.khpt.util.base.check.CheckResultCodeEnum.*;
import static com.daojia.khpt.util.base.check.CheckResultCodeEnum.MAP_NOT_EMPTY_FAIL;

/**
 * @author: liurenpeng
 * @date: Created in 2017-11-12
 */
public class MapNotEmptyRuler extends BaseRuler<Map> {


    public MapNotEmptyRuler() {
        init(MAP_NOT_EMPTY_FAIL.getCode(), MAP_NOT_EMPTY_FAIL.getDesc());
    }

    public MapNotEmptyRuler(long failCode, String failDesc) {
        init(failCode, failDesc);
    }

    @Override
    public void check(Map checkTarget) {
        if (null == checkTarget) {
            return;
        }
        if (MapUtil.isNotEmpty(checkTarget)) {
            return;
        }
        throw new CheckException(failCode, failDesc);
    }

}
