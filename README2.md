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



## 初步了解



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

## InputStream与OutputStream

InputStream

| Modifier and Type | Method and Description                                       |
| ----------------- | ------------------------------------------------------------ |
| `int`             | `available()`  返回一个可以从这个输入流读取（或跳过）的字节数的估计值，而不阻塞该输入流的下一个方法的调用。 |
| `void`            | `close()`  关闭此输入流并释放与流关联的任何系统资源。        |
| `void`            | `mark(int readlimit)`  标记此输入流中的当前位置。            |
| `boolean`         | `markSupported()`  如果输入流的支持 `mark`和  `reset`方法。  |
| `abstract int`    | `read()`  从输入流读取下一个数据字节。                       |
| `int`             | `read(byte[] b)`  读取一定数量的字节从输入流并存入缓冲区阵列 `b`。 |
| `int`             | `read(byte[] b,  int off, int len)`  读到 `len`字节从输入流读入字节数组数据。 |
| `void`            | `reset()`  重新定位该流在时间的 `mark`方法的位置上呼吁这个输入流。 |
| `long`            | `skip(long n)`  跳过并丢弃 `n`字节从输入流中的数据。         |



OutputStream

| Modifier and Type | Method and Description                                       |
| ----------------- | ------------------------------------------------------------ |
| `void`            | `close()`  关闭此输出流并释放与此流关联的任何系统资源。      |
| `void`            | `flush()`  刷新输出流，使缓存数据被写出来。                  |
| `void`            | `write(byte[] b)`  写 `b.length`字节从指定的字节数组的输出流。 |
| `void`            | `write(byte[] b,  int off, int len)`  写 `len`字节指定字节数组中的偏移  `off`开始到输出流。 |
| `abstract void`   | `write(int b)`  将指定的字节写入该输出流中。                 |





### FileInputStream与FileOutputStream

#### FileInputStream读数据

| Modifier and Type | Method and Description                                       |
| ----------------- | ------------------------------------------------------------ |
| `int`             | `available()`  返回一个剩余的字节数的估计，可以从这个输入流读取（或跳过），而不阻塞该输入流的方法的下一次调用。 |
| `void`            | `close()`  关闭此文件输入流并释放与流关联的任何系统资源。    |
| `protected void`  | `finalize()`  确保该文件输入流的 `close`方法被调用时，没有对它的引用。 |
| `FileChannel`     | `getChannel()`  返回与此文件输入流有关的独特的 [`FileChannel`]对象。 |
| `FileDescriptor`  | `getFD()`  返回表示实际的文件在文件系统中的  `FileInputStream`使用的连接的 `FileDescriptor`对象。 |
| `int`             | `read()`  从这个输入流读取一个字节的数据。                   |
| `int`             | `read(byte[] b)`  读到 `b.length`从输入流到字节数组数据字节。 |
| `int`             | `read(byte[] b,  int off, int len)`  读到 `len`从输入流到字节数组数据字节。 |
| `long`            | `skip(long n)`  跳过并丢弃 `n`字节输入流中的数据。           |

#### FileOutputStream写数据


| Modifier and Type | Method and Description                                       |
| ----------------- | ------------------------------------------------------------ |
| `void`            | `close()`  关闭此文件输出流并释放与此流关联的任何系统资源。  |
| `protected void`  | `finalize()`  清理文件的连接，并确保此文件输出流的  `close`方法被调用时，没有引用此流。 |
| `FileChannel`     | `getChannel()`  返回唯一 [`FileChannel`]对象与此文件输出流相关。 |
| `FileDescriptor`  | `getFD()`  返回与此流关联的文件描述符。                      |
| `void`            | `write(byte[] b)`  写 `b.length`字节从指定的字节数组来此文件输出流。 |
| `void`            | `write(byte[] b,  int off, int len)`  写 `len`字节指定字节数组中的起始偏移  `off`此文件输出流。 |
| `void`            | `write(int b)`  将指定的字节写入该文件输出流中。             |





