package AAA7_16;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public class HashMapTestDemo1 {


    public static void main(String[] args) {
        Map<Integer,String> map = new HashMap<>();
        map.put(1,"qwe");
        map.put(2,"asd");
        map.put(3,"rty");
        map.put(4,"fgh");
        map.put(5,"uio");
        map.put(6,"jkl");
        Set<Integer> sets = map.keySet();
        Iterator<Integer> iterator = sets.iterator();
        while (iterator.hasNext()){
            Integer next=iterator.next();
            System.out.println(next +" : "+ map.get(next));
        }

    }
}
