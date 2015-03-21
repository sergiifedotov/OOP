package hw9.taxi.dao;

import hw9.taxi.domain.User;

import java.util.List;

/**
 * Created by Chuvychin on 13.03.2015.
 */
public interface UserDao {

    Long create (User user);
    User read (Long id);
    User readByLogin (String login);
    boolean update(User user);
    boolean delete (User user);
    List<User> getAll();
}