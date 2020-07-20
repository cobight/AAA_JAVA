package AAA7_20;

import java.io.File;

public class FileDemo1 {
    public static void main(String[] args) {
        File file = new File("f:/");
//        File file = new File("F:/JAVA/AAA_JAVA/README.md");
//        System.out.println(file.exists());
//        System.out.println(file.isFile());
//        System.out.println(file.isDirectory());
//        System.out.println(file.isAbsolute());
//        System.out.println(file.length());
        printFileName(file,3);
    }
    public static void printFileName(File src,int deep){
        System.out.println(src.getName()+"------"+deep);
        if (src==null||!src.exists()){
            return;
        }else if (src.isDirectory()){
            for (File s:src.listFiles()){
                printFileName(s,deep+1);
            }
        }

    }
}
/*
1、异常的分类
2、为什么使用异常机制
3、什么是编译时异常
4、什么是运行时异常
5、什么是检察型异常
6、什么是非检察型异常
7、throw的作用
8、throws的作用
9、throw和throws的区别
10、try catch finally的几种组合
11、日志使用的步骤
12、%d %m %M %F %l %n的作用分别是什么


集合预习
* */