package AAA7_2;



public class ArraySame {
    public static void main(String[] args) {
        int[] array = new int[3];
        array[1]=50;
//        System.out.println(array[1]);
        int[] array2 = array.clone();
        array2[1]=100;
        System.out.println(array+""+array2);
//        System.out.println(array2[1]);
//        System.out.println(array[1]);
    }
}
