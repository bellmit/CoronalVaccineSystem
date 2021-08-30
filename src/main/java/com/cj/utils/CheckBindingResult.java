package com.cj.utils;

import com.cj.controller.RootInformationController;
import com.cj.enums.ResultEnums;
import com.cj.exception.GlobalException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.validation.BindingResult;

/**
 * @author 93948
 * @date 2021-07-27 21:02
 * @Email:19927539545@163.com
 * @project: coronalVaccineSystem
 * @descript:
 */
public class CheckBindingResult {
    private static Logger logger = LogManager.getLogger(RootInformationController.class.getName());
    public static void checkBindResult(BindingResult bindingResult){
        if(bindingResult.hasErrors()){
            logger.info(ResultEnums.PARAM_ERROR.getMessage());
            throw new GlobalException(ResultEnums.PARAM_ERROR);
        }
    }
}
