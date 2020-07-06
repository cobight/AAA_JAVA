package cn;

public class Student_demo1 {
    public static void main(String[] args) {
        Student_tools tools = new Student_tools();
        tools.insert(new Student("老大",10,"boy"));
        tools.insert(new Student("老二",11,"girl"));
        tools.insert(new Student("老三",12,"boy"));
        tools.insert(new Student("老四",13,"boy"));
        tools.insert(new Student("老五",14,"girl"));
        tools.insert(new Student("老六",15,"boy"));
//        tools.forshow();
//        System.out.println(tools.delete(0));
//        System.out.println("*************");
//        tools.forshow();
//        System.out.println(tools.get_index_by_name("老三"));
//        System.out.println(tools.change("老大",new Student("name",1,"bb")));
//        tools.forshow();
        System.out.println(tools.select("老大"));

    }
}
class Student_tools{
    Student[] students;
    //初始化数据
    public Student_tools() {
        this.students = null;
    }
    public Student_tools(Student[] students) {
        this.students = students;
    }
    //增
    public Student insert(Student student){
        if (this.students == null && student != null){
            this.students = new Student[1];
            this.students[0] = student;
            return student.cloneme();
        }else if (student != null){
            //备份数据
            Student[] clone = this.students.clone();
            //开辟新空间
            this.students = new Student[clone.length+1];
            //原数据归为
            for (int i = 0; i < clone.length; i++) {
                this.students[i] = clone[i];
            }
            //新数据归为
            this.students[this.students.length-1] = student;
            return student.cloneme();
        }else {
            return null;
        }
    }
    //删
    public Student delete(int index){
        if (index >=0 && index <this.students.length){
            //准备返回的数据
            Student retn = this.students[index].cloneme();
            //准备一个新长度的数组
            Student[] newarr = new Student[this.students.length-1];
            //两个for放数据
            for (int i = 0; i < index; i++) {
                newarr[i] = this.students[i];
            }
            for (int i = index; i < newarr.length; i++) {
                newarr[i] = this.students[i+1];
            }
            this.students = newarr;
            return retn;
        }else {
            return null;
        }

    }
    public Student delete(String name){
        int index = get_index_by_name(name);
        delete(index);
        return null;
    }
    //改
    public Student change(int index,Student student){
        //直接拿下标改
        if (index >=0 && index <= this.students.length){
            this.students[index] = student;
            return student.cloneme();
        }else {
            return null;
        }
    }
    public Student change(String name,Student student){
        int index = get_index_by_name(name);
        Student stu = change(index,student);
        return stu;
    }
    //查
    public Student select(int index){
        //通过下标查
        if (index>=0 && index<this.students.length){
            return this.students[index].cloneme();
        }else {
            return null;
        }
    }
    public Student select(String name){
        //先通过名字拿下标，然后再查
        int index = get_index_by_name(name);
        //下标判断上面写了，没必要重复，哪怕传进去-1也无妨
        Student stu = select(index);
        return stu;
    }
    //通过名字获取下标:找不到返回-1
    public int get_index_by_name(String name){
        for (int i = 0; i < this.students.length; i++) {
            if (this.students[i].getName().equals(name)){
                return i;
            }
        }
        return -1;
    }
    //显示全部
    public void forshow(){
        if (this.students != null){
            for (Student s : this.students){
                System.out.println(s);
            }
        }
    }
}

class Student{
    private String name;
    private int age;
    private String sex;

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