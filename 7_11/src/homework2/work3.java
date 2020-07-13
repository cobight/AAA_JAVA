package homework2;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class work3 {
    public static void main(String[] args) throws ParseException {
        Tools tools = new Tools();
        tools.insert("老大", "1988 01 22", 60);
        tools.insert("老二", "1950 01 22", 40);
        tools.insert("老三", "1998 01 22", 20);
        tools.insert("老四", "1920 01 22", 30);
        tools.insert("老五", "2000 01 22", 80);
        System.out.println("delete : " + tools.delete("老二"));
        tools.change("老四", "老八", "1953 02 03", 50);
        tools.select("老三");
        System.out.println("==========ID排序从小到大=========");
        tools.sort(1, 1);
        tools.showAll();
        System.out.println("==========年龄排序从大到小=========");
        tools.sort(2, 2);
        tools.showAll();
        System.out.println("==========成绩排序从小到大=========");
        tools.sort(3, 1);
        tools.showAll();
    }
}

class Tools {
    private Student[] students = new Student[10];
    public int length = 0;//记录数组长度
    private SimpleDateFormat sdf = new SimpleDateFormat("yyyy MM dd");
        //增
    public boolean insert(String name, String birthday, int score) throws ParseException {
        if (length < 10) {
            this.students[length++] = new Student(name, birthday, score);
            return true;
        } else {//满了
            return false;
        }
    }
        //删
    public Student delete(String name) {
        int index = getIndexByName(name);
        if (index > -1) {
            Student retn = this.students[index];
            for (int i = index; i < this.length; i++) {
                this.students[i] = this.students[i + 1];
            }
            length--;
            return retn;
        } else {
            return null;
        }
    }
        //改
    public boolean change(String name, String newname, String birthday, int score) throws ParseException {
        int index = getIndexByName(name);
        if (index > -1) {
            this.students[index].setName(newname);
            this.students[index].setBirthday(birthday);
            this.students[index].setScore(score);
            return true;
        } else {
            return false;
        }
    }
        //查
    public Student select(String name) {
        int index = getIndexByName(name);
        if (index > -1) {
            return this.students[index];
        } else {
            return null;
        }
    }
        //排序方式方法  的判断
    private boolean typer(Student a, Student b, int key, int value) {
        //控制排序类型
        //      key控制按什么排序
        //      value控制正序倒序
        if (key == 1) {
            return value == 1 ? a.getId() > b.getId() : a.getId() < b.getId();
        } else if (key == 2) {
            return value == 1 ? a.getAge() > b.getAge() : a.getAge() < b.getAge();
        } else if (key == 3) {
            return value == 1 ? a.getScore() > b.getScore() : a.getScore() < b.getScore();
        } else {
            return false;
        }
    }
        //排序
    public boolean sort(int key, int value) {
        if (this.length > 0 && key > 0 && value > 0) {
            for (int i = 0; i < this.length; i++) {
                for (int j = 0; j < this.length - 1 - i; j++) {
                    if (typer(this.students[j], this.students[j + 1], key, value)) {
                        Student a = this.students[j];
                        this.students[j] = this.students[j + 1];
                        this.students[j + 1] = a;
                    }
                }
            }
            return true;
        } else {
            return false;
        }
    }
        //遍历所有
    public void showAll() {
        if (this.length > 0) {
            for (int i = 0; i < this.length; i++) {
                System.out.println(this.students[i]);
            }
        }
    }
        //通过name  获取下标
    private int getIndexByName(String name) {
        for (int i = 0; i < this.length; i++) {
            if (this.students[i].getName().equals(name)) {
                return i;
            }
        }
        return -1;
    }
}
    //学生类
class Student {
    private int id;
    private String name;
    private Date birthday;
    private int score;
    private static int index = 0;
    private SimpleDateFormat sdf = new SimpleDateFormat("yyyy MM dd");

    public Student(String name, String birthday, int score) throws ParseException {
        id = ++index;
        this.name = name;
        this.birthday = sdf.parse(birthday);
        this.score = score;
    }

    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", birthday=" + sdf.format(birthday) +      //date转string
                ", score=" + score +
                '}' + "\t\tage：" +getAge();
    }

    public int getAge() {
        Calendar calendar = Calendar.getInstance();
        long now = calendar.getTimeInMillis();
        calendar.setTime(birthday);
        long birth = calendar.getTimeInMillis();
        return (int) ((now - birth) / 1000 / 60 / 60 / 24 / 365);

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

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(String birthday) throws ParseException {
        this.birthday = sdf.parse(birthday);            //string转date
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }
}