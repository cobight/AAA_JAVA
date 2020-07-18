package AAA7_16;

import java.util.HashMap;

public class HashMapSavePerson {
    public static void main(String[] args) {
        show();
    }
    public static void show(){
        HashMap<Person,String> map = new HashMap<>();
        map.put(new Person("老大",15),"中国");
        map.put(new Person("老二",12),"非洲");
        map.put(new Person("老三",19),"美国");
        map.put(new Person("老四",20),"俄罗斯");

    }
}
class Person{
    private String name;
    private int age;

    public Person() {
    }

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
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

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}