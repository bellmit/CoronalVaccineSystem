package com.cj.mapper;

import com.baomidou.mybatisplus.extension.api.R;
import com.cj.pojo.RootInformation;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.cj.pojo.StationInformation;
import org.apache.ibatis.annotations.Mapper;
import org.w3c.dom.stylesheets.LinkStyle;

import java.util.List;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author hcj
 * @since 2021-07-17
 * @descript:此Mapper应当包含：
 * 1.对于root用户：增、改、查自己的相关信息，不提供查询别的root用户信息以及删除root的接口
 * 2.对于医院站点的增删改查操作
 */
@Mapper
public interface RootInformationMapper extends BaseMapper<RootInformation> {
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
    List<StationInformation> selectStationList();
    int deleteStation(int id);
}
