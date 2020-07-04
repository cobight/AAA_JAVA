package cn;

import java.util.Scanner;

public class demo1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        double num = 0;
        for (int i = 1; i <= 5; i++) {
            System.out.print("请输入第" + i + "个同学的成绩");
            double a = scanner.nextDouble();
            if (a >= 0 && a <= 100) {
                num += a;
            } else {
                i--;
                System.out.println("输入有误，请从新输入！");
            }
//            num += (a >= 0 && a <= 100) ? a : 0;  //括号可以删
        }
        System.out.println("5人平均数：" + num / 5);
    }
}
