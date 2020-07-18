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

### ==比较

基本数据类型是对比值

引用数据类型是对比地址值

### equals比较

这是两个String类型的值的比较

### equalsIgnoreCase比较

比较时忽略大小写

# 修饰

## 访问权限修饰符

### public > protect > (default) > private

(default)并不是关键字default，而是根本不写。

|              | public | protect | (default) | private |
| ------------ | ------ | ------- | --------- | ------- |
| 同一个类     | Y      | Y       | Y         | Y       |
| 同一个包     | Y      | Y       | Y         | N       |
| 不同包子类   | Y      | Y       | N         | N       |
| 不同包非子类 | Y      | N       | N         | N       |



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

## 非访问权限修饰符

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

# 重写与重载

## (Override)

重写是子类对父类的允许访问的方法的实现过程进行重新编写, 返回值和形参都不能改变。**即外壳不变，核心重写！**

重写的好处在于子类可以根据需要，定义特定于自己的行为。 也就是说子类能够根据需要实现父类的方法。

重写方法不能抛出新的检查异常或者比被重写方法申明更加宽泛的异常。例如： 父类的一个方法申明了一个检查异常 IOException，但是在重写这个方法的时候不能抛出 Exception 异常，因为 Exception 是 IOException 的父类，只能抛出 IOException 的子类异常。

## 方法的重写规则

- 参数列表必须完全与被重写方法的相同。
- 返回类型与被重写方法的返回类型可以不相同，但是必须是父类返回值的派生类（java5 及更早版本返回类型要一样，java7 及更高版本可以不同）。
- 访问权限不能比父类中被重写的方法的访问权限更低。例如：如果父类的一个方法被声明为 public，那么在子类中重写该方法就不能声明为 protected。
- 父类的成员方法只能被它的子类重写。
- 声明为 final 的方法不能被重写。
- 声明为 static 的方法不能被重写，但是能够被再次声明。
- 子类和父类在同一个包中，那么子类可以重写父类所有方法，除了声明为 private 和 final 的方法。
- 子类和父类不在同一个包中，那么子类只能够重写父类的声明为 public 和 protected 的非 final 方法。
- 重写的方法能够抛出任何非强制异常，无论被重写的方法是否抛出异常。但是，重写的方法不能抛出新的强制性异常，或者比被重写方法声明的更广泛的强制性异常，反之则可以。
- 构造方法不能被重写。
- 如果不能继承一个方法，则不能重写这个方法。

## Super 关键字的使用

当需要在子类中调用父类的被重写方法时，要使用 super 关键字。

## (Overload)

重载(overloading) 是在一个类里面，方法名字相同，而参数不同。返回类型可以相同也可以不同。

每个重载的方法（或者构造函数）都必须有一个独一无二的参数类型列表。

最常用的地方就是构造器的重载。

**重载规则:**

- 被重载的方法必须改变参数列表(参数个数或类型不一样)；
- 被重载的方法可以改变返回类型；
- 被重载的方法可以改变访问修饰符；
- 被重载的方法可以声明新的或更广的检查异常；
- 方法能够在同一个类中或者在一个子类中被重载。
- 无法以返回值类型作为重载函数的区分标准。

## 重写与重载之间的区别

| 区别点   | 重载方法 | 重写方法                                       |
| :------- | :------- | :--------------------------------------------- |
| 参数列表 | 必须修改 | 一定不能修改                                   |
| 返回类型 | 可以修改 | 一定不能修改                                   |
| 异常     | 可以修改 | 可以减少或删除，一定不能抛出新的或者更广的异常 |
| 访问     | 可以修改 | 一定不能做更严格的限制（可以降低限制）         |

------

## 总结

方法的重写(Overriding)和重载(Overloading)是java多态性的不同表现，重写是父类与子类之间多态性的一种表现，重载可以理解成多态的具体表现形式。

