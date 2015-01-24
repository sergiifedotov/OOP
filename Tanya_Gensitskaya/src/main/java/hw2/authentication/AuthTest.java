package hw2.authentication;

import java.util.HashMap;
import java.util.Map;


public class AuthTest {
    public static void main(String[] args) {
        testAuthenticate();
        testAuthenticate();
        testAdd();
        remove();

    }

    public static boolean testAuthenticate()  {
        Map<String, String> users = new HashMap<>();
        users.put("hashMap", "w");
        Auth auth = new Auth(users);
        if(auth.authenticate() == false ){ // введите символ "hashMap"
            System.out.println("Test authenticate success ");
            auth = null;
            return true;
        }else {
            System.out.println("Test authenticate failed");
            auth = null;
            return false;
        }
    }

    public static boolean testAuthParam(){
        Map<String, String> users = new HashMap<>();
        String login = "hashMap";
        String pass = "w";
        users.put(login, pass);
        Auth auth = new Auth(users);
        if (auth.authenticate(login, pass) == true){
            System.out.println("Test authenticate(login, pass) success ");
            auth = null;
            return true;
        }else {
            System.out.println("Test authenticate (login, pass) failed");
            auth = null;
            return false;
        }
    }

    public static boolean testAdd() {
        Map<String, String> users = new HashMap<>();
        String login = "hashMap";
        String pass = "w";
        users.put(login, pass);
        Auth auth = new Auth(users);
        if (auth.add(login, pass) == false) {
            System.out.println("Test add success ");
            auth = null;
            return true;
        } else {
            System.out.println("Test add failed");
            auth = null;
            return false;
        }
    }


    public static boolean remove() {
        Map<String, String> users = new HashMap<>();
        String login = "hashMap";
        String pass = "w";
        users.put(login, pass);
        Auth auth = new Auth(users);
        if (auth.remove(login) == true) {
            System.out.println("Test remove success ");
            auth = null;
            return true;
        } else {
            System.out.println("Test remove failed");
            auth = null;
            return false;
        }
    }
}
