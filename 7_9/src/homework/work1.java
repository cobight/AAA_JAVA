package homework;


import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Scanner;

public class work1 {
    /*
    学生类：
            private String name；
            private Date birthday；
    工具类：
            增删改查
            年龄排序
    */
    public static void main(String[] args) throws ParseException {
        Tools tools = new Tools();
        Scanner scanner = new Scanner(System.in);
        String[] msg = {scanner.next(),scanner.next(),scanner.next(),scanner.next()};
        System.out.println(tools.insert(msg[0], msg[1] + " " + msg[2] + " " + msg[3]));

//        tools.sort();
//        tools.showall();
    }
}

class Tools {
    private Student[] students;

    {
        try {
            System.out.println("插入了一个学生 ：" + insert("老大", "1998 01 22"));
            System.out.println("插入了一个学生 ：" + insert("老二", "1997 12 13"));
            System.out.println("插入了一个学生 ：" + insert("老三", "1995 08 22"));
            System.out.println("插入了一个学生 ：" + insert("老4", "1994 01 22"));
            System.out.println("插入了一个学生 ：" + insert("老5", "1985 12 13"));
            System.out.println("插入了一个学生 ：" + insert("老6", "1994 08 22"));
            System.out.println("插入了一个学生 ：" + insert("老7", "1996 01 22"));
            System.out.println("插入了一个学生 ：" + insert("老8", "1997 12 13"));
            System.out.println("插入了一个学生 ：" + insert("老9", "1992 08 22"));

        } catch (ParseException e) {
            e.printStackTrace();
        }
    }

    public Student insert(String name, String birthday) throws ParseException {
        if (this.students == null && name != null && birthday != null) {
            this.students = new Student[1];
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy MM dd");
//            System.out.println(sdf.parse(birthday));
            this.students[0] = new Student(name, sdf.parse(birthday));
            return this.students[0].cloneme();
        } else if (name != null && birthday != null) {
            Student[] clone = this.students.clone();
            this.students = new Student[this.students.length + 1];
            for (int i = 0; i < clone.length; i++) {
                this.students[i] = clone[i];
            }
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy MM dd");
//            System.out.println(sdf.parse(birthday));
            this.students[this.students.length - 1] = new Student(name, sdf.parse(birthday));
            return this.students[this.students.length - 1].cloneme();
        } else {
            return null;
        }
    }

    public Student delete(int index) {
        if (index >= 0 && index < this.students.length) {
            Student retn = this.students[index].cloneme();
            Student[] clone = this.students.clone();
            this.students = new Student[this.students.length - 1];
            for (int i = 0; i < index; i++) {
                this.students[i] = clone[i];
            }
            for (int i = index; i < clone.length; i++) {
                this.students[i] = clone[i + 1];
            }
            return retn;
        } else {
            return null;
        }
    }

    public Student change(String name, String newName, String birthday) throws ParseException {
        int index = getIndexByName(name);
        if (index > -1) {
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy MM dd");
            this.students[index] = new Student(newName, sdf.parse(birthday));
            return this.students[index].cloneme();
        } else {
            return null;
        }
    }

    public Student select(String name) {
        int index = getIndexByName(name);
        if (index > -1) {
            return this.students[index].cloneme();
        } else {
            return null;
        }
    }

    public int getIndexByName(String name) {
        for (int i = 0; i < this.students.length; i++) {
            if (this.students[i].getName().equals(name)) {
                return i;
            }
        }
        return -1;
    }

    public void sort() {
        for (int i = 0; i < this.students.length; i++) {
            for (int j = 0; j < this.students.length - 1 - i; j++) {
                if (this.students[j].getlivesecond() < this.students[j + 1].getlivesecond()) {
                    Student a = this.students[j];
                    this.students[j] = this.students[j + 1];
                    this.students[j + 1] = a;
                }
            }
        }
    }

    public void showall() {
        for (int i = 0; i < this.students.length; i++) {
            System.out.println(this.students[i]);
        }
    }
}

class Student {
    private String name;
    private Date birthday;

    public Student(String name, Date birthday) {
        this.name = name;
        this.birthday = birthday;
//        System.out.println(this.birthday);
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

    @Override
    public String toString() {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(this.birthday);
        int birthYear = calendar.get(Calendar.YEAR);
//        System.out.println(birthYear);
        Calendar s = Calendar.getInstance();
        int nowYear = s.get(Calendar.YEAR);
        return "Student{" +
                "name='" + name + '\'' +
                ", age=" + (nowYear - birthYear) +
                '}';
    }

    public Student cloneme() {
        return new Student(name, birthday);
    }

    public long getlivesecond() {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(this.birthday);
        return calendar.getTimeInMillis();
    }
}