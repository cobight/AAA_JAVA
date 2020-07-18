package AAA7_16.myhash;

import java.util.HashMap;
import java.util.Objects;

public class Demo2 {
    static class Node<K, V> {
        int hash;
        K key;
        V value;
        Node<K, V> next;

    }

    static class SxtHashMap<K, V> {
        Node<K, V>[] table;//位桶数组
        int size = 0;//存放键值对的个数

        @Override
        public String toString() {
            StringBuilder sb = new StringBuilder("{");
            for (Node<K, V> kvNode : table) {
                Node<K, V> temp = kvNode;
                while (temp != null) {
                    sb.append(temp.key).append(":").append(temp.value).append(",");
                    temp = temp.next;
                }
            }
            sb.setCharAt(sb.length() - 1, '}');
            return sb.toString();
        }

        public SxtHashMap() {
            table = new Node[16];//长度一般定义成2的整数幂
        }

        public V get(K key) {
            int hash = myHash(key.hashCode(), table.length);
            V value = null;

            if (table[hash] != null) {
                Node<K, V> temp = table[hash];
                while (temp != null) {
                    if (temp.key.equals(key)) {//如果相等，就是找到了
                        value = temp.value;
                        break;
                    } else {
                        temp = temp.next;
                    }
                }
            }
            return value;
        }
        public void put(K key, V value) {
            Node<K, V> newNode = new Node<K, V>();
            newNode.hash = myHash(key.hashCode(), table.length);
            newNode.key = key;
            newNode.value = value;
            newNode.next = null;

            Node<K, V> temp = table[newNode.hash];
            Node<K, V> iterLast = null;
            boolean keyRepeat = false;
            if (temp == null) {//数组元素为空，将节点放入
                table[newNode.hash] = newNode;
                size++;
            } else {
                while (temp != null) {
                    if (temp.key.equals(key)) {//重复
                        keyRepeat = true;
                        temp.value = value;
                        break;
                    } else {
                        iterLast = temp;
                        temp = temp.next;
                    }
                }
                if (!keyRepeat) {
                    iterLast.next = newNode;
                    size++;
                }
            }
        }

        public int myHash(int v, int length) {
//        System.out.println("hash in myHash:"+(v&(length-1)));//位运算，效率高
//        System.out.println("hash in myHash:"+(v%(length-1)));//取模运算，效率低
            return v & (length - 1);
        }
    }
    static final int hash(Object key) {
        int h;
        return (key == null) ? 0 : (h = key.hashCode()) ^ (h >>> 16);
    }
    public static void main(String[] args) {
        int h;
        String key="123";
        System.out.println((key == null) ? 0 : (h = key.hashCode()) ^ (h >>> 16));


//        System.out.println(hash(2));
//        for (int i = 0; i < 20; i++) {
//            System.out.println(cococo(i, i+1));
//        }
//        SxtHashMap<Integer, String> m = new SxtHashMap<>();
//        m.put(10, "aa");//6
//        m.put(20, "bb");//4----kill
//        m.put(30, "cc");//14
//        m.put(20, "sss");//4
//        m.put(53, "gg");//5
//        m.put(69, "hh");//5
//        m.put(85, "kk");//5
//
//        System.out.println(m);
//        System.out.println(m.get(53));
    }
    public static final int cococo(Object key, Object value) {
        return Objects.hashCode(key) ^ Objects.hashCode(value);
    }
}




