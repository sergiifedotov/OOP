package hw2.authentication;

/**
 * Created by vladimir on 23.01.2015.
 * <p/>
 * Написать класс аутентификации пользователя по логину и паролю, с методами:
 * - boolean authenticate() - ввод логина и пароля + проверка
 * - boolean authenticate(String login, String pass)
 * - add(String login, String pass)
 * - remove(String login)
 * <p/>
 * Написать модульный тест.
 * <p/>
 * Класс задания hw2.authentication.Auth
 * Класс теста hw2.authentication.AuthTest
 */
public class AuthTest {
    public static void main(String[] args) {
        Auth auth = new Auth();
        auth.add("111", "222");
        auth.add("333", "444");

        boolean actual;
        boolean expected;

        System.out.print("add test: ");
        actual = auth.getUsers().containsKey("333") &&
                auth.getUsers().get("333").equals("444");
        expected = true;
        if (actual == expected) {
            System.out.println("passed");
        } else {
            System.out.println("failed");
        }

        System.out.print("remove test: ");
        auth.remove("333");
        actual = auth.getUsers().containsKey("333");
        expected = false;
        if (actual == expected) {
            System.out.println("passed");
        } else {
            System.out.println("failed");
        }


        System.out.print("auth test 1: ");
        actual = auth.authenticate("111", "222");
        expected = true;
        if (actual == expected) {
            System.out.println("passed");
        } else {
            System.out.println("failed");
        }

        System.out.print("auth test 2: ");
        actual = auth.authenticate("111", "333");
        expected = false;
        if (actual == expected) {
            System.out.println("passed");
        } else {
            System.out.println("failed");
        }

        System.out.print("auth test 3: ");
        actual = auth.authenticate("555", "666");
        expected = false;
        if (actual == expected) {
            System.out.println("passed");
        } else {
            System.out.println("failed");
        }
    }
}
