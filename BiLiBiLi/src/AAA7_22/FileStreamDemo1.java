package AAA7_22;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FileStreamDemo1 {
    public static void main(String[] args) {
        test2();


    }
    public static void ByteArray(){
        byte[] dest = null;
        ByteArrayInputStream bi  = null;
//         = null;
        String infomsg = "show me the code!";
        byte[] datas = infomsg.getBytes();
        try(ByteArrayOutputStream bo = new ByteArrayOutputStream()){

            bo.write(datas,0,datas.length);
            bo.flush();
            dest = bo.toByteArray();

            bi = new ByteArrayInputStream(dest);
            int c;
            while ((c=bi.read())!=-1){
                System.out.print((char)c);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public static void byteControl(){
        File file = new File("7_22\\src\\beforeclass\\demo1.java");
        File file1 = new File("msg1.txt");
        InputStream is = null;
        OutputStream os = null;
        try {
            is = new FileInputStream(file);
            os = new FileOutputStream(file1);

            byte[] temp = new byte[1024*10];
            int length;
            while ((length=is.read(temp))!=-1){
                os.write(temp,0,length);
                os.flush();
            }
//            os.write("giao".getBytes());
//            os.flush();

            is.close();
            os.close();
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            try {
                if (is != null) {
                    is.close();
                }
                if (os != null) {
                    os.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
    public static void FileWriter(){
        File file = new File("7_22\\src\\beforeclass\\demo1.java");
        File file1 = new File("msg1.txt");
        Reader reader = null;
        Writer writer = null;
        try {
            reader = new FileReader(file);
            writer = new FileWriter(file1);
            char[] temp = new char[1024*10];
            int length;
            while ((length=reader.read(temp))!=-1){
                writer.append(new String(temp,0,length));
                writer.flush();
            }
//            writer.append("giao").append("fuc");
//            writer.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            try {
                if (reader != null) {
                    reader.close();
                }
                if (writer != null) {
                    writer.close();
                }


            } catch (IOException e) {
                e.printStackTrace();
            }

        }
    }
    public  static  void test1(){
        List<String> list = new ArrayList<String>();
        for (int i = 0; i < 5; i++) {
            list.add(""+i);
        }
        // String[] strs = (String[])list.toArray();
        //强制类型转化只适用于一个对象，不能适用于一组对象；
        String[] strs = list.toArray(new String[]{});
        System.out.println(Arrays.toString(strs));


    }

    public  static  void test2(){
        System.out.println(File.separator);
        System.out.println(File.pathSeparator);
    }

    public  static  void test3(){
        File f = new File("d:\\aaa\\abc.txt");//
        File f1 = new File("D:\\1801\\geli");
        //传的可以是真实的也可以是虚假的，可以是文件，也可以是目录
        System.out.println(f);
        System.out.println(f1);
        File f3 = new File(f1,"src\\com\\aaa\\util");//
        File f4 = new File(f1,"\\WebContent\\WEB-INF\\web.xml");//
        System.out.println(f3);
        System.out.println(f4);
        File f5 = new File("D:\\1801\\geli","src\\com\\aaa\\util");//
        System.out.println(f5);
        File f6 = new File("d:"+File.separator+"soft");
        System.out.println(f6);

    }
}
