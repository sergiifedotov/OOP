package web.domain;

import org.hibernate.validator.constraints.NotEmpty;

import javax.persistence.*;

/**
 * Created with IntelliJ IDEA.
 * UserDao: al1
 * Date: 15.06.13
 */


@Entity
@Table(name = "WEB_USERS")
public class User {
    @Id
    @SequenceGenerator(name = "sequence", sequenceName = "SEQ_EMPLOYEE_ID", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "sequence")
    @Column(name = "USER_ID")
    long id;

    private String login;
    private String password;

    public User() {
    }

    public User(String login, String pass) {
        this.login = login;
        this.password = pass;
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

    public String getPassword() {
        return password;
    }

    public void setPassword(String pass) {
        this.password = pass;
    }

}
//public class UserDao {
//    @NotEmpty
//    private String login;
//    @NotEmpty
//    private String pass;
//
//    public UserDao() {
//    }
//
//    public UserDao(String login, String pass) {
//        this.login = login;
//        this.pass = pass;
//    }
//
//    public String getLogin() {
//        return login;
//    }
//
//    public void setLogin(String login) {
//        this.login = login;
//    }
//
//    public String getPass() {
//        return pass;
//    }
//
//    public void setPass(String pass) {
//        this.pass = pass;
//    }
//
//    @Override
//    public String toString() {
//        return "UserDao{" +
//                "login='" + login + '\'' +
//                ", pass='" + pass + '\'' +
//                '}';
//    }
//}
