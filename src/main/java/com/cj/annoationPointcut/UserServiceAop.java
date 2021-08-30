package com.cj.annoationPointcut;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

/**
 * @author 93948
 * @date 2021-07-27 20:18
 * @Email:19927539545@163.com
 * @project: coronalVaccineSystem
 * @descript:预约人员调用controller时，打印日志
 */
@Aspect
@Component
public class UserServiceAop {
    private static Logger logger = LogManager.getLogger(UserServiceAop.class.getName());
    @Pointcut("execution(* com.cj.service.impl.UserServiceImpl.*(..))")//定义一个切面
    public void LogAspect(){}

    @Before("LogAspect()")
    public void before(){
        logger.info("**********hcj调用了userService**********");
    }

    @After("LogAspect()")
    public void after(){
        logger.info("**********hcj结束调用userService**********");
    }
}