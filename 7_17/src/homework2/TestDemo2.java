package homework2;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Date;
import java.util.Scanner;

public class TestDemo2 {
    /*
    学生类：  class Student
        1、private Integer id；
        2、private String name；
        3、private String password；
        4、private Date birthday；
        5、private Integer sex；//0女1男
     (X)6、private Integer score；
        7、getter / setter / toString / 构造方法   重写
    数据处理类：  class StudentUtil
        1、String转Date                       -->修改set方法：void    setBirthday(String birthday)
        2、Date转String                       -->修改get方法：String  getBirthday()
        3、Date（birthday）  转Age(int)        -->           int     getAge()
     (X)4、String（birthday）转Age(int)        -->           int     getAge()
        5、getIntegerBySex                    -->           Integer getIntegerBySex(String sex)
        6、getStringBySex                     -->           String  getStringBySex(Integer)
    定义接口：  abstract class StudentDao
        1、定义增删改查方法（参数与返回值要注意）
        2、排序（int typer，int key）{// typer选择abcd那种排序；key选择正序倒序
            a:I D排序，通过id（添加的顺序）
            b:年龄排序，通过birthday
         (X)c:性别排序，利用0与1
         (X)d:成绩排序，利用score成绩
        }
        3、登录（String name,String password）返回 匹配到的【学生对象】
        4、定义菜单方法{
            欢迎用户语
            开始用户登录
            用循环控制登录行为
            ...
            登陆成功：欢迎登录的学生名字，打印学生的所有信息（记得重写学生对象的toString）
            return结束
        }
    实现接口：  class StudentIpm implements StudentDao
        1、实现增删改查方法
        2、实现排序方法
        3、实现登录方法
        4、实现菜单
    调用调试类： class StuTest
        1、主方法new StudentIpm对象，调用方法进入菜单
*/
    public static void main(String[] args) {
        IPL ipl = new IPL();
        ipl.add(new Student("老大", "admin", Util.getBirthday("19980122"), Util.getSex("男"), 100));
        ipl.add(new Student("老二", "ad", Util.getBirthday("19500122"), Util.getSex("男"), 40));
        ipl.add(new Student("老三", "admiaa", Util.getBirthday("1910122"), Util.getSex("女"), 60));
//        ipl.del("老二");
//        ipl.upData("老大",new Student("老八","laoba",Util.getBirthday("19580101"),Util.getSex("女"),70));
//        System.out.println(ipl.getStu("老八"));
//        ipl.showAll();
        ipl.Menu();
//        if (ipl.Login()) {
//            ipl.Menu();
//        }else {
//            System.out.println("登陆失败！");
//        }老四 laosi 19580203 男 60

    }
}

class IPL implements Dao {
    private int max = 10;
    private int length = 0;
    private Student[] students = new Student[max];
    private Scanner scanner = new Scanner(System.in);

    public int getLength() {
        return length;
    }

    @Override
    public Student add(Student stu) {
        if (length > max - (max >> 2)) {
            students = Arrays.copyOf(students, max = (max << 1));
        }
        students[length++] = stu;
        return stu;
    }

    @Override
    public Student del(String name) {
        int index = getIndexByName(name);
        Student stu = students[index];
        System.arraycopy(students, index + 1, students, index, length--);
        return stu;
    }

    @Override
    public Student upData(String name, Student stu) {
        int index = getIndexByName(name);
        if (index > -1) {
            students[index].setName(stu.getName());
            students[index].setBirthday(stu.getBirthday());
            students[index].setPassword(stu.getPassword());
            students[index].setSex(stu.getSex());
            students[index].setScore(stu.getScore());
            return students[index];
        }
        return null;
    }

    @Override
    public Student getStu(String name) {
        int index = getIndexByName(name);
        if (index > -1) return students[index];
        else return null;
    }

    @Override
    public int getIndexByName(String name) {
        for (int i = 0; i < length; i++) {
            if (students[i].getName().equals(name)) return i;
        }
        return -1;
    }

    @Override
    public void showAll() {
        for (int i = 0; i < length; i++) {
            System.out.println(students[i]);
        }
    }

    @Override
    public Student login(String name, String password) {
        for (int i = 0; i < length; i++) {
            if (students[i].getName().equals(name) && students[i].getPassword().equals(password)) return students[i];
        }
        return null;
    }

