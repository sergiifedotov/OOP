package main.java.hw2.authentication;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by illia_naumov on 21.01.2015.

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
    public static void main(String[] args) throws IOException {
        Auth aut = new Auth();
        aut.add("Illia", "111");
        aut.add("Maks", "222");
        aut.add("Helen", "333");
        System.out.println(aut.authenticate());
        aut.add("Dashlo", "666");
        aut.remove("Illia");
        aut.print();
    }
    Map<String, String> users;
    public Auth(){
        users = new HashMap<String, String>();
    }
    public boolean authenticate() throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Type your login");
        String login = bf.readLine();
        System.out.println("Type your password");
        String password = bf.readLine();
        bf.close();
        return authenticate(login, password)?true:false;


    }

    public boolean authenticate(String login, String pass){
        return users.containsKey(login) && users.get(login).equals(pass)?true:false;
    }

    public void add(String login, String pass){
        if(users.containsKey(login) && !login.isEmpty()){
            System.out.println("This login is occupied");
        }else {
            users.put(login, pass);
        }
    }

    public void remove(String login){
        if(users.containsKey(login)){
            users.remove(login);
        } else {
            System.out.println("there is no user with current login");
        }
    }

    public void print(){
        for(Map.Entry<String, String> entry : users.entrySet()){
            System.out.println(entry.getKey() + " " + entry.getValue());
        }
    }
    class AuthTest {

    }
}


