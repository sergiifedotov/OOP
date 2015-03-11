package web.service;

import web.domain.User;

import java.util.List;

/**
 * Created by tsv on 07.03.15.
 */
public interface UserService {
    List<User> getAllUsers();
    void addUser(User user);
    public User getUserByLogin(String login);
}