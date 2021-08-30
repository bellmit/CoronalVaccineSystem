package com.cj.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.cj.controller.RootInformationController;
import com.cj.enums.ResultEnums;
import com.cj.enums.RolesEnums;
import com.cj.exception.GlobalException;
import com.cj.mapper.StationInformationMapper;
import com.cj.mapper.UserMapper;
import com.cj.pojo.RootInformation;
import com.cj.mapper.RootInformationMapper;
import com.cj.pojo.StationInformation;
import com.cj.pojo.User;
import com.cj.service.RootInformationService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.cj.utils.CheckBindingResult;
import com.cj.utils.CommentResult;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.sql.Date;
import java.util.List;
import java.util.Map;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author hcj
 * @since 2021-07-17
 */
@Service
public class RootInformationServiceImpl extends ServiceImpl<RootInformationMapper, RootInformation> implements RootInformationService {
    @Autowired
    private RootInformationMapper rootInformationMapper;

    @Autowired
    private UserMapper userMapper;

    @Autowired
    private StationInformationMapper stationInformationMapper;

    private static Logger logger = LogManager.getLogger(RootInformationController.class.getName());

    @Override
    @Transactional
    public int addRoot(RootInformation rootTO) {
        QueryWrapper<RootInformation> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("username",rootTO.getUsername());
        RootInformation rootInformation = rootInformationMapper.selectOne(queryWrapper);
        if(rootInformation==null){
            int saveRoot = rootInformationMapper.insert(rootTO);
            //添加root用户时，root用户也是用户啊，所以需要添加进user表中
            User user = new User(0, RolesEnums.ROOTS, rootTO.getUsername(), rootTO.getPassword(), rootTO.getId(), "19927539545", "123456", 0, 0, null,null);
            int insert = userMapper.insert(user);
            if(saveRoot==1&&insert==1){
                logger.info("添加root用户成功");
                return 1;
            }else {
                logger.info("添加root用户失败");
                throw new GlobalException(ResultEnums.ADD_ROOT_EXCEPTION);
            }
        }else {
            logger.error("用户名已存在");
            throw new GlobalException(ResultEnums.USER_EXIST);
        }
    }

    @Override
    @Transactional
    public int updateRoot(RootInformation rootTO) {
        //判断用户名是否已存在
        QueryWrapper<RootInformation> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("username",rootTO.getUsername());
        RootInformation rootInformation = rootInformationMapper.selectOne(queryWrapper);
        if(rootInformation==null) {
            int updateRoot = rootInformationMapper.updateRoot(rootTO);
            QueryWrapper<User> wrapper = new QueryWrapper<>();
            wrapper.eq("role_relatied_id",rootTO.getId());
            int updateUser = userMapper.update(new User(), wrapper);
            if (updateRoot == 1&& updateUser ==1) {
                logger.info("更新Root信息成功");
                return 1;
            } else {
                logger.error("更新Root信息失败");
                throw new GlobalException(ResultEnums.UPDATE_ROOT_EXCEPTION);
            }
        }else {
            logger.error("用户名已存在");
            throw new GlobalException(ResultEnums.USER_EXIST);
        }
    }

    @Override
    @Transactional
    public RootInformation selectRoot(int id) {
        return rootInformationMapper.selectRoot(id);
    }

    @Override
    @Transactional
    public int addStation(StationInformation stationTO) {
        //先判断用户名是否已存在
        QueryWrapper<StationInformation> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("username",stationTO.getUsername());
        List<StationInformation> stationInformations = stationInformationMapper.selectList(queryWrapper);
        if(stationInformations.size()==0) {
            //添加站点，初始化人数的这些值都为0即可
            StationInformation stationInformation = new StationInformation(0, stationTO.getUsername(), stationTO.getPhone(), 0, 0, 0, 0, 0, 0, 0, 0, "", null, null,null,null,null,null);
            int insertStation = stationInformationMapper.insert(stationInformation);
            //站点也是user，同样需要加入user中,初始化密码都是123456,由于id自增，这里直接设置为null即可
            User user = new User(0, RolesEnums.STATION, stationTO.getUsername(), "123456", stationInformation.getId(), "19927539545", "123456", 0, 0, null, null);
            int insertUser = userMapper.insert(user);
            if (insertStation == 1 && insertUser == 1) {
                logger.info("添加Station成功");
                return 1;
            } else {
                logger.error("添加Station失败");
                throw new GlobalException(ResultEnums.ADD_STATION_EXCEPTION);
            }
        }else {
            logger.error("用户名已存在");
            throw  new GlobalException(ResultEnums.USER_EXIST);
        }
    }

    @Override
    @Transactional
    public int updateStation(StationInformation stationTO) {
        //更新站点信息
        QueryWrapper<StationInformation> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("username",stationTO.getUsername());
        if(stationInformationMapper.selectList(queryWrapper).size()==0){
            int updateStation = stationInformationMapper.updateById(stationTO);

            //先根据用户id查询出用户user,而后根据这个用户的相关信息进行后续操作
            QueryWrapper<User> userQueryWrapper = new QueryWrapper<>();
            userQueryWrapper.eq("role_relatied_id",stationTO.getId());
            User selectUser = userMapper.selectOne(userQueryWrapper);
            User user = new User(selectUser.getId(), RolesEnums.STATION, stationTO.getUsername(), selectUser.getPassword(), stationTO.getId(), stationTO.getPhone(), "123456", selectUser.getVersion(), selectUser.getDeleted(), null,null);
            int updateUser = userMapper.updateById(user);
            if(updateUser==1&&updateStation==1){
                logger.info("更新Station信息成功");
                return 1;
            } else {
                logger.error("更新Station信息失败");
                throw new GlobalException(ResultEnums.UPDATE_STATION_EXCEPTION);
            }
        }else {
            logger.error("用户名已存在");
            throw new GlobalException(ResultEnums.USER_EXIST);
        }
    }

    @Override
    @Transactional
    public StationInformation selectStation(int id) {
        if(rootInformationMapper.selectStation(id)==null){
            throw new GlobalException(ResultEnums.NO_SUCH_STATION);
        }
        return rootInformationMapper.selectStation(id);
    }

    @Override
    @Transactional
    public IPage<StationInformation> selectStationList() {
        //加上分页操作
        IPage<StationInformation> page = new Page<>(1, 5);
        return stationInformationMapper.selectPage(page,new QueryWrapper<StationInformation>());
    }

    @Override
    @Transactional
    public int deleteStation(int id) {
        int deleteStation = rootInformationMapper.deleteStation(id);
        QueryWrapper<User> queryWrapper = new QueryWrapper<>();
        //这里同时要删除user里的相关信息，当然这里是逻辑删除
        queryWrapper.eq("role_relatied_id",id);
        int deleteUser=userMapper.delete(queryWrapper);
        if(deleteStation==1&&deleteUser==1){
            logger.info("删除Station成功");
        } else {
            logger.error("删除Station失败");
            throw new GlobalException(ResultEnums.DELETE_STATION_EXCEPTION);
        }
        return rootInformationMapper.deleteStation(id);
    }
}
