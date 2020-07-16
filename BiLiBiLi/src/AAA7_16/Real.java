package AAA7_16;

public class Real {
    public static void main(String[] args) {
        People people = new Student();
        people.eat();
    }
}
interface People{
    void eat();
}
class Student implements People{
    @Override
    public void eat() {
        System.out.println("dog eat shit");
    }
}