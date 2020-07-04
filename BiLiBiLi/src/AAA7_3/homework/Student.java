package AAA7_3.homework;

public class Student {
    String name;
    int id;
    String sex;

    public Student(String name, int id, String sex) {
        this.name = name;
        this.id = id;
        this.sex = sex;
    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", id=" + id +
                ", sex='" + sex + '\'' +
                '}';
    }

    public Student cloneme(){

        return new Student(this.name,this.id,this.sex);
    }
}
