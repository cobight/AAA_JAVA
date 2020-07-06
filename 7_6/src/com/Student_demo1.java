package com;

import java.util.Scanner;

public class Student_demo1 {
    public static void main(String[] args) {
        /*增删改查
        * 循环
        * 遍历输出
        * */
        Tools tool = new Tools();
//        System.out.println(tool.getLength());
        //增
        tool.insert(new Student("老大",11,"boy"));
        tool.insert(new Student("老二",12,"girl"));
        tool.insert(new Student("老三",13,"boy"));
        tool.insert(new Student("老四",14,"boy"));
//        tool.forshow();
        //删除
//        System.out.println(tool.delete(2));
//        System.out.println("***********");
//        tool.forshow();
        //定位下标
//        System.out.println(tool.getindexbyname("老六"));
        //改
//        System.out.println(tool.change(0,new Student("asd",1,"girl")));
//        System.out.println("***********");
//        tool.forshow();
        //查
//        System.out.println(tool.select("老二"));
        //循环
        Scanner scanner = new Scanner(System.in);
        while (true){
            System.out.println("请输入操作码：1、增加；2、删除；3、修改；4、查询；5、遍历输出；6、结束");
            String code = scanner.next();

            switch (str_change_int(code,7)){
                case 1:
                    System.out.print("请输入插入的姓名、年龄、性别，并用空格分开 : ");
                    String[] msg = {scanner.next(),scanner.next(),scanner.next()};
                    Student retn = tool.insert(new Student(msg[0],str_change_int(msg[1],150),msg[2]));
                    System.out.println("成功加入了一个学生："+retn);
                    break;
                case 2:
                    System.out.print("请输入需要删除的下标或者位置 : ");
                    String msg1 = scanner.next();
                    int index = str_change_int(msg1,tool.getLength());
                    Student stu = index != -1?tool.delete(index):tool.delete(msg1);

                    System.out.println(stu != null?"成功删除了一位同学:"+stu:"删除操作失败");
                    break;
                case 3:
                    System.out.println("请输入需要修改的下标或者位置，加修改后的学生姓名、年龄、性别，用空格分开 : ");
                    String[] msg2 = {scanner.next(),scanner.next(),scanner.next(),scanner.next()};
                    int index1 = str_change_int(msg2[0],tool.getLength());
                    Student stu1 = index1 != -1?tool.change(index1,new Student(msg2[1],str_change_int(msg2[2],150),msg2[3])):tool.change(msg2[0],new Student(msg2[1],str_change_int(msg2[2],150),msg2[3]));
                    System.out.println(stu1 != null?"成功修改了一位同学:"+stu1:"修改操作失败");
                    break;
                case 4:
                    System.out.print("请输入需要查询的下标或名字 ： ");
                    String msg3 = scanner.next();
                    int index2 = str_change_int(msg3,tool.getLength());
                    Student stu2 = index2 != -1 ? tool.select(index2):tool.select(msg3);
                    System.out.println(stu2 != null?"找到了学生 ： "+stu2:"没找到学生");
                    break;
                case 5:
                    tool.forshow();
                    break;
                case 6:
                    return;
                default:
                    System.out.println("操作码异常，请从新输入");
                    break;

            }
        }

    }
    public static int str_change_int(String a,int max){//输入的年龄；字符串转整数型，顺便防止异常

        for (int i = 0; i < 150; i++) {
            if (Integer.toString(i).equals(a)){
                return i;
            }
        }
        return -1;
    }
}
class Tools{
    Student[] students;
    //获取数组长度
    public int getLength(){
        if (this.students == null){
            return -1;
        }else {
            return this.students.length;
        }
    }
    //初始化
    public Tools() {
        this.students = null;
    }
    public Student insert(Student student){
        if (this.students == null && student != null){//第一次加数据
            this.students = new Student[1];
            this.students[0] = student;
            return this.students[0].cloneme();
        }else if (this.students != null && student != null){//增数据
            //备份数据
            Student[] clone = this.students.clone();
            //准备个更大的数组
            this.students = new Student[clone.length+1];
            //数据归位
            for (int i = 0; i < clone.length; i++) {
                this.students[i] = clone[i];
            }
            this.students[this.students.length-1] = student;
            return this.students[this.students.length-1].cloneme();
        }else {
            return null;
        }
    }
    //删除
    public Student delete(int index){
        //通过下标删除数据
        if (this.students != null && index >=0 && index <this.students.length){
            //准备好返回数据
            Student retn = this.students[index].cloneme();
            //备份数组
            Student[] clone = this.students.clone();
            //换一个小一号的数组
            this.students = new Student[clone.length-1];
            //数据归位
            for (int i = 0; i < index; i++) {
                this.students[i] = clone[i];
            }
            for (int i = index; i < this.students.length; i++) {
                this.students[i] = clone[i+1];
            }
            return retn;
        }else {
            return null;
        }
    }
    public Student delete(String name){
        //先定位下标，后删除
        int index = getindexbyname(name);
        return delete(index);
    }
    //改
    public Student change(int index,Student student){
        if (this.students != null && student != null && index >= 0 && index <this.students.length){
            //数据修改
            this.students[index] = student;
            //返回修改后的结果
            return this.students[index].cloneme();
        }else {
            return null;
        }
    }
    public Student change(String name,Student student){
        //先定位下标，后修改
        int index = getindexbyname(name);
        return change(index,student);
    }
    //查询
    public Student select(int index ){
        //通过下标获取数据
        if (this.students != null && index >= 0 && index < this.students.length){
            return this.students[index].cloneme();
        }else {
            return null;
        }
    }
    public Student select(String name){
        //先定位下标，后查询
        int index = getindexbyname(name);
        return select(index);
    }
    //通过名字定位下标
    public int getindexbyname(String name){
        for (int i = 0; i < this.students.length; i++) {
            if (this.students[i] != null && this.students[i].getName().equals(name)){
                return i;
            }
        }
        return -1;
    }
    //遍历输出
    public void forshow(){
        if (this.students != null){
            for (Student s : this.students) {
                System.out.println(s);
            }
        }else {
            System.out.println("数据为空");
        }

    }
}
class Student{
    private String name;
    private int age;
    private String sex;

    public Student(String name, int age, String sex) {
        this.name = name;
        this.age = age;
        this.sex = sex;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", sex='" + sex + '\'' +
                '}';
    }
    public Student cloneme(){
        return new Student(name,age,sex);
    }
}