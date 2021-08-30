package com.cj.enums;

/**
 * @author 93948
 * @date 2021-07-18 15:07
 * @Email:19927539545@163.com
 * @project: coronalVaccineSystem
 * @descript:返回结果
 */
public enum ResultEnums {
    SUCCESS(0,"success"),

    FALSE(1,"false"),

    PARAM_ERROR(100,"参数错误"),
    //待补充

    USER_NOT_EXIST(200,"用户不存在"),
    USER_CHECK_ERROR(201,"用户参数检查异常"),
    CHECK_ULTRA_VIRES(202,"未知错误"),
    UNLOGIN(203,"未授权"),
    USER_EXIST(204,"用户已存在"),
    ADD_ROOT_EXCEPTION(205,"添加Root用户失败"),
    UPDATE_ROOT_EXCEPTION(206,"更新ROOT用户失败"),
    DELETE_ROOT_EXCEPTION(207,"删除ROOT用户失败"),
    ADD_STATION_EXCEPTION(208,"添加Station失败"),
    UPDATE_STATION_EXCEPTION(209,"更新Station失败"),
    DELETE_STATION_EXCEPTION(210,"删除Station失败"),
    NO_SUCH_STATION(210,"查询站点失败"),

    USER_REGISTER_FAILED(211,"用户注册失败"),
    APPOINT_VACCINE_FAILED(212,"预约疫苗失败"),

    UPDATE_MEDICAL_EXCEPTION(209,"更新Station失败"),
    DELETE_MEDICAL_EXCEPTION(210,"删除Station失败"),

    REPETED_APPOINT(213,"请勿重复预约");
    private Integer code;
    private String message;

     ResultEnums(Integer code, String message){
        this.code=code;
        this.message=message;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
