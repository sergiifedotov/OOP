package web.domain;

import org.hibernate.validator.constraints.NotEmpty;

import javax.persistence.*;

/**
 *
 */

@Entity
@Table(name="USERS")
public class User {

    @Id
    @SequenceGenerator(name = "auto", sequenceName = "USER_ID")
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "auto")
    @Column(name="USER_ID")
    private Long id;


    @NotEmpty
    @Column(name="LOGIN")
    private String login;
    @NotEmpty
    @Column(name="PASS")
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
    public String toString() {
        return "User{" +
                "login='" + login + '\'' +
                ", pass='" + pass + '\'' +
                '}';
    }
}
