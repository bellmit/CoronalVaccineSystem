package com.cj.shiro;

import org.apache.shiro.spring.security.interceptor.AuthorizationAttributeSourceAdvisor;
import org.apache.shiro.spring.web.ShiroFilterFactoryBean;
import org.apache.shiro.web.mgt.DefaultWebSecurityManager;
import org.apache.shiro.web.servlet.Cookie;
import org.apache.shiro.web.servlet.ShiroHttpSession;
import org.apache.shiro.web.servlet.SimpleCookie;
import org.apache.shiro.web.session.mgt.DefaultWebSessionManager;
import org.springframework.aop.framework.autoproxy.DefaultAdvisorAutoProxyCreator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * @author 93948
 * @date 2021-07-18 15:22
 * @Email:19927539545@163.com
 * @project: coronalVaccineSystem
 * @descript:shiro配置拦截页面
 */
@Configuration
public class ShiroConfig {
        /**
         *  Shiro自带的过滤器，可以在这里配置拦截页面
         *  shiro的三大核心：
         *  SecurityManager：管理整个认证和授权流程
         *
         */
        @Bean
        public ShiroFilterFactoryBean shiroFilterFactoryBean(@Autowired DefaultWebSecurityManager securityManager){
            // 1. 初始化一个ShiroFilter工程类
            ShiroFilterFactoryBean shiroFilterFactoryBean = new ShiroFilterFactoryBean();

            // 2. 我们知道Shiro是通过SecurityManager来管理整个认证和授权流程的，这个SecurityManager可以在下面初始化
            shiroFilterFactoryBean.setSecurityManager(securityManager);

            // 3. 上面我们讲过，有的页面不需登录任何人可以直接访问，有的需要登录才能访问，有的不仅要登录还需要相关权限才能访问
            Map<String, String> filterMap = new LinkedHashMap<>();

            // 4. Shiro过滤器常用的有如下几种
            // 4.1. anon 任何人都能访问，如登录页面
            filterMap.put("/home/**", "anon");
            filterMap.put("/user/userRegist", "anon");
            //4.2 authc这些肯定要登录认证的
            filterMap.put("/user/**", "authc");
            filterMap.put("/medical-staff-information/**", "authc");
            filterMap.put("/root-information/**", "anon");
            filterMap.put("/station-information/**", "authc");
            filterMap.put("/user-information/**", "authc");
            filterMap.put("/volunteers-information/**", "authc");
            // 5. 让ShiroFilter按这个规则拦截
            shiroFilterFactoryBean.setFilterChainDefinitionMap(filterMap);

            // 6. 用户没登录被拦截后，当然需要调转到登录页了，这里配置登录页
            shiroFilterFactoryBean.setLoginUrl("/home/unauth");
            return shiroFilterFactoryBean;
        }

        @Bean
        public DefaultWebSessionManager sessionManager(){
            DefaultWebSessionManager webSessionManager = new DefaultWebSessionManager();
            webSessionManager.setSessionIdUrlRewritingEnabled(false);
            Cookie cookie = new SimpleCookie(ShiroHttpSession.DEFAULT_SESSION_ID_NAME);
            cookie.setHttpOnly(false);
            cookie.setSameSite(null);
            webSessionManager.setSessionIdCookie(cookie);
            webSessionManager.setSessionIdCookieEnabled(true);
            webSessionManager.setSessionIdUrlRewritingEnabled(true);
            return webSessionManager;
        }

        /**
         * SecurityManager管理认证、授权整个流程
         */
        @Bean
        public DefaultWebSecurityManager defaultWebSecurityManager(@Autowired UserRealm userRealm){
            // 7. 新建一个SecurityManager供ShiroFilterFactoryBean使用
            DefaultWebSecurityManager securityManager = new DefaultWebSecurityManager();
            // 8. SecurityManager既然管理认证等信息，那他就需要一个类来帮他查数据库吧。这就是Realm类
            securityManager.setRealm(userRealm);
            securityManager.setSessionManager(sessionManager());
            return securityManager;
        }

        /**
         * 自定义Realm，当SecurityBean需要来查询相关权限信息时，需要有Realm代劳
         */
        @Bean
        public UserRealm userRealm(){
            return new UserRealm();
        }


        /**
         * 开启Shiro的注解(如@RequiresRoles,@RequiresPermissions)
         * 配置以下两个bean(DefaultAdvisorAutoProxyCreator和AuthorizationAttributeSourceAdvisor)即可实现此功能
         * @return
         */
//        @Bean
//        public DefaultAdvisorAutoProxyCreator advisorAutoProxyCreator(){
//            DefaultAdvisorAutoProxyCreator advisorAutoProxyCreator = new DefaultAdvisorAutoProxyCreator();
//            advisorAutoProxyCreator.setProxyTargetClass(true);
//            return advisorAutoProxyCreator;
//        }
//        @Bean
//        public AuthorizationAttributeSourceAdvisor authorizationAttributeSourceAdvisor(@Autowired DefaultWebSecurityManager securityManager){
//            AuthorizationAttributeSourceAdvisor authorizationAttributeSourceAdvisor = new AuthorizationAttributeSourceAdvisor();
//            authorizationAttributeSourceAdvisor.setSecurityManager(securityManager);
//            return authorizationAttributeSourceAdvisor;
//        }
}
