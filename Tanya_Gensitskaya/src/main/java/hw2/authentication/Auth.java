package hw2.authentication;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;


/**
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
public class Auth {
    private Map<String, String> users = new HashMap<>();

    public Auth() {
    }


    public Auth(Map<String, String> users) {
        this.users = users;
    }

    public boolean authenticate()  {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        try {
            System.out.print("Enter login:");
            String login = br.readLine();
            if (users.get(login) == null) {
                System.out.print("Enter pass:");
                String pass = br.readLine();
                br.close();
                return true;
            } else {
                System.out.println("Error. Login exist!");
                br.close();
                return false;
            }
        }catch (IOException ex){
            System.out.println("Reading error");
        }
        return true;
    }

    public boolean authenticate(String login, String pass) {
        for (Map.Entry<String, String> elem : users.entrySet()) {
            if (elem.getKey().equals(login) && elem.getValue().equals(pass)) {
                return true;
            }
        }
        return false;
    }

    public boolean add(String login, String pass) {
        if (users.get(login) == null) {
            users.put(login, pass);
            System.out.println("true " + users.size());
            return true;
        } else {
            System.out.println("Error. Login exist!");
            return false;
        }
    }

    public boolean remove(String login) {
        if (users.get(login) != null) {
            users.remove(login);
            System.out.println("remove " + login + " true");
            return true;
        } else {
            System.out.println("Error. Login no exist!");
            return false;
        }
    }

    public void show() {
        int count = 1;
        for (Map.Entry<String, String> elem : users.entrySet()) {
            String key = elem.getKey();
            String value = elem.getValue();
            System.out.println(count + " " + key + " " + value);
            count++;
        }
    }
}


