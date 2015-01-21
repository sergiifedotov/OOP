package hw2.authentication;
import java.util.*;
/**
 * Created by sanya on 20.01.2015.
 */
public class Auth {
    private HashMap<String,String> users = new HashMap<String,String>();

    public Auth(){

        users.put("sasha","123456");
        users.put("igor","123456");
    }

    public void add(String login, String pass){
        if (users.containsKey(login)){
            System.out.println("логин уже существует");
        }else {
            System.out.println("пользователь " + login + " добавлен");
            users.put(login, pass);
        }
    }

    public void remove(String login){
        if (users.get(login)==null){
            System.out.println("не верный логин");
        }else {
            System.out.println("пользователь " + login + " удален");
            users.remove(login);
        }
    }

    public boolean authenticate(String login,String pass){
        boolean rez = false;
        for (Map.Entry e: users.entrySet()){if (e.getKey().equals(login)&&e.getValue().equals(pass)){ rez = true;} }
        return(rez);
    }

}
