package com.cj.controller;


import com.cj.enums.RolesEnums;
import com.cj.pojo.MedicalStaffInformation;
import com.cj.service.MedicalStaffInformationService;
import com.cj.utils.CheckBindingResult;
import com.cj.utils.CommentResult;
import com.cj.utils.CommentResultUtil;
import org.apache.shiro.authz.annotation.RequiresRoles;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author hcj
 * @since 2021-07-17
 */
@RestController
@RequestMapping("/medical-staff-information")
@RequiresRoles(RolesEnums.MedicalStaff)
public class MedicalStaffInformationController {
    @Autowired
    private MedicalStaffInformationService medicalStaffInformationService;

    @PostMapping(value = "/updateMedical")
    public CommentResult updateMedical(@Valid @RequestBody MedicalStaffInformation medicalStaffInformation, BindingResult bindingResult){
        CheckBindingResult.checkBindResult(bindingResult);
        return CommentResultUtil.success(medicalStaffInformationService.updateMedicalStaff(medicalStaffInformation));
    }

    @GetMapping(value = "/getMedical")
    public CommentResult getMedical(){
        return CommentResultUtil.success(medicalStaffInformationService.selectMedicalStaff());
    }
}

