public class demo1 {
    public static void main(String[] args) {
        String a="hello2";
        final String b = get();
        String c= b+2;
        System.out.println((a==c));
    }
    public static String get(){
        return "hello";
    }
}
