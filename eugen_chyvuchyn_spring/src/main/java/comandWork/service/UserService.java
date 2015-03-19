package comandWork.service;

import comandWork.domain.User;

import java.util.List;

/**
 * Created by Chuvychin on 07.03.2015.
 */
public interface UserService {
    void create(User user);
    Long add(User user);
    User read (Long id);
    List<User> getAll();
    List<User>  findByNameAndPass(String login, String pass);

}
