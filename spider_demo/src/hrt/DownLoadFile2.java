package hrt;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.URL;
import java.net.URLConnection;
import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Objects;
import java.util.concurrent.TimeUnit;

public class DownLoadFile2 {
    public static void main(String[] args) throws Exception {
        Tool tool = new Tool();
        tool.getHtml();//获取网页的html文档
        tool.getUl();//解析html文档，获取对应的ul标签列表
        tool.getLi();//解析ul列表里的ul数据，获取li标签里的数据（保存类型为li_data）
        tool.showLi();//展示所有数据
        ArrayList<li_data> list = tool.li_list;
        for (hrt.li_data li_data : list) {
            System.out.println(li_data.m3u8);
            File f = new File("download\\" + li_data.date + "" + li_data.id);
            if (!f.exists()) {
                System.out.println(f.mkdirs()?"成功生成目录！":"文件夹创建失败！");
                //第i个数据，创建对应的文件夹，后续下载的视频切片都保存在此
            }
//            TimeUnit.MILLISECONDS.sleep(1000);//当前线程休息1000毫秒
            Tool_m3u8 t = new Tool_m3u8();//m3u8视频格式的下载工具类
            t.load_m3u8(li_data.m3u8, li_data.date + "" + li_data.id);
        }
    }
}
class Tool{
    private String index_page = null;
    private ArrayList<String> ul_list = new ArrayList<>();
    public ArrayList<li_data> li_list = new ArrayList<>();
    public void getHtml() {
        try {
            StringBuilder html = new StringBuilder();
            String URL = "https://www.547ch.com/";
            java.net.URL url = new java.net.URL(URL); //根据 String 表示形式创建 URL 对象。
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
            this.index_page = html.toString();//数据保存成员变量里
            System.out.println(URL+"\t加载完毕");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public void getUl(){
        int left=0,right=0;

        left = index_page.indexOf("<ul>",right);
        right = index_page.indexOf("</ul>",left);

        left = index_page.indexOf("<ul>",right);
        right = index_page.indexOf("</ul>",left);


        left = index_page.indexOf("<ul>",right);
        right = index_page.indexOf("</ul>",left)+5;
//        System.out.println(index_page.substring(left, right));
        ul_list.add(index_page.substring(left,right));
        left = index_page.indexOf("<ul>",right);
        right = index_page.indexOf("</ul>",left)+5;
//        System.out.println(index_page.substring(left, right));
        ul_list.add(index_page.substring(left,right));
        left = index_page.indexOf("<ul>",right);
        right = index_page.indexOf("</ul>",left)+5;
//        System.out.println(index_page.substring(left, right));
        ul_list.add(index_page.substring(left,right));
        left = index_page.indexOf("<ul>",right);
        right = index_page.indexOf("</ul>",left)+5;
//        System.out.println(index_page.substring(left, right));
        ul_list.add(index_page.substring(left,right));

    }
    public void getLi(){
        //https://pho.038vg.com/Uploads/vod/2020-07-25/1002.mp4.gif.jpg
        for (String str : ul_list) {
            int left = 0, right = 0;
            for (int i1 = 0; i1 < 6; i1++) {
                left = str.indexOf("https://pho.038vg.com/Uploads/vod/", right) + 34;
                right = str.indexOf(".mp4.gif.jpg", left);
//                System.out.println(str.substring(left,right));
                String[] msg = str.substring(left, right).split("/");
                left = str.indexOf("target=\"_blank\">", right) + 16;
                right = str.indexOf("</a></h3>", left);
                String name = (str.substring(left, right));
                li_list.add(new li_data("https://play.093ch.com/" + msg[0].replace("-", "") + "/" + msg[1].substring(0, msg[1].length() - 1) + "/" + msg[1] + "/" + msg[1] + ".mp4.m3u8", name, msg[0].replace("-", ""), msg[1]));
            }
        }
    }
    public void showLi(){
        for (hrt.li_data li_data : li_list) {
            System.out.println(li_data);
        }
    }
}
class li_data{
    String m3u8;
    String name;
    String date;
    String id;

    public li_data(String m3u8, String name, String date, String id) {
        this.m3u8 = m3u8;
        this.name = name;
        this.date = date;
        this.id = id;
    }

    @Override
    public String toString() {
        return "li_data{" +
                "m3u8='" + m3u8 + '\'' +
                ", name='" + name + '\'' +
                '}';
    }
}
class Tool_m3u8{
    public void load_m3u8(String url,String file) throws Exception {
        String m = HttpRequest.sendGet(url,"");
//        System.out.println(m);//获取m3u8切片数据
        String uri = url.substring(0,url.lastIndexOf("/")+1);
        ArrayList<String> list = getM3u8_ItemList(m,uri);
//        System.out.println(list.size());获取切片视频的数量，后续合并切片文件到视频
        ArrayList<DownloadThread> threadlist = new ArrayList<>();//存放new的下载线程
        for (int i = 0; i < list.size(); i++) {
//            System.out.println(list.get(i));
            DownloadThread dt = new DownloadThread(list.get(i),"download/"+file+"/file.mp4"+i+".ts");
            dt.start();
            threadlist.add(dt);
            if (i % 15==0){
                TimeUnit.MILLISECONDS.sleep(3000);//毫秒
            }
        }
        for (DownloadThread downloadThread : threadlist) {
            downloadThread.join();//用了join，主线程就得等我执行完
        }
        merge_ts("download/"+file);//切片视频下载完，开始合并视频



//        System.out.println(m);
        //cmd控制台的合并文件语句
//        copy /b  F:\JAVA\AAA_JAVA\download\202007261001\file.mp4*.ts  F:\JAVA\AAA_JAVA\download\202007261001\test.mp4

    }
    public ArrayList<String> getM3u8_ItemList(String info,String uri){
        String[] arr = info.split("\n");//分割m3u8里的字符串数据
        ArrayList<String> list = new ArrayList<>();
        for (String s : arr) {
            if (s.contains(".ts")) {//找ts结尾的
                list.add(uri + s);
            }
        }
        return list;
    }
    public void merge_ts(String PATH){
        File directory = new File(PATH);
        //获取所有当前文件下的所有切片数据.ts文件
        ArrayList<File> list = new ArrayList<>(Arrays.asList(Objects.requireNonNull(directory.listFiles())));
        //排序
        list.sort(new Comparator<File>() {
            @Override
            public int compare(File o1, File o2) {
//                System.out.println(o1.getName().substring(9, o1.getName().length() - 3));
                int ind1 = Integer.parseInt(o1.getName().substring(8,o1.getName().length()-3));
                int ind2 = Integer.parseInt(o2.getName().substring(8,o2.getName().length()-3));
                return ind1-ind2;
            }
        });
        //查看排序后的列表
//        for (int i = 0; i < list.size(); i++) {
//            System.out.println(list.get(i).getName());
//        }
        String outputPATH=PATH+"\\file.mp4";
        try {
            OutputStream os = new FileOutputStream(outputPATH);
            for (int i = 0; i < list.size(); i++) {
                InputStream is = new FileInputStream(PATH+"\\file.mp4"+i+".ts");//我记得想用list.get(i)来着
                byte[] temp = new byte[1024];
                int len;
                while ((len=is.read(temp))!=-1){
                    os.write(temp,0,len);
                    os.flush();
                }
                is.close();
            }
            os.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
class HttpRequest {
    /**
     * 向指定URL发送GET方法的请求，返回字符串
     *
     * @param url
     *            发送请求的URL
     * @param param
     *            请求参数，请求参数应该是 name1=value1&name2=value2 的形式。
     * @return URL 所代表远程资源的响应结果
     */
    public static String sendGet(String url, String param) {
        StringBuilder result = new StringBuilder();
        BufferedReader in = null;
        try {
            String urlNameString = url + "?" + param;
            URL realUrl = new URL(urlNameString);
            // 打开和URL之间的连接
            URLConnection connection = realUrl.openConnection();
            // 设置通用的请求属性
            connection.setRequestProperty("User-Agent",
                    "Mozilla/5.0 (Windows NT 10.0; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/70.0.3538.25 Safari/537.36 Core/1.70.3756.400 QQBrowser/10.5.4039.400");
            // 建立实际的连接
            connection.connect();
            // 获取所有响应头字段
//            Map<String, List<String>> map = connection.getHeaderFields();
//            // 遍历所有的响应头字段
//            for (String key : map.keySet()) {
//                System.out.println(key + "--->" + map.get(key));
//            }
            // 定义 BufferedReader输入流来读取URL的响应
            in = new BufferedReader(new InputStreamReader(
                    connection.getInputStream()));
            String line;
            while ((line = in.readLine()) != null) {
                result.append(line).append("\n");
            }
            return result.toString();
        } catch (Exception e) {
            System.out.println("发送GET请求出现异常！" + url);
//            e.printStackTrace();
            return sendGet(url, param);
        }
        // 使用finally块来关闭输入流
        finally {
            try {
                if (in != null) {
                    in.close();
                }
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }

    }

    /**
     * 向指定 URL 发送POST方法的请求
     *
     * @param url
     *            发送请求的 URL
     * @param param
     *            请求参数，请求参数应该是 name1=value1&name2=value2 的形式。
     * @return 所代表远程资源的响应结果
     */
    public static String sendPost(String url, String param) {
        PrintWriter out = null;
        BufferedReader in = null;
        StringBuilder result = new StringBuilder();
        try {
            URL realUrl = new URL(url);
            // 打开和URL之间的连接
            URLConnection conn = realUrl.openConnection();
            // 设置通用的请求属性
            conn.setRequestProperty("accept", "*/*");
            conn.setRequestProperty("connection", "Keep-Alive");
            conn.setRequestProperty("user-agent",
                    "Mozilla/4.0 (compatible; MSIE 6.0; Windows NT 5.1;SV1)");
            // 发送POST请求必须设置如下两行
            conn.setDoOutput(true);
            conn.setDoInput(true);
            // 获取URLConnection对象对应的输出流
            out = new PrintWriter(conn.getOutputStream());
            // 发送请求参数
            out.print(param);
            // flush输出流的缓冲
            out.flush();
            // 定义BufferedReader输入流来读取URL的响应
            in = new BufferedReader(
                    new InputStreamReader(conn.getInputStream()));
            String line;
            while ((line = in.readLine()) != null) {
                result.append(line);
            }
        } catch (Exception e) {
            System.out.println("发送 POST 请求出现异常！"+e);
            e.printStackTrace();
        }
        //使用finally块来关闭输出流、输入流
        finally{
            try{
                if(out!=null){
                    out.close();
                }
                if(in!=null){
                    in.close();
                }
            }
            catch(IOException ex){
                ex.printStackTrace();
            }
        }
        return result.toString();
    }

    /**
     * 文件下载与保存
     */
    public static void download_file(String url, String filepath) {
        InputStream is = null;
        FileOutputStream fos = null;
        try {
            URL realUrl = new URL(url);
            // 打开和URL之间的连接
            URLConnection connection = realUrl.openConnection();
            // 设置通用的请求属性头
            connection.setRequestProperty("accept", "*/*");
            connection.setRequestProperty("connection", "Keep-Alive");
            connection.setRequestProperty("user-agent",
                    "Mozilla/4.0 (compatible; MSIE 6.0; Windows NT 5.1;SV1)");
            // 建立实际的连接
            connection.connect();
            // 获取所有响应头字段
//            Map<String, List<String>> map = connection.getHeaderFields();
//            // 遍历所有的响应头字段
//            for (String key : map.keySet()) {
//                System.out.println(key + "--->" + map.get(key));
//            }
            // 定义 BufferedReader输入流来读取URL的响应
            is = new BufferedInputStream(connection.getInputStream());
            fos = new FileOutputStream(filepath);

            byte[] temp = new byte[1024];
            int len;
            while ((len = is.read(temp)) != -1) {
                fos.write(temp,0,len);
            }

        } catch (Exception e) {
            System.out.println("ts切片下载出现异常！开始重新下载：" + url);
//            e.printStackTrace();异常重载
            download_file(url, filepath);
        }finally {
            try{
                if (is!=null){
                    is.close();
                }
                if (fos!=null){
                    fos.close();
                }
            }catch (Exception e){
                e.printStackTrace();
            }
        }
        // 使用finally块来关闭输入流


    }

}
class DownloadThread extends Thread{
    private String url;
    private String filepath;

    public DownloadThread(String url,String filepath) {
        this.url=url;//切片地址
        this.filepath=filepath;//保存路径
    }

    @Override
    public void run(){
        System.out.println(this.url);
        HttpRequest.download_file(this.url,this.filepath);
    }
}