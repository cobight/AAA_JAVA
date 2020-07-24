package inclass;

import java.io.*;
import java.util.Date;

public class ObjectStreamDemo1 {
    public static void main(String[] args) throws Exception {
        String path = "7_24\\src\\inclass\\obj.txt";
        Student a = new Student("老八",18,new Date());
//        Student b= (Student) ;
        System.out.println(a.hashCode());
        System.out.println(a.clone().hashCode());
//        writeObj(path,a.clone());
//        Student s = (Student) readObj(path);
//        System.out.println(s);
    }
    public static void writeObj(String path,Object obj) throws Exception {
        FileOutputStream fos = new FileOutputStream(path);
        ObjectOutputStream oos = new ObjectOutputStream(fos);
        oos.writeObject(obj);
        oos.flush();
        fos.close();
        oos.close();
    }
    public static Object readObj(String path) throws Exception {
        FileInputStream fis = new FileInputStream(path);
        ObjectInputStream ois = new ObjectInputStream(fis);
        Object o = ois.readObject();
        fis.close();
        ois.close();
        return o;
    }
}
class Student implements Serializable,Cloneable {
    private String name;
    private Integer age;
    private Date now;

    public Student(String name, Integer age, Date now) {
        this.name = name;
        this.age = age;
        this.now = now;
    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", now=" + now +
                '}';
    }

    @Override
    protected Object clone() {
        try {
            return super.clone();
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
            return null;
        }
    }
}
