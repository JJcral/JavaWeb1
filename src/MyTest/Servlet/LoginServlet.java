package MyTest.Servlet;

import MyTest.Dao.UserDao;
import MyTest.Entity.User;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @Auther: xuwenjin
 * @Date: 2019/11/20 15:57
 * @Description:手写web.xml配置，最原始的方法
 */
public class LoginServlet extends HttpServlet {

    public LoginServlet(){
        super();
    }

    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        UserDao userDao = new UserDao();

        String name = request.getParameter("name");
        String pwd = request.getParameter("pwd");
        String flag = request.getParameter("flag");

        System.out.println(name);
        System.out.println(pwd);
        if(flag!=null){
            System.out.println("一天之内免登录");
        }

//        这是测试最简单的用例
//        if(name==null || name.equals("")){
//            response.sendRedirect("index.jsp");
//        }else {
//            request.setAttribute("name",name);
//            request.getRequestDispatcher("show.jsp").forward(request,response);
//        }

        //        这是测试加上数据库的用例
        User user = userDao.selectByname(name, pwd);
        if(user == null){
            System.out.println("查无此人");
            response.sendRedirect("index.jsp");
        }else {
            System.out.println("找到了："+user.getName()+"; "+user.getPwd());
            Cookie name1 = new Cookie("name",user.getName());
            Cookie pwd1 = new Cookie("pwd", user.getPwd());
            if(flag!=null){
                if(flag.equals("1")){
                    name1.setMaxAge(24*3600);
                    pwd1.setMaxAge(24*3600);
                }
            }

            response.addCookie(name1);
            response.addCookie(pwd1);
            request.getRequestDispatcher("show.jsp").forward(request,response);
        }

    }

    @Override
    public void doPost(HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException{
        doGet(request,response);
    }

}