- (1)方法重载是一个类中定义了多个方法名相同,而他们的参数的数量不同或数量相同而类型和次序不同,则称为方法的重载(Overloading)。
- (2)方法重写是在子类存在方法与父类的方法的名字相同,而且参数的个数与类型一样,返回值也一样的方法,就称为重写(Overriding)。
- (3)方法重载是一个类的多态性表现,而方法重写是子类与父类的一种多态性表现。

# 继承extends

## 变量操作

方法中的成员变量：优先级最高，直接使用

本类中的成员变量：优先级较低，用this.变量名操作

父类中的成员变量：优先级最低，用super.变量名操作

## 重写重载

重写（Override）：方法名称一样，参数【也一样】。覆盖覆写

重载（Overload）：方法名称一样，参数【不一样】。

## 静态变量与方法

静态变量父子各用各的

静态方法，子有父隐藏，子没父显示，不重写。

## final修饰的变量和方法，子继承不过来

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

**继承优先于接口**

interface是面向对象编程语言中接口操作的关键字，功能是把所需成员组合起来，用来装封一定功能的集合。它好比一个模板，在其中定义了对象必须实现的成员，通过类或结构来实现它。接口不能直接实例化，即ICount ic=new iCount()是错的。接口不能包含成员的任何代码，只定义成员本身。接口成员的具体代码由实现接口的类提供。接口使用interface关键字进行声明。

## 接口定义

接口是一种约束形式，其中只包括成员定义，不包含成员实现的内容。

声明格式如下：

[attributes] [modifiers] interface identifier [: base-list] {interface-body} {;}

**无静态代码块，无构造方法**

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

### 案例（java8开始）

```java
interface MyInterFaceDefaul {
    public abstract void abs();
    public default void methodDefault(){//public 可以重写
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



## static

java8开始也有了static定义静态方法

## 接口常量

java9开始

public static final 数据类型 常量名 = ***；

= 							数据类型 常量名 = ***;

接口里的常量必须赋值。

常量名全大写，下划线连接。

## java 9 版本总结

1、成员变量其实是常量，格式：

[public]  [static] [final] 数据类型 常量名 = 数据值；

注意：

​	常量名必须进行赋值，而且一旦赋值不能改变。

​	常量名称完全大写，用下划线进行分割。

2、接口中最重要的就是抽象方法，格式：

[public] [abstract] 返回值类型 方法名称（参数列表）;

注意：实现类必须覆盖重写接口所有的抽象方法，除非实现类是抽象类。

3、从java 8开始，接口里允许定义默认方法，格式：

[public] default 返回值类型 方法名称（参数列表）{  方法体  }

注意：默认方法也可以被覆盖重写

4、从java 8开始，接口里允许定义静态方法，格式：

[public] static 返回值类型 方法名称（参数列表）{  方法体  }

注意：应该通过接口名称调用，不能通过实现类对象调用接口静态方法

5、从java 9开始，接口里允许定义私有方法，格式：

普通私有方法：private 返回值类型 方法名称（参数列表）{  方法体  }

静态私有方法：private static 返回值类型 方法名称（参数列表）{  方法体  }

注意：private的方法只有接口自己才能调用，不能被实现类或别人调用。 

## 接口使用注意

1. 接口是没有静态代码块或者构造方法的。
2. 一个类的直接父类是唯一的，但是一个类可以同时实现多个接口。
3. 如果实现类所实现的多个接口当中，存在重复的抽象方法，那么只需要覆盖重写一次即可。
4. 如果实现类没有覆盖重写所有接口当中的所有抽象方法，那么实现类就必须是一个抽象类。
5. 如果实现类所实现的多个接口当中，存在重复的默认方法，那么实现类一定要对冲突的默认方法进行覆盖重写。
6. 一个类如果继承父类当中的方法，和接口当中的默认方法产生了冲突，优先用父类当中的方法。

## 继承注意

1. 类与类之间是单继承的。直接父类只有一个。
2. 类与接口之间是多实现的。一个类可以实现多个接口。
3. 接口与接口之间是多继承的。

注意事项：

1. 多个父接口当中的抽象方法如果重复，没关系，没方法体。
2. 多个父接口当中的默认方法如果重复，那么子接口必须进行默认方法的覆盖重写，【而且带着default关键字】。

# 多态

格式：

父类名称  对象名 = new 子类名称（）;

接口名称  对象名 = new 实现类名称（）;

**简称：左父右子  叫多态。**

## 向上转型

多态写法。

格式：父类名称  对象名 = new 子类名称（）;

含义：右侧创建一个子对象，把它当作父类使用。

```java
Animal animal = new Cat();
注意事项：向上转型一定是安全的。从小范围转向了大范围。
类似于
    double num = 100;
