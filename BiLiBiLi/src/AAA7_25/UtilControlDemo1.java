package AAA7_25;


import org.apache.commons.io.FileUtils;
import org.apache.commons.io.filefilter.DirectoryFileFilter;
import org.apache.commons.io.filefilter.EmptyFileFilter;
import org.apache.commons.io.filefilter.FileFilterUtils;
import org.apache.commons.io.filefilter.SuffixFileFilter;

import java.io.File;
import java.util.Collection;

public class UtilControlDemo1 {
    public static void main(String[] args) {
        FileForeach();
    }
    public static void FileSize(){
        long len = FileUtils.sizeOf(new File("download"));
        System.out.println(len);
    }
    public static void FileForeach(){
        Collection<File> files = FileUtils.listFiles(new File("download"), EmptyFileFilter.NOT_EMPTY, null);
        for (File file : files) {
            System.out.println(file.getAbsolutePath());
        }
        System.out.println("-------------------------------");
        files = FileUtils.listFiles(new File("download"), FileFilterUtils.or(new SuffixFileFilter("jpg"),new SuffixFileFilter("txt")), DirectoryFileFilter.INSTANCE);
        for (File file : files) {
            System.out.println(file.getAbsolutePath());
        }
    }
}
