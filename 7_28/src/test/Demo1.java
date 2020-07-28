package test;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.*;

public class Demo1 {
    public static void main(String[] args) throws IOException {
        InputStream is = System.in;
        OutputStream os = System.out;
        Map<String, Integer> map = new HashMap<>();
        int ch;
        while ((ch = is.read()) != -1) {
            char c = (char) ch;
            if (ch != 10 && ch != 32) {//10回车，32空格
//                System.out.println(c + ":" + ch);
                if (ch <= 128) {
                    map.put(c + "", map.get(c + "") == null ? 1 : map.get(c + "") + 1);
                } else {
                    byte[] bt = new byte[3];
                    bt[0] = (byte) ch;
                    bt[1] = (byte) is.read();
                    bt[2] = (byte) is.read();
                    map.put(new String(bt), map.get(new String(bt)) == null ? 1 : map.get(new String(bt)) + 1);
                }
            } else if (ch == 10) {
                StringBuilder sb = new StringBuilder("[");
                for (String string : map.keySet()) {
                    sb.append(string).append("-->").append(map.get(string)).append("\t");
                }
                os.write(sb.append("]\n").toString().getBytes());
                map.clear();
            }
        }
    }

    public static void test1() {
        Scanner scanner = new Scanner(System.in);
        String[] info;
        Map<String, Integer> map = new HashMap<>();
        while (((info = scanner.next().split(""))) != null) {
            for (String c : info) {
                map.put(c, map.get(c) == null ? 1 : map.get(c) + 1);
            }
            StringBuilder sb = new StringBuilder("[");
            for (String string : map.keySet()) {
                sb.append(string).append("-->").append(map.get(string)).append("\t");
            }
            System.out.println(sb.append("]"));
            map.clear();
        }
    }
}
