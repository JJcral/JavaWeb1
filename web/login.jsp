<%--
  Created by IntelliJ IDEA.
  User: root
  Date: 2019/11/20
  Time: 15:46
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>登录</title>
</head>
<body>
<%
    String name = null;
    String pwd = null;
    Cookie[] cookies = request.getCookies();
    if(cookies != null){
        for (Cookie cookie:cookies) {
            if(cookie.getName().equals("name")){
                name = cookie.getValue();
            }

            if(cookie.getName().equals("pwd")){
                pwd = cookie.getValue();
            }
        }
    }

    if(name!=null && pwd!=null){
        request.getRequestDispatcher("show.jsp").forward(request,response);
    }
%>
<form action="loginServlet" method="post">
    用户名：<input type="text" name="name">
    密  码：<input type="password" name="pwd">
    <input type="checkbox" value="1" name="flag">一天之内直接登录
    <input type="submit" value="登录">
</form>

</body>
</html>
