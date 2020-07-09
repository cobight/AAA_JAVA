package homework;

import java.util.Scanner;

public class work1 {
    /*
    *   学生管理系统：
        学生类：
        *      private int id;
        *      private String name;
        *      private int score;//0-100
        *      private String sex;

        学生管理类：(合并作业要求) + 【循环操作】
            1、求出该班级学生的最高分，最低分，平均分；【getMaxScore、getMinScore、getAverageScore】
            2、获取最高分、最低分的同学；            【getStudentByMaxScore、getStudentByMinScore】
            3、把同学按ID、成绩排序与反转；              【sort、reverse】
            4、删除一个同学；                      【delete】
            5、遍历输出；                         【forShow】
        * */


    public static void main(String[] args) {
        Tools tools = new Tools();
        Scanner scanner = new Scanner(System.in);
        tools.insert(new Student(1, "老大", 60, "boy"));
        tools.insert(new Student(2, "小花", 100, "girl"));
        tools.insert(new Student(3, "老二", 71, "girl"));
        tools.insert(new Student(4, "老三", 83, "boy"));
        tools.insert(new Student(5, "老四", 97, "boy"));
        tools.insert(new Student(6, "老五", 82, "boy"));
        tools.insert(new Student(7, "老六", 99, "boy"));
//        tools.sort();
//        tools.reverse();
//        tools.forShow();
//        System.out.println(tools.getAverageScore());
        while (true) {
            System.out.println("请对应输入操作码：1、增加；2、删除；3、成绩查询；4、学生查询；5、排序；6、遍历输出；7、退出");

            String codemsg = scanner.next();
            int code = str_to_int(codemsg, 7);
            switch (code) {
                case 1:
                    System.out.print("请输入要加入的学生信息[id,name,score,sex] ，并用空格分开  : ");
                    String[] msgs = {scanner.next(), scanner.next(), scanner.next(), scanner.next()};
                    int id = str_to_int(msgs[0], 999);
                    int score = str_to_int(msgs[2], 100);
                    if (id != -1 && tools.haveId(id) && score != -1) {
                        Student a = new Student(id, msgs[1], score, msgs[3]);
                        tools.insert(a);
                        System.out.println("加入成功 : " + a);
                        break;
                    } else {
                        System.out.println("输入异常");
                        break;
                    }
                case 2:
                    System.out.print("请输入要删除的名字或下标：");
                    String msg1 = scanner.next();
                    int index1 = str_to_int(msg1, tools.getLength());
                    Student dele = index1 != -1 ? tools.delete(index1) : tools.delete(msg1);
                    System.out.println(dele);
                    System.out.println(dele == null ? "删除时输入异常，出现错误" : "删除了一位学生 : " + dele);
                    break;
                case 3:
                    System.out.print("成绩查询功能：1、获取最高分；2、获取最低分；3、获取平均分；  请输入操作码： ");
                    int code3 = str_to_int(scanner.next(), 3);
                    switch (code3) {
                        case 1:
                            System.out.println(tools.getMaxScore());
                            break;
                        case 2:
                            System.out.println(tools.getMinScore());
                            break;
                        case 3:
                            System.out.println(tools.getAverageScore());
                            break;
                        default:
                            System.out.println("输入错误");
                            break;
                    }
                    break;
                case 4:
                    System.out.print("获取最高分与最低分的学生：1、最高分的学生；2、最低分的学生  ： ");
                    int code4 = str_to_int(scanner.next(), 2);
                    if (code4 == 1) {
                        System.out.println(tools.getStudentByMaxScore());
                    } else if (code4 == 2) {
                        System.out.println(tools.getStudentByMinScore());
                    } else {
                        System.out.println("异常操作");
                    }
                    break;
                case 5:
                    System.out.print("-->排序类型：1、通过ID排序；2、通过成绩排序  ： ");
                    int type5 = str_to_int(scanner.next(), 2);
                    System.out.print("-->排序类型：1、顺序；2、倒序  ： ");
                    int fx = str_to_int(scanner.next(), 2);
                    tools.sort(type5, fx);
                    break;
                case 6:
                    tools.forShow();
                    break;
                case 7:
                    return;
                default:
                    System.out.println("操作码输入异常");

            }
            System.out.println("*****************************");
        }
    }

    public static int str_to_int(String msg, int max) {
        for (int i = 0; i <= max; i++) {
            if (Integer.toString(i).equals(msg)) {
                return i;
            }
        }
        return -1;
    }
}

class Tools {

    private Student[] students;

    public Tools() {
        students = null;
    }

    //增加一位同学
    public void insert(Student student) {
        if (this.students == null && student != null) {//第一次增加数据
            this.students = new Student[1];
            this.students[0] = student;
        } else if (this.students != null && student != null) {//后来增加数据
            Student[] clone = this.students.clone();
            this.students = new Student[clone.length + 1];
            for (int i = 0; i < clone.length; i++) {
                this.students[i] = clone[i];
            }
            this.students[this.students.length - 1] = student;
        } else {
            System.out.println("insert erro");
        }
    }

