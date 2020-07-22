package AAA7_21;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class IODemo1 {
    public static void main(String[] args) {
        File file = new File("msg.txt");
        try {
            InputStream is = new FileInputStream(file);
            int temp ;
//            byte[] b = new byte[1024];
//            is.read(b);
//            String msg = new String(b);
//            System.out.println(msg.toCharArray().length);//1024,他把0也算上了
//            System.out.println(msg);

            StringBuilder arr= new StringBuilder();
            while ((temp=is.read())!=-1){
                arr.append(temp);
            }
            System.out.println(arr.length());//3，有多少算多少
            System.out.println(arr.toString());

//            int data1 = is.read();
//            int data2 = is.read();
//            int data3 = is.read();
//            int data4 = is.read();
//            System.out.println((char)data1);
//            System.out.println((char)data2);
//            System.out.println((char)data3);
//            System.out.println(data4);
            is.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
