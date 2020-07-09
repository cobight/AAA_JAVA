package cn;

import java.util.Arrays;
import java.util.Scanner;

public class work2 {
        /*
一、随便输入一邮箱地址，判断是否合法；
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
    static Scanner scanner = new Scanner(System.in);
    public static void main(String[] args) {

        System.out.println(getUser("1234@qq.com"));
//        strarr();
//        getnum();
//        cleanmsg();
        strtoarr();
    }

    public static String getUser(String email){
        if (!email.contains("@") || !email.endsWith(".com")){
            System.out.println("缺少@或后缀不合法");
            return null;
        }else if (email.indexOf("@")!=email.lastIndexOf("@") || email.indexOf(".")!=email.lastIndexOf(".")){
            System.out.println("地址不合法");
            return null;
        }else if (email.indexOf("@")+1>=email.indexOf(".")){
            System.out.println("地址不合法");
            return null;
        }else if (email.indexOf("@")==0){
            System.out.println("找不到用户名");
            return null;
        }else {
            return email.substring(0,email.indexOf("@"));
        }


    }
    public static void strarr(){

        System.out.print("请输入三个字符串并用空格隔开 ： ");
        String[] msgs= {scanner.next(), scanner.next(), scanner.next()};
        System.out.println(Arrays.toString(msgs));
    }
    public static void getnum(){
        System.out.print("请输入一段字符串 ： ");
        byte[] bt = scanner.next().getBytes();
        int upper=0,lower=0,numb=0,other=0;
        for (int i = 0; i < bt.length; i++) {
            if('a'<=bt[i] && bt[i]<='z'){
                lower++;
            }else if ('A'<=bt[i] && bt[i]<='Z'){
                upper++;
            }else if ('0'<=bt[i] && bt[i]<='9'){
                numb++;
            }else {
                other++;
            }
        }
        System.out.println("大写 ： "+upper);
        System.out.println("小写 ： "+lower);
        System.out.println("数字 ： "+numb);
        System.out.println("其他 ： "+other);
    }
    public static void cleanmsg(){
        String[] shit = {"fuck","大爷的","TMD"};
        String msg = scanner.next();
        for (int i = 0; i < shit.length; i++) {
            msg = msg.replace(shit[i],"***");
        }
        System.out.println(msg);

    }
    public static void strtoarr(){
        int[] arr = {10,20,30};
        String msg="{";
        for (int i = 0; i < arr.length; i++) {
            msg+="@"+arr[i];
        }
        msg+="}";
        System.out.println(msg);
    }
}
