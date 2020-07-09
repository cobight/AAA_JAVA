package AAA7_7;

public class static_demo2 {
    public static void main(String[] args) {
//        Static_class.do1();//直接报红
        Static_class obj = new Static_class();
        obj.do1();//成员方法需要先创建对象

        obj.do2();//也对，不推荐，也没代码提示，硬写也不算错
        Static_class.do2();//推荐类名.静态方法
    }
}
