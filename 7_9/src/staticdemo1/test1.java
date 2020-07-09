package staticdemo1;

public class test1 {


    public static void main(String[] args) {
//        St st = new St();
//        st.set();
//        St.put();
        final String asd="qwe";
        String.copyValueOf(new char[]{'a','q'});
    }
}
class St{
    public void set(){
        System.out.println("set");
    }
    public static void put(){
        System.out.println("put");
    }
}