```

## 向下转型

格式：子类名称 对象名 = (自类名称) 父类对象；

含义：将父对象，【还原】 成为本来的子类对象。

```
Animal animal = new Cat();//本来是猫，向上转型成动物
Cat cat = (Cat) animal;//本来是猫，当作动物了，还原回本来的猫
注意事项：
a、必须保证对象本来创建的时候，就是猫，才能向下转型成为猫。
b、如果对象创建的时候本来不是猫，现在非要向下转型成为猫，就会报错。
类似于
	int num = (int)10.0;
```



## 转型错误案例

```java
public class demo1 {
    public static void main(String[] args) {
        Animal cat = new Cat();
        cat.eat();
        Cat cat1 = (Cat) cat;
        cat1.eat();
        Dog dog = (Dog) cat; 
        dog.eat();
    }
}
abstract class Animal{
    public abstract void eat();
}
class Cat extends Animal{

    @Override
    public void eat() {
        System.out.println("cat eat house");
    }
}
class Dog extends Animal{

    @Override
    public void eat() {
        System.out.println("dog eat shit");
    }
}
```



内部变量优先级

```java
public class demo1 {
    public static void main(String[] args) {
        Animal cat = new Cat();
        cat.eat();
        System.out.println(cat.num);
        Cat cat1 = (Cat) cat;
        cat1.eat();
        System.out.println(cat1.num);
        System.out.println(cat1.num2);
//        Dog dog = (Dog) cat;
//        dog.eat();
    }
}

abstract class Animal {
    public int num = 10;
    public void eat(){
        System.out.println("animal");
    }
}

class Cat extends Animal {
    public int num = 20;
    public int num2 = 30;
    @Override
    public void eat() {
        System.out.println("cat eat house");
    }
}

class Dog extends Animal {

    @Override
    public void eat() {
        System.out.println("dog eat shit");
    }
}

out:
cat eat house
10
cat eat house
20
30
```



## 判断类型

```java
public class demo1 {
    public static void main(String[] args) {
        Animal animal = new Cat();
        animal.eat();
        if (animal instanceof Dog){
            Dog dog = (Dog) animal;
            dog.watchHouse();
        }else if (animal instanceof Cat){
            Cat cat = (Cat) animal;
            cat.catchMouse();
        }
    }
}

class Animal {
    public int num = 10;
    public void eat(){
        System.out.println("animal");
    }
}

class Cat extends Animal {
    public int num = 20;
    public int num2 = 30;
    @Override
    public void eat() {
        System.out.println("cat eat house");
    }
    public void catchMouse(){
        System.out.println("cat catch mouse");
    }
}

class Dog extends Animal {

