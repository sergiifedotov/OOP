package Session3_4_DZ;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Chuvychin on 22.01.2015.
 */
public class Authenticator {

   private Map<String, String> users;

    public Authenticator(){
        users = new HashMap<>();
        users.put("1","5");
        users.put("2","4");
        users.put("3","3");
        users.put("4","2");
        users.put("5","1");

    }



    public boolean auth(String login, String pass){
        if (users.containsKey(login) && users.get(login).equals(pass))return true;
        return false;
    }

    public boolean auth1(String login, String pass){
        return users.containsKey(login) && users.get(login).equals(pass);

    }
}
