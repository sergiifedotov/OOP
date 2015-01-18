package Weekend_2_2;

/**
 * Created by sanya on 18.01.2015.
 */
public class User {
    private String loggin;
    private String password;

    public User(){};

    public User(String loggin, String password){
        this.loggin = loggin;
        this.password = password;
    }

    public String getLoggin(){
        return(loggin);
    }
}
