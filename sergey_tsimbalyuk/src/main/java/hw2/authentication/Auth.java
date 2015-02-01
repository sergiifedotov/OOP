package hw2.authentication;

import java.util.HashMap;
import java.util.Scanner;

/**
 * Created by Tsimbalyuk Sergey
 * 2/1/2015.
 */
public class Auth {
    public static void main(String[] args) {

        Auth auth = new Auth();

        auth.add("Vova", "vova");
        auth.add("Toma", "toma");

        System.out.println(auth.authenticate());
        System.out.println(auth.authenticate());
    }

    private HashMap<String, String> user;

    public Auth() {
        user = new HashMap<>();
    }

    public boolean authenticate(){
        System.out.print("Login >  ");
        String login = stringScanner();
        System.out.print("Password >  ");
        String pass = stringScanner();
        if (!user.containsKey(login)) return false;
        if (!user.get(login).equals(pass)) return false;
        return true;
    }

    public boolean authenticate (String login, String pass){
        if (!user.containsKey(login)) return false;
        if (!user.get(login).equals(pass)) return false;
        return true;
    }

    public void add(String login, String pass){
        user.put(login, pass);
    }

    public void remove(String login){
        user.remove(login);
    }

    public String stringScanner(){
        String s = "";
        Scanner scanner = new Scanner(System.in);
        s = scanner.nextLine();
        return s;
    }

}
class AuthTest {

    public static void main(String[] args) {

        Auth auth = new Auth();

        auth.add("uSeR01", "12345");
        auth.add("user02", "zxcsaa");

        System.out.println(auth.authenticate());
        System.out.println(auth.authenticate());
    }

}