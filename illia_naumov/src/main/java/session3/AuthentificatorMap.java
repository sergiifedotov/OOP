package session3;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by user on 18.01.2015.
 */
public final class AuthentificatorMap {
    public static void main(String[] args) {
        AuthentificatorMap auther = new AuthentificatorMap();
        auther.users.put("Maks", "1");
        auther.users.put("Olga", "2");
        auther.users.put("Vano", "13");
        System.out.println(auther.auth("Maks", "1"));

    }
    HashMap<String, String> users = new HashMap<String, String>();

    public boolean auth(String login, String password){
        if(users.containsKey(login)){
            for (Map.Entry<String, String> entry : users.entrySet()) {
                if(entry.getKey().equals(login) && entry.getValue().equals(password)){
                    return true;
                }
            }
        }
        return false;
    }
}
