package AAA7_3;

public class StringDemo1 {
    public static void main(String[] args) {
        String string = new String();
        System.out.println(1+":"+string);
        char[] charArray = {'A','B','C'};
        String string1 = new String(charArray);
        System.out.println(string1);
        byte[] byteArray = {97,98,99};
        String string2 = new String(byteArray);
        System.out.println(string2);

    }
}
