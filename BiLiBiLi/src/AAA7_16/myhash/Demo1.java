package AAA7_16.myhash;


public class Demo1 {
    static class Node{
        int hash;
        Object key;
        Object value;
        Node next;

    }
    static class SxtHashMap{
        Node[] table;//位桶数组
        int size=0;//存放键值对的个数

        @Override
        public String toString() {
            StringBuilder sb = new StringBuilder("{");
            for (int i = 0; i < table.length; i++) {
                Node temp = table[i];
                while (temp!=null){
                    sb.append(temp.key+":"+temp.value+",");
                    temp=temp.next;
                }
            }
            sb.setCharAt(sb.length()-1,'}');
            return sb.toString();
        }
        public SxtHashMap() {
            table = new Node[16];//长度一般定义成2的整数幂
        }
        public Object get(Object key){
            int hash = myHash(key.hashCode(),table.length);
            Object value=null;

            if (table[hash]!=null){
                Node temp=table[hash];
                while (temp!=null){
                    if (temp.key.equals(key)){//如果相等，就是找到了
                        value=temp.value;
                        break;
                    }else {
                        temp=temp.next;
                    }
                }
            }

            return value;
        }
        public void put(Object key,Object value){
            Node newNode = new Node();
            newNode.hash=myHash(key.hashCode(),table.length);
            newNode.key=key;
            newNode.value=value;
            newNode.next=null;

            Node temp = table[newNode.hash];
            Node iterLast = null;
            boolean keyRepeat =false;
            if (temp==null){//数组元素为空，将节点放入
                table[newNode.hash] = newNode;
                size++;
            }else {
                while (temp!=null){
                    if (temp.key.equals(key)){//重复
                        keyRepeat=true;
                        temp.value=value;
                        break;
                    }else {
                        iterLast = temp;
                        temp = temp.next;
                    }
                }
                if (!keyRepeat){
                    iterLast.next=newNode;
                    size++;
                }

            }
        }
        public int myHash(int v,int length){
//        System.out.println("hash in myHash:"+(v&(length-1)));//位运算，效率高
//        System.out.println("hash in myHash:"+(v%(length-1)));//取模运算，效率低
            return v&(length-1);
        }
    }
    public static void main(String[] args) {
        SxtHashMap m = new SxtHashMap();
        m.put(10,"aa");//6
        m.put(20,"bb");//4----kill
        m.put(30,"cc");//14
        m.put(20,"ssss");//4
        m.put(53,"gg");//5
        m.put(69,"hh");//5
        m.put(85,"kk");//5

        System.out.println(m);
        System.out.println(m.get(53));

    }
    public static int myHash(int v,int length){
        return v&(length-1);
    }

}








