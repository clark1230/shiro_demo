package com.hzit.util;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.config.IniSecurityManagerFactory;
import org.apache.shiro.mgt.SecurityManager;
import org.apache.shiro.subject.Subject;
import org.apache.shiro.util.Factory;


public class ShiroUtil {
    /**
     * 传入一个shiro的ini配置文件
     * @param ini    配置文件
     * @return          主体
     */
    public static Subject getSubject(String ini){
        Factory<SecurityManager> factory = new IniSecurityManagerFactory(ini);
        SecurityManager sm = factory.getInstance();
        SecurityUtils.setSecurityManager(sm);
        return SecurityUtils.getSubject();
    }
}
