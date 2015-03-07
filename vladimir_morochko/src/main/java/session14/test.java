package session14;

import java.util.Date;

/**
 * Created by vladimir on 03.03.2015.
 */
public class test {
    public static void main(String[] args) {
//        Date date1 = new Date(2015, 03, 03);
//        Date date2 = new Date(2015, 02, 03);
//        Long diff = date1.getTime() - date2.getTime();
//        System.out.println(diff / 1000 / 31 / 24);

        Date date1 = new Date();
        System.out.println(date1.getTime());
        System.out.println(String.format("%tF", date1));
        Long timeDiff = 1000L * 60 * 60 * 24 * 31;
        System.out.println(timeDiff);
        timeDiff += date1.getTime();
        System.out.println(timeDiff);
        date1.setTime(timeDiff);
        //date1.setTime(1427666890212L);
        System.out.println(date1.getTime());
        System.out.println(String.format("%tF", date1));

    }
}
