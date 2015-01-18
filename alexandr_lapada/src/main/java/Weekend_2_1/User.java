package Weekend_2_1;

/**
 * Created by sanya on 17.01.2015.
 */
public class User {
    private String loggin;
    private String password;

    public User(){}

    public User(String loggin,String password){
        this.password = password;
        this.loggin = loggin;
    }

    public void setLoggin(String loggin){
        this.loggin = loggin;
        this.password = password;
    }
        public String getLoggin(){
            return(loggin);
        }

    public void setPassword(String password){
        this.password = password;
    }
        public String getPassword(){
            return(password);
        }

}
