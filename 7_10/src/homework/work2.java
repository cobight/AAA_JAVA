package homework;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Scanner;

public class work2 {
    /*
    学生类：
            private String name；
            private Date birthday；
    工具类：
            增删改查
            年龄排序
    */
    public static void main(String[] args) throws ParseException {
        Tol tol = new Tol();
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("1、增；2、删；3、改；4、查；5、获取最年轻与最年长的教师；6、获取年龄的最大、最小与平均值；7、排序；8、展示；9、结束");
            int code = scanner.nextInt();
            if (code == 1) {
                System.out.print("增加 ： ");
                System.out.println("增加了 ： " + tol.insert(scanner.next(), scanner.next() + " " + scanner.next() + " " + scanner.next()));
            } else if (code == 2) {
                System.out.print("删除的下标 ： ");
                System.out.println("删除了 ：" + tol.delete(scanner.nextInt()));
            } else if (code == 3) {
                System.out.print("修改 （name,newName,birth）： ");
                System.out.println("修改了 : " + tol.chenge(scanner.next(), scanner.next(), scanner.next() + " " + scanner.next() + " " + scanner.next()));
            } else if (code == 4) {
                System.out.print("查询的名字 ： ");
                System.out.println(tol.select(scanner.next()));
            } else if (code == 5) {
                System.out.println("年长的 ： " + tol.getOld());
                System.out.println("年轻的 ： " + tol.getYoung());
            } else if (code == 6) {
                System.out.println("MAX : " + tol.getMax());
                System.out.println("MIN : " + tol.getMin());
                System.out.println("AVG : " + tol.getAverage());
            } else if (code == 7) {
                tol.sort();
            } else if (code == 8) {
                tol.showall();
            } else if (code == 9) {
                return;
            } else {
                System.out.println("错误操作码！");
            }
        }
    }
}

class Tol {
    private Teacher[] teachers;

    {//静态代码块 本来是  static{   ,可以简写为{
        try {
            insert("老1", "1991 01 22");
            insert("老2", "1950 01 22");
            insert("老3", "1945 01 22");
            insert("老4", "1955 01 22");
            insert("老5", "1999 01 22");
            insert("老6", "1920 01 22");
        } catch (ParseException e) {
            e.printStackTrace();
        }
    }

    public Teacher insert(String name, String birthday) throws ParseException {
        if (this.teachers == null && birthday != null) {
            this.teachers = new Teacher[1];
            this.teachers[0] = new Teacher(name, birthday);
            return this.teachers[0].cloneme();
        } else if (this.teachers != null && birthday != null) {
            Teacher[] clone = this.teachers.clone();
            this.teachers = new Teacher[this.teachers.length + 1];
            for (int i = 0; i < clone.length; i++) {
                this.teachers[i] = clone[i];
            }
            this.teachers[this.teachers.length - 1] = new Teacher(name, birthday);
            return this.teachers[this.teachers.length - 1].cloneme();
        } else {
            return null;
        }

    }

    public Teacher delete(int index) throws ParseException {
        if (index >= 0 && index < this.teachers.length) {
            Teacher retn = this.teachers[index].cloneme();
            Teacher[] clone = this.teachers.clone();
            this.teachers = new Teacher[this.teachers.length - 1];
            for (int i = 0; i < index; i++) {
                this.teachers[i] = clone[i];
            }
            for (int i = index; i < clone.length - 1; i++) {
                this.teachers[i] = clone[i + 1];
            }
            return retn;
        } else {
            return null;
        }
    }

    public Teacher chenge(String name, String newName, String birthday) throws ParseException {
        int index = getIndexByName(name);
        if (index > -1) {
            this.teachers[index] = new Teacher(newName, birthday);
            return this.teachers[index].cloneme();
        } else {
            return null;
        }
    }

    public Teacher select(String name) throws ParseException {
        int index = getIndexByName(name);
        if (index > -1) {
            return this.teachers[index].cloneme();
        } else {
            return null;
        }
    }

    public int getIndexByName(String name) {
        for (int i = 0; i < this.teachers.length; i++) {
            if (this.teachers[i].getName().equals(name)) {
                return i;
            }
        }
        return -1;
    }

    public Teacher getOld() throws ParseException {
        Teacher max = this.teachers[0];
        for (int i = 0; i < this.teachers.length; i++) {
            max = max.breathTime() < this.teachers[i].breathTime() ? this.teachers[i] : max;
        }
        return max.cloneme();
    }

    public Teacher getYoung() throws ParseException {
        Teacher min = getOld();
        for (int i = 0; i < this.teachers.length; i++) {
            min = min.breathTime() > this.teachers[i].breathTime() ? this.teachers[i] : min;
        }
        return min.cloneme();
    }

    public int getMax() throws ParseException {
        return getOld().getage();
    }

    public int getMin() throws ParseException {
        return getYoung().getage();
    }

    public Float getAverage() {
        double sum = 0;
        for (int i = 0; i < this.teachers.length; i++) {
            sum += this.teachers[i].getage();
        }
        return Float.parseFloat(String.format("%.2f", sum / this.teachers.length));
    }

    public void sort() {
        for (int i = 0; i < this.teachers.length; i++) {
            for (int j = 0; j < this.teachers.length - 1 - i; j++) {
                if (this.teachers[j].breathTime() > this.teachers[j + 1].breathTime()) {
                    Teacher a = this.teachers[j];
                    this.teachers[j] = this.teachers[j + 1];
                    this.teachers[j + 1] = a;
                }
            }
        }
    }

    public void showall() {
        for (Teacher teacher : this.teachers) {
            System.out.println(teacher);
        }
    }
}

class Teacher {
    private String name;
    private Date birthday;

    public Teacher(String name, String birthday) throws ParseException {
        this.name = name;
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy MM dd");
        this.birthday = sdf.parse(birthday);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getBirthday() {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy MM dd");

        return sdf.format(this.birthday);
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public int getage() {
        Calendar calendar = Calendar.getInstance();
        int nowYear = calendar.get(Calendar.YEAR);
        calendar.setTime(this.birthday);
        int birthYear = calendar.get(Calendar.YEAR);
        return (nowYear - birthYear);
    }

    public long breathTime() {
        Calendar calendar = Calendar.getInstance();
        long now = calendar.getTimeInMillis();
        calendar.setTime(this.birthday);
        long birth = calendar.getTimeInMillis();
        return (now - birth);
    }

    @Override
    public String toString() {

        return "Teacher{" +
                "name='" + name + '\'' +
                ", age=" + getage() +
                '}';
    }

    public Teacher cloneme() throws ParseException {
        return new Teacher(name, getBirthday());
    }
}