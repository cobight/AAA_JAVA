package AAA7_23;

import java.io.*;

public class FileCopyDemo1 {
    public static void main(String[] args) {
        test1();
        test2();//较快
    }

    public static void test1(){
        long t1 = System.currentTimeMillis();
        byte[] info = Util.readFileBytes("test1.jpg");
        if (info != null) {
            System.out.println(info.length);
            boolean a = Util.writeFileBytes(info,"test2.jpg");
            System.out.println(a?"Success":"Failure");
        }else {
            System.out.println("null");
        }
        long t2 = System.currentTimeMillis();
        System.out.println("1:"+(t2-t1));
    }
    public static void test2(){
        long t1 = System.currentTimeMillis();
        byte[] info = Util.readBuffered("test1.jpg");
        if (info != null) {
            System.out.println(info.length);
            boolean a = Util.writeBuffered(info,"test3.jpg");
            System.out.println(a?"Success":"Failure");
        }else {
            System.out.println("null");
        }
        long t2 = System.currentTimeMillis();
        System.out.println("2:"+(t2-t1));
    }
}

class Util{
    //文件输入流  与  字节数组输出流
    public static byte[] readFileBytes(String path){
        try(InputStream is = new FileInputStream(new File(path)); ByteArrayOutputStream baos = new ByteArrayOutputStream();) {
            byte[] temp = new byte[1024*10];
            int len;
            while ((len=is.read(temp))!=-1){
                baos.write(temp,0,len);
            }
            baos.flush();
            return baos.toByteArray();
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }
    //文件输出流  与  字节数组输入流
    public static boolean writeFileBytes(byte[] info,String path){
        try(ByteArrayInputStream bais = new ByteArrayInputStream(info);OutputStream os = new FileOutputStream(new File(path));) {
            byte[] temp = new byte[1024*10];
            int len;
            while ((len=bais.read(temp))!=-1){
                os.write(temp,0,len);
            }
            os.flush();
            return true;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return false;
    }

                    /*字节数组缓冲流的加速*/
    //文件输入流+字节输入缓冲流  与  字节数组输出流
    public static byte[] readBuffered(String path){
        try(InputStream is = new BufferedInputStream(new FileInputStream(new File(path)));ByteArrayOutputStream baos = new ByteArrayOutputStream();) {
            byte[] temp = new byte[1024*10];
            int len;
            while ((len=is.read(temp))!=-1){
                baos.write(temp,0,len);
            }
            baos.flush();
            return baos.toByteArray();
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }
    //文件输出流+字节输出缓冲流  与  字节数组输入流
    public static boolean writeBuffered(byte[] info, String path){
        try(ByteArrayInputStream bais =new ByteArrayInputStream(info);OutputStream os = new BufferedOutputStream(new FileOutputStream(new File(path)));) {
            byte[] temp = new byte[1024];
            int len;
            while ((len=bais.read(temp))!=-1){
                os.write(temp,0,len);
            }
            os.flush();
            return true;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return false;
    }
                    /*字符数组缓冲流的加速*/
    public static boolean StringCopy(String path1,String path2){
        try(
                BufferedReader br = new BufferedReader(new FileReader(path1));
                BufferedWriter bw = new BufferedWriter(new FileWriter(path2));
        ) {
            String temp;
            while ((temp=br.readLine())!=null){
                bw.write(temp);
                bw.newLine();
            }
            bw.flush();
        } catch (IOException e) {
            e.printStackTrace();
            return false;
        }
        return true;
    }

}