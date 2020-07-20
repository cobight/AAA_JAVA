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
```



### 文件的创建与删除



| 代码                   | 意义     |
| ---------------------- | -------- |
| file.createNewFile（） | 创建文件 |
| file.delete()          | 删除文件 |















 