package com.cj.exception;

import com.cj.enums.ResultEnums;

/**
 * @author 93948
 * @date 2021-07-18 0:05
 * @Email:19927539545@163.com
 * @project: coronalVaccineSystem
 * @descript:全局性异常
 */
public class GlobalException extends RuntimeException{
    private Integer code;//异常状态码
    private String message;//异常打印信息

    public GlobalException(Integer code,String message){
        super(message);
        this.code=code;
    }

    public GlobalException(ResultEnums resultEnums){
        super(resultEnums.getMessage());
        this.code=resultEnums.getCode();
    }

}
