# AAA_自学高级篇

2020-7-18夜

# IO

## File

### 文件路径

**参数path可以是不存在的文件路径**

创建个File对象

```java
File file = new File（path绝对路径）
file.getAbsolutePath()//返回文件绝对路径
System.getProperty("user.dir")//返回当前项目的根目录
```

### 路径的省略

```java
File src = new File("IO.png");//省略写法
File src = new File(System.getProperty("user.dir"),"io.png");//原写法
					parentPath						childrenPath
```

### 获取路径

getName()获取文件名

getPath()获取相对路径，也就是new File时传的路径参数

getAbsolutePath()获取绝对路径，即使new的时候传的相对路径，他也会返回完整的绝对路径

getParent()获取父路径，构建时写了会返回，没写就返回空

### 判断状态

| File file = new File("xxx") |                |
| --------------------------- | -------------- |
| exist()                     | 路径是否存在   |
| isFile()                    | 是不是文件     |
| isDirectory()               | 是不是文件夹   |
| isAbsolute()                | 是不是绝对路径 |
| length()                    | 文件大小       |



```java
File file = new File("F:/JAVA/AAA_JAVA/README.md");
System.out.println(file.isAbsolute());
System.out.println(file.isDirectory());
System.out.println(file.isFile());
System.out.println(file.exists());
获取父对象的文件名
file.getParentFile().getName();
```



### 文件的创建与删除



| 代码                              | 意义                               |
| --------------------------------- | ---------------------------------- |
| boolen * = file.createNewFile（） | 创建文件                           |
| boolen * = file.delete()          | 删除文件                           |
| boolen * = mkdir()                | 上级目录存在才能创建，否则创建失败 |
| boolen * = mkdirs()               | 上级目录不存在，一同创建           |



### 文件夹内容

遍历一个文件，且指定深度

```java
public class FileDemo1 {
    public static void main(String[] args) {
        File file = new File("download");
        System.out.println(file.getAbsoluteFile());
//        printName(file,2);
    }
    public static void printName(File src,int deep){
        if (deep>0){
            deep--;
            for (File files: Objects.requireNonNull(src.listFiles())){
                if (files.isFile()){
                    System.out.println(files.getName());
                }else if (files.isDirectory()){
                    System.out.println(files.getPath());
                    printName(files,deep);
                }else {

                }

            }
        }

    }
}

```



## IO四大抽象类



| 抽象类       | 说明                             | 常用方法 |
| ------------ | -------------------------------- | -------- |
| InputStream  | 字节输入流的父类，数据单位为字节 | int read()<br>void close()         |
| OutputStream | 字节输出流的父类，数据单位为字节 | void write(int)<br>void flush()<br>void close() |
| Reader       | 字符输入流的父类，数据单位为字符 | void read()<br>void close() |
| Writer       | 字节输出流的父类，数据单位为字符 | void write(String)<br>void flush()<br>void close() |



## 文件输入流

FileInputStream

```java
File file = new File("msg.txt");//adc
try {
    InputStream is = new FileInputStream(file);
    int data1 = is.read();
    int data2 = is.read();
    int data3 = is.read();
    int data4 = is.read();
    System.out.println((char)data1);
    System.out.println((char)data2);
    System.out.println((char)data3);
    System.out.println(data4);
    is.close();
} catch (IOException e) {
    e.printStackTrace();
}
out：
    a
    b
    c
    -1
```



```java
File file = new File("msg.txt");
try {
    InputStream is = new FileInputStream(file);
    int temp ;
    //            byte[] b = new byte[1024];
    //            is.read(b);
    //            String msg = new String(b);
    //            System.out.println(msg.toCharArray().length);//1024,他把0也算上了
    //            System.out.println(msg);

    StringBuilder arr= new StringBuilder();
    while ((temp=is.read())!=-1){
        arr.append((char) temp);//不加char就是数字拼接
    }
    System.out.println(arr.length());//3，有多少算多少
    System.out.println(arr.toString());

    //            int data1 = is.read();
    //            int data2 = is.read();
    //            int data3 = is.read();
    //            int data4 = is.read();
    //            System.out.println((char)data1);
    //            System.out.println((char)data2);
    //            System.out.println((char)data3);
    //            System.out.println(data4);
    is.close();
} catch (IOException e) {
    e.printStackTrace();
}
```



















 