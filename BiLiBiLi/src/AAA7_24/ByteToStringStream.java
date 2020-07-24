package AAA7_24;

import java.io.*;
import java.nio.charset.StandardCharsets;

public class ByteToStringStream {
    public static void main(String[] args) {
        try (
                BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(new File("msg.txt")), StandardCharsets.UTF_8));
                BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(new File("msg1.txt"),false),StandardCharsets.UTF_8));
        ) {
//                String msg;
//                while ((msg=br.readLine())!=null){
//                    bw.write(msg);
//                    bw.newLine();
//                }
//                bw.flush();
            bw.write("");
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

}
