package web.service;

import web.domain.User;

import java.util.List;

/**
 * Created by Chuvychin on 07.03.2015.
 */
public interface UserService {
    Long add(User user);
    User read(Long id);
    List<User> getAll();
    List<User>  findByNameAndPass(String login, String pass);

}
