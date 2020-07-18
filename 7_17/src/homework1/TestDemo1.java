package homework1;

import java.text.ParseException;

public class TestDemo1 {
/*
    学生类：  class Student
        1、private Integer id；
        2、private String name；
        3、private String password；
        4、private Date birthday；
        5、private Integer sex；//0女1男
     (X)6、private Integer score；
        7、getter / setter / toString / 构造方法   重写
    数据处理类：  class StudentUtil
        1、String转Date                       -->修改set方法：void    setBirthday(String birthday)
        2、Date转String                       -->修改get方法：String  getBirthday()
        3、Date（birthday）  转Age(int)        -->           int     getAge()
     (X)4、String（birthday）转Age(int)        -->           int     getAge()
        5、getIntegerBySex                    -->           Integer getIntegerBySex(String sex)
        6、getStringBySex                     -->           String  getStringBySex(Integer)
    定义接口：  abstract class StudentDao
        1、定义增删改查方法（参数与返回值要注意）
        2、排序（int typer，int key）{// typer选择abcd那种排序；key选择正序倒序
            a:I D排序，通过id（添加的顺序）
            b:年龄排序，通过birthday
         (X)c:性别排序，利用0与1
         (X)d:成绩排序，利用score成绩
        }
        3、登录（String name,String password）返回 匹配到的【学生对象】
        4、定义菜单方法{
            欢迎用户语
            开始用户登录
            用循环控制登录行为
            ...
            登陆成功：欢迎登录的学生名字，打印学生的所有信息（记得重写学生对象的toString）
            return结束
        }
    实现接口：  class StudentIpm implements StudentDao
        1、实现增删改查方法
        2、实现排序方法
        3、实现登录方法
        4、实现菜单
    调用调试类： class StuTest
        1、主方法new StudentIpm对象，调用方法进入菜单
*/
    public static void main(String[] args){
        /*
        * 0  000
        * 1  001
        * 2  010
        * 3  011
        * 4  100
        * 5  101
        * 6  110
        * 7  111
        * 8 1000
        * 9 1001
        *10 1010
        * */
        System.out.println(10>>2);
//        int max = 100;
//        int min = max&10;
//        System.out.println(1&2);//001 & 010 = 000 / 0
//        System.out.println(3&4);//011 & 100 = 000 / 0
//        System.out.println(3&5);//011 & 101 = 001 / 1
//        System.out.println(5&7);//101 & 111 = 101 / 5
//        System.out.println(3&10);//0011 & 1010 = 0010 / 2
//        System.out.println(6&10);//0110 & 1010 = 0010 / 2
        /*
        * max>>1 = 50
        * max>>2 = 25
        * max>>3 = 12
        * max>>4 = 6
        * max>>5 = 3
        * max>>6 = 1
        * max>>7 = 0
        *
        * */
//        System.out.println(min);

//        try {
//            method();
//        } catch (ParseException e) {
//            e.printStackTrace();
//        }
    }
    public static void method() throws ParseException {
        StudentIpl tool = new StudentIpl();
        tool.add(new Student("老大","admin","男","19980122",100));
        tool.add(new Student("老二","ad","男","19880122",500));
        tool.add(new Student("老三","adm","女","19990122",10));
        tool.add(new Student("老大","admin","男","19980122",100));
        tool.add(new Student("老二","ad","男","19880122",500));
        tool.add(new Student("老三","adm","女","19990122",10));
        tool.add(new Student("老大","admin","男","19980122",100));
        tool.add(new Student("老二","ad","男","19880122",500));
        tool.add(new Student("老三","adm","女","19990122",10));
        tool.add(new Student("老大","admin","男","19980122",100));
        tool.add(new Student("老二","ad","男","19880122",500));
        tool.add(new Student("老三","adm","女","19990122",10));
        tool.add(new Student("老大","admin","男","19980122",100));
        tool.add(new Student("老二","ad","男","19880122",500));
        tool.add(new Student("老三","adm","女","19990122",10));
        tool.add(new Student("老大","admin","男","19980122",100));
        tool.add(new Student("老二","ad","男","19880122",500));
        tool.add(new Student("老三","adm","女","19990122",10));
        tool.Menu();
    }
}



