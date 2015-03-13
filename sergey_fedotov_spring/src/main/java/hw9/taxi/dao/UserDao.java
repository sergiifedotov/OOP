package hw9.taxi.dao;

import hw9.taxi.domain.User;

/**
 * Created by warit on 03.03.2015.
 */
public interface UserDao {

    boolean authenticate(String login, String pass);

    Long create(User user);
    User read(String login);

}
