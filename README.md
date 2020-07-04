# AAA_JAVA

6月30

# 初识java

## 各种缩写

SE-->Standard Edition标准版写桌面程序

ME-->Micro Edition微机版写嵌入式

EE-->enterprise edition企业版写服务器

JVM-->*Java* Virtual Machine虚拟机

GC-->Garbage Collection垃圾回收

重要命令

JAVAC-->用于源代码编译源文件

JAVA-->用于源文件丢虚拟机运行

JDB-->java调试器

## 编码表详解

ASCII：American Standard Code for Infomation Interchage美国信息交换标准代码

Unicode：万国码，0-127与ASCII一样



## 判断语句

## 作业猜拳



7月1

# 循环语句

for，while，do。。。while

输入学生成绩，返回总分与平均分

# 对象，类

类是对象的模板，对象是类的具体存在

# 数据类型

## 数据类型默认值

byte,short,int  =0

long  =0l

float=0f

double =0.0

char ='\u0000'

boolen=flase

引用类型String =null

# 内存五部分

1、栈（Stack）：存放的都是方法中的局部变量。方法的运行一定要在栈当中。

​	局部变量：方法的参数，或者是方法{ }内部的变量

​	作用域：一旦超过作用域，立刻从栈内存中消失。

2、堆（Heap）：凡是new出来的东西，都在堆当中

​	堆内存里面的东西都有一个地址值：16进制

​	堆内存里面的数据，都有默认值

​	规则：

| 数据类型                         | 默认值   |
| -------------------------------- | -------- |
| 整数int                          | 0        |
| 浮点float                        | 0.0      |
| 字符byte                         | '\u0000' |
| 布尔boolean                      | false    |
| 引用类型（String、int[] a=null） | null     |



3、方法区（Method Area）：存储.class相关信息，包含方法的信息。

4、本地方法栈（Native Method Stack）：与操作系统相关。

5、寄存器（PC Regidter）：与CPU相关。

# 数组ArrayList

```java
ArrayList<泛型> list = new ArratList<>();
```

泛型只能是引用类型，不能是基础类型。

| 基本类型                 | 包装类型 |
| ---------------------- | -------- |
| 字节byte           | Byte    |
| 短整short               | Short  |
| 整数int                 | Integer特殊 |
| 长整long                | Long |
| 浮点float               | Float |
| 双浮点double       | Double |
| 字符char           | Character特殊 |
| 布尔boolean    | Boolean |

## 方法

加入

```java
arr.add(* element)
arr.add(int index,* element)
```

删除

```java
* element = arr.remove(int index)
```

获取

```java
* element = arr.get(int index)
```

改

```java
arr.set(int index,* element)
```

合并两个ArrayList

```java
ArrayList<Integer> list1 = new ArrayList<>();
list1.add(1);
ArrayList<Integer> list2 = new ArrayList<>();
list2.add(5);
//返回个新list
ArrayList<Integer> retn = new ArrayList<>(list1);
retn.addAll(list2);
System.out.println(retn);
//原有list追加
list1.addAll(list2);
System.out.println(list1);
```

# String类型

## 构造方法

```java
String string = new String();
System.out.println(1+":"+string);
char[] charArray = {'A','B','C'};
String string1 = new String(charArray);
System.out.println(string1);
byte[] byteArray = {97,98,99};
String string2 = new String(byteArray);
System.out.println(string2);
```

## 字符串比较

==比较

基本数据类型是对比值

引用数据类型是对比地址值