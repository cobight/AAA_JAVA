package homework1;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class Util {
    static SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");

    public static Date getDateByBirthday(String birthday) {

        try {
            return sdf.parse(birthday);
        } catch (ParseException e) {
            e.printStackTrace();
        }finally {
            return null;
        }
    }

    public static String getStringByBirthday(Date birthday) {
        return sdf.format(birthday);
    }

    public static int getAge(Date birthday) {
        Calendar calendar = Calendar.getInstance();
        long now = calendar.getTimeInMillis();
        calendar.setTime(birthday);
        long birth = calendar.getTimeInMillis();
        return (int) ((now - birth) / 1000 / 60 / 60 / 24 / 365);
    }

    public static Integer getSex(String sex) {
        if ("男".equals(sex)) {
            return 1;
        } else if ("女".equals(sex)) {
            return 0;
        } else {
            return -1;
        }
    }

    public static String getSex(Integer sex) {
        if (sex == 1) {
            return "男";
        } else if (sex == 2) {
            return "女";
        } else {
            return null;
        }
    }
}
