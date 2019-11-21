<%--
  Created by IntelliJ IDEA.
  User: root
  Date: 2019/11/21
  Time: 17:33
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>MD5加密</title>
    <script src="https://code.jquery.com/jquery-3.1.1.min.js"></script>
    <script type="text/javascript" src="jquery.md5.js"></script>
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


<script>
    function check() {
        var pwd = document.getElementById('pwd');
        // var MD5pwd = document.getElementById('MD5pwd');
        pwd.value = $.md5(pwd.value);
        alert("shishi!")
        console.log("测试是否走通加密");
        return true;
    }
</script>


<form action="loginForMD5Servlet" method="post" id="loginName" onsubmit="return check()">
    用户名：<input type="text" name="name" value="">
    密  码：<input type="password" id="pwd" name="pwd" value="">
            <%--<input type="hidden" name="pwd" id="MD5pwd" value="">--%>
    <input type="checkbox" value="1" name="flag">一天之内直接登录
    <button type="submit">登录</button>
</form>
<script>
    console.log("测试输出！");
</script>

</body>
</html>
