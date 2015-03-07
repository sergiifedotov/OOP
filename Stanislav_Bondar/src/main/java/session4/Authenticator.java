package session4;

import java.util.Map;

/**
 * Created by stan on 18.01.15.
 */
public class Authenticator {
    private Map<String, String> users;

public Authenticator(){

}
    public boolean auth (String login, String password){
        if(users.containsKey(login)&&users.get(login).equals(password)){
            return true;
        }
        return false;
    }
    public boolean auth1 (String login, String password){
        return users.containsKey(login)&& users.get(login).equals(password);
    }
    public boolean auth2 (String login, String password){
        for (Map.Entry<String, String> entry: users.entrySet()){
            if(entry.getKey().equals(login) && entry.getValue().equals(password)){
                return true;
            }
        }
        return false;
    }
}
