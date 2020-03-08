package com.cdy.base.util.bean

-util.bean;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class RespBean {
    private Integer code;
    private String msg;
    private Object data;

    public static RespBean success(int code,String msg,Object data){
        return new RespBean(code,msg,data);
    };
    public static RespBean success(Object data){
        return success(com.cdy.base.util.bean.ResultEnum.SUCCESS.getCode(), com.cdy.base.util.bean.ResultEnum.SUCCESS.getDesc(),data);
    };

    public static RespBean error(int code,String msg,Object data){
        return new RespBean(code,msg,data);
    };
    public static RespBean error(Object data){
        return error(com.cdy.base.util.bean.ResultEnum.ERROR.getCode(), com.cdy.base.util.bean.ResultEnum.ERROR.getDesc(),data);
    };

}
