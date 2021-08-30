package com.cj.service.impl;

import com.cj.pojo.UserInformation;
import com.cj.mapper.UserInformationMapper;
import com.cj.service.UserInformationService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author hcj
 * @since 2021-07-17
 */
@Service
public class UserInformationServiceImpl extends ServiceImpl<UserInformationMapper, UserInformation> implements UserInformationService {

}
