package AAA7_7;

import java.util.Scanner;

public class cout_char {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String msg = scanner.next();
        char[] arr = msg.toCharArray();
        int countUpper = 0;
        int countLoewer = 0;
        int countNumber = 0;
        int countOther = 0;
        for (int i = 0; i < arr.length; i++) {
            if ('A'<=arr[i] && arr[i]<='Z'){
                countUpper++;
            }else if ('a'<=arr[i] && arr[i]<='z'){
                countLoewer++;
            }else if ('0'<=arr[i] && arr[i]<='9'){
                countNumber++;
            }else {
                countOther++;
            }
        }
        System.out.println("A-Z : "+countUpper);
        System.out.println("a-z : "+countLoewer);
        System.out.println("0-9 : "+countNumber);
        System.out.println("other : "+countOther);

    }
}
