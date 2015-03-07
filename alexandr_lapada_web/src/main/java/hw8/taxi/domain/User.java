package hw8.taxi.domain;

/**
 * Created by sanya on 04.03.2015.
 */
public class User {
    private String login;
    private String password;
    private String identNumber;

    public User(){

    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getIdentNumber() {
        return identNumber;
    }

    public void setIdentNumber(String identNumber) {
        this.identNumber = identNumber;
    }
}