    @Override
    public void eat() {
        System.out.println("dog eat shit");
    }
    public void watchHouse(){
        System.out.println("dog watch house");
    }
}
```



# Final

## 常见四种方法

1. 可以用来修饰一个类
2. 可以用来修饰一个方法
3. 可以修饰一个局部变量
4. 可以修饰一个成员变量

## 修饰类时

**太监类，没儿子**

代表类是String类

## 修饰方法时

该方法无法被覆盖重写，他是 **最终方法**

## 修饰局部变量时

### 基本数据类型

```java
final 基本数据类型  变量名=10;
final 基本数据类型  变量名;
变量名=20;
```

final 修饰的变量，值只能赋一次；

### 引用数据类型

```java
final 引用数据类型  变量名=new 引用数据类型();
地址将被锁定，无法接收新new对象的地址。
但是能用对象的set、get方法修改、获取对象里存的数据。
```

final修饰的对象，只能接收new的一次地址。

## 修饰成员变量时

引用数据类型不赋值时默认为null

基本数据类型默认是各自的

```java
class a{
    public final int q=0;//直接赋值
}
或
class b{
    public final int w;//构造方法赋值，有参无参都得赋值
    public b(){
        w=1;
    }
    public b(int d){
        w=d;
    }
      
}
```

# 内部类

外部类：public / （default）不写

内部类：public / protect / （default） / private

局部类：什么都不能写

## 成员内部类

```java
public class Outer {
    int num = 10;
    class Inner{
        int num = 20;
        public void method(){
            int num = 30;
            System.out.println(num);
            System.out.println(this.num);
            System.out.println(Outer.this.num);
        }
    }
}
class man{
    public static void main(String[] args) {
        Outer.Inner obj = new Outer().new Inner();
        obj.method();
    }
}
out:
30
20
10
```



## 局部内部类

只有所属的方法才能调用它

```java
public class Outer {
    public void method(){
        class Inner2{
            public void method(){
                System.out.println("Inner2 method");
            }
        }
        Inner2 inner2 = new Inner2();
        inner2.method();
    }
}
class man{
    public static void main(String[] args) {
        Outer outer = new Outer();
        outer.method();
    }
}
out:
Inner2 method
```

### final 问题

只有fuc固定不变时，局部类测i能直接用

```java
public class Outer {
    public void method(){
        （final）int fuc =100;//final可不写，或者先定义，后赋值，只能赋值一次。
        class Inner2{
            public void method(){
                System.out.println(fuc);
            }
        }
    }
}
```

## 匿名内部类

**interface**

署名内部类：方法可以用多次

匿名内部类：方法只能用一次

```java
public class InnerClass {
    public static void main(String[] args) {
        MyInterface ipl = new MyInterface(){

            @Override
            public void method() {
                System.out.println("inner");
            }
        };
        ipl.method();
        
        new MyInterface(){

            @Override
            public void method() {
                System.out.println("inner1");
            }
        }.method();

    }
}
interface MyInterface{
    void method();
}
class MyInterfaceIpl implements MyInterface{
    @Override
    public void method() {
        System.out.println("IPL");
    }
}
out:
inner
inner1
```

# 接口2

```java
public class Real {
    public static void main(String[] args) {
        People people = new Student();
        people.eat();
    }
}
interface People{
    void eat();
}
class Student implements People{
    @Override
    public void eat() {
        System.out.println("dog eat shit");
    }
}
out:
dog eat shit
```



# 迭代器

### Iterator

```java
ArrayList<String> list = new ArrayList<>();
list.add("1");
list.add("2");
list.add("3");
Iterator<String> iterator = list.iterator();
for (;iterator.hasNext();){
    System.out.println(iterator.next());
}
```



# 泛型

## 通配符？

​	? ：代表任意的数据类型

​	不能创建对象时使用

​	只能作为方法的参数使用

上限？ extends  E -->代表使用的泛型是能是E类型的子类/本身

下限？ super  E     -->代表使用的泛型只能是E类型的父类/本身



# Hashset与Linkhashset

hashset无序输出

linkhashset有序输出



# 方法之可变参数

public void add(int...arr){

​	

}

# 自定义排序规则

## 重写Comparable接口的compareTo方法

被排序的类通过Comparable接口重写compareTo方法

通过Collections集合工具进行排序或者选定接口排序方法

```
list.sort(User::compareTo);
```

```java
public class SortImplement {
    public static void main(String[] args) throws ParseException {
        ArrayList<User> list = new ArrayList<>();
        list.add(new User("老大","19980122",50));
        list.add(new User("老二","19970122",60));
        list.add(new User("老三","19980122",70));
        Collections.sort(list);
        System.out.println(list);
    }
}
class User implements Comparable<User>{
    private String name;
    private Date birthday;
    private int score;
    private SimpleDateFormat sdf= new SimpleDateFormat("yyyyMMdd");
    public User(String name, String birthday, int score) throws ParseException {
        this.name = name;
        this.birthday = sdf.parse(birthday);
        this.score = score;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getBirthday() {
        return sdf.format(birthday);
    }
    public void setBirthday(String birthday) throws ParseException {
        this.birthday = sdf.parse(birthday);
    }
    public int getScore() {
        return score;
    }
    public void setScore(int score) {
        this.score = score;
    }
    public int getAge(){
        Calendar calendar = Calendar.getInstance();
        long now = calendar.getTimeInMillis();
        calendar.setTime(this.birthday);
        long birth = calendar.getTimeInMillis();
        return (int) ((now-birth)/1000/60/60/24/365);
    }
    @Override
    public String toString() {
        return "User{" +
                "name='" + name + '\'' +
                ", birthday=" + sdf.format(birthday) +
                ", score=" + score +
                ", age=" + getAge() +
                '}';
    }
    @Override
    public int compareTo(User o) {
        return this.getAge()-o.getAge();
    }
}
```

### Comparable排序规则

自己（this）-参数：升序

参数-自己（this）：降序

## 重写Comparator接口里的Compare排序方法

```java
ArrayList<User> list = new ArrayList<>();
list.add(new User("老大","19980122",50));
list.add(new User("老二","19970122",60));
list.add(new User("老三","19980122",70));
//list.sort(User::compareTo);
Collections.sort(list, new Comparator<User>() {
    @Override
    public int compare(User o1, User o2) {
        return o2.getAge()-o1.getAge();
    }
});
//Collections.sort(list);
System.out.println(list);
```

# Map

<key,value>

## 特点

1. Map集合是一个双列集合，一个元素包含两个值（一个key，一个value）
2. Map集合中的元素，key和value的数据类型可以相同，也可以不同
3. Map集合中的元素，key是不允许重复的，但是value是可以重复的
4. Map集合中的元素，key和value是一一对应



## 子类：HashMap

implements Map<k,v>

接口是Map

**key不重复，无序集合**

### 特点

1. HashMap集合底层是哈希表：查询速度特别的快

   ​	JDK1.8之前：数组+单向链表

   ​	JDK1.8之后：数组+单向链表/红黑树（链表的长度超过8）：提高查询的速度

2. hashmap集合是一个无序的集合，存储元素和取出元素的顺序有可能不一致

   

### 案例

```java
Map<Integer,String> map = new HashMap<>();
map.put(1,"qwe");
map.put(2,"asd");
map.put(3,"rty");
map.put(4,"fgh");
map.put(5,"uio");
map.put(6,"jkl");
Set<Integer> sets = map.keySet();
Iterator<Integer> iterator = sets.iterator();
while (iterator.hasNext()){
    Integer next=iterator.next();
    System.out.println(next +" : "+ map.get(next));
}
```

### 存储自定义类型键值

自定义类型作为key，重写hashcode，equals方法



## 子类：LinkedHashMap

**key不重复有序集合**输入跟输出顺序一样

### 特点

1. LinkedHashMap集合底层是哈希表+链表（保证迭代的顺序）
2. LinkedHashMap集合是一个有序的集合，存储元素和取出元素的顺序是一致的



## 内部接口Entry



# Hashtable

**Hashtable和Vector集合一样，在jdk1.2后被HashMap,ArrayList取代了，Hashtable的子类Properties依然活跃**

Properties集合是一个唯一和IO流相结合的集合

Hashtable:底层也是一个哈希表，是一个线程安全的集合，是单线程集合，速度慢

HashMap:底层是一个哈希表，是一个线程不安全的集合，是多线程的集合，速度快



HashMap集合：可以存储null键，null值

Hashtable集合：不能存储null值，null键



# List

JDK9的新特性：//暂时没法写

​		List接口，Set接口，Map



# 异常

## Exception：编译期异常

把异常处理掉，程序可以继续执行

若知道将要出现的错误，可以写错误名Exception，不知道的直接写Exception

```java
SimpleDateFormat sdf = new SimpleDateFormat（“yyyy-MM-dd”）;
Date date = null;
try{
    date = sdf.parse("1999-09-09");//yes
    date = sdf.parse("1999-0909");//no，exception
}catch (ParseException e){//Exception e
    e.printStackTrack();
}
```



## RuntimeException运行期异常

修改源代码，程序才能继续执行。



## throw抛异常



#### index不在范围

throw new ArrayIndexOutOfNoundsException("下标异常 ")

#### obj=null

throw new NullPointerException("传递的对象的值是null")； 

或者用Objects的静态方法

Objects.requireNonNULL(obj,"传递的对象是null")；



## 自定义抛异常



在方法声明时使用

```
修饰符 返回值类型 方法名（参数列表） throws  AAAException,BBBException...{

	throw new AAAException("产生原因");

	throw new BBBException("产生原因");

}
```

注意：

1. throws关键字必须写在方法声明处

2. throws关键字后边声明的异常必须是Exception或者是Exception的子类

3. 方法内部如果抛出了多个异常，那么throws后边必须也声明多个异常

   ​	如果抛出的多个异常对象有子父类关系，那么直接声明父类异常即可

4. 调用了一个声明抛出异常的方法，我们就必须的处理声明的异常

   ​	要么继续使用throws声明抛出，交给方法的调用者处理，最终交给JVM

   ​	要么try...catch自己处理异常

## 自定义处理异常

try...catch：自己处理异常

格式：

```java
try{
    可能产生异常的代码
}catch （定义一个异常的变量，用来接收try中抛出的异常对象）{
    异常的处理逻辑，接收异常对象之后，怎么处理异常对象
    一般在工作中，会把异常的信息记录到一个日志中
}
...
catch（异常类名 变量名）{

}
```

注意：

1. try中可能会抛出多个异常对象，那么就可以使用多个catch来处理这些异常对象
2. 如果try中没有产生异常，那么就不会执行catch中异常的处理逻辑，执行完try中的代码继续执行try...catch之后的代码



## Throwable

Throwable类中定义了3个异常处理的方法

​	String getMessage（）	返回此 throwable 的简短描述。

​	String toString（）	返回此  throwable 的详细消息字符串。

​	void printStackTrace（）  JVM打印异常对象，默认此方法，打印的异常信息是最全面的。

 

## finally

finally中有return语句，就一定会用finally中的return

不管try中还是catch中有return   ，最终会执行finally的return

## 子父类异常

父类的方法声明抛出什么异常，子类继承后也要声明抛出什么异常

父类的方法没有声明抛出异常，子类继承后也不能声明抛出异常

​		除非方法体中try...catch抓异常

## 自定义异常类



```java
public class xxxException extends Exception | RuntimeException{
    添加一个空参的构造方法
    添加一个带异常信息的构造方法
}
```

注意：

1. 自定义异常类一般都是以Exception结尾，说明该类是一个异常类

2. 自定义异常类，必须继承Exception或者RuntimeException

   ​		继承Exception：那么自定义的异常类就是一个编译期异常，如果方法内部抛出编译期异常，就必须处理这个异常，要么throws，要么try...catch

   ​		继承RuntimeException：那么自定义的异常类就是一个运行期异常，无需处理，交给虚拟机处理（中断处理）





