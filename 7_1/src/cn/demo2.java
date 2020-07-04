package cn;

import java.util.Scanner;

public class demo2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        double num = 0;
        int i = 0;
        while (true) {
            System.out.print("请输入学生成绩:");
            double a = scanner.nextDouble();
            if (a >= 0 && a <= 100) {//合法输入
                i++;
                num += a;
                System.out.println("共输入" + i + "个学生，总分：" + num + "\t平均分：" + num / i);
            } else if (a == -1) {//跳出循环
                System.out.println("*******记录结束*******\n共输入" + i + "个学生，总分：" + num + "\t平均分：" + num / i);
                break;
            } else {//异常输入
                System.out.println("输入错误，请从新输入！");
            }
        }
    }
}
