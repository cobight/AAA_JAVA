import java.util.Arrays;

public class array_reverse {
    public static void main(String[] args) {
        int[] arr = {1,2,3,4,5,6,7};
        for (int min = 0,max = arr.length - 1; min != max ; min++, max--) {
            int a = arr[max];
            arr[max] = arr[min];
            arr[min] = a;
        }
        System.out.println(Arrays.toString(arr));
    }
}
