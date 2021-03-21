package com.dmw.servlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(value = "/cookieServlet_one")
public class cookieServlet_one extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //创建Cookie对象
        Cookie c1 = new Cookie("msg1", "我存中文1");
        Cookie c2 = new Cookie("msg2", "阿法狗a");
        //设置存活时长
        c1.setMaxAge(60);
        c2.setMaxAge(60);
        //使用response对象响应到浏览器
        response.addCookie(c1);
        response.addCookie(c2);
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }
}
