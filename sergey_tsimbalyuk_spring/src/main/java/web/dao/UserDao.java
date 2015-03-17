package web.dao;


import web.domain.User;

import java.util.List;

/**
 * Created by tsv on 07.03.15.
 */
public interface UserDao {
    void create(User user);
    User read(Long id);
    void update(User user);
    void delete(User user);
    List<User> findAll();
    User getUserByLogin(String login);
}