    public int getLength() {
        return this.students.length;
    }

    public boolean haveId(int a) {
        for (Student student : this.students) {
            if (student.getId() == a) {
                System.out.println("ID重复");
                return false;
            }
        }
        return true;
    }

    //删除一位同学
    public Student delete(int index) {//通过下标删除学生
        if (index >= 0 && index < this.students.length) {
            Student retn = this.students[index];
            Student[] clone = this.students.clone();
            this.students = new Student[clone.length - 1];
            for (int i = 0; i < index; i++) {
                this.students[i] = clone[i];
            }
            for (int i = index; i < this.students.length; i++) {
                this.students[i] = clone[i + 1];
            }
            return retn;
        } else {
            return null;
        }


    }

    public Student delete(String name) {//通过名字删除学生
        int index = getIndexByName(name);
        //下表是否越界问题上面的delete有过滤，不重复写代码了
        return delete(index);
    }

    //通过名字定位下标
    public int getIndexByName(String name) {
        for (int i = 0; i < this.students.length; i++) {
            if (this.students[i].getName().equals(name)) {
                return i;
            }
        }
        return -1;
    }

    //循环展示
    public void forShow() {
        if (this.students == null) {
            System.out.println("空数组");
        } else {
            for (Student student : this.students) {
                System.out.println(student);
            }
        }
    }

    //getMaxScore、getMinScore、getAverageScore
    public int getMaxScore() {
        int max = -1;
        if (this.students != null) {
            for (Student student : this.students) {
                max = student.getScore() > max ? student.getScore() : max;
            }
            return max;
        } else {
            System.out.println("空数组");
            return -1;
        }

    }

    public int getMinScore() {
        int min = getMaxScore();
        if (this.students != null) {
            for (Student student : this.students) {
                min = student.getScore() < min ? student.getScore() : min;
            }
            return min;
        } else {
            System.out.println("空数组");
            return -1;
        }
    }

    public float getAverageScore() {
        float sum = 0;
        if (this.students == null) {
            System.out.println("空数组");
            return -1;
        } else {
            for (Student student : this.students) {
                sum += student.getScore();
            }
            return Float.parseFloat(String.format("%.2f", sum / this.students.length));
        }

    }

    //getStudentByMaxScore、getStudentByMinScore
    public Student getStudentByMaxScore() {
        int max = getMaxScore();
        if (max == -1) {
            System.out.println("空数组");
            return null;
        } else {
            for (Student student : this.students) {
                if (student.getScore() == max) {
                    return student.cloneme();
                }
            }
            System.out.println("异常");
            return null;
        }

    }

    public Student getStudentByMinScore() {
        int min = getMinScore();
        if (this.students == null) {
            System.out.println("空数组");
            return null;
        } else {
            for (Student student : this.students) {
                if (student.getScore() == min) {
                    return student.cloneme();
                }
            }
            System.out.println("异常");
            return null;
        }
    }

    //sort、reverse

    public void sort(int tp, int fx) {//倒序、逆序  id、成绩
        if (this.students != null) {
            for (int i = 0; i < this.students.length; i++) {
                for (int j = 0; j < this.students.length - i - 1; j++) {
if (tp == 1 ? sortById(this.students[j], this.students[j + 1], fx == 1) : sortById(this.students[j], this.students[j + 1], fx == 2) ||
        tp == 2 ? sortByScore(this.students[j], this.students[j + 1], fx == 1) : sortByScore(this.students[j], this.students[j + 1], fx == 2)) {
    Student a = this.students[j].cloneme();
    this.students[j] = this.students[j + 1];
    this.students[j + 1] = a;
}
                }
            }
        } else {
            System.out.println("数组为空");
        }
    }

    private boolean sortById(Student a, Student b, boolean d) {
        return d ? a.getId() < b.getId() : a.getId() > b.getId();
    }

    private boolean sortByScore(Student a, Student b, boolean d) {
        return d ? a.getScore() < b.getScore() : a.getScore() > b.getScore();
    }

    public void reverse() {
        if (this.students != null) {
            for (int min = 0, max = this.students.length - 1; min < max; min++, max--) {
                Student student = this.students[min].cloneme();
                this.students[min] = this.students[max];
                this.students[max] = student;
            }
        } else {
            System.out.println("数组为空");
        }

    }
}

class Student {
    private int id;
    private String name;
    private int score;
    private String sex;

    public Student(int id, String name, int score, String sex) {
        this.id = id;
        this.name = name;
        this.score = score;
        this.sex = sex;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
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
                "id=" + id +
                ", name='" + name + '\'' +
                ", score=" + score +
                ", sex='" + sex + '\'' +
                '}';
    }

    public Student cloneme() {
        return new Student(id, name, score, sex);
    }
}