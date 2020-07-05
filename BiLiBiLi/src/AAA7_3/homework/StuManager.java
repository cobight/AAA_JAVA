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
        while (true) {
            System.out.println("请输入操作码：1、插入；2、删除；3、修改；4、查询；5、显示全部；6、退出");
            int code = scanner.nextInt();
            if (code == 1) {
                System.out.print("请输入加入的姓名、年龄、性别，并用 英文逗号分开：");
                String inp = scanner.next();
                String[] msg = inp.split(",");
//                System.out.println(msg.length);
//                showmsg_arr(msg);
                Student stu = new Student(msg[0], Integer.parseInt(msg[1]), msg[2]);
                stu_tools.insert(stu);
                System.out.println("插入了一个学生：" + stu);
            } else if (code == 2) {
                System.out.print("请输入删除的学生下标或者学生姓名：");
                String msg = scanner.next();
                int index = input_index(msg, stu_tools.getLength());
//                System.out.println(index);
                Student stu = index != -1 ? stu_tools.delete(index) : stu_tools.delete(msg);
                System.out.println(stu!=null?"删除了一位学生：" + stu:"******没找到******");
            } else if (code == 3) {
                System.out.print("请输入修改的下标或者位置，修改后的姓名、年龄、性别，用英文逗号分开：");
                String[] msg = scanner.next().split(",");
                int index = input_index(msg[0], stu_tools.getLength());
                if (index != -1) {
                    stu_tools.change(index, new Student(msg[1], Integer.parseInt(msg[2]), msg[3]));
                } else {
                    index = stu_tools.find(msg[0]);
                    stu_tools.change(index, new Student(msg[1], Integer.parseInt(msg[2]), msg[3]));
                }
            } else if (code == 4) {
                Student stu;
                System.out.println("请输入查询的姓名或下标：");
                String name = scanner.next();
                int index = input_index(name, stu_tools.getLength());
                if (index != -1) {
                    stu = stu_tools.getStudent(index);
                } else {
                    stu = stu_tools.getStudent(name);
                }
                System.out.println(stu != null ? stu : "！！！没找到学生！！");
            } else if (code == 5) {
                stu_tools.forshow();
            } else if (code == 6) {
                System.out.println("**************结束**************");
                break;
            }
            System.out.println("**************************************");
        }
    }

    public static int input_index(String msg, int length) {
        for (int i = 0; i < length; i++) {
            if (msg.equals(Integer.toString(i))) {
                return i;
            }
        }
        return -1;
    }

    public static void showmsg_arr(String[] msg) {
        for (String s : msg) {
            System.out.println(s);
        }
    }
}

class Stu_tools {
    private Student[] student;

    public Stu_tools() {
        student = null;
    }

    public Stu_tools(Student[] student) {
        this.student = student.clone();
    }

    //插入
    public void insert(Student student) {
        if (this.student == null) {
            this.student = new Student[1];
            this.student[0] = student;
        } else {
            Student[] clone = this.student.clone();
            this.student = new Student[this.student.length + 1];
            for (int i = 0; i < clone.length; i++) {
                this.student[i] = clone[i];
            }
            this.student[this.student.length - 1] = student;
        }
    }

    //修改
    public void change(int index, Student student) {
        if (this.student != null && student!=null && index >= 0 && index < this.student.length) {
            this.student[index] = student;
        } else {
            System.out.println("超了!!!!");
        }
    }

    //name查询
    public Student select(String name) {
        for (Student stu : this.student) {
            if (stu.name.equals(name)) {
                return stu;
            }
        }
        return null;
    }

    //删除
    public Student delete(int index) {
        Student retn = null;
        if (this.student == null) {
//            System.out.println("空的还TM删？");
        } else if (this.student.length == 1) {
            this.student = null;
        } else {
            retn = this.student[index].cloneme();
            Student[] reput = new Student[this.student.length - 1];
            for (int j = 0; j < index; j++) {
                reput[j] = this.student[j];
            }
            for (int i = index; i < this.student.length - 1; i++) {
                reput[i] = this.student[i + 1];
            }
            this.student = reput;
//            this.student[this.student.length-1]=null;
        }
        return retn;
    }

    public Student delete(String name) {
        Student retn = null;
        int index = -1;
        for (int i = 0; i < this.student.length; i++) {
            if (this.student[i].name.equals(name)) {
                index = i;
            }
        }
        if (index == -1) {
            return retn;
        } else {
            return delete(index);
        }
    }

    //查找名字对应位置
    public int find(String name) {
        for (int i = 0; i < this.student.length; i++) {
            if (this.student[i].name.equals(name)) {
                return i;
            }
        }
        return -1;
    }

    //获取对应位置的学生对象
    public Student getStudent(int index) {
        if (index >= 0 && index < this.student.length) {
            return this.student[index];
        } else {
            return null;
        }
    }

    public Student getStudent(String name) {
        int index = find(name);
        return getStudent(index);
    }

    //循环遍历展示
    public void forshow() {
        if (this.student == null) {
            System.out.println("空学生数组");
        } else {
            for (Student stu : student) {
                System.out.println(stu);
            }
        }

    }

    //返回数组长度
    public int getLength() {
        return this.student.length;
    }
}