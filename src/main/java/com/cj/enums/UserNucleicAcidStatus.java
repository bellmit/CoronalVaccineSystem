package com.cj.enums;

/**
 * @author 93948
 * @date 2021-07-18 14:49
 * @Email:19927539545@163.com
 * @project: coronalVaccineSystem
 * @descript:用户核酸检测情况
 */
public enum UserNucleicAcidStatus {
    Not_Detected("NotDetected"),//未检测
    Negative("Negative"),//阴性
    Positive("positive");//阳性

    String status;//核酸检测状态
    UserNucleicAcidStatus(String status){
        this.status=status;
    }

}
