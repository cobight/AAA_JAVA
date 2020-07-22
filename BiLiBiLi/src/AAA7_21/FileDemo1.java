package AAA7_21;

import java.io.File;
import java.util.Objects;

public class FileDemo1 {
    public static void main(String[] args) {
        File file = new File("download");
        System.out.println(file.getAbsoluteFile());
//        printName(file,2);
    }
    public static void printName(File src,int deep){
        if (deep>0){
            deep--;
            for (File files: Objects.requireNonNull(src.listFiles())){
                if (files.isFile()){
                    System.out.println(files.getName());
                }else if (files.isDirectory()){
                    System.out.println(files.getPath());
                    printName(files,deep);
                }else {

                }

            }
        }

    }
}
