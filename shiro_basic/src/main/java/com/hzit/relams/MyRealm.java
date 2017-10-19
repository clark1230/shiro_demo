package com.hzit.relams;

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
public class MyRealm  extends AuthorizingRealm {
    /**
     *获取权限
     * @param principalCollection
     * @return
     */
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
        SimpleAuthorizationInfo info = new SimpleAuthorizationInfo();
        info.addStringPermission("545");
        info.addStringPermission("index");
        return info;
    }

    /**
     * 账号和密码的验证
     * @param token
     * @return
     * @throws AuthenticationException
     */
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {
        String username =  (String) token.getPrincipal();//获取用户名
        String password = new String((char[])token.getCredentials());
        System.out.println(username+"--------"+password);
        SimpleAuthenticationInfo info = new SimpleAuthenticationInfo(username,password,getName());
        return info;
    }
}
