<%--
  Created by IntelliJ IDEA.
  User: 35612
  Date: 2021/3/10
  Time: 14:06
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>$Title$</title>
</head>
<body>
<%="Hello 平"%>
<%--一下service方法中的代码 <%代码%> --%>
<%
    System.out.println("hello");
    int i = 10;
    response.getWriter().write("response ==1");
    out.write("out ===2");
%>
<%--定义成员变量 <%!代码%> --%>
<%!
    int i = 20;
%>
<%--将任何输出语句中的内容可以响应到页面,优先使用局部变量，即service方法内的变量--%>
<%="Hello JSP 我有中文" + i + "级水平"%>
</body>
</html>
