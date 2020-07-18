package homework3;

import java.util.HashMap;
import java.util.Iterator;

public class TestDemo3 {
    public static void main(String[] args) {
        MyHashMap<String,Integer> map = new MyHashMap<>();
        map.put("asd",1);
        map.put("qwe",2);
        System.out.println(map);
    }
}
class MyHashMap<K,V> extends HashMap<K,V> {
    @Override
    public String toString() {
        Iterator<Entry<K,V>> i = entrySet().iterator();
        if (! i.hasNext())
            return "{}";

        StringBuilder sb = new StringBuilder();
        for (;;) {
            Entry<K,V> e = i.next();
            K key = e.getKey();
            V value = e.getValue();
            sb.append(key   == this ? "(this Map)" : key);
            sb.append(" : ");
            sb.append(value == this ? "(this Map)" : value);
            if (! i.hasNext())
                return sb.toString();
            sb.append('\n');
        }
    }
}