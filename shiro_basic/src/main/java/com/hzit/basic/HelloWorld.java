package com.hzit.basic;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.config.IniSecurityManagerFactory;
import org.apache.shiro.mgt.SecurityManager;
import org.apache.shiro.subject.Subject;
import org.apache.shiro.util.Factory;
import org.junit.Test;


public class HelloWorld {
    @Test
    public void helloWorld(){
        Factory<SecurityManager> factory = new IniSecurityManagerFactory("classpath:helloworld.ini");//创建SecurityManager工厂
        SecurityManager sm = factory.getInstance();//从SecurityManager工厂中获取SecurityManager实例
        SecurityUtils.setSecurityManager(sm);//把安全管理器设置带SecurityUtils中

        Subject subject = SecurityUtils.getSubject();//获取一个主体
        //创建一个登录令牌
        UsernamePasswordToken token = new UsernamePasswordToken("admin1","admin1");
        try{
            subject.login(token);
            System.out.println("登录成功");
        } catch (AccountException e){
            System.out.println("账号异常..");
            e.printStackTrace();
        }finally {
            subject.logout();//注销账号
        }

    }
}
