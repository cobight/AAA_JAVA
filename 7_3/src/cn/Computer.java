package cn;

public class Computer {
    public Keyborad keyborad;
    public Mouse mouse;
    public Displayer displayer;
    public Computer(Keyborad k,Mouse m,Displayer d){
        this.keyborad = k;
        this.mouse = m;
        this.displayer = d;
    }
    void runs(){
//        keyborad = new Keyborad();
//        keyborad.brand="键盘";
//        mouse = new Mouse();
//        mouse.brand="鼠标";
//        displayer = new Displayer();
//        displayer.brand="显示器";
        System.out.println(this.toString());
    }

    @Override
    public String toString() {
        return "Computer{" +
                "keyborad=" + keyborad.brand +
                ", mouse=" + mouse.brand +
                ", displayer=" + displayer.brand +
                '}';
    }
}
