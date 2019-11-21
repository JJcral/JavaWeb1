package MyTest.Entity;

/**
 * @Auther: xuwenjin
 * @Date: 2019/11/20 17:56
 * @Description:
 */
public class User {
    private String name;
    private String pwd;


    public User() {
    }

    public User(String name, String pwd) {
        this.name = name;
        this.pwd = pwd;
    }

    public String getName() {
        return name;
    }

    public String getPwd() {
        return pwd;
    }

    @Override
    public String toString() {
        return "User{" +
                "name='" + name + '\'' +
                ", pwd='" + pwd + '\'' +
                '}';
    }
}
