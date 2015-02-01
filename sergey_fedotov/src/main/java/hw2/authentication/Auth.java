package hw2.authentication;

import java.util.HashMap;
import java.util.Scanner;

/**
 * Created by warit on 17.01.2015.
 */
public class Auth {

    private HashMap<String, String> memberList;

    public Auth(){
        memberList = new HashMap<>();
    }

    public void add(String login, String pass){
        memberList.put(login, pass);
    }

    public void remove(String login){
        memberList.remove(login);
    }

    public boolean authenticate(String login, String pass){
       return memberList.containsKey(login)&&memberList.get(login).equals(pass);
    }

    public boolean authenticate(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Add login");
        String login = scanner.nextLine();
        System.out.println("Add pass");
        String pass = scanner.nextLine();
        return authenticate(login, pass);
    }

}
