package hw2;

/**
 * Created by warit on 17.01.2015.
 */
public class User {

    private String login;
    private String pass;

    public User(String login, String pass){
        this.login = login;
        this.pass = pass;
    }

    public String getLogin() {
        return login;
    }

    public String getPass() {
        return pass;
    }

    @Override
    public boolean equals(Object user){


        if (user == null)
            return false;
        if (getClass() != user.getClass())
            return false;
        User other = (User) user;

        return ((login.equals(other.login))&&(pass.equals(other.pass)));
    }

    @Override
    public int hashCode() {
        return login.hashCode()+pass.hashCode();
    }
}
