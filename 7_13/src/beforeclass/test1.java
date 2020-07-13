package beforeclass;

import javax.tools.Tool;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Scanner;

public class test1 {
    public static void main(String[] args) throws ParseException {
        Tools tools = new Tools();
        Scanner scanner = new Scanner(System.in);
        tools.insert("老大","19980122",50);
        tools.insert("老二","19880122",60);
        tools.insert("老三","19780122",90);
        tools.insert("老四","19970122",40);
//        tools.delete(1);
//        tools.change("老大","老八","19580305",100);
//        tools.select("老八");
//        tools.sort();
//        tools.Average();
        while (true){
            System.out.println("1、增；2、删；3、改；4、查；5、排序-->最大最小值平均值;6、跳出");
            int code = scanner.nextInt();
            if (code==1){
                System.out.print("insert : ");
                tools.insert(scanner.next(),scanner.next(),scanner.nextInt());
            }else if (code==2){
                System.out.print("delete : ");
                tools.delete(scanner.nextInt());
            }else if (code==3){
                System.out.print("change : ");
                tools.change(scanner.next(),scanner.next(),scanner.next(),scanner.nextInt());
            } else if (code==4) {
                System.out.print("select : ");
                tools.select(scanner.next());
            }else if (code==5){
                tools.sort();
                tools.Average();
            }else {
                return;
            }

        }
    }
}
class Tools{
    private Student[] students= new Student[11];
    public int length = 0;

    public void insert(String name,String birthday,int score) throws ParseException {
        students[length++] = new Student(name,birthday,score);
        System.out.println(students[length-1]);
    }
    public void delete(int index){
        if (length>0 && length<10){
            System.out.println(students[index]);
            for (int i = index; i < length; i++) {
                students[i] = students[i+1];
            }
            length--;
        }
    }
    public void change(String name,String newname,String birthday,int score) throws ParseException {
        int index = getIndexByName(name);
        if (index>-1){
            students[index].setName(newname);
            students[index].setBirthday(birthday);
            students[index].setScore(score);
            System.out.println(students[index]);
        }else {
            System.out.println("change err");
        }
    }
    public void select(String name){
        int index = getIndexByName(name);
        if (index>-1){
            System.out.println(students[index]);
        }else {
            System.out.println("select err");
        }
    }

    private int getIndexByName(String name){
        for (int i = 0; i < length; i++) {
            if (students[i].getName().equals(name)){
                return i;
            }
        }
        return -1;
    }


    public void sort(){

        for (int i = 0; i < length; i++) {
            for (int j = 0; j < length-1-i; j++) {
                if (students[j].getAge()>students[j+1].getAge()){
                    Student a = students[j];
                    students[j] = students[j+1];
                    students[j+1] = a;
                }
            }
        }
        System.out.println("min:" +students[0]);
        System.out.println("max:" + students[length-1]);
    }
    public void Average(){
        float sum=0;
        for (int i = 0; i < length; i++) {
            sum+=students[i].getScore();
        }
        System.out.println("Average  : "+Float.parseFloat(String.format("%.2f", sum / length)));
    }


}
class Student{
    private String name;
    private Date birthday;
    private int score;
    private SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
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
    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", birthday=" + sdf.format(birthday) +
                ", score=" + score +
                '}';
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

    public void setBirthday(String birthday) throws ParseException {
        this.birthday = sdf.parse(birthday);
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }
}