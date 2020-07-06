public class before_class {
    public static void main(String[] args) {
//        Teacher_tools tools = new Teacher_tools();
//        tools.insert(new Teacher("老大",18,"boy"));
//        tools.insert(new Teacher("老二",28,"boy"));
//        tools.insert(new Teacher("老三",18,"boy"));
//        tools.insert(new Teacher("老四",88,"boy"));
//        tools.insert(new Teacher("老五",18,"boy"));
//        tools.insert(new Teacher("老六",58,"boy"));
//        System.out.println(tools.select("老大"));
//        System.out.println("***********************");
//        tools.showall();
        String[] msg = "冯浩 18 boy".split(" ");
        for (int i = 0; i < msg.length; i++) {
            System.out.println(msg[i]);
        }
    }
}
class Teacher{
    //查询增加
    private String name;
    private int age;
    private String sex;

    public Teacher() {
    }

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
    public Teacher clone(){
        return new Teacher(this.name,this.age,this.sex);
    }

    @java.lang.Override
    public java.lang.String toString() {
        return "Teacher{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", sex='" + sex + '\'' +
                '}';
    }
}
class Teacher_tools{
    private Teacher[] teachers = null;
    public Teacher_tools(){

    }
    public boolean insert(Teacher teacher){
        if (this.teachers ==null){
            this.teachers = new Teacher[1];
            this.teachers[0] = teacher;
            return true;
        }else {
            Teacher[] clone = this.teachers.clone();

            this.teachers = new Teacher[this.teachers.length+1];
            for (int i =0;i<this.teachers.length-1;i++){
                this.teachers[i]=clone[i];
            }
            this.teachers[this.teachers.length-1] = teacher;
            return true;
        }
    }
    public Teacher delete(String name){
        int index = get_index_from_name(name);
        if (index>-1){

        }else {
            System.out.println("没找到！");
        }
        return null;
    }
    private int get_index_from_name(String name){
        for (int i = 0; i < this.teachers.length; i++) {
            if (this.teachers[i].getName().equals(name)){
                return i;
            }
        }
        return -1;
    }
    public Teacher select(String name){
        for (Teacher t : this.teachers){
            if (t.getName().equals(name)){
                return t;
            }
        }
        return null;
    }
    public void showall(){
        for (Teacher t : this.teachers){
            System.out.println(t);
        }
    }
}