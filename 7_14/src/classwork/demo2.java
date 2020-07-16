package classwork;

public class demo2 {

}
class MyList{
    Animal[] list = new Animal[10];
    int length=0;
    public void add(Animal animal){

    }

}
abstract class Animal{
    String name;
    abstract void eat();
}
class Cat extends Animal {

    @Override
    void eat() {
        System.out.println("猫吃老鼠");
    }
}
class Dog extends Animal {

    @Override
    void eat() {
        System.out.println("狗吃屎");
    }
}