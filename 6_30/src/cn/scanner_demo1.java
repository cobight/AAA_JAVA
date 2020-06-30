package cn;

import java.util.Scanner;

public class scanner_demo1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("请输入姓名");
        String name = scanner.next();
        System.out.println("请输入年龄");
        int age = scanner.nextInt();
        System.out.println("请输入体重");
        float weight = scanner.nextFloat();
        System.out.println("请输入身高");
        double height = scanner.nextDouble();
        System.out.println("我是："+name+"\t年龄："+age+"\t体重："+weight+"\t身高："+height);
    }
}
