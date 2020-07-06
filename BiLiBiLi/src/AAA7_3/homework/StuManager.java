package AAA7_3.homework;

import java.util.Scanner;

public class StuManager {
    public static void main(String[] args) {
        Stu_tools stu_tools = new Stu_tools();
        stu_tools.insert(new Student("老大", 29, "boy"));
        stu_tools.insert(new Student("老二", 30, "girl"));
        stu_tools.insert(new Student("老三", 25, "boy"));
        stu_tools.insert(new Student("老四", 29, "boy"));
        stu_tools.insert(new Student("老五", 31, "girl"));
        stu_tools.insert(new Student("老六", 23, "boy"));

//        stu_tools.change(1, new Student("冯浩", 18, "boy"));
////        Student st = stu_tools.select("冯浩");
//        System.out.println(stu_tools.delete("小小"));
//        System.out.println("******来吧，展示******");
//        stu_tools.forshow();

        Scanner scanner = new Scanner(System.in);
        while (true) {//操作循环
            System.out.println("请输入操作码：1、插入；2、删除；3、修改；4、查询；5、显示全部；6、退出");
            int code = scanner.nextInt();

            if (code == 1) {//code = 1 ， 插入方法
                System.out.println("请输入加入的姓名、年龄、性别，并用 空格逗号分开：");
                //空格就是回车？？？？为何效果相同？？？？
                String[] msg = {scanner.next(),scanner.next(),scanner.next()};
                Student stu = new Student(msg[0], Integer.parseInt(msg[1]), msg[2]);
                stu_tools.insert(stu);//末尾加一个学生
                System.out.println("插入了一个学生：" + stu);
            } else if (code == 2) {//code = 2 ， 删除方法
                System.out.print("请输入删除的学生下标或者学生姓名：");
                String msg = scanner.next();
                //如果输入的是下标，就获取下标，若返回-1，说明输入的是名字，或者 下标小与0或大于数组长度了
                int index = input_index(msg, stu_tools.getLength());
                //三元表达式成立：执行参数是int index的删除方法<--->不成立：执行参数是String msg的删除方法
                //若依然不懂，看code = 3，那里没有用三元，用的if else
                Student stu = index != -1 ? stu_tools.delete(index) : stu_tools.delete(msg);
                //stu可能为null，也就是没找到。
                //表达式成立：不为null，那就是删了<--->表达式不成立：stu为null，也就是没删除成功（没找到）
                System.out.println(stu != null ? "删除了一位学生：" + stu : "******没找到******");
            } else if (code == 3) {//code = 3 ， 修改方法
                System.out.print("请输入修改的下标或者位置，修改后的姓名、年龄、性别，用英文逗号分开：");
                String[] msg = scanner.next().split(" ");//js讲过的链式操作
                int index = input_index(msg[0], stu_tools.getLength());//依然是找下标
                //这次没有三元表达式，降低阅读难度
                if (index != -1) {
                    //若是直接输入了下标，那就直接拿过来删
                    stu_tools.change(index, new Student(msg[1], Integer.parseInt(msg[2]), msg[3]));
                } else {
                    //若是拿到了名字，那就对应的找下标，找到再删
                    index = stu_tools.find(msg[0]);
                    stu_tools.change(index, new Student(msg[1], Integer.parseInt(msg[2]), msg[3]));
                }
            } else if (code == 4) {//code = 4 ， 查询方法
                Student stu;
                System.out.println("请输入查询的姓名或下标：");
                String name = scanner.next();
                int index = input_index(name, stu_tools.getLength());
                //这不用三元表达式可惜了，if else占了5行
                if (index != -1) {
                    //通过下标获取一个Student
                    stu = stu_tools.getStudent(index);
                } else {
                    //通过名字获取一个Student
                    stu = stu_tools.getStudent(name);
                }
                //老子不写if else 了
                System.out.println(stu != null ? stu : "！！！没找到学生！！");
            } else if (code == 5) {//code = 5 ， 展示所有学生信息
                //for：循环；show：展示 --> forshow：循环展示，嗯，没毛病
                stu_tools.forshow();
            } else if (code == 6) {//code = 6 ， 结束while循环，通过break语句跳出
                System.out.println("**************结束**************");
                break;
            }//  一次循环结束了用**分割
            System.out.println("**************************************");
        }
    }

