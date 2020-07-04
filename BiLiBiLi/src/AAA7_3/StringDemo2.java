package AAA7_3;

public class StringDemo2 {
    public static void main(String[] args) {
        String a = "asd";
        String b = "asd";
        System.out.println((a == b) +"-->"+a+" : "+b);
        a+="f";
        b+="f";

        System.out.println((a == b) +"-->"+a+" : "+b);

        a = "fff";
        b = "fff";
        System.out.println((a == b) +"-->"+a+" : "+b);
    }
}
