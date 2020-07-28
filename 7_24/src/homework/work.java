package homework;


import java.io.*;
import java.util.*;

public class work {
    public static void main(String[] args) throws Exception {

        wk9();
        /*第十题算法记忆*/
    }

    public static void wk1() throws IOException {
        /*在电脑D盘下创建一个文件为HelloWorld.txt文件，判断他是文件还是目录，在创建一个目录IOTest,之后将HelloWorld.txt移动到IOTest目录下去；
         * 之后遍历IOTest这个目录下的文件
         * */
        File file = new File("D:\\HelloWorld.txt");
        if (!file.exists()) System.out.println(file.createNewFile() ? "HelloWorld.txt文件创建成功" : "HelloWorld.txt文件创建失败");
        File newdirectory = new File("D:\\IOTest");
        if (!newdirectory.exists()) System.out.println(newdirectory.mkdir() ? "IOTest文件夹不存在，创建成功" : "IOTest文件夹创建失败");
        File newfile = new File(newdirectory, "HelloWorld.txt");
        boolean b = file.renameTo(newfile);
        System.out.println(b ? "HelloWorld.txt移动成功" : "HelloWorld.txt移动失败");
        for (File listFile : Objects.requireNonNull(newdirectory.listFiles())) {
            System.out.println(listFile.getName());
        }
    }

    public static void wk2() {
        /*递归实现输入任意目录，列出文件以及文件夹，效果看图*/
        FileUtil.showAllFile(new File("F:\\JAVA\\AAA_JAVA\\download"));
    }

    public static void wk3() {
        /*递归实现列出当前工程下所有.java文件*/
        FileUtil.showAllFile(new File(System.getProperty("user.dir")), ".java");
    }

    public static void wk4() throws Exception {
        /*从磁盘读取一个文件到内存中，再打印到控制台*/
        String url = "F:\\JAVA\\AAA_JAVA\\6_30\\src\\cn\\demo1.java";
        InputStream is = new FileInputStream(url);
        StringBuilder sb = new StringBuilder();
        int len;
        byte[] temp = new byte[1024];
        while ((len = is.read(temp)) != -1) {
            sb.append(new String(temp, 0, len));
        }
        is.close();
        System.out.println(sb.toString());

    }

    public static void wk5() throws Exception {
        /*在程序中写一个"HelloJavaWorld你好世界"输出到操作系统文件Hello.txt文件中*/
        OutputStream os = new FileOutputStream("msg.txt");
        String info = "HelloJavaWorld你好世界";
        os.write(info.getBytes());
        os.flush();
        os.close();
    }

    public static void wk6() {
        /*拷贝一张图片，从一个目录到另外一个目录下(PS:是拷贝是不是移动)*/
        FileUtil.copyByBytes("test.jpg", "download/test1.jpg");
    }

    public static void wk7() throws Exception {
        /*统计一个文件calcCharNum.txt（见附件）中字母'A'和'a'出现的总次数*/
        try (InputStream is = new FileInputStream("calcCharNum.txt");) {
            Map<Character, Integer> map = new HashMap<>();
            int r;
            int count;
            while ((r = is.read()) != -1) {
                char c = (char) r;
                if (c == 'A') {
//                    map.merge('A', 1, Integer::sum);
                    map.put('A', map.get('A') == null ? 1 : map.get('A') + 1);
                } else if (c == 'a') {
//                    map.merge('a', 1, Integer::sum);
                    map.put('a', map.get('a') == null ? 1 : map.get('a') + 1);
                }
            }
            System.out.println("a:" + map.get('a'));
            System.out.println("A:" + map.get('A'));
        }

    }

