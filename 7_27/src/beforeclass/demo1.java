package beforeclass;

import java.io.*;

public class demo1 {
    public static void main(String[] args) throws Exception {
        File f= new File("msg.txt");
        File nf = new File("msg1.txt");
        Reader r = new BufferedReader(new FileReader(f));
        Writer w = new BufferedWriter(new FileWriter(nf));
        int temp;
        while ((temp=r.read())!=-1){
            char c = (char)temp;
            w.write(c);
        }
        w.flush();
        w.close();
        r.close();
    }
}
