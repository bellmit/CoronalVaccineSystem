package com.cj.annoations;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @author 93948
 * @date 2021-07-27 20:27
 * @Email:19927539545@163.com
 * @project: coronalVaccineSystem
 * @descript:
 */

@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
public @interface MyPasswordRule {

}
