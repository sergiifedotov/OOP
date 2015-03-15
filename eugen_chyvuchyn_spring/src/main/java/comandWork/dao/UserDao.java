package comandWork.dao;

import comandWork.domain.User;
import comandWork.domain.User;

import java.util.List;

/**
 * Created by Chuvychin on 07.03.2015.
 */
public interface UserDao {
    Long create(User user);
    User read(Long ig);
    boolean update(User user);
    boolean delete(User user);
    List<User> findByNameAndPass(String login, String pass);
    List<User> findAll();
    //don't care about this comment
}
