package homework;

import org.omg.CORBA.PUBLIC_MEMBER;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Scanner;

/*
学生管理系统：
    学生类：
        private String name;
        private Date birthday;
        private int score;
    工具类：
        1、增删改查；
        2、成绩排序；
        3、年龄排序；
        4、遍历输出；
*/
public class work1 {
    static Scanner scanner = new Scanner(System.in);
    static Tool tool = new Tool();
    static SimpleDateFormat sdf = new SimpleDateFormat("yyyy MM dd");

    public static void main(String[] args) throws ParseException {
        try {
            tool.insert(new Student("老大",sdf.parse("1998 01 22"),80));
            tool.insert(new Student("老二",sdf.parse("1948 01 22"),90));
            tool.insert(new Student("老三",sdf.parse("1958 01 22"),20));
            tool.insert(new Student("老四",sdf.parse("1920 01 22"),60));
        } catch (ParseException e) {
            e.printStackTrace();
        }

        while (true){
            System.out.println("1、增加数据；2、删除数据；3、修改数据；4、查询数据；5、排序；6、遍历数据；7、获取最值;8、退出");
            int code = scanner.nextInt();
            if (code==1){//增
                System.out.print("请输入增加的数据：名字 出生年月日 成绩 （空格分开）：");
                System.out.println("insert : "+tool.insert(new Student(scanner.next(), sdf.parse(scanner.next() + " " + scanner.next() + " " + scanner.next()), scanner.nextInt())));
            }else if (code==2){//删
                System.out.print("请输入要删除的下标 ：");
                System.out.println("delete : "+tool.delete(scanner.nextInt()));
            }else if (code==3){//改
                System.out.println("请输入要修改的名字与新的数据【姓名,出生年月日,成绩】（空格分开）");
                System.out.println("修改后的数据 ： "+tool.upData(scanner.next(), new Student(scanner.next(), sdf.parse(scanner.next() + " " + scanner.next() + " " + scanner.next()), scanner.nextInt())));
            }else if (code==4) {//查
                System.out.print("请输入要查询的姓名 ： ");
                System.out.println(tool.select(scanner.next()));
            }else if (code==5){
                System.out.println("请输入排序的方式与方法(参数一：1-->年龄；2-->成绩；参数二：1-->正序；2-->倒序) ");
                tool.sort(scanner.nextInt(),scanner.nextInt());
                System.out.println("sort finished");
            }else if (code==6){
                tool.showAll();
            }else if(code==7){
                tool.getMaxMinAverage();
            }else if (code == 8){
                return;
            }else {
                System.out.println("err code");
            }
            System.out.println("=========================================");
        }
    }
}

class Tool {
    private Student[] students;


    //增
    public Student insert(Student info) {
        if (this.students == null) {
            this.students = new Student[1];
            this.students[0] = info;
            return this.students[0].cloneMe();
        } else {
            Student[] clone = this.students.clone();
            this.students = new Student[clone.length + 1];
            for (int i = 0; i < clone.length; i++) {
                this.students[i] = clone[i];
            }
            this.students[this.students.length - 1] = info;
            return this.students[this.students.length - 1].cloneMe();
        }
    }

    //删
    public Student delete(int index) {
        if (index >= 0 && index < this.students.length) {
            Student retn = this.students[index].cloneMe();
            Student[] clone = this.students.clone();
            this.students = new Student[this.students.length - 1];
            for (int i = 0; i < index; i++) {
                this.students[i] = clone[i];
            }

            for (int i = index; i < clone.length-1; i++) {
                this.students[i] = clone[i + 1];
            }
            return retn;
        } else {
            return null;
        }

    }

    //改
    public Student upData(String name, Student info) {
        int index = getIndexByName(name);
        if (index != -1) {
            this.students[index] = info;
            return info.cloneMe();
        } else {
            return null;
        }
    }

    //查
    public Student select(String name) {
        int index = getIndexByName(name);
        if (index != -1) {
            return this.students[index].cloneMe();
        } else return null;
    }

    //定位
    public int getIndexByName(String name) {
        if (this.students != null) {
            for (int i = 0; i < this.students.length; i++) {
                if (this.students[i].getName().equals(name)) {
                    return i;
                }
            }
            return -1;//没找到
        } else {
            return -1;//空数组
        }
    }

    //show
    public void showAll() {
        for (int i = 0; i < this.students.length; i++) {
            System.out.println(this.students[i]);
        }
    }

    //排序
    private boolean sortBy(Student a, Student b, int key, int value) {
        if (key == 1) {
            return value == 1 ? a.getAge() > b.getAge() : a.getAge() < b.getAge();
        } else if (key == 2) {
            return value == 1 ? a.getScore() > b.getScore() : a.getScore() < b.getScore();
        } else return false;
    }

    public void sort(int key, int value) {
        for (int i = 0; i < this.students.length; i++) {
            for (int j = 0; j < this.students.length - 1 - i; j++) {
                if (sortBy(this.students[j], this.students[j + 1], key, value)) {
                    Student a = this.students[j];
                    this.students[j] = this.students[j + 1];
                    this.students[j + 1] = a;
                }
            }
        }
    }

    public void getMaxMinAverage() {
        int MaxAge = this.students[0].getAge();
        int MinAge = this.students[0].getAge();

        int MaxScore = this.students[0].getScore();
        int MinScore = this.students[0].getScore();
        float sum = 0;
        float Average = 0;

        for (int i = 0; i < this.students.length; i++) {
            MaxAge = this.students[i].getAge() > MaxAge ? this.students[i].getAge() : MaxAge;
            MinAge = this.students[i].getAge() < MinAge ? this.students[i].getAge() : MinAge;

            MaxScore = this.students[i].getScore() > MaxScore ? this.students[i].getScore() : MaxScore;
            MinScore = this.students[i].getScore() < MinScore ? this.students[i].getScore() : MinScore;
            sum+=this.students[i].getScore();
        }
        Average = Float.parseFloat(String.format("%.2f", sum / this.students.length));
        System.out.println("最大年龄：" + MaxAge);
        System.out.println("最小年龄：" + MinAge);
        System.out.println("最高分：" + MaxScore);
        System.out.println("最低分：" + MinScore);
        System.out.println("平均分：" + Average);
    }
}

class Student {
    private String name;
    private Date birthday;
    private int score;

    public Student(String name, Date birthday, int score) {
        this.name = name;
        this.birthday = birthday;
        this.score = score;
    }

    public Student cloneMe() {
        return new Student(name, birthday, score);
    }

    public int getAge() {
        Calendar calendar = Calendar.getInstance();
        long now = calendar.getTimeInMillis();
        calendar.setTime(birthday);
        long birth = calendar.getTimeInMillis();
        return (int) ((now - birth) / 1000 / 60 / 60 / 24 / 365);
    }

    @Override
    public String toString() {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy MM dd");

        return "Student{" +
                "name='" + name + '\'' +
                ", birthday=" + sdf.format(birthday) + '\'' +
                ", score=" + score +
                '}' + "age=" + getAge();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }
}