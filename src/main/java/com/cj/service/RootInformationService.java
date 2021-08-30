package com.cj.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.cj.enums.RolesEnums;
import com.cj.pojo.RootInformation;
import com.baomidou.mybatisplus.extension.service.IService;
import com.cj.pojo.StationInformation;
import org.apache.shiro.authz.annotation.RequiresRoles;

import java.util.List;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author hcj
 * @since 2021-07-17
 */
public interface RootInformationService extends IService<RootInformation> {
    /*
    对root用户的操作
     */
    int addRoot(RootInformation rootTO);
    int updateRoot(RootInformation rootTO);
    RootInformation selectRoot(int id);

    /**
     对医院站点的增删改查安排
     */
    int addStation(StationInformation stationTO);
    int updateStation(StationInformation stationTO);
    StationInformation selectStation(int id);
    IPage<StationInformation> selectStationList();
    int deleteStation(int id);
}