```java
File file = new File("7_22\\src\\beforeclass\\demo1.java");
File file1 = new File("msg1.txt");
InputStream is = null;
OutputStream os = null;
try {
    is = new FileInputStream(file);
    os = new FileOutputStream(file1);

    byte[] temp = new byte[1024*10];
    int length;
    while ((length=is.read(temp))!=-1){
        os.write(temp,0,length);
        os.flush();
    }
    //            os.write("giao".getBytes());
    //            os.flush();

    is.close();
    os.close();
} catch (IOException e) {
    e.printStackTrace();
}finally {
    try {
        if (is != null) {
            is.close();
        }
        if (os != null) {
            os.close();
        }
    } catch (IOException e) {
        e.printStackTrace();
    }
}
```



### Reader与Writer



#### Reader

| Modifier and Type | Method and Description                                       |
| ----------------- | ------------------------------------------------------------ |
| `abstract void`   | `close()`  关闭流并释放与它相关联的任何系统资源。            |
| `void`            | `mark(int readAheadLimit)`  标记流中的当前位置。             |
| `boolean`         | `markSupported()`  告诉这是否流支持的mark()操作。            |
| `int`             | `read()`  读取单个字符。                                     |
| `int`             | `read(char[] cbuf)`  将字符读入一个数组。                    |
| `abstract int`    | `read(char[] cbuf,  int off, int len)`  将字符读入一个数组的一部分。 |
| `int`             | `read(CharBuffer target)`  试图将字符读入指定的字符缓冲区中。 |
| `boolean`         | `ready()`  告诉是否该流已准备好阅读。                        |
| `void`            | `reset()`  重置流。                                          |
| `long`            | `skip(long n)`  跳过的字符。                                 |



#### Writer

| Modifier and Type | Method and Description                                       |
| ----------------- | ------------------------------------------------------------ |
| `Writer`          | `append(char c)`  将指定的字符到这个作家。                   |
| `Writer`          | `append(CharSequence csq)`  将指定的字符序列，这个作家。     |
| `Writer`          | `append(CharSequence csq, int start,  int end)`  添加一个序列指定的字符序列，这个作家。 |
| `abstract void`   | `close()`  关闭流，冲洗它。                                  |
| `abstract void`   | `flush()`  冲流。                                            |
| `void`            | `write(char[] cbuf)`  写一个字符数组。                       |
| `abstract void`   | `write(char[] cbuf,  int off, int len)`  写入一个字符数组的一部分。 |
| `void`            | `write(int c)`  写一个字符。                                 |
| `void`            | `write(String str)`  写一个字符串。                          |
| `void`            | `write(String str,  int off, int len)`  写入字符串的一部分。 |



#### InputStreamReader

实现类：FileReader

| Modifier and Type | Method and Description                                       |
| ----------------- | ------------------------------------------------------------ |
| `void`            | `close()`  关闭流并释放与它相关联的任何系统资源。            |
| `String`          | `getEncoding()`  返回此流使用的字符编码的名称。              |
| `int`             | `read()`  读取单个字符。                                     |
| `int`             | `read(char[] cbuf,  int offset, int length)`  将字符读入一个数组的一部分。 |
| `boolean`         | `ready()`  告诉是否该流已准备好阅读。                        |



#### OutputStreamWriter

实现类：FileWriter

| Modifier and Type | Method and Description                                       |
| ----------------- | ------------------------------------------------------------ |
| `void`            | `close()`  关闭流，冲洗它。                                  |
| `void`            | `flush()`  冲流。                                            |
| `String`          | `getEncoding()`  返回此流使用的字符编码的名称。              |
| `void`            | `write(char[] cbuf,  int off, int len)`  写入一个字符数组的一部分。 |
| `void`            | `write(int c)`  写一个字符。                                 |
| `void`            | `write(String str,  int off, int len)`  写入字符串的一部分。 |



```java
File file = new File("7_22\\src\\beforeclass\\demo1.java");
        File file1 = new File("msg1.txt");
        Reader reader = null;
        Writer writer = null;
        try {
            reader = new FileReader(file);
            writer = new FileWriter(file1);
            char[] temp = new char[1024*10];
            int length;
            while ((length=reader.read(temp))!=-1){
                writer.append(new String(temp,0,length));
                writer.flush();
            }
//            writer.append("giao").append("fuc");
//            writer.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            try {
                if (reader != null) {
                    reader.close();
                }
                if (writer != null) {
                    writer.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
```





### ByteArrayInputStream与ByteArrayOutputStream

#### ByteArrayInputStream

