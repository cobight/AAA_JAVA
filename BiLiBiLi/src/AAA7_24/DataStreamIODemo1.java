package AAA7_24;

import com.sun.xml.internal.messaging.saaj.util.ByteOutputStream;

import java.io.*;
import java.net.URL;

public class DataStreamIODemo1 {
    public static void main(String[] args) throws IOException {
//        new URL("http://baidu.com").openStream();
        //写
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        DataOutputStream dos = new DataOutputStream(new BufferedOutputStream(baos));
        dos.writeUTF("我真TM没开挂！");
        dos.writeInt(18);
        dos.writeBoolean(true);
        dos.writeChar('F');
        dos.writeChars("do u love me");
        dos.flush();
        byte[] data = baos.toByteArray();

        //读

        DataInputStream dis = new DataInputStream(new BufferedInputStream(new ByteArrayInputStream(data)));
        String UTF = dis.readUTF();
        int ints = dis.readInt();
        boolean bl = dis.readBoolean();
        char c = dis.readChar();
        char chars = dis.readChar();
        System.out.println(UTF);
        System.out.println(ints);
        System.out.println(bl);
        System.out.println(c);
        System.out.println(chars);
        System.out.println(dis.readChar());
        System.out.println(dis.readChar());
        System.out.println(dis.readChar());
        System.out.println(dis.readChar());
        System.out.println(dis.readChar());

    }
}
