package cn;

import java.lang.annotation.Target;

public class Teacher_demo2 {
    public static void main(String[] args) {
        /*
        * 增删改查
        * 遍历循环
        * 每个演示
        * */
        //增
        Teacher_tool tool = new Teacher_tool();
        tool.insert(new Teacher("老大",1,"boy"));
        tool.insert(new Teacher("老二",1,"boy"));
        tool.insert(new Teacher("老三",1,"girl"));
        tool.insert(new Teacher("老四",1,"boy"));
        //删
//        System.out.println(tool.delete(0));
//        System.out.println("*****************");
//        tool.forshow();
//        System.out.println(tool.getindexbyname("老二"));
        //改
//        System.out.println(tool.change("老三",new Teacher("a",1,"girl")));
//        System.out.println("************");
//        tool.forshow();
        System.out.println(tool.select("老四"));
    }
}
class Teacher_tool{
    Teacher[] teachers;
    //初始化数据
    public Teacher_tool() {
        this.teachers=null;
    }
    //增
    public Teacher insert(Teacher teacher){
        if (this.teachers == null){
            this.teachers = new Teacher[1];
            this.teachers[0] = teacher;
            //准备个相同的数据，地址却不一样，这样操作时互相不影响
            return teacher.cloneme();
        }else {
            //数组 数据备份
            Teacher[] clone = this.teachers.clone();
            //开辟一个更大的空间的数组
            this.teachers = new Teacher[clone.length+1];
            for (int i = 0; i < clone.length; i++) {
                this.teachers[i] = clone[i];
            }
            this.teachers[this.teachers.length-1] = teacher;
            return teacher.cloneme();
        }
    }
    //删
    public Teacher delete(int index){
        //通过下标删
        if (this.teachers!=null && this.teachers.length==1){
            Teacher retn = this.teachers[0].cloneme();
            this.teachers=null;
            return retn;
        }else if (this.teachers != null && index >=0 && index < this.teachers.length){
            //准备好返回数据
            Teacher retn = this.teachers[index].cloneme();
            //准备个新数组，比原来的小1
            Teacher[] newarr = new Teacher[this.teachers.length-1];
            for (int i = 0; i < index; i++) {
                newarr[i] = this.teachers[i];
            }
            for (int i = index; i < newarr.length; i++) {
                newarr[i] = this.teachers[i+1];
            }
            this.teachers = newarr;
            return retn;
        }else {
            return null;
        }
    }
    public Teacher delete(String name){
        //通过名字删
        int index = getindexbyname(name);
        //下标是否异常上面的delete方法里写了，这里不重复代码了
        return delete(index);
    }
    //改
    public Teacher change(int index,Teacher teacher){
        //通过下标改
        if (this.teachers!=null && index>=0 && index < this.teachers.length){
            this.teachers[index] = teacher;
            return this.teachers[index].cloneme();
        }else {
            return null;
        }
    }
    public Teacher change(String name,Teacher teacher){
        int index = getindexbyname(name);
        return change(index,teacher);
    }
    //查
    public Teacher select(int index){
        //通过下标直接查
        if (this.teachers != null && index >=0 && index <this.teachers.length){
            return this.teachers[index].cloneme();
        }else {
            return null;
        }
    }
    public Teacher select(String name){
        //先定位下标，再查
        int index = getindexbyname(name);
        //下标判断就不代码重复了
        return select(index);
    }

    //通过名字定位下标
    public int getindexbyname(String name){
        for (int i = 0; i < this.teachers.length; i++) {
            if (this.teachers[i]!=null && this.teachers[i].getName().equals(name)){
                return i;
            }
        }
        return -1;
    }

    //展示所有数据
    public void forshow(){
        for (Teacher t : this.teachers){
            System.out.println(t);
        }
    }
}
class Teacher{
    private String name;
    private int age;
    private String sex;

    public Teacher(String name, int age, String sex) {
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
        return "Teacher{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", sex='" + sex + '\'' +
                '}';
    }
    public Teacher cloneme(){
        //新开辟个地址，数据不变
        return new Teacher(name,age,sex);
    }
}