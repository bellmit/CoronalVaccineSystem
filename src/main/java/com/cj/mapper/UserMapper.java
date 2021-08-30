package com.cj.mapper;

import com.cj.pojo.User;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author hcj
 * @since 2021-07-17
 */
@Mapper
public interface UserMapper extends BaseMapper<User> {

}
