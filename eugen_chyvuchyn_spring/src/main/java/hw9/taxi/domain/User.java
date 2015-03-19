package hw9.taxi.domain;

import org.hibernate.validator.constraints.NotEmpty;

import javax.persistence.*;
import java.util.Date;

/**
 * Created by Chuvychin on 13.03.2015.
 */
@Entity
@Table(name="OPERATOR")
public class User {

    @Id
    @Column(name = "OPERATOR_ID")
    @SequenceGenerator(name = "sequence", sequenceName = "SEQ_CLIENTS_ID",
            allocationSize = 1, initialValue = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "sequence")
    private Long id;

    @NotEmpty
    @Column (name = "LOGIN")
    private String login;
    @NotEmpty
    @Column (name = "PASSWORD")
    private String pass;

    @Column (name = "ACT_DATE")
    @Temporal(TemporalType.DATE)
    private Date activatedDate;

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

    public Date getActivatedDate() {
        return activatedDate;
    }

    public void setActivatedDate(Date activatedDate) {
        this.activatedDate = activatedDate;
    }

    @Override
    public String toString() {
        return "User{" +
                "login='" + login + '\'' +
                ", pass='" + pass + '\'' +
                '}';
    }
}
