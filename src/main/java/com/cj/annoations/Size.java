package com.cj.annoations;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.*;

/**
 * @author 93948
 * @date 2021-07-28 9:05
 * @Email:19927539545@163.com
 * @project: coronalVaccineSystem
 * @descript:
 */
@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
public @interface Size {

    int minLength() default 0;
    int maxLength() default 0;
    Class type() default String.class;
    boolean empty() default true;
}