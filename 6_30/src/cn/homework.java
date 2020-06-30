package cn;

import java.util.Random;
import java.util.Scanner;

public class homework {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        Random random = new Random();
        while (true) {
            System.out.println("****************************\n----猜拳开始----");
            String info = input.next();
            if (info.equals("out")) {
                System.out.println("****************************\n----猜拳结束----");
                break;
            }
            int rdom = random.nextInt(3);
            String robot = rdom == 0 ? "石头" : rdom == 1 ? "剪刀" : "布";
            System.out.println("玩家：" + info + "\t电脑：" + robot);
            if (info.equals(robot)) {
                System.out.println("平局");
            }else {
                switch (info) {
                    case "石头":
                        System.out.println(robot.equals("剪刀") ? "玩家胜利" : "电脑胜利");
                        break;
                    case "剪刀":
                        System.out.println(robot.equals("布") ? "玩家胜利" : "电脑胜利");
                        break;
                    case "布":
                        System.out.println(robot.equals("石头") ? "玩家胜利" : "电脑胜利");
                        break;
                    default:
                        System.out.println("输入错误");
                        return;
                }
            }
        }
    }
}
