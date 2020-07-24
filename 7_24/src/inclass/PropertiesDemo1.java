package inclass;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Iterator;
import java.util.Properties;
import java.util.Set;

public class PropertiesDemo1 {
    public static void main(String[] args) throws Exception {
        Properties ps = new Properties();
        FileInputStream fis = new FileInputStream("log4j.properties");
        ps.load(fis);
        Set set = ps.keySet();
        Iterator it = set.iterator();
        while (it.hasNext()){
            String key = (String)it.next();
            String value = ps.getProperty(key);
            System.out.println(key+"---------"+value);
        }
    }
}
