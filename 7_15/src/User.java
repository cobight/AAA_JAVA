import java.util.Scanner;


class Control{
    public static void main(String[] args) {
        ToolsPlus<User> tools = new ToolsPlus<User>();
        tools.add(new User("admin","admin"));
        tools.add(new User("admins","admins"));
        tools.add(new User("a","a"));
        Scanner scanner = new Scanner(System.in);
        boolean state = true;
        String name = null;
        System.out.println("欢迎来到学生管理系统");
        while (true){
            if (state){
                System.out.println("请输入用户名 ：");
                name = scanner.next();
                if (tools.isName(name)){
                    state=false;
                    System.out.println("用户名输入正确，请继续输入密码：");
                }else {
                    System.out.println("该用户不存在，请重新输入！");
                }
            }else {
                String pwd = scanner.next();
                if (tools.getNode(name,pwd)!=null){
                    System.out.println("密码输入正确！");
                    System.out.println("登陆成功！");
                    return;
                }else {
                    System.out.println("密码输入不正确，请重新输入！");
                    System.out.println("请输入密码：");
                }
            }
        }
    }
    public static void demo1(){
        User user = new User("admin","admin");
        Scanner scanner = new Scanner(System.in);
        boolean state = true;
        System.out.println("欢迎来到学生管理系统");
        while (true){
            if (state){
                System.out.println("请输入用户名 ：");
                String name = scanner.next();
                if (name.equals(user.getName())){
                    state=false;
                    System.out.println("用户名输入正确，请继续输入密码：");
                }else {
                    System.out.println("该用户不存在，请重新输入！");
                }
            }else {
                String pwd = scanner.next();
                if (pwd.equals(user.getName())){
                    System.out.println("密码输入正确！");
                    System.out.println("登陆成功！");
                    return;
                }else {
                    System.out.println("密码输入不正确，请重新输入！");
                    System.out.println("请输入密码：");
                }
            }
        }
    }
}
class ToolsPlus<E> extends Tools<E>{
    public E getNode(String name,String pwd){
        String msg = name + "," + pwd;
        for (Node<E> node = first;node!=null;node=node.next){
            if (node.toString().equals(msg)){
                return node.element;
            }
        }
        return null;
    }
    public boolean isName(String name){
        String msg = name;
        for (Node<E> node = first;node!=null;node=node.next){
            if (node.toString().split(",")[0].equals(msg)){
                return true;
            }
        }
        return false;
    }
    public boolean isPwd(String pwd){
        String msg = pwd;
        for (Node<E> node = first;node!=null;node=node.next){
            if (node.toString().split(",")[1].equals(msg)){
                return true;
            }
        }
        return false;
    }
}
class Tools<E> {
    Node<E> first;
    Node<E> last;
    int length = 0;
    public void add(E element) {
        Node<E> node = new Node<>(element);
        if (first == null && last == null) {
            first = node;
            last = node;
        }
        node.head = last;
        last.next = node;
        node.next = null;
        last = node;
        length++;
    }

    public void add(int index, E element) {
        if (index >= 0 && index <= length) {
            Node<E> node = new Node<>(element);
            if (index == 0) {
                node.next = first;
                node.head = node;
                first = node;
            } else if (index == length) {
                node.head = last;
                last.next = node;
                node.next = null;
                last = node;
            } else {
                Node<E> ind = first;
                for (int i = 1; i < index; i++) {
                    ind = ind.next;
                }
                node.head = ind;
                node.next = ind.next;
                ind.next = node;
//                System.out.println(ind);
            }
        } else {
            System.out.println("add err");
        }
    }

    public Node<E> del(int index) {
        if (index >= 0 && index < length) {
            Node<E> retn = null;
            if (index == 0) {
                retn = first;
                first.next.head = first.next;
                first = first.next;
            } else if (index == length - 1) {
                retn = last;
                last.head.next = null;
            } else {
                Node<E> ind = first;
                for (int i = 0; i < index; i++) {
                    ind = ind.next;
                }
                retn = ind;
                ind.head.next = ind.next;
            }
            length--;
            return retn;
        }
        return null;
    }

    public Node<E> getNode(int index) {
        Node<E> retn = null;
        if (index >= 0 && index < length) {
            Node<E> ind = first;
            for (int i = 0; i < index; i++) {
                ind = ind.next;
            }
            retn = ind;
        }
        return retn;
    }

    public void setNode(int index, E element) {
        if (index >= 0 && index < length) {
            Node<E> ind = first;
            for (int i = 0; i < index; i++) {
                ind = ind.next;
            }
            ind.element = element;
        }
    }

    @Override
    public String toString() {
        Node<E> node = first;
        StringBuilder str = new StringBuilder("{");
        while (node != null) {
            str.append(node.element).append(",");
            node = node.next;
        }
        str.setCharAt(str.length() - 1, '}');
        return str.toString();
    }
}
public class User {
    private String name;
    private String pwd;
    public User() {
    }

    public User(String name, String pwd) {
        this.name = name;
        this.pwd = pwd;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPwd() {
        return pwd;
    }

    public void setPwd(String pwd) {
        this.pwd = pwd;
    }

    @Override
    public String toString() {
        return name+","+ pwd;
    }
}
class Node<E> {
    Node<E> head;
    Node<E> next;
    E element;

    public Node(E element) {
        this.element = element;
    }

    public E getElement() {
        return element;
    }

    public void setElement(E element) {
        this.element = element;
    }

    @Override
    public String toString() {
        return element.toString();
    }
}