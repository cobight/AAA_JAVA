package AAA7_18;

public class RegisterException extends Exception{
    public RegisterException() {
        super();
    }

    public RegisterException(String message) {
        super(message);
    }
}
class run{
    public static void main(String[] args) {
        try {
            method("a");
        } catch (RegisterException e) {
            e.printStackTrace();
        }
    }
    public static void method(String name) throws RegisterException {
        if (name.equals("a")){
            throw new RegisterException("重复了");
        }
    }
}