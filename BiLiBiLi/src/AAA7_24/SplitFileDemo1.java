package AAA7_24;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.RandomAccessFile;

public class SplitFileDemo1 {
    public static void main(String[] args) throws IOException {
        File src = new File("test.jpg");
        long len = src.length();
        int blockSize = 1024*10;
        int splitNum = (int)Math.ceil(len*1.0/blockSize);

        int beginPos=0;
        int actualSize=(int)(blockSize>len?len:blockSize);
        for (int i = 0; i < splitNum; i++) {
            beginPos=i*blockSize;
            if (i==splitNum-1){
                actualSize=(int)len;


            }else {
                actualSize=blockSize;
                len-=actualSize;
            }
            System.out.println(i+"-->"+beginPos+"-->"+actualSize);
            split(i,beginPos,actualSize);
        }
        System.out.println(splitNum);
    }
    public static void split(int i,long beginPos,long actualSize) throws IOException {
//        System.out.println(beginPos+":"+actualSize);
        FileOutputStream fos = new FileOutputStream(new File("download/split/"+i+"tes.jpg"));
        RandomAccessFile raf = new RandomAccessFile(new File("test.jpg"),"r");
        raf.seek(beginPos);
        byte[] flush = new byte[1024];
        int len;
        while ((len=raf.read(flush))!=-1){
            if (actualSize>len){
                fos.write(flush,0,len);
                actualSize-=len;
            }else{
                fos.write(flush,0,(int)actualSize);
                break;
            }
        }
        raf.close();
        fos.close();




    }
}
