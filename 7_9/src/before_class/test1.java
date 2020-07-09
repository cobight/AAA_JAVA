package before_class;

import java.util.Arrays;
import java.util.Scanner;

public class test1 {
    public static void main(String[] args) {
        tools t=new tools();
        Scanner scanner = new Scanner(System.in);
        t.insert(new Student(1,"老大",100,"boy"));
        t.insert(new Student(2,"老二",50,"boy"));
        t.insert(new Student(3,"老三",80,"boy"));
        while (true){
            System.out.println("1、增；2、删；3改；4、查；5、各分值;6、遍历");
            int code = scanner.nextInt();
            if (code==1){
                System.out.println("请输入增加的学生数据");
                t.insert(new Student(scanner.nextInt(),scanner.next(),scanner.nextInt(),scanner.next()));
            }else if (code==2){
                System.out.println("请输入删除的学生下标");
                t.delete(scanner.nextInt());
            }else if (code==3){
                System.out.println("请输入修改的学生下标+修改的新数据");
                t.chenge(scanner.nextInt(),new Student(scanner.nextInt(),scanner.next(),scanner.nextInt(),scanner.next()));
            }else if (code==4){
                System.out.println("请输入查询的学生下标");
                System.out.println(t.select(scanner.nextInt()));
            }else if (code==5){
                System.out.println(t.getmaxscore());
                System.out.println(t.getminscore());
                System.out.println(t.getaverage());
            }else if (code==6){
                t.forshow();
            }else {
                System.out.println("err code");
            }
        }
    }
}

class tools {
    Student[] students;

    public void insert(Student student) {
        if (this.students == null && student != null) {
            this.students = new Student[1];
            this.students[0] = student;
            System.out.println("insert success");
        } else if (this.students != null && student != null) {
            Student[] clone = this.students.clone();
            this.students = new Student[clone.length + 1];
            for (int i = 0; i < clone.length; i++) {
                this.students[i] = clone[i];
            }
            this.students[this.students.length - 1] = student;
            System.out.println("insert success");
        } else {
            System.out.println("insert err");
        }
    }

    public void delete(int index) {
        if (index >= 0 && index < this.students.length) {
            Student[] clone = this.students.clone();
            this.students = new Student[this.students.length - 1];
            for (int i = 0; i < index; i++) {
                this.students[i] = clone[i];
            }
            for (int i = index; i < clone.length - 1; i++) {
                this.students[i] = clone[i + 1];
            }
            System.out.println("delete success");
        } else {
            System.out.println("delete err");
        }
    }

    public void chenge(int index, Student student) {
        if (index >= 0 && index < this.students.length && student != null) {
            this.students[index] = student;
            System.out.println("change success");
        } else {
            System.out.println("change err");
        }
    }

    public Student select(int index) {
        if (index >= 0 && index < this.students.length) {
            return this.students[index];
        } else {
            return null;
        }
    }
    public void forshow(){
        if (this.students!=null){
            for (int i=0;i<this.students.length;i++){
                System.out.println(this.students[i]);
            }
        }
    }
    public int getmaxscore(){
        if (this.students!=null){
            int max=0;
            for (int i = 0; i < this.students.length; i++) {
                max= (this.students[i].getScore()>max)?this.students[i].getScore():max;
            }
            return max;
        }else {
            return -1;
        }
    }
    public int getminscore(){
        if (this.students!=null){
            int min=getmaxscore();
            for (int i = 0; i < this.students.length; i++) {
                min= (this.students[i].getScore()<min)?this.students[i].getScore():min;
            }
            return min;
        }else {
            return -1;
        }
    }
    public float getaverage(){
        if (this.students!=null){
            float sum = 0;
            for (int i = 0; i < this.students.length; i++) {
                sum+=this.students[i].getScore();
            }
            return Float.parseFloat(String.format("%.2f", sum / this.students.length));
        }else {
            return -1;
        }
    }

}

class Student {
    private String name, sex;
    private int id, score;

    public Student(int id, String name, int score, String sex) {
        this.name = name;
        this.sex = sex;
        this.id = id;
        this.score = score;
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

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
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