    @Override
    public boolean Login() {
        System.out.println("欢迎登录学生管理系统！");
        for (int i = 3; i >= 0; i--) {
            System.out.println("请输入账号 与 密码");
            if (login(scanner.next(), scanner.next()) != null) {
                System.out.println("登陆成功!");
                return true;
            }
            System.out.println("还有" + i + "次机会");
        }
        return false;
    }

    @Override
    public void Menu() {
        System.out.println("欢迎进入学生管理系统！");
        while (true) {
            System.out.println("1、增；2、删；3、改；4、查；5、遍历；6、退出");
            switch (scanner.nextInt()) {
                case 1:
                    add();
                    break;
                case 2:
                    del();
                    break;
                case 3:
                    upData();
                    break;
                case 4:
                    getStu();
                    break;
                case 5:
                    showAll();
                    break;
                case 6:
                    return;
                default:
                    System.out.println("操作码错误！");
                    break;
            }
        }
    }

    public void add() {
        System.out.println("请输入学生信息（姓名、密码、生日、性别、成绩），请用空格分开");
        Student add = add(new Student(scanner.next(), scanner.next(), Util.getBirthday(scanner.next()), Util.getSex(scanner.next()), scanner.nextInt()));
        if (add != null) System.out.println("添加成功：" + add);
        else System.out.println("添加失败!");
    }

    public void del() {
        System.out.print("请输入删除的姓名：");
        Student del = del(scanner.next());
        if (del != null) System.out.println("删除成功:" + del);
        else System.out.println("删除失败！");
    }

    public void upData() {
        System.out.println("请输入要修改的学生姓名：");
        String name = scanner.next();
        if (getIndexByName(name) > -1) {
            Student student = upData(name, new Student(scanner.next(), scanner.next(), Util.getBirthday(scanner.next()), Util.getSex(scanner.next()), scanner.nextInt()));
            if (student != null) System.out.println("修改成功：" + student);
            else System.out.println("修改异常！");
        } else {
            System.out.println("为找到！");
        }

    }

    public void getStu() {
        System.out.println("请输入你要查询的姓名：");
        Student stu = getStu(scanner.next());
        if (stu != null) System.out.println(stu);
        else System.out.println("未查到！");
    }
}

interface Dao {
    int getLength();

    Student add(Student stu);

    Student del(String name);

    Student upData(String name, Student stu);

    Student getStu(String name);

    int getIndexByName(String name);

    void showAll();

    Student login(String name, String password);

    boolean Login();

    void Menu();
}

class Util {
    private static SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");

    public static String getBirthday(Date birthday) {
        return sdf.format(birthday);
    }

    public static Date getBirthday(String birthday) {
        try {
            return sdf.parse(birthday);
        } catch (ParseException e) {
            e.printStackTrace();
            return null;
        }
    }

    public static String getSex(Integer sex) {
        if (sex == 1) return "男";
        else return "女";
    }

    public static Integer getSex(String sex) {
        if (sex.equals("男")) return 1;
        else return 0;
    }

    public static int getAge(String birthday) {

        try {
            Calendar calendar = Calendar.getInstance();
            long now = calendar.getTimeInMillis();
            calendar.setTime(sdf.parse(birthday));
            long birth = calendar.getTimeInMillis();
            return (int) ((now - birth) / 1000 / 60 / 60 / 24 / 365);

        } catch (ParseException e) {
            e.printStackTrace();
        }
        return 0;
    }

    public static int getAge(Date birthday) {
        Calendar calendar = Calendar.getInstance();
        long now = calendar.getTimeInMillis();
        calendar.setTime(birthday);
        long birth = calendar.getTimeInMillis();
        return (int) ((now - birth) / 1000 / 60 / 60 / 24 / 365);
    }

}

class Student {
    private static int ids = 0;
    private Integer id;
    private String name;
    private String password;
    private Date birthday;
    private Integer sex;
    private Integer score;

    public Student(String name, String password, Date birthday, Integer sex, Integer score) {
        this.id = ++ids;
        this.name = name;
        this.password = password;
        this.birthday = birthday;
        this.sex = sex;
        this.score = score;
    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", password='" + password + '\'' +
                ", birthday=" + Util.getBirthday(birthday) +
                ", sex=" + sex +
                ", score=" + score +
                '}' + "\t\t age=" + Util.getAge(birthday);
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

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public Integer getSex() {
        return sex;
    }

    public void setSex(Integer sex) {
        this.sex = sex;
    }

    public Integer getScore() {
        return score;
    }

    public void setScore(Integer score) {
        this.score = score;
    }
}