package AAA7_3;

import java.util.ArrayList;

public class ArrayListDEMO1 {
    public static void main(String[] args) {
        ArrayList<Integer> list1 = new ArrayList<>();
        list1.add(1);
        list1.set(0,9);
        ArrayList<Integer> list2 = new ArrayList<>();
        list2.add(5);
        ArrayList<Integer> retn = new ArrayList<>(list1);
        retn.addAll(list2);
        list1.addAll(list2);
        System.out.println(retn);
        System.out.println(list1);
    }
}
