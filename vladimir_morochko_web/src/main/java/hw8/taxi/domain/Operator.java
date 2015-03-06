package hw8.taxi.domain;

import java.util.Date;

/**
 * Created by vladimir on 03.03.2015.
 */
public class Operator {
    private Long id;
    private String login;
    private String accessId;
    private String password;
    private Date expireDate;
    private boolean locked;

    public Operator() {
    }

    public Operator(String login, String accessId, String password, Date expireDate, boolean locked) {
        this.login = login;
        this.accessId = accessId;
        this.password = password;
        this.expireDate = expireDate;
        this.locked = locked;
    }

    public Operator(Long id, String login, String accessId, String password, Date expireDate, boolean locked) {
        this.id = id;
        this.login = login;
        this.accessId = accessId;
        this.password = password;
        this.expireDate = expireDate;
        this.locked = locked;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getAccessId() {
        return accessId;
    }

    public void setAccessId(String accessId) {
        this.accessId = accessId;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Date getExpireDate() {
        return expireDate;
    }

    public void setExpireDate(Date expireDate) {
        this.expireDate = expireDate;
    }

    public boolean isLocked() {
        return locked;
    }

    public void setLocked(boolean locked) {
        this.locked = locked;
    }

    @Override
    public String toString() {
        return "Operator{id=" + id
                + ", login=" + "'" + login + "'"
                + ", accessId=" + "'" + accessId + "'"
                + ", password=" + "'" + password + "'"
                + ", expireDate=" + String.format("%tF", expireDate)
                + ", locked=" + locked
                + "}";
    }
}
