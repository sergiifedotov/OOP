package hw2.hash;

import java.util.Calendar;
import java.util.GregorianCalendar;

/**
 *Написать модульные тесты для класса пользователь, на методы equals и hashCode.
 Поля класса пользователь:
 1. Логин
 2. Пароль
 3. Дата регистрации
 4. Рейтинг (вещественное число)
 5. Пол
 */
public class UserTest {

    public static void equalsTest(String nameTest, User user1, User user2, boolean rezult){

        if (user1.equals(user2)==rezult) {
            System.out.println(nameTest.concat("completed successfully"));}
        else
        {System.err.println(nameTest.concat("error"));}

    }

    public static void hashCodeTest(String nameTest, User user, int rezult){

        if (user.hashCode()==rezult) {
            System.out.println(nameTest.concat("completed successfully"));}
        else
        {System.err.println(nameTest.concat("error"));}

    }

    public static void main(String[] args) {
        User user1 = new User("Ivan", "123", new GregorianCalendar(2015, Calendar.JANUARY, 15), 50.6, "male");
        User user2 = new User("Ivan", "456", new GregorianCalendar(2015, Calendar.JANUARY, 15), 50.6, "male");
        User user3 = new User("Ivan", "456", new GregorianCalendar(2015, Calendar.JANUARY, 15), 50.6, "male");
        User user4 = new User("1", "2", new GregorianCalendar(2000, Calendar.JANUARY, 1), 0, "male");

        String nameTest;

        nameTest = "equalsTest1:";
        equalsTest(nameTest, user2, user3, true);

        nameTest = "equalsTest2:";
        equalsTest(nameTest, user1, user2, false);

        nameTest = "equalsTest3:";
        equalsTest(nameTest, user1, null, false);


        nameTest = "hashCodeTest1:";
        hashCodeTest(nameTest, user4, 498267761);

        nameTest = "hashCodeTest2:";
        hashCodeTest(nameTest, user4, 100);

        nameTest = "hashCodeTest3:";
        hashCodeTest(nameTest, user4, -1);
    }
}