| Modifier and Type  | Field and Description                                     |
| ------------------ | --------------------------------------------------------- |
| `protected byte[]` | `buf`  由流的创建者提供的字节数组。                       |
| `protected int`    | `count`  输入流缓冲区中的最后一个有效字符的索引一个大于。 |
| `protected int`    | `mark`  当前在流中的标记位置。                            |
| `protected int`    | `pos`  从输入流缓冲区读取的下一个字符的索引。             |



#### ByteArrayOutputStream

| Modifier and Type | Method and Description                                       |
| ----------------- | ------------------------------------------------------------ |
| `void`            | `close()`  关闭 `ByteArrayOutputStream`没有影响。            |
| `void`            | `reset()`  将这个字节数组输出流的  `count`场为零，因此，目前累计输出输出流被丢弃。 |
| `int`             | `size()`  返回缓冲区的当前大小。                             |
| `byte[]`          | `toByteArray()`  创建一个新分配的字节数组。                  |
| `String`          | `toString()`  使用该平台的默认字符集将缓冲区的内容转换为字符串解码字节。 |
| `String`          | `toString(int hibyte)`  过时的。  这种方法不正确地将字节转换为字符。作为 JDK 1.1，这样的首选方式是通过`toString(String  enc)`方法，它以一个编码名称的争论，或`toString()`方法，使用平台的默认字符编码。 |
| `String`          | `toString(String charsetName)`  将缓冲区的内容到一个字符串使用命名 [`charset`](../../java/nio/charset/Charset.html)解码字节。 |
| `void`            | `write(byte[] b,  int off, int len)`  写 `len`字节指定字节数组中的起始偏移  `off`这个字节数组输出流。 |
| `void`            | `write(int b)`  将指定的字节写入该字节数组输出流中。         |
| `void`            | `writeTo(OutputStream out)`  写这个字节数组输出流的完整内容到指定的输出流的说法，如果通过调用输出流的写法  `out.write(buf, 0, count)`。 |



```java
byte[] dest = null;
ByteArrayInputStream bi  = null;
ByteArrayOutputStream bo = null;
String infomsg = "show me the code!";
byte[] datas = infomsg.getBytes();
try{
    bo = new ByteArrayOutputStream();
    bo.write(datas,0,datas.length);
    bo.flush();
    dest = bo.toByteArray();

    bi = new ByteArrayInputStream(dest);
    int c;
    while ((c=bi.read())!=-1){
        System.out.print((char)c);
    }
} catch (Exception e) {
    e.printStackTrace();
}
```





### BufferedInputStream与BufferedOutputStream

缓冲输入输出流(JVM层)

通过设置这样的输入输出流，一个应用程序可以读写字节到基本的输入输出流，而不必导致每个字节写入的底层系统的调用。

#### BufferedInputStream

| Modifier and Type | Method and Description                                       |
| ----------------- | ------------------------------------------------------------ |
| `int`             | `available()`  返回一个可以从这个输入流读取（或跳过）的字节数的估计值，而不阻塞该输入流的下一个方法的调用。 |
| `void`            | `close()`  关闭此输入流并释放与流关联的任何系统资源。        |
| `void`            | `mark(int readlimit)`  看到的 `InputStream`的  `mark`方法一般合同。 |
| `boolean`         | `markSupported()`  如果输入流的支持 `mark`和  `reset`方法。  |
| `int`             | `read()`  看到的 `InputStream`的  `read`方法一般合同。       |
| `int`             | `read(byte[] b,  int off, int len)`  从这个字节的输入流读取到指定的字节数组中的字节，从给定的偏移量开始。 |
| `void`            | `reset()`  看到的 `InputStream`的  `reset`方法一般合同。     |
| `long`            | `skip(long n)`  看到的 `InputStream`的  `skip`方法一般合同。 |

#### BufferedOutputStream

| Modifier and Type | Method and Description                                       |
| ----------------- | ------------------------------------------------------------ |
| `void`            | `flush()`  刷新缓冲输出流。                                  |
| `void`            | `write(byte[] b,  int off, int len)`  写 `len`字节指定字节数组中的起始偏移  `off`这个缓冲输出流。 |
| `void`            | `write(int b)`  将指定的字节写入该缓冲输出流中。             |





```java
class Util{
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
    public static byte[] readBuffered(String path){
        try(InputStream is = new BufferedInputStream(new FileInputStream(new File(path))); ByteArrayOutputStream baos = new ByteArrayOutputStream();) {
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
    public static boolean writeBuffered(byte[] info, String path){
        try(ByteArrayInputStream bais = new ByteArrayInputStream(info);OutputStream os = new BufferedOutputStream(new FileOutputStream(new File(path)));) {
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
}
```



