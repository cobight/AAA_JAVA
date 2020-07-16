package beforeclass;

import java.util.Random;
import java.util.Scanner;

public class demo1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("猜数字");
        int a = new Random().nextInt(99)+1;
        for (int i = 0; i < 7; i++) {
            int info = scanner.nextInt();
            if (info<a){
                System.out.println("小了");
            }else if (info>a){
                System.out.println("大了");
            }else {
                System.out.println("答对了:"+a);
                return;
            }
        }
    }
}
