package AAA7_3.homework;

public class StuManager {
    public static void main(String[] args){
        Stu_tools stu_tools = new Stu_tools();
        stu_tools.insert(new Student("老大", 29, "boy"));
        stu_tools.insert(new Student("老二", 30, "girl"));
        stu_tools.insert(new Student("老三", 25, "boy"));
        stu_tools.insert(new Student("老四", 29, "boy"));
        stu_tools.insert(new Student("老五", 31, "girl"));
        stu_tools.insert(new Student("老六", 23, "boy"));

        stu_tools.change(1, new Student("冯浩", 18, "boy"));
//        Student st = stu_tools.select("冯浩");
        System.out.println(stu_tools.delete("老大"));
        System.out.println("******来吧，展示******");
        stu_tools.forshow();
    }
}

class Stu_tools {
    private Student[] student;

    public Stu_tools() {
        student = null;
    }

    public Stu_tools(Student[] student) {
        this.student = student.clone();
    }
    //插入
    public void insert(Student student) {
        if (this.student == null) {
            this.student = new Student[1];
            this.student[0] = student;
        } else {
            Student[] clone = this.student.clone();
            this.student = new Student[this.student.length + 1];
            for (int i = 0; i < clone.length; i++) {
                this.student[i] = clone[i];
            }
            this.student[this.student.length - 1] = student;
        }
    }
    //修改
    public void change(int index, Student student) {
        if (index >= 0 && index < this.student.length) {
            this.student[index] = student;
        } else {
            System.out.println("超了!!!!");
        }
    }
    //name查询
    public Student select(String name) {
        for (Student stu : this.student) {
            if (stu.name.equals(name)) {
                return stu;
            }
        }
        return null;
    }
    //删除
    public Student delete(int index){
        Student retn = null;
        if (this.student==null){
            System.out.println("空的还TM删？");
        }else if(this.student.length==1){
            this.student=null;
        }else {
            retn = this.student[index].cloneme();
            Student[] reput = new Student[this.student.length-1];
            for (int j = 0; j < index; j++) {
                reput[j] = this.student[j];
            }
            for (int i = index; i < this.student.length-1; i++) {
                reput[i] = this.student[i+1];
            }
            this.student = reput;
//            this.student[this.student.length-1]=null;
        }
        return retn;
    }
    public Student delete(String name){
        Student retn =null;
        int index = -1;
        for (int i = 0; i < this.student.length; i++) {
            if (this.student[i].name.equals(name)){
                index = i;
            }
        }
        if (index == -1){
            System.out.println("没找到");
            return retn;
        }else {
            return delete(index);
        }
    }
    //循环遍历展示
    public void forshow() {
        if(this.student==null){
            System.out.println("空学生数组");
        }else {
            for (Student stu : student) {
                System.out.println(stu);
            }
        }

    }
}