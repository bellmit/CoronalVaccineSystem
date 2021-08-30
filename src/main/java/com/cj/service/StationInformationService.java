package com.cj.service;

import com.cj.pojo.StationInformation;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author hcj
 * @since 2021-07-17
 */
public interface StationInformationService extends IService<StationInformation> {
    int updateStation(StationInformation stationInformation);
    StationInformation selectStation();//查询当前station的相关信息
}
