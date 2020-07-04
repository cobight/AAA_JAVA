package cn;

import java.util.Scanner;

public class demo3 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int i=0,num=0;
        do {
            System.out.print("请输入学生成绩:");
            double a = scanner.nextDouble();
            if (a >= 0 && a <= 100) {//合法输入
                i++;
                num += a;
                System.out.println("共输入" + i + "个学生，总分：" + num + "\t平均分：" + num / i);
            } else if (a == -1) {//跳出循环
                System.out.print("是否继续输入(Y/N)：");
                String string = scanner.next();
                if(string.equalsIgnoreCase("y")){
                    System.out.println("共输入" + i + "个学生，总分：" + num + "\t平均分：" + num / i);
                }else if (string.equalsIgnoreCase("n")){
                    System.out.println("*******记录结束*******\n共输入" + i + "个学生，总分：" + num + "\t平均分：" + num / i);
                    break;
                }else {
                    System.out.println("输入错误，请从新输入！");
                }

            } else {//异常输入
                System.out.println("输入错误，请从新输入！");
            }
        }while (true);
    }
}
