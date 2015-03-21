package hw8.taxi.domain;

import org.hibernate.annotations.Type;
import org.hibernate.validator.constraints.NotEmpty;
import javax.persistence.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;


/**
 * Created by illia_naumov on 10.03.2015.
 */
@Entity
@Table(name = "OPERATORS")
public class User {
    @Id
    @Column(name = "OPERATOR_ID")
    @SequenceGenerator(name = "sequence", sequenceName = "operator_id",
            allocationSize = 1, initialValue = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "sequence")
    private long id;

    @Column(name = "LOGIN")
    private String login;
    @Column(name = "PASSWORD")
    private String password;
    @Column(name = "STATUS")
    private boolean blocked = false;
    @Column(name = "ACCESS_ATTEMPTS")
    private int authTries = 0;
    @Temporal(TemporalType.DATE)
    @Column(name = "PASSWORD_DATE" )
    private Date passDate;

    public User() {
    }

    public User(String login, long id, String password) {
        this.login = login;
        this.id = id;
        this.password = password;
        passDate = new Date();

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

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public Date getPassDate() {
        return passDate;
    }

    public void setPassDate(Date passDate) {
        this.passDate = passDate;
    }

    @Override
    public String toString() {
        return login + " " + password;
    }
}
