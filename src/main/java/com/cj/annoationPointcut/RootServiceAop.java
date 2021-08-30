package com.cj.annoationPointcut;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

/**
 * @author 93948
 * @date 2021-07-27 16:01
 * @Email:19927539545@163.com
 * @project: coronalVaccineSystem
 * @descript:root添加用户等操作时，打印日志
 */
@Aspect
@Component
public class RootServiceAop {
    private static Logger logger = LogManager.getLogger(RootServiceAop.class.getName());
    @Pointcut("execution(* com.cj.service.impl.RootInformationServiceImpl.*(..))")//定义一个切面
    public void LogAspect(){}

    @Before("LogAspect()")
    public void before(){
        logger.info("**********hcj调用了rootService**********");
    }

    @After("LogAspect()")
    public void after(){
        logger.info("**********hcj结束调用rootService**********");
    }
}
