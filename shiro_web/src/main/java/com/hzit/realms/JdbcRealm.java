package com.hzit.realms;

import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;

/**
 * 自定义域
 */
public class JdbcRealm  extends AuthorizingRealm {
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
        SimpleAuthorizationInfo info = new SimpleAuthorizationInfo();
        info.addStringPermission("index");
        info.addStringPermission("user:add");
        return null;
    }

    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {
        String username =  (String) token.getPrincipal();
        String name ="admin";
        String password = "admin";
        //根据用户名到数据库查询数据
        //查询出来的数据 (用户名和密码传入到SimpleAuthenticationInfo 由shiro自动验证)
        SimpleAuthenticationInfo info = new SimpleAuthenticationInfo(name,password,this.getName());
        
        return info;
    }
}
