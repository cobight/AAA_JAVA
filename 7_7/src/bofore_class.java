import javax.tools.Tool;
import java.util.Scanner;

public class bofore_class {
    public static void main(String[] args) {
        Tools tool = new Tools();
        Scanner scanner = new Scanner(System.in);
        tool.insert(new Cat("小花",2,"boy"));
        tool.insert(new Cat("小率",2,"boy"));
        tool.insert(new Cat("小粉",2,"boy"));
        while (true){
            System.out.println("请输入控制码:1、增；2、改；3、查；4、便利循环；5、退出");
            int code = scanner.nextInt();
            switch (code){
                case 1:
                    System.out.println("请输入姓名、年龄、性别，用空格分开");
                    String[] msg = {scanner.next(),scanner.next(),scanner.next()};
                    int age = change_str(msg[1]);//0-150
                    tool.insert(new Cat(msg[0],age,msg[2]));
                    break;
                case 2:
                    System.out.println("请输入要修改的名字，加上修改后的新数据，并用空格分开");
                    String[] msg1 = {scanner.next(),scanner.next(),scanner.next(),scanner.next()};
                    int index = tool.getindexbyname(msg1[0]);
                    tool.change(index,new Cat(msg1[1],change_str(msg1[2]),msg1[3]));//0-150
                    break;
                case 3:
                    System.out.println("请输入要查找的下标");
                    int index1 = scanner.nextInt();
                    tool.select(index1);
                    break;
                case 4:
                    tool.showall();
                    break;
                case 5:
                    System.out.println("结束");
                    return;
                default:
                    System.out.println("操作码错误");
                    break;
            }
        }
    }
    public static int change_str(String string){
        for (int i = 0; i < 150; i++) {
            if (Integer.toString(i).equals(string)){
                return i;
            }
        }
        return -1;
    }
}
class Tools{
    Cat[] cats;

    public Tools() {
        cats = null;
    }
    //insert
    public void insert(Cat cat){
        if (this.cats ==null && cat != null){
            this.cats = new Cat[1];
            this.cats[0] = cat;
        }else if (cat!=null){
            Cat[] clone = this.cats.clone();
            this.cats = new Cat[clone.length+1];
            for (int i = 0; i < clone.length; i++) {
                this.cats[i] = clone[i];
            }
            this.cats[this.cats.length-1] = cat;
        }else {
            System.out.println("insert erro");
        }
    }
    //change
    public void change(int index,Cat cat){
        if (index >=0 && index <this.cats.length && cat!=null){
            this.cats[index] = cat;
            System.out.println("successful");
        }else {
            System.out.println("change erro");
        }
    }
    //select
    public void select(int index){
        if (index >= 0 && index < this.cats.length){
            System.out.println(this.cats[index]);
        }else {
            System.out.println("select erro");
        }
    }
    //show
    public void showall(){
        if (this.cats!=null){
            for (Cat cat: this.cats){
                System.out.println(cat);
            }
        }else {
            System.out.println("数组为空");
        }

    }
    //getindexbyname
    public int getindexbyname(String name){
        for (int i = 0; i < this.cats.length; i++) {
            if (name.equals(this.cats[i].getName())){
                return i;
            }
        }
        return -1;
    }
}
class Cat{
    private String name;
    private int age;
    private String sex;

    public Cat(String name, int age, String sex) {
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
        return "Cat{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", sex='" + sex + '\'' +
                '}';
    }
    public Cat cloneme(){
        return new Cat(name,age,sex);
    }
}