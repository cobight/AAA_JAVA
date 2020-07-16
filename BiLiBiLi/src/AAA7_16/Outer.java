package AAA7_16;

public class Outer {
    int num = 10;
    class Inner1{
        int num = 20;
        public void method(){
            int num = 30;
            System.out.println(num);
            System.out.println(this.num);
            System.out.println(Outer.this.num);
        }
    }
    public void method(){
        int fuc=100;
        class Inner2{
            public void method(){
                System.out.println(fuc);
                System.out.println("Inner2 method");
            }
        }
        Inner2 inner2 = new Inner2();
        inner2.method();
    }

}
class man{
    public static void main(String[] args) {
        Outer.Inner1 obj = new Outer().new Inner1();
        obj.method();
        Outer outer = new Outer();
        outer.method();
    }
}