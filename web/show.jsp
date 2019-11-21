<%--
  Created by IntelliJ IDEA.
  User: root
  Date: 2019/11/20
  Time: 16:16
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>登录成功</title>
</head>
<body>
用户名：<%=request.getAttribute("name")%><br>
密码：<%=request.getAttribute("pwd")%><br><br>
用户名：<%=request.getParameter("name")%><br>
密码：<%=request.getParameter("pwd")%><br><br>
</body>
</html>
