package com.cj.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.cj.enums.ResultEnums;
import com.cj.exception.GlobalException;
import com.cj.pojo.StationInformation;
import com.cj.mapper.StationInformationMapper;
import com.cj.pojo.User;
import com.cj.service.StationInformationService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.apache.shiro.SecurityUtils;
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
public class StationInformationServiceImpl extends ServiceImpl<StationInformationMapper, StationInformation> implements StationInformationService {
    public User getCurrentUser(){
        return (User) SecurityUtils.getSubject().getPrincipal();
    }

    @Autowired
    private StationInformationMapper stationInformationMapper;

    @Override
    @Transactional
    public int updateStation(StationInformation stationTO) {
        if(stationInformationMapper.updateById(stationTO)==1){
            return 1;
        }else {
            throw new GlobalException(ResultEnums.UPDATE_STATION_EXCEPTION);
        }
    }

    @Override
    @Transactional
    public StationInformation selectStation() {
        //这里就体现出role_relatied_id的作用了
        if(stationInformationMapper.selectById(getCurrentUser().getRoleRelatiedId())==null){
            throw new GlobalException(ResultEnums.NO_SUCH_STATION);
        }else {
            return stationInformationMapper.selectById(getCurrentUser().getRoleRelatiedId());
        }
    }
}