## 对象序列化与反序列化之对象流

#### ObjectOutputStream

| Modifier and Type             | Method and Description                                       |
| ----------------------------- | ------------------------------------------------------------ |
| `protected void`              | `annotateClass(类<?> cl)`  子类可以实现这种方法，以允许将类数据存储在流中。 |
| `protected void`              | `annotateProxyClass(类<?> cl)`  子类可以实现这种方法来存储流中的自定义数据以及动态代理类的描述符。 |
| `void`                        | `close()`  关闭流。                                          |
| `void`                        | `defaultWriteObject()`  将当前类的非静态和非瞬态字段写入该流。 |
| `protected void`              | `drain()`  在ObjectOutputStream的任何缓冲的数据流失。        |
| `protected boolean`           | `enableReplaceObject(boolean enable)`  使流能够替换流中的对象。 |
| `void`                        | `flush()`  冲流。                                            |
| `ObjectOutputStream.PutField` | `putFields()`  检索用于将要写入流的缓冲持久字段的对象。      |
| `protected Object`            | `replaceObject(Object obj)`  这种方法将允许受信任的子类对象来代替一个物体对另一个序列化期间。 |
| `void`                        | `reset()`  重置将忽略已写入流的任何对象的状态。              |
| `void`                        | `useProtocolVersion(int version)`  在写入流时指定要使用的流协议版本。 |
| `void`                        | `write(byte[] buf)`  写入一个字节数组。                      |
| `void`                        | `write(byte[] buf,  int off, int len)`  写入字节数组的字节数。 |
| `void`                        | `write(int val)`  写一个字节。                               |
| `void`                        | `writeBoolean(boolean val)`  写一个布尔值。                  |
| `void`                        | `writeByte(int val)`  写入一个8位字节。                      |
| `void`                        | `writeBytes(String str)`  写入字符串作为一个字节序列。       |
| `void`                        | `writeChar(int val)`  写入一个16位字符。                     |
| `void`                        | `writeChars(String str)`  写一个字符串作为字符序列。         |
| `protected void`              | `writeClassDescriptor(ObjectStreamClass desc)`  写入指定的类描述的对象。 |
| `void`                        | `writeDouble(double val)`  写一个64位双。                    |
| `void`                        | `writeFields()`  将缓冲区写到流中。                          |
| `void`                        | `writeFloat(float val)`  写一个32位浮点。                    |
| `void`                        | `writeInt(int val)`  将32位int。                             |
| `void`                        | `writeLong(long val)`  写一个64位长的。                      |
| `void`                        | `writeObject(Object obj)`  写入指定的对象的对象。            |
| `protected void`              | `writeObjectOverride(Object obj)`  用子类重写默认的writeObject方法。 |
| `void`                        | `writeShort(int val)`  写一个16位的短。                      |
| `protected void`              | `writeStreamHeader()`  的writestreamheader方法提供子类可以附加或在自己的头的流。 |
| `void`                        | `writeUnshared(Object obj)`  写一个“独享”的对象的对象。      |
| `void`                        | `writeUTF(String str)`  原始数据写在 [modified UTF-8](DataInput.html#modified-utf-8)格式字符串。 |



#### ObjectInputStream

| Modifier and Type             | Method and Description                                       |
| ----------------------------- | ------------------------------------------------------------ |
| `int`                         | `available()`  返回可以不阻塞读取的字节数。                  |
| `void`                        | `close()`  关闭输入流。                                      |
| `void`                        | `defaultReadObject()`  从该流中读取当前类的非静态和非瞬态字段。 |
| `protected boolean`           | `enableResolveObject(boolean enable)`  使流能够允许从流中读取的对象被替换。 |
| `int`                         | `read()`  读取一个字节的数据。                               |
| `int`                         | `read(byte[] buf,  int off, int len)`  读入一个字节数组。    |
| `boolean`                     | `readBoolean()`  在布尔值中读取。                            |
| `byte`                        | `readByte()`  读取一个8位字节。                              |
| `char`                        | `readChar()`  读取一个16位字符。                             |
| `protected ObjectStreamClass` | `readClassDescriptor()`  从序列化流中读取类描述符。          |
| `double`                      | `readDouble()`  读一个64位的双。                             |
| `ObjectInputStream.GetField`  | `readFields()`  从流中读取持久字段，并使它们可用名称命名。   |
| `float`                       | `readFloat()`  读取一个32位浮点。                            |
| `void`                        | `readFully(byte[] buf)`  读取字节，阻塞，直到所有的字节都读。 |
| `void`                        | `readFully(byte[] buf,  int off, int len)`  读取字节，阻塞，直到所有的字节都读。 |
| `int`                         | `readInt()`  读取一个32位int。                               |
| `String`                      | `readLine()`  过时的。  此方法没有正确地将字节转换为字符。详见和替代输入流。 |
| `long`                        | `readLong()`  读一个64位长的。                               |
| `Object`                      | `readObject()`  从对象输入流对象。                           |
| `protected Object`            | `readObjectOverride()`  这种方法被称为对象，通过构建保护对象使用无参数构造函数受信任的子类。 |
| `short`                       | `readShort()`  读一个16位的短。                              |
| `protected void`              | `readStreamHeader()`  的readstreamheader方法是提供让子类来读取和验证自己的流头。 |
| `Object`                      | `readUnshared()`  读取对象输入流“独享”的对象。               |
| `int`                         | `readUnsignedByte()`  读取一个无符号的8位字节。              |
| `int`                         | `readUnsignedShort()`  读取一个无符号的16位短。              |
| `String`                      | `readUTF()`  读 [modified UTF-8]格式字符串。 |
| `void`                        | `registerValidation(ObjectInputValidation obj,  int prio)`  在返回图形之前注册一个要验证的对象。 |
| `protected 类<?>`             | `resolveClass(ObjectStreamClass desc)`  加载指定的流类描述的本地类等价。 |
| `protected Object`            | `resolveObject(Object obj)`  这种方法将允许受信任的子类对象输入流用另一个来代替在反序列化期间。 |
| `protected 类<?>`             | `resolveProxyClass(String[] interfaces)`  返回实现代理类描述符中命名的接口的代理类；子类可以实现此方法从流中读取自定义数据以及动态代理类的描述符，从而允许它们使用接口和代理类的替代加载机制。 |
| `int`                         | `skipBytes(int len)`  跳过的字节。                           |



#### 案例

```java
public class ObjectStreamDemo1 {
    public static void main(String[] args) throws Exception {
        String path = "7_24\\src\\inclass\\obj.txt";
        writeObj(path,new Student("老八",18,new Date()));
        Student s = (Student) readObj(path);
        System.out.println(s);
    }
    public static void writeObj(String path,Object obj) throws Exception {
        FileOutputStream fos = new FileOutputStream(path);
        ObjectOutputStream oos = new ObjectOutputStream(fos);
        oos.writeObject(obj);
        oos.flush();
        fos.close();
        oos.close();
    }
    public static Object readObj(String path) throws Exception {
        FileInputStream fis = new FileInputStream(path);
        ObjectInputStream ois = new ObjectInputStream(fis);
        Object o = ois.readObject();
        fis.close();
        ois.close();
        return o;
    }
}
class Student implements Serializable {
    private String name;
    private Integer age;
    private Date now;

    public Student(String name, Integer age, Date now) {
        this.name = name;
        this.age = age;
        this.now = now;
    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", now=" + now +
                '}';
    }
}

```



## Socket + IO流



//

```java
public static void main(String[] args) {
    try {
        String PATH = System.getProperty("user.dir");//项目根目录
        System.out.println("项目根目录："+PATH);
        //初始化服务端socket并且绑定9999端口
        ServerSocket serverSocket = new ServerSocket(9999);
        //等待客户端的连接
        Socket socket = serverSocket.accept();
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

        if (URLPATH != null) {
            System.out.println("请求地址：" + PATH + URLPATH);
            BufferedInputStream bis = new BufferedInputStream(new FileInputStream(PATH + URLPATH));
            BufferedOutputStream bos = new BufferedOutputStream(socket.getOutputStream());


            byte[] data = new byte[1024];
            int length;
            while ((length = bis.read(data)) != -1) {
                bos.write(data, 0, length);
            }
            bos.flush();

            bis.close();
            bos.close();
        }
    } catch (IOException e) {
        e.printStackTrace();
    }
}
```











