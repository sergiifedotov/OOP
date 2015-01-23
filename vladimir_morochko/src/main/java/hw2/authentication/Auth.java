package hw2.authentication;

import java.util.HashMap;
import java.util.Scanner;

/**
 * Created by vladimir on 23.01.2015.
 * Написать класс аутентификации пользователя по логину и паролю, с методами:
 * - boolean authenticate() - ввод логина и пароля + проверка
 * - boolean authenticate(String login, String pass)
 * - add(String login, String pass)
 * - remove(String login)
 *
 * Написать модульный тест.
 *
 * Класс задания hw2.authentication.Auth
 * Класс теста hw2.authentication.AuthTest
 */

public class Auth {
    private HashMap<String, String> users;

    public Auth() {
        users = new HashMap<String, String>();
    }

    public void add(String login, String pass) {
        if (!users.containsKey(login)) {
            users.put(login, pass);
        }
    }

    public void remove(String login) {
        if (users.containsKey(login)) {
            users.remove(login);
        }
    }

    public boolean authenticate(String login, String pass) {
        return users.containsKey(login) && users.get(login).equals(pass);
    }

    public boolean authenticate() {
        Scanner scan = new Scanner(System.in);
        System.out.print("login:");
        String login = scan.next();
        System.out.print("password:");
        String pass = scan.next();

        return authenticate(login, pass);
    }

    public HashMap<String, String> getUsers() {
        return users;
    }
    public void setUsers(HashMap<String, String> users) {
        this.users = users;
    }


}
