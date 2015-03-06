package session14;

import java.util.Date;

/**
 * Created by vladimir on 03.03.2015.
 */
public class test {
    public static void main(String[] args) {
        Date date1 = new Date(2015, 03, 03);
        Date date2 = new Date(2015, 02, 03);
        Long diff = date1.getTime() - date2.getTime();
        System.out.println(diff / 1000 / 31 / 24);
    }
}
