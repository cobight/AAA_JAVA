import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.SocketException;

public class SocketDemo1 {
    public static void main(String[] args) {
        try {
            String PATH = System.getProperty("user.dir");//项目根目录
            System.out.println("项目根目录："+PATH);
            //初始化服务端socket并且绑定9999端口
            ServerSocket serverSocket = new ServerSocket(9999);
            serverSocket.setSoTimeout(10000);
            //等待客户端的连接
            Socket socket;
            while ((socket = serverSocket.accept())!=null){

//            Socket socket = serverSocket.accept();
                //获取输入流
                BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
                //读取一行数据
                String str;
                String URLPATH = null;
                while (!(str = bufferedReader.readLine()).equals("")) {
                    if (str.contains("GET")) {
                        URLPATH = str.substring(4, str.length() - 9);
                        System.out.println("浏览器发送的请求URL=" + URLPATH);
                    }
                    //输出打印浏览器的请求头
                    System.out.println(str);
                }
                System.out.println("===========================");
                System.out.println("读取结束，开始响应");
                System.out.println("===========================");


                if (URLPATH != null && socket.isConnected()) {
                    System.out.println("请求地址：" + PATH + URLPATH);
                    BufferedInputStream bis = new BufferedInputStream(new FileInputStream(PATH + URLPATH));
                    BufferedOutputStream bos = new BufferedOutputStream(socket.getOutputStream());
                    String retn = "HTTP/1.1 200 OK\n" +
                            "Date: Fri, 24 Jul 2020 12:42:08 GMT\n" +
                            "Content-Type: image/jpg\n" +
                            "Last-Modified: Mon, 04 Mar 2019 12:26:20 GMT\n" +
                            "Connection: close\n" +
                            "ETag: \"5c7d196c-1e8\"\n" +
                            "Accept-Ranges: bytes\n\n";
                    bos.write(retn.getBytes());

                    byte[] data = new byte[1024];
                    int length;
                    while ((length = bis.read(data)) != -1) {
                        bos.write(data, 0, length);
                    }
                    bos.flush();
                    bufferedReader.close();
                    bis.close();
                    bos.close();
                    System.out.println("响应完毕");
                }
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
