package com.cdy.base.util.ruler.base;

import com.cdy.base.util.ruler.Ruler;
import com.cdy.base.util.ruler.detail.string.StrNotEmptyRuler;

public class StrRuler{
    private StrRuler(){

    }
    public static Ruler<String>  notEmpty(){
        return new StrNotEmptyRuler();
    }
}
