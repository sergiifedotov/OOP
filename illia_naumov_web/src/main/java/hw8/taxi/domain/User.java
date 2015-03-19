package hw8.taxi.domain;

/**
 * Created by illia_naumov on 10.03.2015.
 */
public class User {
    //private String login;
    private long id;
    private String password;
    private boolean blocked = false;
    private int authTries = 0;

    public User(long id, String password) {
        //this.login = login;
        this.id = id;
        this.password = password;
    }

    public User() {
    }


    public String getPassword() {
        return password;
    }


    public void setPassword(String password) {
        this.password = password;
    }

    public int getAuthTries() {
        return authTries;
    }

    public boolean isBlocked() {
        return blocked;
    }

    public void setBlocked(boolean blocked) {
        this.blocked = blocked;
    }

    public void setAuthTries(int authTries) {
        this.authTries = authTries;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }
}
