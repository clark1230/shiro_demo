package com.hzit.relams;

import com.hzit.util.ShiroUtil;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.junit.Test;


public class MyRealmTest {
    @Test
    public void testRealm(){
        Subject subject = ShiroUtil.getSubject("classpath:Realm.ini");
        UsernamePasswordToken token = new UsernamePasswordToken("admin","admin");
        subject.login(token);
        subject.checkPermissions("index");
        boolean result  =subject.isPermitted("index");
        System.out.println(result);
    }
}
