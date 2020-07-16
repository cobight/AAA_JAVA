

public class Music {
    public static void tune(Instument i){
        if (i instanceof Wind){
            Wind wind = (Wind) i;
            wind.play();
            wind.play2();
        }else if (i instanceof Brass){
            Brass brass = (Brass) i;
            brass.play();
            brass.play2();
        }
    }

    public static void main(String[] args) {
        tune(new Brass());
        tune(new Wind());
    }
}
class Instument{
    public void play(){};
}
class Wind extends Instument{
    @Override
    public void play() {
        System.out.println("Wind play");
    }
    public void play2(){
        System.out.println("Wind play2");
    }
}
class Brass extends Instument{
    @Override
    public void play() {
        System.out.println("Brass play");
    }
    public void play2(){
        System.out.println("Brass play2");
    }
}