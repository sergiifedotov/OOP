package hw9.taxi.service;

import hw9.taxi.domain.User;
import hw9.taxi.exception.AuthenticationException;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;

/**
 * Created by Sergey Tsimbalyuk on 10.03.15.
 */
@Repository
@Transactional
public interface AuthenticationService {
    @Transactional
    boolean authenticate(String login, String pass) throws AuthenticationException;

    @Transactional
    User getUser(String login);

    @Transactional
    public List<User> findAll();
}