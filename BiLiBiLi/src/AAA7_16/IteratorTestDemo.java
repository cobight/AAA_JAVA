package AAA7_16;

import java.util.ArrayList;
import java.util.Iterator;

public class IteratorTestDemo {


    public static void main(String[] args) {
        ArrayList<String> list = new ArrayList<>();
        list.add("1");
        list.add("2");
        list.add("3");
        Iterator<String> iterator = list.iterator();
        for (;iterator.hasNext();){
            System.out.println(iterator.next());
        }

    }


}
