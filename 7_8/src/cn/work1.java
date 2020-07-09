package cn;

import org.omg.CORBA.PUBLIC_MEMBER;

import java.util.Arrays;
import java.util.Scanner;

public class work1 {
    /*
一、随便输入一邮箱地址，判断是否合法；
yyh@qq.com
1.必须有@符号，.com符号endswith(".com")            a!=-1  && endwith**
2、@符号和点符号有且只能有一个；                     对比indexof与lastindexof
3、@符号必须在d点符号之前；                         a<b
4、@符号和点符号不能连着；@的下标+1《点符号的下标       a+1<b
5、@符号不能再第一位                               a>=1
6、截取你的用户名（@符号前面的就是用户名）             substring(0,a)

二、随便输入三个字符串，把三个字符串进行组合，中间使用空格隔开，然后再使用空格分割成字符串数组；

三、随便输入一个字符串，判断里面的大写字母、小写字母、数字以及其他字符的个数；

四、随便输入一个字符串，如果其中有敏感字符串，就替换成，把所有的敏感字符放到一个数组里；

五、把数组[10,20,30],拼接成"{@10@20@30}"
*/
    public static void main(String[] args) {
        Tol tol = new Tol();
//        System.out.println(tol.isEmailRight("123@qq.com"));
        Scanner scanner = new Scanner(System.in);
//        System.out.print("请输入三个字符串，用空格分开 ：");
//        String[] msgs = {scanner.next(),scanner.next(),scanner.next()};
//        System.out.println(Arrays.toString(msgs));
//        System.out.println("请输入连续的字符串");
//        tol.getstrnum(scanner.next());
//        tol.printmsg("TMD，你大爷的，我FUCK you");
        int[] info = {10,20,30};
        System.out.println(tol.mix(info));
    }


}

class Tol {
    public String isEmailRight(String email) {
//        System.out.println(email.contains("@") +":"+ email.endsWith(".com"));
        if (!email.contains("@") || !email.endsWith(".com")) {
            System.out.println("缺少关键字");
            return null;
        }
        if (email.indexOf("@") != email.lastIndexOf("@") || email.indexOf(".") != email.lastIndexOf(".")) {
            System.out.println("@或.重复");
            return null;
        }
        if (email.indexOf("@") + 1 >= email.indexOf(".")) {
            System.out.println("符号链接了或位置有问题");
            return null;
        }
        if (email.indexOf("@") == 0) {
            System.out.println("不能@起始");
            return null;
        }

        return email.substring(0, email.indexOf("@"));
    }

    public void getstrnum(String msg) {
        byte[] bts = msg.getBytes();
        int upper = 0, lower = 0, numb = 0, other = 0;
        for (int i = 0; i < bts.length; i++) {
            if ('a' <= bts[i] && bts[i] <= 'z') {
                lower++;
            } else if ('A' <= bts[i] && bts[i] <= 'Z') {
                upper++;
            } else if ('0' <= bts[i] && bts[i] <= '9') {
                numb++;
            } else {
                other++;
            }
        }
        System.out.println("大写字符："+upper+"个");
        System.out.println("小写字符："+lower+"个");
        System.out.println("数字字符："+numb+"个");
        System.out.println("其他字符："+other+"个");
    }
    public void printmsg(String msg){
        String[] shit = {"TMD","FUCK","大爷的"};
        for (int i = 0; i < shit.length; i++) {
            if (msg.contains(shit[i])){
                msg = msg.replace(shit[i],"***");
            }
        }
        System.out.println(msg);
    }
    public String mix(int[] info){
        String msg = "{";
        for (int i = 0; i < info.length; i++) {
            msg+="@"+info[i];
        }
        msg+="}";
        return msg;
    }
}
