package Weekend_2_1;
import java.util.*;
/**
 * Created by sanya on 17.01.2015.
 */
public class Auntifikator {

    private HashSet<User> users = new HashSet<User>();
    public Auntifikator(){
        users.add(new User("sanya","123456"));
        users.add(new User("sasha","123"));
        users.add(new User());
        users.add(new User("alex","1"));
    }

    public boolean aunt(String loggin, String password){
        boolean rez = false;
        for(User a: users){
            //System.out.println(a.getLoggin()+" - "+a.getPassword());
            //System.out.println(loggin+" - "+password);
            //System.out.println("--------------------------------");
            if( (loggin.equals(a.getLoggin() ) ) && (password.equals(a.getPassword() ) ) ){
                rez = true;
            }
        }
        return(rez);
    }

}
