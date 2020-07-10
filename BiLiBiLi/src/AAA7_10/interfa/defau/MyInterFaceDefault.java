package AAA7_10.interfa.defau;

public interface MyInterFaceDefault {
    public abstract void abs();
    public default void methodDefault(){
        System.out.println("default");
    }
}
