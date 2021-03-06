import java.io.*;
import java.net.InetSocketAddress;
import java.net.Socket;

public class SocketTest {
    public static void main(String[] args) throws Exception {

        InetSocketAddress isa = new InetSocketAddress("www.cobight.cn",80);
        Socket socket = new Socket();
        socket.connect(isa);
        String strSend = "GET /index.html HTTP/1.1\r\nHost: " + "www.cobight.cn" + "\r\nConnection: Close\r\n\r\n";
        OutputStream outputStream = socket.getOutputStream();
        InputStream inputStream = socket.getInputStream();
        byte[] bytes = strSend.getBytes();
        outputStream.write(bytes);
        outputStream.flush();

        InputStreamReader inputStreamReader = new InputStreamReader(inputStream);
        BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
        String line;
        while((line = bufferedReader.readLine()) != null) {

            System.out.println(line);
        }
        //要关闭各种
        bufferedReader.close();
        inputStreamReader.close();
        inputStream.close();
        outputStream.close();
        socket.close();

    }
}
