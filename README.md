# AAA_JAVA

、6月30

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

### ==比较

基本数据类型是对比值

引用数据类型是对比地址值

### equals比较

这是两个String类型的值的比较

### equalsIgnoreCase比较

比较时忽略大小写

# 修饰

## 访问修饰符

- **default** (即默认，什么也不写）: 在同一包内可见，不使用任何修饰符。使用对象：类、接口、变量、方法。
- **private** : 在同一类内可见。使用对象：变量、方法。 **注意：不能修饰类（外部类）**
- **public** : 对所有类可见。使用对象：类、接口、变量、方法
- **protected** : 对同一包内的类和所有子类可见。使用对象：变量、方法。 **注意：不能修饰类（外部类）**。
  - **子类与基类在同一包中**：被声明为 protected 的变量、方法和构造器能被同一个包中的任何其他类访问；
  - **子类与基类不在同一包中**：那么在子类中，子类实例可以访问其从基类继承而来的 protected 方法，而不能访问基类实例的protected方法。

### 访问控制和继承

请注意以下方法继承的规则：

- 父类中声明为 public 的方法在子类中也必须为 public。
- 父类中声明为 protected 的方法在子类中要么声明为 protected，要么声明为 public，不能声明为 private。
- 父类中声明为 private 的方法，不能够被继承。

## 非访问修饰符

### static 修饰符

- **静态变量：**

  static 关键字用来声明独立于对象的静态变量，无论一个类实例化多少对象，它的静态变量只有一份拷贝。 静态变量也被称为类变量。局部变量不能被声明为 static 变量。

- **静态方法：**

  static 关键字用来声明独立于对象的静态方法。静态方法不能使用类的非静态变量。静态方法从参数列表得到数据，然后计算这些数据。

  

```java
package AAA7_7;

public class static_demo1 {
    public static void main(String[] args) {
        Staticclass ss = s();
        System.out.println(ss);
    }
    public static Staticclass s(){
        Staticclass s1 = new Staticclass("asd");
        s1.setS("101");
        Staticclass s2 = new Staticclass("qwe");
        s2.setS("105");
        System.out.println(s1.getA1()+" : "+s1.getS());
        System.out.println(s2.getA1()+" : "+s2.getS());
        System.out.println(s1);
        return s1;
    }
}
class Staticclass{
    public String a1;
    static String s;

    public Staticclass(String a1) {
        this.a1 = a1;
    }

    public String getA1() {
        return a1;
    }

    public void setA1(String a1) {
        this.a1 = a1;
    }

    public String getS() {
        return s;
    }

    public void setS(String s) {
        this.s = s;
    }


}+
```



### final 修饰符

**final 变量：**

final 表示"最后的、最终的"含义，变量一旦赋值后，不能被重新赋值。被 final 修饰的实例变量必须显式指定初始值。

final 修饰符通常和 static 修饰符一起使用来创建类常量。

### abstract 修饰符

**抽象类：**

抽象类不能用来实例化对象，声明抽象类的唯一目的是为了将来对该类进行扩充。

一个类不能同时被 abstract 和 final 修饰。如果一个类包含抽象方法，那么该类一定要声明为抽象类，否则将出现编译错误。

抽象类可以包含抽象方法和非抽象方法。

```java
public abstract class SuperClass{
    abstract void m(); //抽象方法
}
 
class SubClass extends SuperClass{
     //实现抽象方法
      void m(){
          .........
      }
}
```

### synchronized 修饰符

synchronized 关键字声明的方法同一时间只能被一个线程访问。synchronized 修饰符可以应用于四个访问修饰符。

```java
public synchronized void showDetails(){
.......
}
```

### transient 修饰符

序列化的对象包含被 transient 修饰的实例变量时，java 虚拟机(JVM)跳过该特定的变量。

该修饰符包含在定义变量的语句中，用来预处理类和变量的数据类型。

```java
public transient int limit = 55;   // 不会持久化
public int b; // 持久化
```

### volatile 修饰符

volatile 修饰的成员变量在每次被线程访问时，都强制从共享内存中重新读取该成员变量的值。而且，当成员变量发生变化时，会强制线程将变化值回写到共享内存。这样在任何时刻，两个不同的线程总是看到某个成员变量的同一个值。

一个 volatile 对象引用可能是 null。

```java
public class MyRunnable implements Runnable
{
    private volatile boolean active;
    public void run()
    {
        active = true;
        while (active) // 第一行
        {
            // 代码
        }
    }
    public void stop()
    {
        active = false; // 第二行
    }
}
```

# Math数学模块

Math.abs()取绝对值

Math.ceil()向上取整

Math.floor()向下取整

Math.round()四舍五入

# 继承extends

## 变量操作

方法中的成员变量：优先级最高，直接使用

本类中的成员变量：优先级较低，用this.变量名操作

父类中的成员变量：优先级最低，用super.变量名操作

## 重写重载

重写（Override）：方法名称一样，参数【也一样】。覆盖覆写

重载（Overload）：方法名称一样，参数【不一样】。

# 抽象abstract



| 方法               | 类       |
| ------------------ | -------- |
| 抽象               | 一定抽象 |
| 既有抽象也有不抽象 | 一定抽象 |

## 使用

1、抽象类不能被创建，除非子类继承（自类不能是抽象类）

2、抽象类中可以有构造方法，是供子类创建对象时，初始化父类成员使用的

3、抽象类中不一定包含抽象方法，但是有抽象方法的类一定是抽象类

4、抽象类的子类，必须重写抽象父类中所有的抽象方法，除非子类也是抽象类

# 日期操作

## Date模块

    System.out.println(date.getTime()); // 1533547522877
    //获得当前日期的毫秒值
    System.out.println(System.currentTimeMillis()); // 1533547522877
### 格式化

日期转字符串

y 代表年

M 代表月

d 代表日

E 代表星期

H 代表24进制的小时

h 代表12进制的小时

m 代表分钟

s 代表秒

S 代表毫秒

## SimpleDateFormat模块

```java
//Date to String
SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
String dateStr=sdf.format(new Date());
```



```java
//String to Date
SimpleDateFormat sdf = new SimpleDateFormat("yyyy MM dd");
Date date = sdf.parse("1998 01 22");
```



```java

public class DateTest {
    public static void main(String[] args) {

        SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

        SimpleDateFormat sdf1=new SimpleDateFormat("yyyy-MM-dd E HH:mm:ss SSS");

        Date date=new Date();

        String dateStr=sdf.format(date);

        System.out.println(dateStr);

        System.out.println(sdf1.format(date));

    }
}
```

```
2020-07-09 16:55:36
2020-07-09 星期四 16:55:36 612
```

## Calendar模块

```java
public int[] getNowTime() {
        Calendar nowTime = Calendar.getInstance();
        return new int[]{
                nowTime.get(Calendar.YEAR),//年
                nowTime.get(Calendar.MONTH) + 1,//月
                nowTime.get(Calendar.DAY_OF_MONTH),//日
                nowTime.get(Calendar.HOUR_OF_DAY),//时
                nowTime.get(Calendar.MINUTE),//分
                nowTime.get(Calendar.SECOND)//秒
        };
    }
```

```java
public int[] getCurrentTime(String times) throws ParseException {//1998 1 22
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy MM dd");
        Date date = sdf.parse(times);
        Calendar currentTime = Calendar.getInstance();
        currentTime.setTime(date);
        return new int[]{
                currentTime.get(Calendar.YEAR),
                currentTime.get(Calendar.MONTH) + 1,
                currentTime.get(Calendar.DAY_OF_MONTH),
                currentTime.get(Calendar.HOUR_OF_DAY),
                currentTime.get(Calendar.MINUTE),
                currentTime.get(Calendar.SECOND)
        };
    }
```

```java
//测试
DataTools tools = new DataTools();
int[] nowTime = tools.getNowTime();
System.out.println(Arrays.toString(nowTime));
int[] times = tools.getCurrentTime("1998 01 22");
System.out.println(Arrays.toString(times));
if (nowTime[1] < times[1]) {
	System.out.println(nowTime[0] - times[0] - 1 + "：岁");//月小-1岁
} else {
	System.out.println(nowTime[0] - times[0] + "：岁");
}
```

```
[2020, 7, 9, 17, 30, 18]
[1998, 1, 22, 0, 0, 0]
22：岁
```



## Date<-->Calendar

```java
Calendar c=Calendar.getInstance();

//通过Calendar对象得到日期对象

Date date = c.getTime();

Date date1 = new Date();

c.setTime(date1);
```

## Calendar时间增减

 c.add(Calendar.*YEAR*, -1);

c.add(Calendar.*MONTH*, 1);

# 接口

interface是面向对象编程语言中接口操作的关键字，功能是把所需成员组合起来，用来装封一定功能的集合。它好比一个模板，在其中定义了对象必须实现的成员，通过类或结构来实现它。接口不能直接实例化，即ICount ic=new iCount()是错的。接口不能包含成员的任何代码，只定义成员本身。接口成员的具体代码由实现接口的类提供。接口使用interface关键字进行声明。

## 接口定义

接口是一种约束形式，其中只包括成员定义，不包含成员实现的内容。

声明格式如下：

[attributes] [modifiers] interface identifier [: base-list] {interface-body} {;}

## 发展

### java 7

```
1、常量

2、抽象方法 public abstract void method();
```

### java 8

```
3、默认方法public default void method();

4、静态方法public static void method();
```

#### java 9

```
5、私有方法
```

## 定义

在任何版本的java中，接口都能定义抽象方法。

public abstract 返回值类型 方法名（参数列表）;

```java
public interface MyInterFaceAbstract {
    //定义抽象方法的四种
    public abstract void methodAbs1();//标准
    abstract void methodAbs2();
    public void methodAbs3();
    void methodAbs4();
}
```

## 使用步骤

1、接口不能直接使用，必须有一个“实现类” 来实现该接口。

格式：

```java
public class 实现类名称 implements 接口名称{
    //。。。
}
```

2、接口的实现类必须覆盖重写（实现）接口中所有的抽象方法。

实现：去掉abstract关键字，加上方法体大括号。

3、创建实现类的对象，进行使用。

注意事项：

如果该类并没有覆盖重写接口中所有的抽象方法，那么这个实现类自己就必须是抽象类。

## Default

### 案例

```java
interface MyInterFaceDefaul {
    public abstract void abs();
    public default void methodDefault(){
        System.out.println("default");
    }
}
public class MyInterFaceDefaultImpl implements MyInterFaceDefaul {
    @Override
    public void abs() {
        System.out.println("abs");
    }


}
class mans{
    public static void main(String[] args) {
        MyInterFaceDefaultImpl m = new MyInterFaceDefaultImpl();
        m.abs();
        m.methodDefault();
    }
}
```

out

```
abs
default
```

methodDefault不在实现类，会向上找借口

### 概念

接口里的默认方法能直接调用，也能覆盖重写。

## 接口常量

public static final 数据类型 常量名 = ***；

= 							数据类型 常量名 = ***;

接口里的常量必须赋值。

常量名全大写，下划线连接。