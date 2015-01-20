package hw2.authentication;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by Yaroslav_Syrota on 19.01.2015.
 */

/*
Написать класс аутентификации пользователя по логину и паролю, с методами:
	- boolean authenticate() - ввод логина и пароля + проверка
	- boolean authenticate(String login, String pass)
	- add(String login, String pass)
	- remove(String login)

Написать модульный тест.

Класс задания hw2.authentication.Auth
Класс теста hw2.authentication.AuthTest
 */

public class Auth {
    private Map<String, String> userMap = new HashMap<String, String>();
    public static final Auth AUTH = new Auth();

    private Auth() {}

    public boolean authenticate() throws IOException{
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Enter your login");
        String login = reader.readLine();
        System.out.println("Enter your password");
        String password = reader.readLine();
        reader.close();
        if(userMap.containsKey(login) && userMap.get(login).equals(password)) return true;
        else return false;

    }

    public void add(String login, String pass) {
        if(!userMap.containsKey(login)) userMap.put(login, pass);
    }

    public boolean authenticate(String login, String pass) {
        if(userMap.containsKey(login) && userMap.get(login).equals(pass)) return true;
        else return false;
    }

    public void remove(String login) {
        if(userMap.containsKey(login)) userMap.remove(login);
    }
}
