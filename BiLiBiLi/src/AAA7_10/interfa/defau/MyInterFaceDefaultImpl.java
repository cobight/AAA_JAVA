package AAA7_10.interfa.defau;
interface MyInterFaceDefaul {
    public abstract void abs();
    public default void methodDefault(){
        System.out.println("default");
    }
}
public class MyInterFaceDefaultImpl implements MyInterFaceDefaul {
    @Override
    public void abs() {
        System.out.println("abs");
    }


}
class mans{
    public static void main(String[] args) {
        MyInterFaceDefaultImpl m = new MyInterFaceDefaultImpl();
        m.abs();
        m.methodDefault();
    }
}