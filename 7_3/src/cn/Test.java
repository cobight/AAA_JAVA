package cn;

public class Test {
    public static void main(String[] args) {

        /*想单独new个对象也行
        Keyborad keyborad = new Keyborad("键盘");
        Mouse mouse = new Mouse("鼠标");
        Displayer displayer = new Displayer("显示器");
        Computer computer = new Computer(keyborad,mouse,displayer);
        */
        Computer computer = new Computer(new Keyborad("键盘"),new Mouse("鼠标"),new Displayer("显示器"));
        computer.runs();
    }
}
