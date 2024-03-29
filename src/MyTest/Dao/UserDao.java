package MyTest.Dao;

import MyTest.DB.DBUtil;
import MyTest.Entity.User;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * @Auther: xuwenjin
 * @Date: 2019/11/20 18:00
 * @Description:
 */
public class UserDao {
    private Connection conn = DBUtil.getConn();

    //这里是简单登录验证，校对用户名密码即可（实际环境不这么做）
    public User selectBynameANDpwd(String name, String pwd){
        User user = null;
        String sql = "select * from User where name=? and pwd=?";
        PreparedStatement ps = null;
        ResultSet rs = null;

        try{
            ps = conn.prepareStatement(sql);
            ps.setString(1,name);
            ps.setString(2,pwd);
            rs = ps.executeQuery();
            if(rs.next()){
                user = new User(rs.getString(1),rs.getString(2));
            }
        }catch (SQLException e){
            e.printStackTrace();
        }finally {
            if(conn != null){
                try{
                    conn.close();
                }catch (SQLException e){
                    e.printStackTrace();
                }
            }

            if(ps != null){
                try{
                    ps.close();
                }catch (SQLException e){
                    e.printStackTrace();
                }
            }

            if(rs != null){
                try{
                    rs.close();
                }catch (SQLException e){
                    e.printStackTrace();
                }
            }
        }
    return user;
    }


    public User selectByname(String name){
        User user = null;
        String sql = "select pwd from User where name=?";
        PreparedStatement ps = null;
        ResultSet rs = null;

        try{
            ps = conn.prepareStatement(sql);
            ps.setString(1,name);
            rs = ps.executeQuery();
            if(rs.next()){
                user = new User(rs.getString(1));
            }
        }catch (SQLException e){
            e.printStackTrace();
        }finally {
            if(conn != null){
                try{
                    conn.close();
                }catch (SQLException e){
                    e.printStackTrace();
                }
            }

            if(ps != null){
                try{
                    ps.close();
                }catch (SQLException e){
                    e.printStackTrace();
                }
            }

            if(rs != null){
                try{
                    rs.close();
                }catch (SQLException e){
                    e.printStackTrace();
                }
            }
        }
        return user;
    }
}
