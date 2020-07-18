package homework1;

import java.text.ParseException;

public interface StudentDao {
    //增
    Student add(Student stu);
    //删
    Student del(String name);
    //通过名字获取下标
    int getIndexByName(String name);
    //改
    Student upData(String name, String newName, String password, String sex, String birthday, Integer score) throws ParseException;
    //查
    void showAll();

//     void sort(int key,boolean value);
//     boolean sortBy(Student a,Student b,int key, boolean value);
    //菜单
    void Menu() throws ParseException;
}
