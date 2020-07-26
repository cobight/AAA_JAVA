package AAA7_25;

import java.io.*;
import java.util.*;

public class SequenceDemo1 {
    public static void main(String[] args) throws Exception {
        System.out.println("我".getBytes("gb2312").length);
//        String PATH = System.getProperty("user.dir")+"\\download\\split";//项目根目录
//        File directory = new File(PATH);
//        ArrayList<File> list = new ArrayList<>(Arrays.asList(Objects.requireNonNull(directory.listFiles())));
//        list.sort(new Comparator<File>() {
//            @Override
//            public int compare(File o1, File o2) {
//                int ind1 = Integer.parseInt(o1.getName().substring(0,o1.getName().length()-7));
//                int ind2 = Integer.parseInt(o2.getName().substring(0,o2.getName().length()-7));
//                return ind1-ind2;
//            }
//        });
//        OutputStream os = new BufferedOutputStream(new FileOutputStream("download/test.jpg"));
//        Vector<InputStream> vi = new Vector<>();
//        SequenceInputStream sis =null;
//        for (int i = 0; i < list.size(); i++) {
//            vi.add(new BufferedInputStream(new FileInputStream(list.get(i))));
//        }
//        sis = new SequenceInputStream(vi.elements());
//        byte[] temp=new byte[1024];
//        int len;
//        while ((len =sis.read(temp))!=-1){
//            os.write(temp,0,len);
//        }
//        os.flush();
//        sis.close();
//        os.close();


    }
}
