package com.cj.service;

import com.cj.pojo.User;
import com.baomidou.mybatisplus.extension.service.IService;
import com.cj.pojo.UserInformation;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author hcj
 * @since 2021-07-17
 * 1.注册
 * 2.登录统一到Home里面，这里不做登录操作
 * 3.查询自己的相关信息（疫苗接种情况、核酸检测情况等）
 * 4.预约打疫苗、测核酸
 */
public interface UserService extends IService<User> {
    int userRegister(User userTO);
    UserInformation selectUser();
    int appointVaccine(int stationId);
    int appointNucleic(int stationId);
    int updateUser(User user);
}
