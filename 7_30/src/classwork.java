import java.io.File;
import java.util.Objects;

public class classwork {
    public static void main(String[] args) {
    /*
    * 在电脑f盘下创建一个文件为HelloWorld.txt文件，判断他是文件还是目录，
    * 在创建一个目录IOTest,之后将HelloWorld.txt移动到IOTest目录下去；之后遍历IOTest这个目录下的文件
    * */
        File file = new File("D:\\HelloWorld.txt");
        System.out.println(file.isFile()?"是文件":"是目录");
        File directory = new File("D:\\IOTest");
        System.out.println(directory.mkdirs()?"文件创建完毕":"文件创建失败");
        System.out.println(file.renameTo(new File(directory, file.getName()))?"移动成功":"移动失败");
        for (File listFile : directory.listFiles()) {
            System.out.println(listFile.getAbsolutePath());
        }
    }
}
