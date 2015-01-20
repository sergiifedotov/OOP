package hw2.hash;

import java.util.Date;

/**
 * Created by Yaroslav_Syrota on 19.01.2015.
 */
public class User {
    private String login;
    private String password;
    private Date dateOfRegistracion;
    private int raiting;
    private boolean sex;

    public User(){}

    public User(String login, String password, boolean sex) {
        this.login = login;
        this.password = password;
        // this.dateOfRegistracion = new Date();
        this.raiting = 0;
        this.sex = sex;
    }

    @Override
    public boolean equals(Object o) {
        boolean temp = false;

        if(o!=null && getClass() == o.getClass()) {
            User u = (User) o;
            if(u.getLogin().equals(((User) o).getLogin()) && u.getPassword().equals(((User) o).getPassword())) temp=true;
        }

        return temp;
    }

    @Override
    public int hashCode() {
        int result = login.hashCode();
        result = 31 * result + password.hashCode();
        return result;
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
    public boolean isSex() {
        return sex;
    }
    public void setSex(boolean sex) {
        this.sex = sex;
    }
    public int getRaiting() {
        return raiting;
    }
    public Date getDateOfRegistracion() {
        return dateOfRegistracion;
    }
    public void setRaiting(int raiting) {
        this.raiting = raiting;
    }
}
