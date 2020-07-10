package AAA7_10.interfa.ststi;

public class MyStaticInterFace {
    public static void main(String[] args) {
        MyStaticInterFaceImpl m = new MyStaticInterFaceImpl();

    }
}
class MyStaticInterFaceImpl implements InterFace{
    public void get(){

        InterFace.method();
    }
}
interface InterFace{
    public static void method(){
        System.out.println("static");
    }
    
}