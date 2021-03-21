package com.dmw.servlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.text.SimpleDateFormat;
import java.util.Date;

@WebServlet(value = "/cookieServlet_three")
public class CookieServlet_three extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        Cookie[] cookies = request.getCookies();
        boolean flag = false;
        //直接拿到的浏览器中的所有的Cookie，判断是否是第一次登入(即判断有无指定的Cookie的名称)
        if (cookies.length > 0 || cookies != null) {
            for (Cookie cookie : cookies) {
                if (cookie.getName().equals("lastTime")) {
                    flag = true;
                    String oldTime = cookie.getValue();//上次登入的时间
                    //设置日期格式
                    SimpleDateFormat sdf = new SimpleDateFormat("y年MM月dd日hh:mm:ss");
                    Date date = new Date();//此时登入的时间
                    String nowTime = sdf.format(date);
                    //nowTime = URLEncoder.encode(nowTime, "UTF-8");
                    //现在的时间存到Cookie中去
                    //cookie.setValue(URLDecoder.decode(nowTime, "UTF-8"));
                    cookie.setValue(nowTime);
                    //响应到浏览器端
                    response.addCookie(cookie);
                    //在页面上响应上次输入的时间
                    response.getWriter().write("欢迎回来,您上次访问的时间为：" + oldTime+"此时的时间为："+nowTime);
                }
            }
        }
        if (!flag || cookies.length == 0 || cookies == null) {
            //第一次登入时候
            Date date = new Date();
            SimpleDateFormat sdf = new SimpleDateFormat("y年MM月dd日hh:mm:ss");
            String nowTime = sdf.format(date);
            // nowTime = URLEncoder.encode(nowTime, "UTF-8");
            Cookie cookie = new Cookie("lastTime", nowTime);
            response.addCookie(cookie);
            response.getWriter().write("欢迎光临"+nowTime);
        }

    }
}