    public static int input_index(String msg, int length) {
        //Integer.toString（int类型参数）     ：int转string方法
        //Integer.parseInt(String类型参数)   ：string转int方法
        //字符串对比不能用 == ，因为String是引用数据类型，用 == 就是对比地址了而不是对比内容，所以用equals
        for (int i = 0; i < length; i++) {
            if (msg.equals(Integer.toString(i))) {
                return i;
            }
        }
        return -1;
    }

    public static void showmsg_arr(String[] msg) {
        //我之前用空格分割，只分割出了一个，没搞明白，所以现在用的英文逗号分割
        for (String s : msg) {
            System.out.println(s);
        }
    }
}

class Stu_tools {
    private Student[] student;

    public Stu_tools() {
        student = null;//好像默认值就是null，写了个废话好像
    }

    public Stu_tools(Student[] student) {
        this.student = student.clone();//避免把地址拿来，只能new 一个新的空间的内容
    }

    //插入
    public void insert(Student student) {
        if (this.student == null) {
            this.student = new Student[1];
            this.student[0] = student;
        } else {
            Student[] clone = this.student.clone();//数据备份
            this.student = new Student[this.student.length + 1];//准备个更大的数组（其实就比之前大了1）
            //原位置的数据照常放进去
            for (int i = 0; i < clone.length; i++) {
                this.student[i] = clone[i];
            }
            //新加的数据放最后
            this.student[this.student.length - 1] = student;
        }
    }

    //修改
    public void change(int index, Student student) {
        //自己的数组不能为空，传进来数据不能为空          &&    下标要在范围内
        if (this.student != null && student != null && index >= 0 && index < this.student.length) {
            this.student[index] = student;
        } else {//感觉返回个true/false会更好
            System.out.println("超了!!!!");
        }
    }

    //name查询
    public Student select(String name) {
        for (Student stu : this.student) {
            if (stu.name.equals(name)) {//字符串对比
                return stu;
            }
        }
        return null;
    }

    //删除
    public Student delete(int index) {
        Student retn = null;
        if (this.student == null) {
//            System.out.println("数组空的还TM删？");
        } else if (this.student.length == 1) {
            this.student = null;
        } else {
            retn = this.student[index].cloneme();
            Student[] reput = new Student[this.student.length - 1];
            //第一个for：原位置的照常
            for (int j = 0; j < index; j++) {
                reput[j] = this.student[j];
            }
            //第二个for：后面的往前移    【 原数组后一位的数据 移到 新数组当前位 】
            for (int i = index; i < this.student.length - 1; i++) {
                reput[i] = this.student[i + 1];
            }
            this.student = reput;//新数组的地址替换掉原数组的地址【 数组的覆盖 】
        }//返回删除的那个学生
        return retn;
    }

    public Student delete(String name) {
        Student retn = null;
        //通过名字找下标
        int index = find(name);
        if (index == -1) {
            return retn;
        } else {
            return delete(index);
        }
    }

    //查找名字对应位置
    public int find(String name) {
        for (int i = 0; i < this.student.length; i++) {
            if (this.student[i].name.equals(name)) {//eqals字符串对比
                return i;
            }
        }
        return -1;
    }

    //获取对应位置的学生对象
    public Student getStudent(int index) {
        //数组不为空                ，下标在范围内
        if (this.student != null && index >= 0 && index < this.student.length) {
            return this.student[index];
        } else {
            return null;
        }
    }

    public Student getStudent(String name) {
        //找下标
        int index = find(name);
        return getStudent(index);
    }

    //循环遍历展示
    public void forshow() {
        if (this.student == null) {
            System.out.println("空学生数组");
        } else {
            for (Student stu : student) {
                //若没重写toString方法，println输出地址值，重写了后输出 你构造的字符串
                System.out.println(stu);
            }
        }

    }

    //返回数组长度
    public int getLength() {
        return this.student.length;
    }
}

class Student {
    String name;
    int id;
    String sex;
    public Student(){
        //其实这个方法我没有用
    }
    public Student(String name, int id, String sex) {
        this.name = name;
        this.id = id;
        this.sex = sex;
    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", id=" + id +
                ", sex='" + sex + '\'' +
                '}';
    }

    public Student cloneme() {//new一个新的空间
        return new Student(this.name, this.id, this.sex);
    }
}