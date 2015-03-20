package hw9.taxi.dao;

import hw9.taxi.domain.User;

import java.util.List;

/**
 * Created by sanya on 10.03.2015.
 */
public interface UserDao {

    Long create(User user);

    User read(Long id);

    boolean update(User user);

    boolean delete(User user);

    List<User> findAll();
}
