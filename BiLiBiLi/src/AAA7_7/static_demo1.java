package AAA7_7;

public class static_demo1 {
    public static void main(String[] args) {
        Staticclass ss = s();
        System.out.println(ss);
    }
    public static Staticclass s(){
        Staticclass s1 = new Staticclass("asd");
        s1.setS("101");
        Staticclass s2 = new Staticclass("qwe");
        s2.setS("105");
        System.out.println(s1.getA1()+" : "+s1.getS());
        System.out.println(s2.getA1()+" : "+s2.getS());
        System.out.println(s1);
        return s1;
    }
}
class Staticclass{
    public String a1;
    static String s;

    public Staticclass(String a1) {
        this.a1 = a1;
    }

    public Staticclass() {

    }

    public String getA1() {
        return a1;
    }

    public void setA1(String a1) {
        this.a1 = a1;
    }

    public String getS() {
        return s;
    }

    public void setS(String s) {
        this.s = s;
    }


}