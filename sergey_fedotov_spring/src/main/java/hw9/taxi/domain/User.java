package hw9.taxi.domain;

import org.hibernate.validator.constraints.NotEmpty;

import javax.persistence.*;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

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

    @Column(name="NUMBER_RETRIES")
    private Integer numberRetries;

    @Column(name="LOCKED")
    private Boolean locked;

    @Temporal(TemporalType.DATE)
    @Column(name="DATE_PASS_VALIDITY")
    private Date datePassValidity;

    public User() {
    }

    public User(String login, String pass) {
        this.login = login;
        this.pass = pass;
    }

    public User(String login, String pass,int numberRetries, int days) {
        this.login = login;
        this.pass = pass;
        this.locked = false;
        this.numberRetries = numberRetries;
        Calendar calendar = GregorianCalendar.getInstance();
        calendar.add(Calendar.DAY_OF_YEAR, days);
        this.datePassValidity = calendar.getTime();

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

    public Integer getNumberRetries() {
        return numberRetries;
    }

    public void setNumberRetries(Integer numberRetries) {
        this.numberRetries = numberRetries;
    }

    public Boolean getLocked() {
        return locked;
    }

    public void setLocked(Boolean locked) {
        this.locked = locked;
    }

    public Date getDatePassValidity() {
        return datePassValidity;
    }

    public void setDatePassValidity(Date datePassValidity) {
        this.datePassValidity = datePassValidity;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", login='" + login + '\'' +
                ", pass='" + pass + '\'' +
                ", locked=" + locked +
                ", datePassValidity=" + datePassValidity +
                '}';
    }

}
