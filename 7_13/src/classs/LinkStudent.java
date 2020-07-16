package classs;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Scanner;

public class LinkStudent {
    public static void main(String[] args) throws ParseException {
        Tools tools = new Tools();
        Scanner scanner = new Scanner(System.in);
        tools.insert("老大", "19980324", 40);
        tools.insert("老二", "19970324", 50);
//        tools.insert("老三", "19880122", 60);
//        tools.insert("老四", "19990324", 80);
//        tools.insert("老五", "19980324", 45);
//        tools.insert("老六", "19970324", 55);
//        tools.insert("老七", "19880122", 65);
//        tools.insert("老八", "19990324", 30);
        tools.insert(0, "小八", "19580202", 90);//第四位
//        System.out.println("delete : "+tools.delete(1));
//        System.out.println("delete : "+tools.delete("老六"));
//        System.out.println(tools.change("老七", "name", "19420102", 100));
//        System.out.println(tools.select("老八"));
//        System.out.println(tools.select(5));
//        tools.sort(2, true);
//        tools.showAll();
        while (true) {
            System.out.println("1、增；2、删；3、改；4、查；5、排序；6、遍历；7、退出");
            int code = scanner.nextInt();
            switch (code) {
                case 1:
                    System.out.print("请输入增加的内容，或指定位置与增加的内容 : ");
                    String msg1 = scanner.next();
                    int index1 = isCode(msg1);
                    if (index1 > -1) {
                        System.out.println("insert ： " + tools.insert(index1, scanner.next(), scanner.next(), scanner.nextInt()));
                    } else {
                        System.out.println("insert ： " + tools.insert(msg1, scanner.next(), scanner.nextInt()));
                    }
                    break;
                case 2:
                    System.out.print("请输入要删除的名字或下标 ：");
                    String msg2 = scanner.next();
                    int index2 = isCode(msg2);
                    if (index2 > -1) {
                        System.out.println("delete ： "+tools.delete(index2));
                    } else {
                        System.out.println("delete ： "+tools.delete(msg2));
                    }
                    break;
                case 3:
                    System.out.print("请输入要修改的名字 + 新的数据，都用空格分开 ： ");
                    System.out.println("change ： "+tools.change(scanner.next(), scanner.next(), scanner.next(), scanner.nextInt()));
                    break;
                case 4:
                    System.out.print("请输入要查询的名字或下标");
                    String msg4 = scanner.next();
                    int index4 = isCode(msg4);
                    if (index4 > -1) {
                        System.out.println("select ： "+tools.select(index4));
                    } else {
                        System.out.println("select ： "+tools.select(msg4));
                    }
                    break;
                case 5:
                    System.out.print("请输入排序类型与方式");
                    tools.sort(scanner.nextInt(), scanner.nextBoolean());
                    System.out.println("sort finished");
                    break;
                case 6:
                    tools.showAll();
                    break;
                case 7:
                    return;
                default:
                    System.out.println("input err");
                    break;

            }
            System.out.println("================================");
        }

    }

    public static int isCode(String code) {
        for (int i = 0; i < 100; i++) {
            if (Integer.toString(i).equals(code)) {
                return i;
            }
        }
        return -1;
    }
}

class Tools {
    private Student students = new Student();//头节点，不存数据，只存下个节点（第一个数据）
    private int length = 0;

    public Tools() throws ParseException {
    }

    public int getLength() {
        return length;
    }

    //增
    public Student insert(String name, String birthday, int score) throws ParseException {
        Student node = students;
        while (node.next != null) {
            node = node.next;
        }
        node.next = new Student(name, birthday, score);
        length++;
        return node.next;
    }

    public Student insert(int index, String name, String birthday, int score) throws ParseException {
        Student node = students;
        for (int i = 0; i < index; i++) {
            node = node.next;
        }
        Student add = new Student(name, birthday, score);


        add.next = node.next;
        node.next = add;
        length++;
        return add;
    }

    //删
    public Student delete(int index) {
        Student node = students;
        if (index >= 0 && index < length) {
            for (int i = 0; i < index; i++) {
                System.out.println(i);
                node = node.next;
            }
            Student retn = node.next;
            if (node.next.next==null){
                node.next=null;
            }else {
                node.next = node.next.next;
            }

            length--;
            return retn;
        } else return null;
    }

    public Student delete(String name) {
        Student node = students;
        if (length > 0 && name != null) {
            while (node != null) {
                if (node.next.getName().equals(name)) {
                    Student retn = node.next;
                    if (node.next.next!=null){
                        node.next = node.next.next;
                    }else {
                        node.next=null;
                    }
                    length--;
                    return retn;
                }
                node = node.next;
            }
            return null;
        } else return null;
    }

    //改
    public Student change(String name, String newName, String birthday, int score) throws ParseException {
        Student node = students;
        if (length > 0) {
            while (node.next != null) {
                node = node.next;
                if (node.getName().equals(name)) {
                    node.setName(newName);
                    node.setBirthday(birthday);
                    node.setScore(score);
                    return node;
                }
            }
        }

        return null;
    }

    //查
    public Student select(int index) {
        if (length > 0 && index >= 0 && index < length) {
            Student node = students;
            for (int i = 0; i < index; i++) {
                node = node.next;
            }
            return node;
        }
        return null;
    }

    public Student select(String name) {
        if (length > 0 && name != null) {
            Student node = students;
            while (node.next != null) {
                node = node.next;
                if (node.getName().equals(name)) {
                    return node;
                }
            }
        }
        return null;
    }

    //遍历
    public void showAll() {
        if (length > 0) {
            Student node = students;
            while (node.next != null) {
                System.out.println(node.next);
                node = node.next;
            }
        }
    }

    //排序,key=1:年龄排序；key=2:成绩排序  ； value=true:从小到大；value=false:从大到小
    private boolean sortType(Student a, Student b, int key, boolean value) {
        if (key == 1) {
            return value ? a.getAge() > b.getAge() : a.getAge() < b.getAge();
        } else if (key == 2) {
            return value ? a.getScore() > b.getScore() : a.getScore() < b.getScore();
        } else return false;
    }

    public void sort(int key, boolean value) {//key: 1、年龄；2、成绩<---->value: true/false正序逆序
        for (int i = 0; i < length; i++) {
            Student node = students;
            for (int j = 0; j < length - 1; j++) {
                if (sortType(node.next, node.next.next, key, value)) {
                    Student a = node.next;
                    Student b = node.next.next;
                    Student c = a;

                    c.next = b.next;
                    b.next = a;
                    node.next = b;
                }
                node = node.next;
            }
        }
    }
}

class Student {
    private String name;
    private Date birthday;
    private int score;
    public Student next;
    private SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");

    public Student() {
    }

    public Student(String name, String birthday, int score) throws ParseException {
        this.name = name;
        this.birthday = sdf.parse(birthday);
        this.score = score;
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

    public void setBirthday(String birthday) throws ParseException {
        this.birthday = sdf.parse(birthday);
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public int getAge() {
        Calendar calendar = Calendar.getInstance();
        long now = calendar.getTimeInMillis();
        calendar.setTime(birthday);
        long birth = calendar.getTimeInMillis();
        return (int) ((now - birth) / 1000 / 60 / 60 / 24 / 365);
    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", birthday=" + sdf.format(birthday) +
                ", score=" + score +
                '}' + "\t\tAge : " + getAge();
    }
}