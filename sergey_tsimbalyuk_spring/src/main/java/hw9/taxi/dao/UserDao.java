package hw9.taxi.dao;

import hw9.taxi.domain.User;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;

/**
 * Created by Sergey Tsimbalyuk on 10.03.15.
 */
@Repository
@Transactional
interface UserDao {
    @Transactional
    User read(String login);
    @Transactional
    List<User>findAll();
    boolean add(User user);
    boolean delete(User user);
}