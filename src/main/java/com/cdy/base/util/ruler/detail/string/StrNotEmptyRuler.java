package com.cdy.base.util.ruler.detail.string;

import com.cdy.base.util.exception.CheckException;
import com.cdy.base.util.exception.enums.ErrorCodeEnum;
import com.cdy.base.util.ruler.BaseRuler;
import org.apache.commons.lang3.StringUtils;

public class StrNotEmptyRuler extends BaseRuler<String> {
    public StrNotEmptyRuler() {
        this.init(ErrorCodeEnum.STR_NOT_EMPTY_FAIL.getCode(), ErrorCodeEnum.STR_NOT_EMPTY_FAIL.getDesc());
    }
    public StrNotEmptyRuler(int code,String desc) {
        this.init(code, desc);
    }
    public void check(String target) {
        if(target !=null){
            if(StringUtils.isEmpty(target)){
                throw new CheckException(this.errorCode,this.errorDesc);
            }
        }
    }
}
