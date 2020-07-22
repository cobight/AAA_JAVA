package beforeclass;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Scanner;

public class work1 {
    public static void main(String[] args) {
        logins l = new logins();
        l.menu();
    }
}
class logins implements DAO{
    Student[] students = new Student[5];
    int length=0;
    Scanner scanner = new Scanner(System.in);
    {
        students[length++] = new Student("admin","admin","男","19580303");

    }
    @Override
    public boolean login(String name, String password) {
        for (int i = 0; i < length; i++) {
            if (students[i].getName().equals(name) && students[i].getPassword().equals(password))return true;
        }
        return false;
    }
    public boolean menu(){
        for (int i = 0; i < 3; i++) {
            System.out.println("请输入账号密码：");
            if (login(scanner.next(),scanner.next())) {
                System.out.println("登陆成功");
                return true;
            }else {
                System.out.println("还有"+(3-i)+"次机会!");
            }
        }
        return false;
    }
}

interface DAO{
    boolean login(String name,String password);

}
class Util{
    public static Integer getSex(String sex){
        if ("男".equals(sex)) return 1;
        else if ("女".equals(sex)) return 0;
        else return -1;
    }
    public static String getSex(Integer sex){
        if (sex==1)return "男";
        else if (sex==0) return "女";
        else return "未知";
    }
    public static String getBirthday(Date birthday){
        SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
        return sdf.format(birthday);
    }
    public static Date getBirthday(String birthday){
        SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
        try {
            return sdf.parse(birthday);
        } catch (ParseException e) {
            e.printStackTrace();
            return null;
        }
    }
    public static int getAge(Date birthday){
        Calendar calendar = Calendar.getInstance();
        long now = calendar.getTimeInMillis();
        calendar.setTime(birthday);
        long birth = calendar.getTimeInMillis();
        return (int) ((now-birth)/1000/60/60/24/365);
    }
}
class Student{
    private String name;
    private String password;
    private Integer sex;
    private Date birthday;

    public Student(String name, String password, String sex, String birthday) {
        this.name = name;
        this.password = password;
        this.sex = Util.getSex(sex);
        this.birthday = Util.getBirthday(birthday);
    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", password='" + password + '\'' +
                ", sex=" + Util.getSex(sex) +
                ", birthday=" + Util.getBirthday(birthday) +
                '}'+"age = "+Util.getAge(birthday);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Integer getSex() {
        return sex;
    }

    public void setSex(Integer sex) {
        this.sex = sex;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }
}