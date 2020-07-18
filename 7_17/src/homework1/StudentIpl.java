package homework1;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class StudentIpl implements StudentDao {
    private int max = 5;//记录数组最大长度
    private Student[] students = new Student[max];//用户信息数组
    private int length = 0;//记录数组当前长度
    private Scanner scanner = new Scanner(System.in);//键盘钩子

    @Override//数组操作增
    public Student add(Student stu) {
        if (length > max >> 2) {//数组扩容
            System.out.println(max);
            students = Arrays.copyOf(students, max = (max << 1));// <<位操作，最大值调高，小数组赋给大数组（扩容）
        }
        //插数据
        students[length++] = stu;
        return stu;
    }

    @Override//数组操作删
    public Student del(String name) {
        int index = getIndexByName(name);//定位下标
        Student stu = null;
        if (index > -1) {//找到下标，返回学生，没找到就返回null
            stu = students[index];
            System.arraycopy(students, index + 1, students, index, length--);
        }
        return stu;
    }

    @Override//通过name获取下标
    public int getIndexByName(String name) {
        for (int i = 0; i < length; i++) {
            if (students[i].getName().equals(name)) {
                return i;//找到后返回下标，结束方法体
            }
        }
        return -1;//遍历结束，没找到下标，返回-1
    }

    @Override//数组操作改
    public Student upData(String name, String newName, String password, String sex, String birthday, Integer score) throws ParseException {
        int index = getIndexByName(name);
        if (index > -1) {//找到下标，修改参数，结束方法体
            students[index].setName(newName);
            students[index].setScore(score);
            students[index].setBirthday(birthday);
            students[index].setPassword(password);
            students[index].setSex(sex);
            return students[index];
        }
        return null;//没找到下标，返回空，结束方法体
    }

    @Override//数组操作遍历
    public void showAll() {
        for (int i = 0; i < length; i++) {//从0 到length，遍历
            System.out.println(students[i]);
        }
    }

    @Override//主菜单
    public void Menu() throws ParseException {

        System.out.println("欢迎进入学生登录系统！");
        while (true) {
            System.out.println("1、增加；2、删除；3、修改；4、遍历；5、退出");
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
                    showAll();
                    break;
                case 5:
                    System.out.println("已退出学生管理系统！");
                    return;
                default:
                    System.out.println("异常操作，请从新输入！");
                    break;
            }
        }
    }

    //用户操作增
    public void add() throws ParseException {
        System.out.println("请输入姓名、密码、性别、生日、成绩，用空格分开：");
        Student info = add(new Student(scanner.next(), scanner.next(), scanner.next(), scanner.next(), scanner.nextInt()));
        //添加成功返回学生对象
        //添加失败返回null
        if (info != null) {
            System.out.println("添加成功：" + info);
        } else {
            System.out.println("添加失败");
        }
    }

    //用户操作删
    public void del() {
        System.out.println("请输入要删除的姓名");
        Student info = del(scanner.next());
        //删除成功返回学生对象
        //删除失败返回null
        if (info != null) {
            System.out.println("删除了：" + info);
        } else {
            System.out.println("删除失败");
        }
    }

    //用户操作改
    public void upData() throws ParseException {
        System.out.println("请输入要修改的姓名，然后输入修改后的姓名、密码、性别、生日、成绩，用空格分开：");
        Student info = upData(scanner.next(), scanner.next(), scanner.next(), scanner.next(), scanner.next(), scanner.nextInt());
        //修改成功返回学生对象
        //修改失败返回null
        if (info != null) {
            System.out.println("修改成功：" + info);
        } else {
            System.out.println("修改失败");
        }

    }


}
