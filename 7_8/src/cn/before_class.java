package cn;

import java.util.Scanner;

public class before_class {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Tools tools = new Tools();
        tools.insert(new Student("老大",12,"boy"));
        tools.insert(new Student("老二",15,"boy"));
        tools.insert(new Student("老三",17,"boy"));

        while (true){
            System.out.print("请输入操作码：1增加；2删除；3修改；4查询   ：");
            int code = scanner.nextInt();
            switch (code){
                case 1:
                    System.out.print("请输入增加的姓名、年龄、性别，用空格分开 ： ");
                    String[] msg1 = {scanner.next(),scanner.next(),scanner.next()};
                    int age = strtoint(msg1[1],150);
                    Student st1 = tools.insert(new Student(msg1[0],age,msg1[2]));
                    System.out.println("增加了一位同学："+st1);
                    break;
                case 2:
                    System.out.println("请输入要删除的下标");
                    String msg2 = scanner.next();
                    int index2 = strtoint(msg2,tools.getLength());
                    Student st2 = index2!=-1?tools.delete(index2):tools.delete(msg2);
                    System.out.println("成功删除一位同学："+st2);
                    break;
                case 3:
                    System.out.println("请输入要修改的姓名，以及修改后的新数据");
                    String[] msg3 = {scanner.next(),scanner.next(),scanner.next(),scanner.next()};
                    Student st3 = tools.change(msg3[0],new Student(msg3[1],strtoint(msg3[2],150),msg3[3]));
                    System.out.println(st3!=null?"删除成功："+st3:"删除失败");
                    break;
                case 4:
                    System.out.print("请输入查询的名字：");
                    String msg4 = scanner.next();
                    Student st4 = tools.select(msg4);
                    System.out.println(st4!= null?st4:"查询失败");
                    break;
                default:
                    System.out.println("输入错误操作码");
                    break;
            }
        }
//        System.out.println();
    }
    public static int strtoint(String msg, int max){
        for (int i = 0; i < max; i++) {
            if (Integer.toString(i).equals(msg)){
                return i;
            }
        }
        return -1;
    }
}

class Tools {
    Student[] students;

    public Tools() {
        students = null;
    }
    public int getLength(){
        return this.students.length;
    }
    public Student insert(Student student) {
        if (this.students == null && student != null) {
            this.students = new Student[1];
            this.students[0] = student;
            return student.cloneme();
        } else if (student != null) {
            Student[] clone = this.students.clone();
            this.students = new Student[clone.length + 1];
            for (int i = 0; i < clone.length; i++) {
                this.students[i] = clone[i];
            }
            this.students[this.students.length - 1] = student;
            return student.cloneme();
        } else {
            System.out.println("插入异常");
            return null;
        }
    }

    public Student delete(int index) {
        if (index >= 0 && index < this.students.length) {
            Student[] clone = this.students.clone();
            this.students = new Student[clone.length - 1];
            for (int i = 0; i < index; i++) {
                this.students[i] = clone[i];
            }
            for (int i = index; i < this.students.length; i++) {
                this.students[i] = clone[i + 1];
            }
            return clone[index];
        } else {
            return null;
        }

    }
    public Student delete(String name){
        int index = getstudentindex(name);
        return delete(index);
    }
    public Student change(String name,Student student) {
        int index = getstudentindex(name);
        if (index >= 0 && index < this.students.length && student !=null) {
            this.students[index] = student;
            return student.cloneme();
        }else {
//            System.out.println("异常");
            return null;
        }
    }

    public Student select(String name){
        int index = getstudentindex(name);
        if (index >=0 && index<this.students.length){
            return this.students[index].cloneme();
        }else {
            return null;
        }
    }
    public int getstudentindex(String name) {
        if (this.students == null && name != null) {
            return -1;
        } else {
            for (int i = 0; i < this.students.length; i++) {
                if (this.students[i].getName().equals(name)) {
                    return i;
                }
            }
            return -1;
        }
    }


}

class Student {
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

    public Student cloneme() {
        return new Student(name, age, sex);
    }
}