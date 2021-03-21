package com.dmw.servlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(value = "/cookieServlet_twe")
public class CookieServlet_twe extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
doGet(request, response);
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //获取浏览器的所有cookie  session
        Cookie[] cookies = request.getCookies();
        for (Cookie cookie : cookies) {
            //根据cookie名称找value
            String name = cookie.getName();
            String value = cookie.getValue();
            System.out.println(name+"  "+value);
        }
    }
}
