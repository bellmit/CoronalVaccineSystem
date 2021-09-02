package com.cj.shiro;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.cj.enums.ResultEnums;
import com.cj.exception.GlobalException;
import com.cj.pojo.User;
import com.cj.service.UserService;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.springframework.context.annotation.Bean;

import javax.annotation.Resource;

/**
 * @author 93948
 * @date 2021-07-18 15:18
 * @Email:19927539545@163.com
 * @project: coronalVaccineSystem
 * @descript:userRealm用于查询数据库，查找有无此用户；判断是否可以登录成功
 */

public class UserRealm extends AuthorizingRealm {

        @Resource
        private UserService userService;
        //
        // 9. 前面被authc拦截后，需要认证(校验登录)，SecurityBean会调用这里进行认证
        @Override
        protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken)
                throws AuthenticationException {
            UsernamePasswordToken token = (UsernamePasswordToken)authenticationToken;
            if (token.getUsername() == null || token.getPassword() == null) {
                throw new GlobalException(ResultEnums.PARAM_ERROR);
            }
            //认证，查看数据库是否有这样的用户信息
            QueryWrapper<User> wrapper = new QueryWrapper<>();
            wrapper.eq("username",token.getUsername());
            User user = userService.getOne(wrapper);
            System.out.println(user.toString());
            String password = new String((char[])token.getPassword()); //得到密码
            if (user == null){
                throw new UnknownAccountException();
            }
            if (!user.getPassword().equals(password)){
                throw new IncorrectCredentialsException();
            }
            return new SimpleAuthenticationInfo(user, user.getPassword(), getName());
        }


        // 10. 前面被roles拦截后，需要授权才能登录，SecurityManager需要调用这里进行权限查询
        @Override
        protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
            //授权，通过用户角色给用户授权
            SimpleAuthorizationInfo authorizationInfo = new SimpleAuthorizationInfo();
            User userInfo  = (User)principals.getPrimaryPrincipal();
            authorizationInfo.addRole(userInfo.getRole());
            return authorizationInfo;
        }
}
