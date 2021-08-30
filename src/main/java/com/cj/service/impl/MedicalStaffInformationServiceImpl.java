package com.cj.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.cj.enums.ResultEnums;
import com.cj.enums.RolesEnums;
import com.cj.exception.GlobalException;
import com.cj.pojo.MedicalStaffInformation;
import com.cj.mapper.MedicalStaffInformationMapper;
import com.cj.pojo.StationInformation;
import com.cj.pojo.User;
import com.cj.pojo.UserInformation;
import com.cj.service.MedicalStaffInformationService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.cj.utils.GetCurrentUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author hcj
 * @since 2021-07-17
 */
@Service
public class MedicalStaffInformationServiceImpl extends ServiceImpl<MedicalStaffInformationMapper, MedicalStaffInformation> implements MedicalStaffInformationService {

    @Autowired
    private MedicalStaffInformationMapper medicalStaffInformationMapper;
    @Override
    public MedicalStaffInformation selectMedicalStaff() {
        User currentUser = new GetCurrentUser().getCurrentUser();
        MedicalStaffInformation medicalStaffInformation = medicalStaffInformationMapper.selectById(currentUser.getRoleRelatiedId());
        return medicalStaffInformation;
    }

    @Override
    public int updateMedicalStaff(MedicalStaffInformation medicalStaffInformation) {
        QueryWrapper<MedicalStaffInformation> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("username",medicalStaffInformation.getUsername());
        if(medicalStaffInformationMapper.selectOne(queryWrapper)!=null){
            int updateMedical = medicalStaffInformationMapper.updateById(medicalStaffInformation);

            //先根据用户id查询出医护人员,而后根据这个用户的相关信息进行后续操作
            QueryWrapper<MedicalStaffInformation> medicalStaffInformationQueryWrapper = new QueryWrapper<>();
            medicalStaffInformationQueryWrapper.eq("role_relatied_id",medicalStaffInformation.getId());
            MedicalStaffInformation selectMedicalStaffInformation = medicalStaffInformationMapper.selectOne(medicalStaffInformationQueryWrapper);
            int updateUser = medicalStaffInformationMapper.updateById(medicalStaffInformation);
            if(updateUser==1&&updateMedical==1){
                return 1;
            } else {
                throw new GlobalException(ResultEnums.UPDATE_STATION_EXCEPTION);
            }
        }else {
            throw new GlobalException(ResultEnums.USER_EXIST);
        }
    }

}
