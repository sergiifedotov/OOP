package homework2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by stan on 07.03.15.
 */
public class Auth {
    public static void main(String[] args) throws IOException {
        Auth aut = new Auth();
        aut.add("berkut236466", "236466berkut");
        aut.add("saddersd", "123098");
        aut.add("amidoknetok", "madmadmad");
        aut.add("rombob", "alotofalcohol");
        System.out.println(aut.authenticate());
        aut.add("danidam", "fuckoff");
        aut.remove("saddersd");
        aut.print();
    }
    Map<String, String> users;
    public Auth(){
        users = new HashMap<String, String>();
    }
    public boolean authenticate() throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Enter your login, please!");
        String login = bf.readLine();
        System.out.println("Enter your password, please!");
        String password = bf.readLine();
        bf.close();
        return authenticate(login, password)?true:false;


    }

    public boolean authenticate(String login, String pass){
        return users.containsKey(login) && users.get(login).equals(pass)?true:false;
    }

    public void add(String login, String pass){
        if(users.containsKey(login) && !login.isEmpty()){
            System.out.println("This login already used");
        }else {
            users.put(login, pass);
        }
    }

    public void remove(String login){
        if(users.containsKey(login)){
            users.remove(login);
        } else {
            System.out.println("incorrect login");
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
