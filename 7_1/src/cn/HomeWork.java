package cn;

import java.util.Random;
import java.util.Scanner;

public class HomeWork {
    public static void main(String[] args) {
        work6();
    }

    public static void work1() {
        int guest = new Random().nextInt(100) + 1;
        Scanner scanner = new Scanner(System.in);
        for (int i = 1; i <= 7; i++) {
            System.out.print("猜猜数字是几：");
            int mycode = scanner.nextInt();
            if (mycode == guest) {
                System.out.println("恭喜你猜中了，数字是：" + mycode);
                return;
            } else {
                System.out.println(mycode > guest ? "猜的数大了" : "猜的数小了");
            }
//            System.out.println(mycode == guest ? "恭喜你猜中了，数字是：" + mycode : mycode > guest ? "猜的数大了" : "猜的数小了");
        }
        System.out.println("次数用完啦，真实数字是：" + guest);
    }

    void work2() {
        int i = 0, n = 0;
        while (i < 10) {
            if (++n % 3 == 0) {
                i++;
                System.out.println(i + "\t" + n);
            }
        }
    }

    void work3() {
        boolean b = true;//用来表示“这个数”是否为质数
        for (int i = 2; i <= 100; i++) {//100以内数的遍历
            //判断其是否为质数
            for (int j = 2; j < i; j++) {
                if (i % j == 0) {
                    b = false;
                }
            }
            if (b) {//如果b为true，则输出i
                System.out.println(i);
            }
            b = true;//当判断完一个数之后，b的值重新赋成true
        }
    }

    void work4() {
        //6
    }

    void work5() {
        for (int i = 0; i < 6; i++) {
            int k = ++i;
            while (k < 5) {
                System.out.print(i + "\t");
                break;
            }
        }
    }

    public static void work6() {
        Scanner scanner = new Scanner(System.in);
        int num = scanner.nextInt();
        if (num >= 100 && num <= 999) {
            int a = num % 10, b = (int) num / 10 % 10, c = (int) num / 100;
//            System.out.println(a + "" + b + "" + c);
            System.out.println(a * a * a + b * b * b + c * c * c == num ? num + "是水仙花" : num + "不是水仙花");
        } else {
            System.out.println("输入异常!");
        }
    }




}
