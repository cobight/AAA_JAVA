package AAA7_16;

public class InnerClass {
    public static void main(String[] args) {
        MyInterface ipl = new MyInterface(){

            @Override
            public void method() {
                System.out.println("inner");
            }
        };
        ipl.method();
        new MyInterface(){

            @Override
            public void method() {
                System.out.println("inner1");
            }
        }.method();

    }
}
interface MyInterface{
    void method();
}
class MyInterfaceIpl implements MyInterface{
    @Override
    public void method() {
        System.out.println("IPL");
    }
}