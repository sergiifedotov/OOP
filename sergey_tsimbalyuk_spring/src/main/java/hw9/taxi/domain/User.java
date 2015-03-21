package hw9.taxi.domain;

import javax.persistence.*;
import java.util.Date;

/**
 * Created by Sergey Tsimbalyuk on 10.03.15.
 */
@Entity
@Table(name = "USERS")
public class User {
    @Id
    @Column(name = "USER_LOGIN")
    private String login;

    @Column (name = "USER_PASSWORD")
    private String password;

    @Column(name = "ACT_DATE")
    @Temporal(TemporalType.DATE)
    private Date passwordActivationDate;

    public User(String login, String password) {
        this.login = login;
        this.password = password;
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

    @Override
    public String toString() {
        return "User{" +
                "login='" + login + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}