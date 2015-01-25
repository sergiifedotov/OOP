package hw2.equalsAndHashcod;

import java.util.Date;
import java.util.GregorianCalendar;

/**
 * Created by Tanya on 19.01.2015.
 */
public class UserTest {
    public static void main(String[] args) {
        testEquals();
        testHashCode();
    }
        public static boolean testEquals() {
            User x = new User("q", "1q", 2010, 1, 20, 0.1f, "m");
            User y = new User("q", "1q", 2010, 1, 20, 0.1f, "m");
            User z = new User("q", "1q", 2010, 1, 20, 0.1f, "m");
            User other = new User("qq", "1qq", 2011, 1, 20, 0.1f, "m");
            if (x.equals(x) == true // Рефлексивность
                    && y.equals(x) == true //Симметричность
                    && x.equals(y) == true //Симметричность
                    && y.equals(z) == true // Транзитивность
                    && x.equals(z) == true // Транзитивность
                    && x.equals(null) == false
                    && x.equals(other) == false) {
                System.out.println("Test Equals success");
                return true;
            } else {
                System.out.println("Test Equals failed");
                return false;
            }
        }
    public static boolean testHashCode(){
        User x = new User("q", "1q", 2010, 1, 20, 0.1f, "m");
        String login = "q";
        String pass = "1q";
        GregorianCalendar calendar = new GregorianCalendar(2010, 0, 20);
        Date dayRegistration = calendar.getTime();
        float rating = 0.1f;
        String sex = "m";

        float temp = new Float(rating).hashCode();
        int ratingHashCod = (int) temp;
        int result = login.hashCode();
        result = 31 * result + pass.hashCode();
        result = 31 * result + dayRegistration.hashCode();
        result = 31 * result + ratingHashCod;
        result = 31 * result + sex.hashCode();

        if(result == x.hashCode()){
            System.out.println("Test hashCode success");
            return true;
        }  else {
            System.out.println("Test hashCode failed");
            return false;
        }
    }
    }