    public static void wk8() {
        /*统计一个文件calcCharNum.txt（见附件）中各个字母出现次数：
        A(8),B(16),C(10)...,a(12),b(10),c(3)....，括号内代表字符出现次数;*/
        try (InputStream is = new FileInputStream("calcCharNum.txt")) {
            int bytes;
            Map<Character, Integer> map = new HashMap<>();
            while ((bytes = is.read()) != -1) {
                char c = (char) bytes;
                map.put(c, map.get(c) == null ? 1 : map.get(c) + 1);
            }
            for (char c : map.keySet()) {
                System.out.println(c + "--->" + map.get(c));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void wk9() {
        /*统计一个文件calcCharNum2.txt（见附件）中各个字母出现次数：A(8),B(16),C(10)...,a(12),b(10),c(3)....中(5),国(6)，括号内代表字符出现次数;*/
        try (InputStream is = new FileInputStream("calcCharNum.txt"); ByteArrayOutputStream bos = new ByteArrayOutputStream()) {
            int len;
            byte[] temp = new byte[1024];
            while ((len = is.read(temp)) != -1) {
                bos.write(temp, 0, len);
            }
            bos.flush();
            String info = bos.toString();
            System.out.println(info + info.length());
            String[] arr = info.split("");
            System.out.println(Arrays.toString(arr));
            Map<String, Integer> map = new HashMap<>();
            for (String string : arr) {
                map.put(string, map.get(string) == null ? 1 : map.get(string) + 1);
            }
            for (String it : map.keySet()) {
                System.out.println(it + "(" + map.get(it) + ")");
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void wk10() throws Exception {
        /*使用随机文件流类RandomAccessFile将一个文本文件倒置读出*/
        String path = "msg.txt";
        File file = new File(path);
        RandomAccessFile raf = new RandomAccessFile(file, "r");//"r"表示只读
        StringBuilder sb = new StringBuilder();
        long length = raf.length();
        while (length > 0) {
            length--;
            //设置在那个位置发生下一个读取或写入操作
            raf.seek(length);
            int len1 = (char) raf.readByte();
            if (len1 <= 128) {
                sb.append((char) len1);
            } else {
                length--;
                raf.seek(--length);
                byte[] bytes = new byte[3];
                // bytes被复制为连续3个字节
                raf.readFully(bytes);
                sb.append(new String(bytes));
            }
        }
        System.out.println(sb.toString());
        raf.close();
    }

    public static void wk11() throws IOException {
        /*编写一个Java应用程序，可以实现Dos中的type命令，并加上行号。
        即将文本文件在控制台上显示出来，并在每一行的前面加上行号。*/
        try (InputStream is = System.in;
             OutputStream os = System.out;
             Reader reader = new InputStreamReader(is);
             BufferedReader br = new BufferedReader(reader);
             BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(os));
        ) {
            int len = 0;
            String line;
            while ((line = br.readLine()) != null) {
                bw.write(++len + "\t-->\t" + line);
                bw.newLine();
                bw.flush();
            }
        }


    }

    public static void wk12() {
        /*输入两个文件夹名称，将A文件夹内容全部拷贝到B文件夹，要求使用多线程来操作。*/
        FileUtil.ThreadCopyFile(new File("F:\\JAVA\\AAA_JAVA\\download", ""), new File("F:\\JAVA\\AAA_JAVA\\download1", ""));
    }

    public static void wk13() throws Exception {
        /*查看D盘中所有的文件和文件夹名称，并且使用名称升序降序，文件夹在前和文件夹在后，文件大小排序等。 */
        File d = new File("D:\\YoudaoNote\\YoudaoNote");
        List<File> list = new LinkedList<>(Arrays.asList(Objects.requireNonNull(d.listFiles())));
//        list.sort(new Comparator<File>() {
//            @Override
//            public int compare(File o1, File o2) {
//                return o1.getName().compareTo(o2.getName());
//            }
//        });
//        list.sort(new Comparator<File>() {
//            @Override
//            public int compare(File o1, File o2) {
//                return o1.isDirectory()?-1:1;
//            }
//        });

//        list.sort(new Comparator<File>() {
//            @Override
//            public int compare(File o1, File o2) {
//                return (FileUtil.getTotalSizeOfFilesInDir(o1)>FileUtil.getTotalSizeOfFilesInDir(o2)?1:-1);
//            }
//        });

        for (File file : list) {
            System.out.println((file.isDirectory() ? "文件夹" : "文件") + "-->" + FileUtil.getTotalSizeOfFilesInDir(file) + "-->" + file.getAbsolutePath());
        }

    }
}

class FileUtil {
    public static void showAllFile(File src) {
        if (src.exists()) {
            if (src.isDirectory()) {
                System.out.println(src.getAbsolutePath());
                for (File file : Objects.requireNonNull(src.listFiles())) {
                    showAllFile(file);
                }
            } else if (src.isFile()) {
                System.out.println(src.getAbsolutePath());
            }
        }
    }

    public static void showAllFile(File src, String limitFile) {
        if (src.exists()) {
            if (src.isDirectory()) {
//                System.out.println(src.getAbsolutePath());
                for (File file : Objects.requireNonNull(src.listFiles())) {
                    showAllFile(file, limitFile);
                }
            } else if (src.isFile()) {
                if (src.getName().contains(limitFile)) {
                    System.out.println(src.getAbsolutePath());
                }
            }
        }
    }

    public static void copyByBytes(String oldPath, String newPath) {
        try (InputStream is = new FileInputStream(oldPath); OutputStream os = new FileOutputStream(newPath)) {
            int len;
            byte[] temp = new byte[1024];
            while ((len = is.read(temp)) != -1) {
                os.write(temp, 0, len);
            }
            os.flush();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void copyByBytes(File oldPath, File newPath) {
        try (InputStream is = new FileInputStream(oldPath); OutputStream os = new FileOutputStream(newPath)) {
            int len;
            byte[] temp = new byte[1024];
            while ((len = is.read(temp)) != -1) {
                os.write(temp, 0, len);
            }
            os.flush();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void ThreadCopyFile(File src, File newpath) {
        if (src.exists()) {
            if (src.isDirectory()) {
                boolean mkdirs = newpath.mkdirs();
                for (File file : Objects.requireNonNull(src.listFiles())) {
                    ThreadCopyFile(file, new File(newpath, file.getName()));
                }
            } else if (src.isFile()) {
//                System.out.println(newpath);
//                System.out.println(src.getAbsolutePath()+"--"+newpath.getAbsolutePath());
                FileUtil.copyByBytes(src, newpath);
            }
        }
    }

    public static long getTotalSizeOfFilesInDir(final File file) {
        if (file.isFile())
            return file.length();
        final File[] children = file.listFiles();
        long total = 0;
        if (children != null)
            for (final File child : children)
                total += getTotalSizeOfFilesInDir(child);
        return total;
    }
}
