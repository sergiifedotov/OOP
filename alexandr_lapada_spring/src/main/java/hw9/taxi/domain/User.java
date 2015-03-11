package hw9.taxi.domain;

import javax.persistence.*;

/**
 * Created by sanya on 10.03.2015.
 */
@Entity
@Table(name = "USERS")
public class User {
    @SequenceGenerator(name = "sequence", sequenceName = "SEQ_USER_ID",
            allocationSize = 1, initialValue = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "sequence")
    @Id
    @Column(name = "USER_ID")
    private Long id;

    @Column(name = "LOGIN")
    private String login;

    @Column(name = "PASSWORD")
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

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "User{" +
                "login='" + login + '\'' +
                ", pass='" + pass + '\'' +
                '}';
    }
}
