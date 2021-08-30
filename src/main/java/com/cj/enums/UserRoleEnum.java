package com.cj.enums;

/**
 * @author 93948
 * @date 2021-05-17 22:50
 * @Email:19927539545@163.com
 * @project: coronalVaccineSystem
 * @descript:用户角色枚举
 */
public enum UserRoleEnum {
    User(1,"user"),
    Volunteer(2,"volunteer"),
    Station(3,"station"),
    MedicalStaff(4,"medical_staff"),
    Root(5,"root"),
    Transporter(6,"transporter");

    private Integer code;
    private String role;
    UserRoleEnum(Integer code,String role){
        this.code=code;
        this.role=role;
    }

    public Integer getCode() {
        return code;
    }

    public String getRole() {
        return role;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public void setRole(String role) {
        this.role = role;
    }


    /**
     * 通过code获取对应角色
     * @param code
     * @return
     */
    public static String getRoleByCode(Integer code){
        for(UserRoleEnum userRoleEnum:UserRoleEnum.values()){
            //遍历enum的值
            if(userRoleEnum.getCode()==code){
                return userRoleEnum.getRole();
            }
        }
        return null;//不存在此code对应的enum
    }


    /**
     * 判断有无此角色
     * @param role
     * @return
     */
    public static boolean isRole(String role){
        for(UserRoleEnum userRoleEnum:UserRoleEnum.values()){
            if(userRoleEnum.getRole().equals(role)){
                return true;
            }
        }
        return false;
    }


}
