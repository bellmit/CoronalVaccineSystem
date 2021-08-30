package com.cj.enums;

/**
 * @author 93948
 * @date 2021-07-17 23:42
 * @Email:19927539545@163.com
 * @project: coronalVaccineSystem
 * @descript:用户疫苗状态枚举
 */
public enum UserStatusEnum {
    First("first"),//第一针
    Second("second");
    private String status;
    UserStatusEnum(String status){
        this.status=status;
    }
}
