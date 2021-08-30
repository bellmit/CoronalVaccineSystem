package com.cj.controller;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.baomidou.mybatisplus.extension.api.R;
import com.cj.enums.ResultEnums;
import com.cj.enums.RolesEnums;
import com.cj.exception.GlobalException;
import com.cj.mapper.UserMapper;
import com.cj.pojo.RootInformation;
import com.cj.pojo.StationInformation;
import com.cj.pojo.User;
import com.cj.service.RootInformationService;
import com.cj.service.StationInformationService;
import com.cj.service.UserService;
import com.cj.utils.CheckBindingResult;
import com.cj.utils.CommentResult;
import com.cj.utils.CommentResultUtil;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authz.annotation.RequiresRoles;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.sql.Date;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Map;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author hcj
 * @since 2021-07-17
 * @descript:
 * root控制器的职责：
 * 1.添加root用户、root用户修改自己的相关信息
 * 2.对医院站点的增删改查操作
 * 3.注意异常处理等规范问题
 */
@RestController
@RequestMapping("/root-information")
//@RequiresRoles(RolesEnums.ROOTS)
public class RootInformationController {
    private static Logger logger = LogManager.getLogger(RootInformationController.class.getName());
    @Autowired
    private RootInformationService rootInformationService;//root用户服务

    @Autowired
    private StationInformationService stationInformationService;//站点服务

    @Autowired
    private UserService userService;

    public User getCurrentUser(){
        return (User) SecurityUtils.getSubject().getPrincipal();
    }
    /**
     * @Valid递归校验，会对对象的元素，数组的元素进行一一校验
     * @descript:添加root用户，这个控制器只在最初有用，后续应将其关闭，不可随意操作
     * @param rootTO
     * @param bindingResult
     * @return
     */
    @PostMapping(value = "/addRoot")
    public CommentResult addRoot(@Validated @RequestBody RootInformation rootTO, BindingResult bindingResult){
        CheckBindingResult.checkBindResult(bindingResult);//参数校验
        return CommentResultUtil.success(rootInformationService.addRoot(rootTO));
    }

    /**
     * root用户更新操作，更改密码或用户名
     * @param rootTO
     * @param bindingResult
     * @return
     */
    @PostMapping(value = "/updateRoot")
    public CommentResult updateRoot(@Validated @RequestBody RootInformation rootTO, BindingResult bindingResult){
        CheckBindingResult.checkBindResult(bindingResult);//参数校验
        return CommentResultUtil.success(rootInformationService.updateRoot(rootTO));
    }

    /**
     * 当前root用户的信息
     * @return
     */
    @GetMapping(value = "/selectRoot")
    @Transactional
    public CommentResult selectRoot(){
        logger.info("当前root的信息为：");
        return CommentResultUtil.success("username:"+getCurrentUser().getUsername()+'\n'+"password:"+getCurrentUser().getPassword());
    }

    /**
     * 添加医院站点信息
     * @param stationTO
     * @param bindingResult
     * @return
     */
    @PostMapping(value = "/addStation")
    @Transactional
    public CommentResult addStation(@RequestBody @Valid StationInformation stationTO,BindingResult bindingResult){
        CheckBindingResult.checkBindResult(bindingResult);
        return CommentResultUtil.success(rootInformationService.addStation(stationTO));
    }

    /**
     * 更新医院站点的信息
     * @param stationTO
     * @param bindingResult
     * @return
     */
    @PostMapping(value = "/updateStation")
    @Transactional
    public CommentResult updateStation(@RequestBody @Valid StationInformation stationTO,BindingResult bindingResult){
        CheckBindingResult.checkBindResult(bindingResult);
        return CommentResultUtil.success(rootInformationService.updateStation(stationTO));
    }

    /**
     * 查询某个站点的信息
     * @param id
     * @return
     */
    @GetMapping(value = "/selectStation")
    @Transactional
    public CommentResult selectStation(int id){
        return CommentResultUtil.success(rootInformationService.selectStation(id));
    }

    /**
     * 查询全部医院站点的信息
     * @return
     */
    @GetMapping(value = "/selectStationList")
    @Transactional
    public CommentResult selectStationList(){
        return CommentResultUtil.success(rootInformationService.selectStationList());
    }

    /**
     * 删除Station
     * @param id
     * @return
     */
    @GetMapping(value = "/deleteStation")
    @Transactional
    public CommentResult deleteStation(int id){
        return CommentResultUtil.success(rootInformationService.deleteStation(id));
    }
}

