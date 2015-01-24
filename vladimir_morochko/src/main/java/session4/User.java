package session4;

/**
 * Created with IntelliJ IDEA.
 * User: al1
 * Date: 17.01.15
 */
public class User {
    private String login;
    private String pass;

    public User() {
    }

    public User(String login, String pass) {
        this.login = login;
        this.pass = pass;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPass() {
        return pass;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }

        User user = (User) obj;

        if (!login.equals(user.login)) {
            return false;
        }
        if (!pass.equals(user.pass)) {
            return false;
        }

        return true;
    }

    @Override
    public int hashCode() {
        int result = login.hashCode();
        result = 31 * result + pass.hashCode();
        return result;
    }
}
