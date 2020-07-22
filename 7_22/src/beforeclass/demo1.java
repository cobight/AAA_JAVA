package beforeclass;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.Scanner;

public class demo1 {
    public static void main(String[] args) {

        Lis lis = new Lis();
        lis.menu();

    }
}
class Lis{
    ArrayList<Student> list = new ArrayList<>();
    Scanner scanner = new Scanner(System.in);
    public boolean add(Student stu){
        return list.add(stu);
    }
    public Student get(String name){
        Iterator<Student> iterator = list.iterator();
        for (;iterator.hasNext();){
            Student st = iterator.next();
            if (st.getName().equals(name)){
                return st;
            }
        }
        return null;
    }
    public void menu(){
        System.out.println("欢迎来到学生管理系统！");
        while (true){
            System.out.println("1、增；2查；3、退出");
            switch (scanner.nextInt()){
                case 1:
                    System.out.println("请输入学生姓名，生日，性别：");
                    boolean a = add(new Student(scanner.next(),scanner.next(),scanner.next()));
                    System.out.println(a?"添加成功":"添加失败");
                    break;
                case 2:
                    System.out.println("请输入查询姓名：");
                    System.out.println(get(scanner.next()));
                    break;
                case 3:
                    System.out.println("再见！");
                    return;
                default:
                    System.out.println("erro code");
                    break;

            }
        }
    }
}
class Util{
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
    public static Integer getSex(String sex){
        if ("男".equals(sex)){
            return 1;
        }else if ("女".equals(sex)){
            return 0;
        }else return -1;
    }
    public static String getSex(Integer sex){
        if (sex==1){
            return "男";
        }else if (sex==0){
            return "女";
        }else return "未知";
    }
}
class Student{
    private String name;
    private Date birthday;
    private Integer sex;

    public Student(String name, String birthday, String sex) {
        this.name = name;
        this.birthday = Util.getBirthday(birthday);
        this.sex = Util.getSex(sex);
    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", birthday=" + Util.getBirthday(birthday) +
                ", sex=" + Util.getSex(sex) +
                '}';
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}