public class befroe_start {
    public static void main(String[] args) {
        Phone phone = new Phone("小米9",3000,"紫色");

        Test test = new Test(phone);
    }
}
class Phone{
    String brand;//品牌
    int price;//价格
    String color;//颜色

    public Phone(String brand, int price, String color) {
        this.brand = brand;
        this.price = price;
        this.color = color;
    }
    public void Call(){
        System.out.println("打电话!");
    }
    public void Sendmsg(){
        System.out.println("发送短信Phone{" +
                "brand='" + brand + '\'' +
                ", price=" + price +
                ", color='" + color + '\'' +
                '}');
    }
    @Override
    public String toString() {
        return "Phone{" +
                "brand='" + brand + '\'' +
                ", price=" + price +
                ", color='" + color + '\'' +
                '}';
    }
}
class Test{
    public Test(Phone phone) {
        System.out.println(phone.toString());
        phone.Call();
        phone.Sendmsg();
    }
}