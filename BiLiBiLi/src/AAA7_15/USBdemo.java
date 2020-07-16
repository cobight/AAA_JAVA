package AAA7_15;

public class USBdemo {
    public static void hi(int x){}
    public static void hi(float x){}
    public final  void hi(String y){}
    public final int hi(double x){return 1;}

    public static void main(String[] args) {

        /*Computer computer = new Computer();
        computer.powerOn();

        computer.useDevice(new Mouse());
        computer.useDevice(new Keyboard());

        computer.powerOff();*/
    }
}
interface USB{
    public abstract void open();
    public abstract void close();
}
class Computer{
    public void powerOn(){
        System.out.println("开机");
    }
    public void powerOff(){
        System.out.println("关机");
    }
    public void useDevice(USB usb){
        usb.open();
        if (usb instanceof Mouse){
            Mouse mouse = (Mouse) usb;
            mouse.move();
        }else if (usb instanceof Keyboard){
            Keyboard keyboard = (Keyboard) usb;
            keyboard.click();
        }
        usb.close();
    }
}
class Mouse implements USB{
    @Override
    public void open() {
        System.out.println("打开鼠标");
    }
    @Override
    public void close() {
        System.out.println("关闭鼠标");
    }
    public void move(){
        System.out.println("move");
    }
}
class Keyboard implements USB{
    @Override
    public void open() {
        System.out.println("打开键盘");
    }
    @Override
    public void close() {
        System.out.println("关闭键盘");
    }
    public void click(){
        System.out.println("click");
    }
}