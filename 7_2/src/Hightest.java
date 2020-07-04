public class Hightest {
    public static void main(String[] args) {
//        Nine nine = new Nine();
//        for (int i = 1; i <= 9; i++) {//四选一
////            nine.prnt_Line1(i);
////            nine.prnt_Line2(i);
////            nine.prnt_Line3(i);
//            nine.prnt_Line4(i);
//        }
        Rectangle rectangle = new Rectangle(2, 2);

    }
}

//9x9
class Nine {
    public Nine() {
        for (int i = 1; i <= 9; i++) {//四选一
//            nine.prnt_Line1(i);
//            nine.prnt_Line2(i);
//            nine.prnt_Line3(i);
//            prnt_Line4(i);
        }
    }

    /*
     * |\
     * |_\
     */

    public void prnt_Line1(int i) {

        for (int j = 1; j <= i; j++) {
            System.out.print(i + "x" + j + "=" + i * j + "\t");
        }
        System.out.print("\n");
    }

    /*
     * |-/
     * |/
     */
    public void prnt_Line2(int i) {
        for (int j = 9; j >= i; j--) {
            System.out.print(i + "x" + j + "=" + i * j + "\t");
        }
        System.out.print("\n");
    }

    /*
     *  /|
     * /_|
     */
    public void prnt_Line3(int i) {
        for (int j = 8; j >= i; j--) {
            System.out.print("\t\t");
        }
        for (int k = 1; k <= i; k++) {
            System.out.print(i + "x" + k + "=" + i * k + "\t");
        }
        System.out.print("\n");
    }

    /*
     * \-|
     *  \|
     */
    public void prnt_Line4(int i) {
        for (int j = 1; j < i; j++) {
            System.out.print("\t\t");
        }
        for (int k = 9; k >= i; k--) {
            System.out.print(i + "x" + k + "=" + i * k + "\t");
        }
        System.out.print("\n");
    }
}

//矩形
class Rectangle {//输入>=1的数

    /*
     *   ┌--┐
     *   └--┘
     *
     * */
    public Rectangle(int x, int y) {//横着4个-为一个格子、竖着2个|为一个格字
        if (x == 1) {
            prnt_top(y);
            prnt_bottom(y);
        } else {
            prnt_top(y);
            for (int i = 0; i < x-1; i++) {
                prnt_mid(y);
            }
            prnt_bottom(y);
        }
    }

    public void prnt_mid(int y) {
        String string = "|";
        for (int i = 0; i < 2 * y; i++) {
            string += " ";
        }
        string += "|";
        System.out.println(string);
    }

    public void prnt_top(int y) {//top & bottom
        String string = "┌";
        for (int i = 0; i < 2 * y; i++) {
            string += "-";
        }
        string += "┐";
        System.out.println(string);
    }

    public void prnt_bottom(int y) {//top & bottom
        String string = "└";
        for (int i = 0; i < 2 * y; i++) {
            string += "-";
        }
        string += "┘";
        System.out.println(string);
    }
}