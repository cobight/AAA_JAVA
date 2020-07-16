package workdemo;


class LinkNode {
    public static void main(String[] args) {
//        Tools<Animal> tools = new Tools();
//        tools.add(new Cat("猫"));
//        tools.add(new Dog("狗"));
//        System.out.println(tools.getNode(1));
//        System.out.println(tools);
        ToolsPlus<Student> tools = new ToolsPlus<>();
        tools.add(new Student("老大",50));
        tools.add(new Student("老三",70));
        tools.add(1,new Student("老二",60));

        System.out.println(tools);
        System.out.println(tools.del(0));
        tools.setNode(0,new Student("老八",100));
        System.out.println(tools.getNode(0));
        System.out.println(tools);
    }
}
class ToolsPlus<E> extends Tools<E>{
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
        return "Node{" +
                "element=" + element +
                '}';
    }
}
class Student{
    private String name;
    private int score;

    public Student(String name, int score) {
        this.name = name;
        this.score = score;
    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", score=" + score +
                '}';
    }
}
abstract class Animal {
    String name;
    abstract void eat();
}
class Cat extends Animal {
    public Cat(String name){
        this.name=name;
    }
    @Override
    void eat() {
        System.out.println("猫吃老鼠");
    }

    @Override
    public String toString() {
        return "Cat："+name;
    }
}
class Dog extends Animal {
    public Dog(String name){
        this.name=name;
    }
    @Override
    void eat() {
        System.out.println("狗吃屎");
    }

    @Override
    public String toString() {
        return "Dog："+name;
    }
}