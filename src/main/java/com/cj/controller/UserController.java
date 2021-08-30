package com.cj.controller;


import com.cj.pojo.User;
import com.cj.service.impl.UserServiceImpl;
import com.cj.utils.CheckBindingResult;
import com.cj.utils.CommentResult;
import com.cj.utils.CommentResultUtil;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author hcj
 * @since 2021-07-17
 */
@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserServiceImpl userService;

    @PostMapping(value = "/userRegist")
    public CommentResult userRegist(@Valid @RequestBody User user, BindingResult bindingResult){
        CheckBindingResult.checkBindResult(bindingResult);
        return CommentResultUtil.success(userService.userRegister(user));
    }
    @GetMapping(value = "/selectUser")
    public CommentResult selectUser(){
        return CommentResultUtil.success(userService.selectUser());
    }

    @GetMapping(value = "/appointVaccine")
    public CommentResult appointVaccine(@Param("id") int id){
        return CommentResultUtil.success(userService.appointVaccine(id));
    }

    @GetMapping(value = "/appointNucleic")
    public CommentResult appointNucleic(@Param("id") int id){
        return CommentResultUtil.success(userService.appointNucleic(id));
    }
}

