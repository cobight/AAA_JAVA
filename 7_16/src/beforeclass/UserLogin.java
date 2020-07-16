package beforeclass;

import java.util.Scanner;

public class UserLogin {


    public static void main(String[] args) {
        System.out.println("欢迎进入管理系统");
        User user = new User("admin","admin");
        Scanner scanner = new Scanner(System.in);
        boolean state =true;
        while (true){
            if (state){
                System.out.println("请输入用户名：");
                String name = scanner.next();
                if (user.getName().equals(name)){
                    state=false;
                    System.out.println("用户输入正确，请输入密码！");
                }else {
                    System.out.println("用户不存在，请重新输入！");
                }
            }else{
                String pwd=scanner.next();
                if (user.getPwd().equals(pwd)){
                    System.out.println("密码输入正确！");
                    System.out.println("登陆成功！");
                    return;
                }else {
                    System.out.println("密码不正确，请重新输入！");
                }
            }
        }
    }
}
class User{
    private String name;
    private String pwd;

    @Override
    public String toString() {
        return "User{" +
                "name='" + name + '\'' +
                ", pwd='" + pwd + '\'' +
                '}';
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPwd() {
        return pwd;
    }

    public void setPwd(String pwd) {
        this.pwd = pwd;
    }

    public User(String name, String pwd) {
        this.name = name;
        this.pwd = pwd;
    }
}