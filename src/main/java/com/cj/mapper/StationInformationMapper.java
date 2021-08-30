package com.cj.mapper;

import com.cj.pojo.StationInformation;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author hcj
 * @since 2021-07-17
 * Station能做什么？
 * 操作当前station的修改（修改志愿者数、员工数、疫苗数等等），查询
 */
@Mapper
public interface StationInformationMapper extends BaseMapper<StationInformation> {
}
