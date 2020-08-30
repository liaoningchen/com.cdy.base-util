package com.cdy.base.util.check.ruler.detail.map;

import com.daojia.khpt.util.base.check.CheckException;
import com.daojia.khpt.util.base.check.ruler.BaseRuler;
import com.daojia.khpt.util.base.util.MapUtil;

import java.util.Map;

import static com.daojia.khpt.util.base.check.CheckResultCodeEnum.*;
import static com.daojia.khpt.util.base.check.CheckResultCodeEnum.MAP_SIZE_LT_FAIL;

/**
 * @author: liurenpeng
 * @date: Created in 2017-11-12
 */
public class MapSizeLtRuler extends BaseRuler<Map> {

    private int norm;

    public MapSizeLtRuler(int norm) {
        init(norm, MAP_SIZE_LT_FAIL.getCode(), MAP_SIZE_LT_FAIL.getDesc());
    }

    public MapSizeLtRuler(int norm, long failCode, String failDesc) {
        init(norm, failCode, failDesc);
    }

    private void init(int norm, long failCode, String failDesc) {
        this.norm = norm;
        init(failCode, failDesc);
    }

    @Override
    public void check(Map checkTarget) {
        if (null == checkTarget) {
            return;
        }
        if (MapUtil.isSizeLt(checkTarget, norm)) {
            return;
        }
        throw new CheckException(failCode, String.format(failDesc, norm));
    }

}
