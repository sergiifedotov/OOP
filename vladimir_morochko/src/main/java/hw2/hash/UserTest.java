package hw2.hash;

/**
 * Created by vladimir on 19.01.2015.
 *
 * Написать модульные тесты для класса пользователь,
 * на методы equals и hashCode.
 * Поля класса пользователь:
 * 1. Логин
 * 2. Пароль
 * 3. Дата регистрации
 * 4. Рейтинг (вещественное число)
 * 5. Пол

 */
public class UserTest {
    public static void main(String[] args) {
        User user1 = new User("Vasya", "111");
        User user2 = new User("Vasya", "111"); // user2 is similar
        user1.setRegDate(user2.getRegDate()); // to equalize moments of creation
        User user3 = new User("Petya", "222"); // user3 is different
        String user4 = new String("Something totally wrong");

        boolean actual;
        boolean expected;

        System.out.println("equals test");

        actual = user1.equals(user2);
        expected = true;
        if (actual == expected) {
            System.out.println("test 1 passed");
        } else {
            System.out.println("test 1 failed");
        }

        actual = user1.equals(user3);
        expected = false;
        if (actual == expected) {
            System.out.println("test 2 passed");
        } else {
            System.out.println("test 2 failed");
        }

        actual = user1.equals(user4);
        expected = false;
        if (actual == expected) {
            System.out.println("test 3 passed");
        } else {
            System.out.println("test 3 failed");
        }

        System.out.println("\nhashCode test");

        actual = user1.hashCode() == user2.hashCode();
        expected = true;
        if (actual == expected) {
            System.out.println("test 1 passed");
        } else {
            System.out.println("test 1 failed");
        }

        actual = user1.hashCode() == user3.hashCode();
        expected = false;
        if (actual == expected) {
            System.out.println("test 2 passed");
        } else {
            System.out.println("test 2 failed");
        }

        actual = user1.hashCode() == user4.hashCode();
        expected = false;
        if (actual == expected) {
            System.out.println("test 3 passed");
        } else {
            System.out.println("test 3 failed");
        }

    }

}
