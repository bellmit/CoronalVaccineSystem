package com.cj.controller;

import com.cj.enums.ResultEnums;
import com.cj.exception.GlobalException;
import com.cj.pojo.User;
import com.cj.utils.CommentResult;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.web.bind.annotation.*;

/**
 * @author 93948
 * @date 2021-07-28 13:58
 * @Email:19927539545@163.com
 * @project: coronalVaccineSystem
 * @descript:用户登录退出行为控制器
 */
@RestController
@RequestMapping("/home")
public class HomeController {
    /**
     * 用户登录
     * @param user
     * @return
     */
    @PostMapping("/login")
    public CommentResult login(@RequestBody User user) {//接收前端过来的数据
        Subject subject = SecurityUtils.getSubject();
        //获取用户的登录数据
        if (!subject.isAuthenticated()) {
            UsernamePasswordToken token = new UsernamePasswordToken(user.getUsername(), user.getPassword());
            try {
                subject.login(token);
            } catch (UnknownAccountException uae) {
                throw new GlobalException(ResultEnums.USER_NOT_EXIST);
            } catch (IncorrectCredentialsException ice) {
                throw new GlobalException(ResultEnums.USER_CHECK_ERROR);
            } catch (AuthenticationException ae) {
                throw new GlobalException(ResultEnums.CHECK_ULTRA_VIRES);
            }
        }
        return new CommentResult(0,ResultEnums.SUCCESS.getMessage(),"登录成功");
    }

    /**
     * 退出登录
     * @return
     */
    @GetMapping("/logout")
    public CommentResult logout()
    {
        Subject subject = SecurityUtils.getSubject();
        subject.logout();
        return new CommentResult(0,ResultEnums.SUCCESS.getMessage(),"退出登录");
    }

    /**
     * 未授权提示
     * @return
     */
    @GetMapping("/unauth")
    public CommentResult unauth(){
        throw new GlobalException(ResultEnums.UNLOGIN);
    }
}
