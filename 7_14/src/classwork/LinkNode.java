package classwork;

public class LinkNode {
    public static void main(String[] args) {
        Tools tools = new Tools();
        tools.add(1);
        tools.add(2);
        tools.add(3);
        tools.add(1, 5);
        System.out.println(tools.del(1));
        System.out.println(tools.getNode(2));
        tools.setNode(2, 8);
        System.out.println(tools);
    }
}
class ToolsPlus extends Tools{

}
class Tools {
    Node first;
    Node last;
    int length = 0;

    public void add(Object element) {
        Node node = new Node(element);
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

    public void add(int index, Object element) {
        if (index >= 0 && index <= length) {
            Node node = new Node(element);
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
                Node ind = first;
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

    public Node del(int index) {
        if (index >= 0 && index < length) {
            Node retn = null;
            if (index == 0) {
                retn = first;
                first.next.head = first.next;
                first = first.next;
            } else if (index == length - 1) {
                retn = last;
                last.head.next = null;
            } else {
                Node ind = first;
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

    public Node getNode(int index) {
        Node retn = null;
        if (index >= 0 && index < length) {
            Node ind = first;
            for (int i = 0; i < index; i++) {
                ind = ind.next;
            }
            retn = ind;
        }
        return retn;
    }

    public void setNode(int index, Object element) {
        if (index >= 0 && index < length) {
            Node ind = first;
            for (int i = 0; i < index; i++) {
                ind = ind.next;
            }
            ind.element = element;
        }
    }

    @Override
    public String toString() {
        Node node = first;
        StringBuilder str = new StringBuilder("{");
        while (node != null) {
            str.append(node.element).append(",");
            node = node.next;
        }
        str.setCharAt(str.length() - 1, '}');
        return str.toString();
    }
}

class Node {
    Node head;
    Node next;
    Object element;

    public Node(Object element) {
        this.element = element;
    }

    @Override
    public String toString() {
        return "Node{" +
                "element=" + element +
                '}';
    }
}
