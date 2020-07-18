package homework1;

import java.text.ParseException;
import java.util.Date;

public class Student {
    static int ids = 0;//静态变量
    private Integer id;
    private String name;
    private String password;
    private Integer sex;
    private Date birthday;
    private Integer score;

    public Student(String name, String password, String sex, String birthday, Integer score) throws ParseException {
        this.id = ++ids;
        this.name = name;
        this.password = password;
        this.sex = Util.getSex(sex);
        this.birthday = Util.getDateByBirthday(birthday);
        this.score = score;
    }

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getPassword() {
        return password;
    }
    public void setPassword(String password) {
        this.password = password;
    }
    public Integer getScore() {
        return score;
    }
    public void setScore(Integer score) {
        this.score = score;
    }


    //Util工具修改的setter与getter
    public String getSex() {
        return Util.getSex(this.sex);
    }
    public void setSex(String sex) {
        this.sex = Util.getSex(sex);
    }
    public String getBirthday() {
        return Util.getStringByBirthday(birthday);
    }
    public void setBirthday(String birthday) throws ParseException {
        this.birthday = Util.getDateByBirthday(birthday);
    }

    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", password='" + password + '\'' +
                ", sex=" + sex +
                ", birthday=" + Util.getStringByBirthday(birthday) +
                ", score=" + score +
                '}' + "\t\t\t age=" + Util.getAge(birthday);
    }
}
