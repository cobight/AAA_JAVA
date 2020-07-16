package classwork;

public class Fuzi {
    public static void main(String[] args) {
        Fu fu1 = new Fu();
        Fu fu2 = new Zi();
        System.out.println("============");
        Zi zi1 = new Zi();
        //Zi zi2 = (Zi) new Fu();
        //Zi zi2 = (Zi) fu2;
    }
}
class Fu{
    public Fu() {
        System.out.println("fu 无参");
    }
    public Fu(String name) {
        System.out.println("fu 有参");
    }
}
class Zi extends Fu{
    public Zi() {
//        super();
        this("dd");
        System.out.println("zi 无参");
    }

    public Zi(String name) {
        super("name");
        System.out.println("zi 有参");
    }
}