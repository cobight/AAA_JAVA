package AAA7_10.interfa.abstrac;

public class MyInterFaceAbstractImpl implements MyInterFaceAbstract {
    @Override
    public void methodAbs1() {
        System.out.println(1);
    }

    @Override
    public void methodAbs2() {
        System.out.println(2);
    }

    @Override
    public void methodAbs3() {

    }

    @Override
    public void methodAbs4() {

    }
}
class man{
    public static void main(String[] args) {
        MyInterFaceAbstractImpl m = new MyInterFaceAbstractImpl();
        m.methodAbs1();
        m.methodAbs2();
    }
}