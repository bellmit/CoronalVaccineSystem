package com.cj.service;

import com.cj.pojo.MedicalStaffInformation;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author hcj
 * @since 2021-07-17
 * 1.查看个人信息(主要是所属站点）
 * 2.修改个人信息
 */
public interface MedicalStaffInformationService extends IService<MedicalStaffInformation> {
    MedicalStaffInformation selectMedicalStaff();
    int updateMedicalStaff(MedicalStaffInformation medicalStaffInformation);
}
