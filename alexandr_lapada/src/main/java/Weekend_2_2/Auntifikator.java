package Weekend_2_2;

import java.util.*;

/**
 * Created by sanya on 18.01.2015.
 */
public class Auntifikator {
    Map<String, String> users = new HashMap<>();

    public Auntifikator(){
        users.put("sanya","123456");
        users.put("alex","123");

    }

    public boolean aunt(String loggin, String password){
        boolean rez = false;
        for(Map.Entry<String,String> e: users.entrySet()){
        if((loggin.equals(e.getKey())) && (password.equals(e.getValue()))){
             rez = true;
        }
        }
        return(rez);
    }
}
