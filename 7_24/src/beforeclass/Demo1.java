package beforeclass;

import java.io.*;

public class Demo1 {
    public static void main(String[] args) {
        File file = new File("D:\\AAA\\test.jpg");
        File file1 = new File("D:\\BBB\\test.jpg");
        try (
                InputStream is = new FileInputStream(file);
                OutputStream os = new FileOutputStream(file1);
        ) {
            byte[] temp = new byte[1024];
            int len;
            while ((len = is.read(temp)) != -1) {
                os.write(temp, 0, len);
            }
            os.flush();

        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
