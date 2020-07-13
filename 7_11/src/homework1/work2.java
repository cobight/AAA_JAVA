package homework1;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class work2 {
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
    public static void main(String[] args) throws ParseException {
        Tools tools = new Tools();
        tools.insert(new Student("老八","1550 12 13",50));
        tools.delete(0);
        tools.change("老二",new Student("小王","1560 11 5",20));
        System.out.println(tools.select("小王"));
        tools.sort(1,2);
        System.out.println("==================");
        tools.showAll();

    }
}
class Tools{
    private Student[] students;
    {
        try {
            insert(new Student("老大","1998 01 22",60));
            insert(new Student("老二","1958 01 22",70));
            insert(new Student("老三","1935 01 22",50));
            insert(new Student("老四","1999 01 22",80));
        } catch (ParseException e) {
            e.printStackTrace();
        }
    }

    public void insert(Student student){
        if (this.students == null && student!=null){
            this.students = new Student[1];
            this.students[0] = student;
            System.out.println(student);
        }else if (this.students!=null && student!=null){
            Student[] clone = this.students.clone();
            this.students = new Student[this.students.length+1];
            for (int i = 0; i < clone.length; i++) {
                this.students[i] = clone[i];
            }
            this.students[this.students.length-1] = student;
            System.out.println(student);
        }else {
            System.out.println("insert err");
        }
    }
    public void delete(int index){
        System.out.println(this.students[index]);
        Student[] clone = this.students.clone();
        this.students = new Student[this.students.length-1];
        for (int i = 0; i < index; i++) {
            this.students[i] = clone[i];
        }
        for (int i = index; i < this.students.length; i++) {
            this.students[i] = clone[i+1];
        }

    }
    public void change(String name ,Student student) throws ParseException {
        int index = getIndexByName(name);
        this.students[index] = student.cloneMe();
    }
    public Student select(String name) throws ParseException {
        int index = getIndexByName(name);
        return this.students[index].cloneMe();
    }

    private boolean typer(Student a,Student b,int key,int value){
        if (key ==1){
            return value==1?a.getAge()>b.getAge():a.getAge()<b.getAge();
        }else if (key==2){
            return value==1?a.getScore()>b.getScore():a.getScore()<b.getScore();
        }else return false;

    }
    public void sort(int key ,int value){
        for (int i = 0; i < this.students.length; i++) {
            for (int j = 0; j < this.students.length-1-i; j++) {
                if (typer(this.students[j],this.students[j+1],key,value)){
                    Student a = this.students[j];
                    this.students[j] = this.students[j+1];
                    this.students[j+1] = a;
                }
            }
        }
    }
    public void showAll(){
        for (int i = 0; i < this.students.length; i++) {
            System.out.println(this.students[i]);
        }
    }

    private int getIndexByName(String name){
        for (int i = 0; i < this.students.length; i++) {
            if (this.students[i].getName().equals(name)){
                return i;
            }
        }
        return -1;
    }
}
class Student{
    private String name;
    private Date birthday;
    private int score;
    SimpleDateFormat sdf = new SimpleDateFormat("yyyy MM dd");

    public Student(String name, String birthday, int score) throws ParseException {

        this.name = name;
        this.birthday = sdf.parse(birthday);
        this.score = score;
    }
    public int getAge(){
        Calendar calendar = Calendar.getInstance();
        long now = calendar.getTimeInMillis();
        calendar.setTime(birthday);
        long birth = calendar.getTimeInMillis();
        return (int) ((now-birth)/1000/60/60/24/365);
    }
    public Student cloneMe() throws ParseException {
        return new Student(name,sdf.format(birthday),score);
    }
    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", birthday=" + sdf.format(birthday) +
                ", score=" + score +
                '}' + getAge();
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
