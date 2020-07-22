package AAA7_21;


import java.io.UnsupportedEncodingException;
import java.nio.charset.StandardCharsets;

public class EncodeDemo1 {
    public static void main(String[] args) throws UnsupportedEncodingException {
        String msg = "性命使命";

        byte[] bytes = msg.getBytes();
        System.out.println(bytes.length);//默认工程(UTF-8)，一个汉字3个字符
        String retn = new String(bytes,0,bytes.length,"utf8");
        System.out.println(msg);

//        bytes = msg.getBytes(StandardCharsets.UTF_8);
//        System.out.println(bytes.length);//一个汉字3个字符
//
//        bytes = msg.getBytes(StandardCharsets.UTF_16LE);
//        System.out.println(bytes.length);//一个汉字2个字符
//
//        bytes = msg.getBytes("GBK");
//        System.out.println(bytes.length);//一个汉字2个字符
//
//        bytes = msg.getBytes("gb2312");
//        System.out.println(bytes.length);//一个汉字2个字符
    }
}
