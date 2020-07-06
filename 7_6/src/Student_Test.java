public class Student_Test {
    public static void main(String[] args) {

    }
}
class Student_tools{
    Student[] students;
    //数组初始化
    public Student_tools() {
        students = null;
    }
    public Student_tools(Student[] students) {
        if (students != null){
            this.students = students;
        }
    }
    //增加
    public Student insert(Student student){
        if (this.students == null && student != null){
            this.students = new Student[1];
            this.students[0] = student;
            return student.cloneme();
        }else if (student!=null){
            Student[] clone = this.students.clone();//备份数组
            this.students = new Student[clone.length+1];//开辟更大的数组空间
            for (int i=0;i<clone.length;i++){//原数据归位
                this.students[i] = clone[i];
            }
            this.students[this.students.length-1] = student;//新数据归位
            return student.cloneme();
        }else {
            return null;
        }
    }

}
class Student{
    private String name;
    private int age;
    private String sex;

    public Student() {
    }

    public Student(String name, int age, String sex) {
        this.name = name;
        this.age = age;
        this.sex = sex;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
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
                "name='" + name + '\'' +
                ", age=" + age +
                ", sex='" + sex + '\'' +
                '}';
    }
    public Student cloneme(){
        return new Student(name,age,sex);
    }
}
