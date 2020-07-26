package AAA7_25;

import java.io.File;

public class CreateFile {
    public static void main(String[] args) {
        File f= new File("download/20200725881/file.mp40.ts");
        f.renameTo(new File("download/file.mp40.ts"));
//        if (!f.exists()){
//            System.out.println(f.mkdirs());
//        }
    }
}
