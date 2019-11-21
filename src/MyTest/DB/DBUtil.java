package MyTest.DB;

import java.sql.*;

/**
 * @Auther: xuwenjin
 * @Date: 2019/11/20 17:39
 * @Description:
 */
public class DBUtil {
    private static Connection conn = null;    //数据库连接对象

    private static final String DRIVER="com.mysql.jdbc.Driver";//这是一个连接数据库必填的常量
    private static final String URL = "jdbc:mysql://localhost:3306/testforlogin"; //数据库的URL 3308为端口  testforlogin是那个数据库
    private static final String USER = "root";  //数据库的账号
    private static final String PWD = "8520";    //数据库的密码

    //获得数据库连接，加载驱动
    public static Connection getConn() {
        //加载驱动
        try {
            Class.forName(DRIVER);
            try {
                conn= DriverManager.getConnection(URL, USER, PWD);
                System.out.println("登录数据库成功！");
            } catch (SQLException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return conn;
    }



    //释放资源的方法
    public void close() {
        try {
            if(conn != null) {
                conn.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args){
        DBUtil.getConn();
    }

}
