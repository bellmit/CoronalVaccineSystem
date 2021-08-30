package com.cj.utils;

import com.cj.pojo.User;
import org.apache.shiro.SecurityUtils;

/**
 * @author 93948
 * @date 2021-07-28 11:42
 * @Email:19927539545@163.com
 * @project: coronalVaccineSystem
 * @descript:获得当前的登录对象
 */
public class GetCurrentUser {
    public User getCurrentUser(){
        return (User) SecurityUtils.getSubject().getPrincipal();
    }
}
