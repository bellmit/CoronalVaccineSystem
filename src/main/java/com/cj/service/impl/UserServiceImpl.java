package com.cj.service.impl;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.cj.controller.RootInformationController;
import com.cj.enums.ResultEnums;
import com.cj.exception.GlobalException;
import com.cj.mapper.StationInformationMapper;
import com.cj.mapper.UserInformationMapper;
import com.cj.pojo.StationInformation;
import com.cj.pojo.User;
import com.cj.mapper.UserMapper;
import com.cj.pojo.UserInformation;
import com.cj.service.UserService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.cj.utils.CheckBindingResult;
import com.cj.utils.GetCurrentUser;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestBody;

import javax.validation.Valid;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author hcj
 * @since 2021-07-17
 *  * 1.注册
 *  * 2.登录统一到Home里面，这里不做登录操作
 *  * 3.查询自己的相关信息（疫苗接种情况、核酸检测情况等）
 *  * 4.预约打疫苗、测核酸
 *  * 5.修改个人信息
 */
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements UserService {
    private static Logger logger = LogManager.getLogger(UserServiceImpl.class.getName());
    @Autowired
    private UserMapper userMapper;

    @Autowired
    private UserInformationMapper userInformationMapper;

    @Autowired
    private StationInformationMapper stationInformationMapper;
    @Override
    @Transactional
    public int userRegister(User userTO) {
        userTO.setDeleted(0);
        userTO.setVersion(0);//乐观锁和逻辑删除字段设置为0
        userTO.setRoleRelatiedId(0);
        if(userMapper.selectById(userTO.getRoleRelatiedId())!=null){
            throw new GlobalException(ResultEnums.USER_EXIST);
        }
        int insertUser = userMapper.insert(userTO);
        if(insertUser==1){
            UserInformation userInformation = new UserInformation(0, userTO.getUsername(), userTO.getPassword(), userTO.getPhone(), "未接种", "阴性",null,0,null, null, null);
            int insertUserInformation = userInformationMapper.insert(userInformation);
            if(insertUserInformation==1){//这一步是为了关联role_realtied_id
                UpdateWrapper<User> updateWrapper = new UpdateWrapper<>();
                updateWrapper.eq("id",userTO.getId())
                .set("role_relatied_id",userInformation.getId());
                userMapper.update(userTO,updateWrapper);
            }
            logger.info("用户注册成功");
            return 1;
        }else {
            throw new GlobalException(ResultEnums.USER_REGISTER_FAILED);
        }
    }

    @Override
    @Transactional
    public UserInformation selectUser() {
        User user = new GetCurrentUser().getCurrentUser();
        QueryWrapper<UserInformation> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("id",user.getRoleRelatiedId());
        UserInformation userInformation = userInformationMapper.selectOne(queryWrapper);
        return userInformation;
    }

    @Override
    @Transactional
    public int appointVaccine(int stationId) {
        //获得当前登录用户
        User user = new GetCurrentUser().getCurrentUser();
        //找到对应的UserInformation
        QueryWrapper<UserInformation> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("id",user.getRoleRelatiedId());
        UserInformation userTO = userInformationMapper.selectOne(queryWrapper);

        //看看他是否预约过了，如果是，那么不能再预约
        if(userTO.getVaccinationAppointed()==1){
            throw new GlobalException(ResultEnums.REPETED_APPOINT);
        }

        //通过选取stationId来选择user对应的station
        StationInformation stationInformation = stationInformationMapper.selectById(stationId);
        if(stationInformation.getVaccinationNums()>0){//先判断疫苗是否还有剩余，没有的话就无法预约了
            synchronized (this){
                UpdateWrapper<StationInformation> updateWrapper = new UpdateWrapper<>();
                updateWrapper.eq("id",stationInformation.getId())
                        .set("vaccination_nums",stationInformation.getVaccinationNums()-1)//剩余疫苗数-1
                        .set("vaccination_appoint_nums",stationInformation.getVaccinationAppointNums()+1)//疫苗已预约数加1
                        .set("user_list",stationInformation.getUserList()+","+user.getRoleRelatiedId());
                stationInformationMapper.update(new StationInformation(),updateWrapper);//更新
            }


            //更新预约情况
            UserInformation userInformation = new UserInformation(user.getRoleRelatiedId(), userTO.getUsername(), userTO.getPassword(), userTO.getPhone(), userTO.getVaccinationStatus(), userTO.getNucleicAcidDetection(),stationId+"", 1, 0,null,null);
            if(userInformationMapper.updateById(userInformation)==1){
                logger.info("疫苗预约成功");
                return 1;
            }else {
                throw new GlobalException(ResultEnums.APPOINT_VACCINE_FAILED);
            }
        }
        else {
            throw new GlobalException(ResultEnums.APPOINT_VACCINE_FAILED);
        }
    }


    @Override
    @Transactional
    public int appointNucleic(int stationId) {
        //获得当前登录用户
        User user = new GetCurrentUser().getCurrentUser();
        //找到对应的UserInformation
        QueryWrapper<UserInformation> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("id",user.getRoleRelatiedId());
        UserInformation userTO = userInformationMapper.selectOne(queryWrapper);

        //看看他是否预约过了，如果是，那么不能再预约
        if(userTO.getNucleicAcidAppointed()==1){
            throw new GlobalException(ResultEnums.REPETED_APPOINT);
        }

        //通过选取stationId来选择user对应的station
        StationInformation stationInformation = stationInformationMapper.selectById(stationId);
        if(stationInformation.getNucleicAppointNums()>0){//先判断核酸是否还有剩余，没有的话就无法预约了
            synchronized (this){
                UpdateWrapper<StationInformation> updateWrapper = new UpdateWrapper<>();
                updateWrapper.eq("id",stationInformation.getId())
                        .set("nucleic_acid_nums",stationInformation.getNucleicAcidNums()-1)//剩余核酸数-1
                        .set("nucleic_appoint_nums",stationInformation.getNucleicAppointNums()+1)//疫苗已预约数加1
                        .set("user_nucleic_list",stationInformation.getUser_nucleic_list()+","+user.getRoleRelatiedId());
                stationInformationMapper.update(new StationInformation(),updateWrapper);//更新
            }

            //更新预约情况
            UserInformation userInformation = new UserInformation(user.getRoleRelatiedId(), userTO.getUsername(), userTO.getPassword(), userTO.getPhone(), userTO.getVaccinationStatus(), userTO.getNucleicAcidDetection(),stationId+"", userTO.getVaccinationAppointed(), 1,null,null);
            if(userInformationMapper.updateById(userInformation)==1){
                logger.info("核酸预约成功");
                return 1;
            }else {
                throw new GlobalException(ResultEnums.APPOINT_VACCINE_FAILED);
            }
        }
        else {
            throw new GlobalException(ResultEnums.APPOINT_VACCINE_FAILED);
        }

    }

    @Override
    public int updateUser(User user) {
        return 0;
    }
}
