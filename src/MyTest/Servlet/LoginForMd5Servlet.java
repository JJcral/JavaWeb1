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
 * @Date: 2019/11/21 17:35
 * @Description:
 */
public class LoginForMd5Servlet extends HttpServlet {

    public LoginForMd5Servlet(){
        super();
    }

    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        UserDao userDao = new UserDao();

        String name = request.getParameter("name");
        String pwd = request.getParameter("pwd");
        String flag = request.getParameter("flag");

        //对密码进行加密


        System.out.println("网页传过来的名字是："+name);
        System.out.println("网页密码是："+pwd);
        if(flag!=null){
            System.out.println("一天之内免登录");
        }

        User user = userDao.selectByname(name);
        if(user == null || !user.getPwd().equals(pwd)){
            System.out.println("真的查无此人");
            response.sendRedirect("index.jsp");
        }else {
            System.out.println("找到了，数据库密码是："+user.getPwd());
            Cookie name1 = new Cookie("name",name);
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
