

public class String_duibi {
    public static void main(String[] args) {
        String abc = "abc";
        String def = "hello", hi = "abchello", world = abc + def, ww = abc + "hello", eee = new String("abchello"), tt = "abc" + "hello";
        System.out.println(abc + def == world);
        System.out.println(tt == world);
        System.out.println(tt == ww);
        System.out.println(tt == eee);
        System.out.println(tt == hi);
        System.out.println("abc" == "a" + "bc");
    }
}
