package datademo1;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Date;
import java.util.Scanner;

public class test1 {
    public static void main(String[] args) throws ParseException {
        Scanner scanner = new Scanner(System.in);
//        Calendar calendar = Calendar.getInstance();
//        System.out.println(calendar.get(Calendar.YEAR));
//        System.out.println(calendar.get(Calendar.MONTH)+1);
//        System.out.println(calendar.get(Calendar.DAY_OF_MONTH));
//        System.out.println(calendar.get(Calendar.HOUR_OF_DAY));
//        System.out.println(calendar.get(Calendar.MINUTE));
//        System.out.println(calendar.get(Calendar.SECOND));

//        demo1();


//        SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
//
//        SimpleDateFormat sdf1=new SimpleDateFormat("yyyy-MM-dd E HH:mm:ss SSS");
//
//        Date date=new Date();
//
//        String dateStr=sdf.format(date);
//
//        System.out.println(dateStr);
//
//        System.out.println(sdf1.format(date));

        DataTools tools = new DataTools();
        tools.gettime();
        int[] nowTime = tools.getNowTime();
        System.out.println(Arrays.toString(nowTime));
        int[] times = tools.getCurrentTime("1998 01 22");
        System.out.println(Arrays.toString(times));
        if (nowTime[1] < times[1]) {
            System.out.println(nowTime[0] - times[0] - 1 + "：岁");//月小-1岁
        } else {
            System.out.println(nowTime[0] - times[0] + "：岁");
        }
    }

    public static void demo1() throws ParseException {
        Scanner scanner = new Scanner(System.in);
        System.out.print("输入出生年月日，空格隔开 ：");
        String[] msg = {scanner.next(), scanner.next(), scanner.next()};
        String data = msg[0] + "-" + msg[1] + "-" + msg[2];
        SimpleDateFormat dfs = new SimpleDateFormat("yyyy-MM-dd");
        Date date = dfs.parse(data);
        long bir = date.getTime();
        long current = System.currentTimeMillis();
        long seconds = (current - bir) / 1000;
        long mins = seconds / 60;
        long hours = mins / 60;
        long days = hours / 24;
        System.out.println("我活了 ：" + days + " 天");
    }

    public static void demo2() {
        SimpleDateFormat dfs = new SimpleDateFormat("yyyy年MM月dd日 HH:mm:ss");
        System.out.println(dfs.format(new Date()));
    }
}

class DataTools {

    public DataTools() {

    }

    public int[] getNowTime() {
        Calendar nowTime = Calendar.getInstance();
        return new int[]{
                nowTime.get(Calendar.YEAR),
                nowTime.get(Calendar.MONTH) + 1,
                nowTime.get(Calendar.DAY_OF_MONTH),
                nowTime.get(Calendar.HOUR_OF_DAY),
                nowTime.get(Calendar.MINUTE),
                nowTime.get(Calendar.SECOND)
        };
    }

    public int[] getCurrentTime(String times) throws ParseException {//1998 1 22
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy MM dd");
        Date date = sdf.parse(times);
        Calendar currentTime = Calendar.getInstance();
        currentTime.setTime(date);
        return new int[]{
                currentTime.get(Calendar.YEAR),
                currentTime.get(Calendar.MONTH) + 1,
                currentTime.get(Calendar.DAY_OF_MONTH),
                currentTime.get(Calendar.HOUR_OF_DAY),
                currentTime.get(Calendar.MINUTE),
                currentTime.get(Calendar.SECOND)
        };
    }
    public void gettime(){
        Date date = new Date();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy年MM年dd");
        System.out.println(sdf.format(date));
    }
}