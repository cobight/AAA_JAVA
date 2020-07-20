package beforeclass;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Date;
import java.util.Scanner;

public class test1 {
    public static void main(String[] args) {
        IPL ipl = new IPL();
        if (ipl.Login()) {
            ipl.Menu();
        }else {
            System.out.println("登陆失败");
        }
    }
}
class IPL implements Dao{
    int max = 10;
    int length=0;
    Scanner scanner = new Scanner(System.in);
    Student[] students = new Student[max];

    {
        Student stu = new Student("老大","男","19980122","admin");
        students[length++] = stu;
        stu = new Student("老二","女","19580306","admins");
        students[length++] = stu;

    }
    @Override
    public boolean add() {

        System.out.println("请输入姓名、性别、出生年月日、密码");
        Student stu = new Student(scanner.next(),scanner.next(),scanner.next(),scanner.next());
        if (length > max-(max>>2)){
            students = Arrays.copyOf(students,max=(max<<1));
        }
        students[length++] = stu;
        return true;
    }

    @Override
    public boolean del() {
        System.out.println("请输入删除的姓名:");
        int index = getIndexByName(scanner.next());
        if (index>-1){
            System.out.println("删除:"+students[index]);
            System.arraycopy(students,index+1,students,index,length);
            return true;
        }
        return false;
    }

    @Override
    public boolean upData() {
        System.out.println("请输入要修改的姓名：");
        int index = getIndexByName(scanner.next());
        if (index>-1){
            System.out.println("找到了原数据："+students[index]);
            System.out.println("请输入新数据：姓名、性别、出生年月日、密码");
            students[index].setName(scanner.next());
            students[index].setSex(scanner.next());
            students[index].setBirthday(scanner.next());
            students[index].setPassword(scanner.next());
            System.out.println("修改后的数据："+students[index]);
            return true;
        }
        return false;
    }

    @Override
    public Student getStu() {
        System.out.println("输入查找的姓名：");
        int index = getIndexByName(scanner.next());
        if (index>-1){
            return students[index];
        }
        return null;
    }

    @Override
    public int getIndexByName(String name) {
        for (int i = 0; i < length; i++) {
            if (students[i].getName().equals(name)){
                return i;
            }
        }
        return -1;
    }

    @Override
    public void showALL() {
        for (int i = 0; i < length; i++) {
            System.out.println(students[i]);
        }
    }

    @Override
    public void Menu() {
        System.out.println("欢迎来到学生管理系统！");
        while (true){
            System.out.println("1-4：增删改查；5、遍历；6、退出");
            switch (scanner.nextInt()){
                case 1:
                    if (add()) System.out.println("添加成功");
                    else System.out.println("添加失败");
                    break;
                case 2:
                    if (del()) System.out.println("删除成功");
                    else System.out.println("删除失败");
                    break;
                case 3:
                    if (upData()) System.out.println("修改成功");
                    else System.out.println("修改失败");
                    break;
                case 4:
                    Student stu = getStu();
                    if (stu != null) System.out.println(stu);
                    else System.out.println("没找到");
                    break;
                case 5:
                    showALL();
                    break;
                case 6:
                    return;
                default:
                    System.out.println("输入错误");
                    break;
            }

        }

    }

    @Override
    public boolean Login() {
        for (int i = 0; i < 3; i++) {
            System.out.println("还有"+(3-i)+"次机会,请输入账号密码：");
            String name=scanner.next(),password = scanner.next();
            for (int j = 0; j < length; j++) {
                if (students[i].getName().equals(name) && students[i].getPassword().equals(password));
                return true;
            }

        }
        return false;
    }
}
interface Dao{
    boolean add();
    boolean del();
    boolean upData();
    Student getStu();
    int getIndexByName(String name);
    void showALL();
    void Menu();
    boolean Login();
}
class Util{
    public static int getSex(String sex){
        if ("男".equals(sex)) return 1;
        else if ("女".equals(sex)) return 0;
        else return -1;
    }
    public static String getSex(int sex){
        if (sex==1)return "男";
        else if (sex==0) return "女";
        else return "未知";
    }

    public static int getAge(Date birthday){
        Calendar calendar = Calendar.getInstance();
        long now = calendar.getTimeInMillis();
        calendar.setTime(birthday);
        long birth = calendar.getTimeInMillis();
        return (int) ((now-birth)/1000/60/60/24/365);
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
    public static String getBirthday(Date birthday){
        SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
        return sdf.format(birthday);
    }
}
class Student{
    private static Integer ids = 0;
    private Integer id;
    private String name;
    private Integer sex;
    private Date birthday;
    private String password;

    public Student(String name, String sex, String birthday, String password) {

        this.id=++ids;
        this.name = name;
        this.sex = Util.getSex(sex);
        this.birthday = Util.getBirthday(birthday);
        this.password = password;
    }

    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", sex=" + Util.getSex(sex) +
                ", birthday=" + Util.getBirthday(birthday) +
                ", password='" + password + '\'' +
                '}'+"\t\t age="+Util.getAge(birthday);
    }



    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSex() {
        return Util.getSex(sex);
    }

    public void setSex(String sex) {
        this.sex = Util.getSex(sex);
    }

    public String getBirthday() {
        return Util.getBirthday(birthday);
    }

    public void setBirthday(String birthday) {
        this.birthday = Util.getBirthday(birthday);
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}