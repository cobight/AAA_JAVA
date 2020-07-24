package beforeclass;

import java.util.Scanner;

public class demo1 {
    public static void main(String[] args) {
       /*修改查询一个学生*/
        Tool tool = new Tool();
        tool.menu();
    }
}
class Tool{
    private Student[] students = new Student[10];
    private Scanner scanner = new Scanner(System.in);
    int length=0;
    {
        students[length++]=new Student("老大","男","15");
        students[length++]=new Student("老二","女","18");
        students[length++]=new Student("老三","男","19");

    }
    public boolean del(String name){
        int index = getIndexByName(name);
        if (index>-1){
            System.arraycopy(students,index+1,students,index,length--);
            return true;
        }else return false;
    }
    public boolean upData(int index,String name,String sex,String age){
        students[index] = new Student(name,sex,age);
        return true;
    }
    public Student getStu(String name){
        int index = getIndexByName(name);
        if (index>-1)return students[index];
        else return null;
    }
    public int getIndexByName(String name){
        for (int i = 0; i < length; i++) {
            if (students[i].getName().equals(name))return i;
        }
        return -1;
    }
    public void showAll(){
        for (int i = 0; i < length; i++) {
            System.out.println(students[i]);
        }
    }
    public void menu(){
        System.out.println("欢迎来到学生管理系统！");
        while (true){
            System.out.println("1、删；2、查；3、改；4、遍历；5、退出");
            switch (scanner.nextInt()){
                case 1:
                    System.out.println("请输入要删除的学生姓名：");
                    System.out.println(del(scanner.next())?"删除成功":"删除失败");
                    break;
                case 2:
                    System.out.println("请输入要查询的学生姓名：");
                    Student stu = getStu(scanner.next());
                    System.out.println(stu!=null?stu:"没查到！");
                    break;
                case 4:
                    System.out.println("遍历：");
                    showAll();
                    break;
                case 3:
                    System.out.println("请输入要修改的姓名：");
                    int index = getIndexByName(scanner.next());
                    if (index>-1){
                        System.out.println("请输入新的学生姓名、性别、年龄：");
                        upData(index,scanner.next(),scanner.next(),scanner.next());
                        System.out.println("修改成功");
                    }else System.out.println("未找到此学生！");
                    break;
                case 5:
                    return;
                default:
                    System.out.println("错误操作！");
                    break;
            }

        }
    }
}
class Student{
    private String name,sex,age;

    public Student(String name, String sex, String age) {
        this.name = name;
        this.sex = sex;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", sex='" + sex + '\'' +
                ", age='" + age + '\'' +
                '}';
    }
}