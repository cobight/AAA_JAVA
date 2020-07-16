package AAA7_16;

import java.util.ArrayList;
import java.util.Iterator;

public class FanXingTongPeiFu {


    public static void main(String[] args) {
        ArrayList<String> list1 = new ArrayList<>();
        list1.add("1");
        list1.add("2");
        ArrayList<Integer> list2 = new ArrayList<>();
        list2.add(3);
        list2.add(4);
        printarray(list1);
        printarray(list2);
    }
    public static void printarray(ArrayList<?> list){
        Iterator<?> iterator = list.iterator();
        for (;iterator.hasNext();){
            System.out.println(iterator.next());
        }
    }
}
