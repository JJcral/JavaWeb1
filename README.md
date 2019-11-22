# JavaWeb1

1、最最简单的登录验证（JSP+Servlet）（无数据库）
    实现方法：
        前端form添加输入框和提交按钮，提交时数据传入request；
        后端java通过request.getParameter("")获取form内两个输入内容的值；
        通过判断name不为空则进入目标页面，否则重定向到登录界面。
    实验目标：
        掌握jsp编写简单内容、掌握Servlet编写（web.xml和前端数据的获取）、页面的跳转（重定向和请求转发）。
        
2、添加实现有数据库时的登录验证
    实现方法：
        添加数据库，简单User表，字段为name和pwd；
        IDEA连接数据库，编写DBUtil，实现数据库连接的封装；
        编写UserDao，实现方法selectBynameANDpwd（name,pwd），返回查询到的user；
        编写Servlet，判断user非空进行跳转。
    实验目标：
        掌握IDEA连接数据库、掌握java对数据库的查询操作。
        
3、添加记住密码直接登录的操作（Cookie实现）
    实现方法：
        jsp中在form处添加选择框，选择是否直接登录，名为flag值为1；
        在Servlet中实现添加cookie操作（添加name、pwd）；
        判断直接登录选项是否勾选，是则设置cookie的过期时间；
        在登录的jsp中添加脚本元素，遍历cookie，寻找到name和pwd并取值；
        判断name和pwd非空后直接请求转发到登陆后的页面。
    实验目标：
        掌握cookie的添加和读取。
    
4、添加前端对密码进行MD5加密的实现(最接近真实操作的登录)
    实现方法：
        jsp中添加jquery框架和jquery下的MD5.js;
        编写js,function处理form内input元素中密码的加密（利用onsubmit实现，教程原址https://www.cnblogs.com/web-wjg/p/7894657.html）；
        USerDao编写查询操作，实现方法selectByname(name)，返回查询到的user；
        Servlet根据request获取到name和pwd，调用selectByname（name）方法找出user，判断request获得的pwd和selectByname获得的user中的pwd是否相同进行登录验证。
    实验目标：
        掌握form的onsubmit，实现js变量传入request中；
        理解登录操作是获取用户名找出密码，并验证前后端密码正确与否进行登录验证。
