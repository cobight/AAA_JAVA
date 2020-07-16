package AAA7_13.duo_tai;

public class demo1 {
    public static void main(String[] args) {
        Animal animal = new Cat();
//        Animal animal = new Dog();
//        System.out.println(animal.num);
        animal.eat();
        method(animal);
        System.out.println("===================");
        Cat cat = new Cat();
        cat.eat();
    }
    public static void method(Animal animal){
        if (animal instanceof Dog){
            Dog dog = (Dog) animal;

            dog.watchHouse();
//            System.out.println(dog.num);
        }else if (animal instanceof Cat){
            Cat cat = (Cat) animal;

            cat.catchMouse();
//            System.out.println(cat.num);
//            System.out.println(cat.num2);
        }
    }
}

class Animal {
    public int num = 10;
    public void eat(){
        System.out.println("animal");
    }
}

class Cat extends Animal {
    public int num = 20;
    public int num2 = 30;
    @Override
    public void eat() {
        System.out.println("cat eat house");
        System.out.println(super.num);
        System.out.println(this.num);
    }
    public void catchMouse(){
        System.out.println("cat catch mouse");
    }
}

class Dog extends Animal {
    int num=90;
    @Override
    public void eat() {
        System.out.println("dog eat shit");
    }
    public void watchHouse(){
        System.out.println("dog watch house");
    }
}