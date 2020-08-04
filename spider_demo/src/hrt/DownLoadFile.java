package hrt;

import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.net.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class DownLoadFile {
    public static void main(String[] args) {

//        String imgUrl = "https://imges.88x.la/Img/2020-06/u93Q4y.jpg";
//        downloadImgByNet(imgUrl,"F:\\JAVA\\AAA_JAVA\\spider_demo\\download",getFileName(imgUrl));
        String path = System.getProperty("user.dir");

        String p = "https://www.1123ye.com/Pic/index.html";
        System.out.println(p.substring(p.lastIndexOf("/")+1, p.lastIndexOf(".")));

        Pages pages = new Pages(1,"https://www.1123ye.com/Pic/index.html");
//        Pages pages = new Pages();
        ArrayList<String> list1 = pages.map.get(1);
        for (int i = 0; i < list1.size(); i++) {
            String path1 = list1.get(i);
            ArrayList<String> list = pages.getImgUrlList(path1);

            for (int j = 0; j < list.size(); j++) {
                int f=j;
                new Thread(new Runnable() {
                    @Override
                    public void run() {
                        ImgControl.downloadImgByNet(list.get(f),
                                path+"\\download\\"+path1.substring(path1.lastIndexOf("/")+1,path1.lastIndexOf(".")),ImgControl.getFileName(list.get(f)));
                    }
                }).start();

            }
        }

    }
}
class Pages{
    public int num=0;
    public HashMap<Integer,ArrayList<String>> map = new HashMap<>();//页数，html列表
    public Pages(){

    }
    public Pages(int index,String indexUrl){
        String html = getHtml(indexUrl);
        map.put(index,getList(html));
//        System.out.println(getList(html));
//        System.out.println(html);
    }
    public ArrayList<String> getList(String htmlPage) {
        String div = getDiv(htmlPage,"<div class=\"list\">","</div>");
        return getLiList(div);
    }
    private String getDiv(String html,String start,String stop){
        int a = html.indexOf(start);
        int b = html.indexOf(stop,a);
        return html.substring(a,b+stop.toCharArray().length);
    }
    private ArrayList<String> getLiList(String ul){
        System.out.println(ul);
        Matcher matcher = Pattern.compile("<li>(.*?)</li>").matcher(ul);
        ArrayList<String> list = new ArrayList<>();
        for (; matcher.find(); ) {

            list.add("https://www.1123ye.com"+getA(matcher.group(1)));
        }
        System.out.println(list);
        System.out.println(num=list.size());
        return list;
    }
    private String getHtml(String urlString) {
        try {
            StringBuilder html = new StringBuilder();
            java.net.URL url = new java.net.URL(urlString); //根据 String 表示形式创建 URL 对象。
            java.net.HttpURLConnection conn = (java.net.HttpURLConnection) url.openConnection();// 返回一个dao URLConnection 对象，它表示到 URL 所引用的远程对象的连接。
            conn.setRequestProperty("User-Agent", "Mozilla/5.0 (Windows NT 10.0; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/70.0.3538.25 Safari/537.36 Core/1.70.3756.400 QQBrowser/10.5.4039.400");
            java.io.InputStreamReader isr = new java.io.InputStreamReader(conn.getInputStream());//返回从此打开的连接读取的输入流。
            java.io.BufferedReader br = new java.io.BufferedReader(isr);//创建一个使用默认大小输入缓冲区的缓冲字符输入流。
            String temp;
            while ((temp = br.readLine()) != null) { //按行读取输出流
                if(!temp.trim().equals("")){
                    html.append(temp).append("\n"); //读完每行后换行
                }
            }
            br.close(); //关闭
            isr.close(); //关闭
            return html.toString(); //返回此序列中数据的字符串表示形式。
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
    private String getA(String a){
        Matcher matcher = Pattern.compile("<a href=\"(.*?)\"").matcher(a);
        matcher.find();
        return matcher.group(1);
    }
    //加载页
    public ArrayList<String> getImgUrlList(String url){
        String html = getHtml(url);
        String div = getDiv(html,"<div class=\"jianjie img\">","</div>");

        return getImgUrl(div);
    }
    private ArrayList<String> getImgUrl(String div){
        Matcher matcher = Pattern.compile("<img src='(.*?)'").matcher(div);
        ArrayList<String> list = new ArrayList<>();

        for (;matcher.find();){
            list.add(matcher.group(1));
        }
        System.out.println(list);
        return list;
    }
}
class ImgControl{
    public static String getFileName(String imgSrc){
        return imgSrc.substring(imgSrc.lastIndexOf("/")+1,imgSrc.length());
    }
    public static void downloadImgByNet(String imgSrc,String filePath,String fileName){
        try{
            URL url = new URL(imgSrc);
            URLConnection conn = url.openConnection();
//设置超时间为3秒
            conn.setConnectTimeout(3*1000);
//防止屏蔽程序抓取而返回403错误
            conn.setRequestProperty("User-Agent", "Mozilla/5.0 (Windows NT 10.0; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/70.0.3538.25 Safari/537.36 Core/1.70.3756.400 QQBrowser/10.5.4039.400");
//输出流
            InputStream str = conn.getInputStream();
//控制流的大小为1k
            byte[] bs = new byte[1024];
//读取到的长度
            int len = 0;
//是否需要创建文件夹
            File saveDir = new File(filePath);
            if(!saveDir.exists()){
                saveDir.mkdir();
            }
            File file = new File(saveDir+File.separator+fileName);
//实例输出一个对象
            FileOutputStream out = new FileOutputStream(file);
//循环判断，如果读取的个数b为空了，则is.read()方法返回-1，具体请参考InputStream的read();
            while ((len = str.read(bs)) != -1) {
//将对象写入到对应的文件中
                out.write(bs, 0, len);
            }
//刷新流
            out.flush();
//关闭流
            out.close();
            str.close();
            System.out.println("下载成功");
        }catch (Exception e) {
            e.printStackTrace();
        }
    }
}
