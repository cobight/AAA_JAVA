package AAA7_16;

import java.util.HashSet;

public class HashCodeTestDemo {
    public static void main(String[] args) {
        HashSet<String> set = new HashSet<>();
        String s1 = new String("qqqqqqqqqqqqqqqeeerqqqqqqqq");
        String s2 = new String("qqqqqqqqqqqqqqqeeerqqqqqqqq");
        set.add(s1);
        set.add(s2);
        set.add("qwe");
        set.add("tyu");
        set.add("qqqqqqqqqqqqqqqeeerqqqqqqqq");
        System.out.println(s1.hashCode());
        System.out.println(s2.hashCode());
        System.out.println("qqqqqqqqqqqqqqqeeerqqqqqqqq".hashCode());
        System.out.println(set);
    }
}
