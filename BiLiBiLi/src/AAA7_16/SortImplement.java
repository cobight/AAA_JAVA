package AAA7_16;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

public class SortImplement {
    public static void main(String[] args) throws ParseException {
        
        ArrayList<User> list = new ArrayList<>();
        list.add(new User("老大","19980122",50));
        list.add(new User("老二","19970122",60));
        list.add(new User("老三","19980122",70));
        list.sort((o1, o2) -> o1.getAge()-o2.getAge());

//        Collections.sort(list, new Comparator<User>() {
//            @Override
//            public int compare(User o1, User o2) {
//                return o2.getAge()-o1.getAge();
//            }
//        });



//        Collections.sort(list);
        System.out.println(list);
    }
}
class User implements Comparable<User>{
    private String name;
    private Date birthday;
    private int score;
    private SimpleDateFormat sdf= new SimpleDateFormat("yyyyMMdd");
    public User(String name, String birthday, int score) throws ParseException {
        this.name = name;
        this.birthday = sdf.parse(birthday);
        this.score = score;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getBirthday() {
        return sdf.format(birthday);
    }
    public void setBirthday(String birthday) throws ParseException {
        this.birthday = sdf.parse(birthday);
    }
    public int getScore() {
        return score;
    }
    public void setScore(int score) {
        this.score = score;
    }
    public int getAge(){
        Calendar calendar = Calendar.getInstance();
        long now = calendar.getTimeInMillis();
        calendar.setTime(this.birthday);
        long birth = calendar.getTimeInMillis();
        return (int) ((now-birth)/1000/60/60/24/365);
    }
    @Override
    public String toString() {
        return "User{" +
                "name='" + name + '\'' +
                ", birthday=" + sdf.format(birthday) +
                ", score=" + score +
                ", age=" + getAge() +
                '}';
    }
    @Override
    public int compareTo(User o) {
        return this.getAge()-o.getAge();
    }
}