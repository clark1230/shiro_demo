package com.hzit.servlets;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/login")
public class LoginServlet extends HttpServlet{
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
          req.getRequestDispatcher("/login.jsp").forward(req,resp);
    }

    /**
     * 处理登录请求
     * @param req
     * @param resp
     * @throws ServletException
     * @throws IOException
     */
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String username = req.getParameter("username");
        String password=req.getParameter("password");
        //使用Shiro来处理登录
        Subject subject = SecurityUtils.getSubject();
        UsernamePasswordToken token = new UsernamePasswordToken(username,password);
        token.setRememberMe(true);//记住我
        String msg = null;
        try{
            subject.login(token);
        }catch (UnknownAccountException e){
            msg ="用户名或密码错误!";
        } catch (IncorrectCredentialsException e){
            msg ="用户名或密码错误!";
        }
        if(msg == null){
            //重定向到主页
            resp.sendRedirect(req.getContextPath()+"/index");
        }   else{
            req.setAttribute("error",msg);
            req.getRequestDispatcher("/login.jsp").forward(req,resp);
        }
    }
}
