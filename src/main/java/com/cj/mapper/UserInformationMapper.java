package com.cj.mapper;

import com.cj.pojo.UserInformation;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author hcj
 * @since 2021-07-17
 * 1.注册
 * 2.修改
 * 3.查询自己的相关信息
 */
@Mapper
public interface UserInformationMapper extends BaseMapper<UserInformation> {

}
