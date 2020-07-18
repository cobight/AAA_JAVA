package AAA7_16;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public class EntrySetTestDemo1 {
    public static void main(String[] args) {
        Map<String,Integer> map = new HashMap<>();
        map.put("老大",12);
        map.put("老二",12);
        map.put("老三",12);
        Set<Map.Entry<String,Integer>> sets = map.entrySet();
        Iterator<Map.Entry<String,Integer>> iterator = sets.iterator();
        while (iterator.hasNext()){
            Map.Entry<String,Integer> entry=iterator.next();
            System.out.println(entry.getKey() +" : "+ entry.getValue());
        }


    }
}
