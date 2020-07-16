package classwork;

public class demo1 {
    public static void main(String[] args) {
        B b = new B();
        B b2 = new B();
        b2.age = 70;
        A a = new A();
        a.prin();
        b.prin();
        b2.prin();
    }
}
class A {
    public static  int age = 50;
    public static void prin(){
        System.out.println(age);
    }
}
class B extends A {
    public static int age = 60;
    public static void prin(){
        System.out.println(age+"..");
    }
}