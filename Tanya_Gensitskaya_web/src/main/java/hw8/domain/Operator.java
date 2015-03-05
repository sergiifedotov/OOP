package hw8.domain;


import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by Tanya on 05.03.2015.
 */
@Entity
@Table(name= "OPERATOR")
public class Operator {
    @SequenceGenerator(name = "sequence", sequenceName = "SEQ_OPERATOR_ID",
            allocationSize = 1, initialValue = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "sequence")

    @Id
    @Column(name = "OPERATOR_ID")
    private Long id;

    @Column(name = "LOGIN")
    private String login;

    @Column(name = "ID_NUM")
    private String idNumber;

    @Column(name = "PASSWORD")
    private String password;

    @Column(name = "CONF_PASSWORD")
    private String confirmPassword;

    public Operator() {
    }

    public Operator(String login, String idNumber, String password, String confirmPassword) {
        this.login = login;
        this.idNumber = idNumber;
        this.password = password;
        this.confirmPassword = confirmPassword;
    }


    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getIdNumber() {
        return idNumber;
    }

    public void setIdNumber(String idNumber) {
        this.idNumber = idNumber;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getConfirmPassword() {
        return confirmPassword;
    }

    public void setConfirmPassword(String confirmPassword) {
        this.confirmPassword = confirmPassword;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "Operator{" +
                "id=" + id +
                ", login='" + login + '\'' +
                ", idNumber='" + idNumber + '\'' +
                ", password='" + password + '\'' +
                ", confirmPassword='" + confirmPassword + '\'' +
                '}';
    }
}
