package cn;

public class demo1 {
    public static void main(String[] args) {
        int a = 'z';
        System.out.println(a);
        for (int i = 48; i <= 57 ; i++) {//0-9
            System.out.println((char) i);
        }
        for (int i = 65; i <= 90 ; i++) {//A-Z
            System.out.println((char) i);
        }
        for (int i = 97; i <= 122 ; i++) {//a-z
            System.out.println((char) i);
        }
    }
}
