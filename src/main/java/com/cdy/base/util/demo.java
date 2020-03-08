package com.cdy.base.util;

import com.cdy.base.util.check.CheckUtil;
import com.cdy.base.util.ruler.base.StrRuler;

public class demo {
    public static void main(String[] args) {
        CheckUtil.check("","字符串",StrRuler.notEmpty());
    }
}
