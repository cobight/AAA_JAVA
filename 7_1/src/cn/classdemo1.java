package cn;

import java.util.Arrays;
//B站视频follow
public class classdemo1 {
    public static void main(String[] args) {
        Person person = new Person();

        person.age=22;
        char a[]={};
        System.out.println("0.0:"+a);
//        a="fucu".toCharArray();
        person.eat(a);

    }
}

class Person {
    private char values[];
    int age;

    public void eat(char name[]) {
        values = Arrays.copyOf(name, name.length);
        System.out.println(name);
        this.show();
    }

    public void show() {
        System.out.println(values.toString());
        System.out.println(values);
//        System.out.println(age);
    }
}