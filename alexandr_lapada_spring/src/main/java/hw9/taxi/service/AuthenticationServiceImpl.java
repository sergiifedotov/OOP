package hw9.taxi.service;

import hw9.taxi.dao.UserDao;
import hw9.taxi.domain.User;
import hw9.taxi.exception.AuthenticationException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

/**
 * Created by sanya on 10.03.2015.
 */
@Service
public class AuthenticationServiceImpl implements AuthenticationService {

    @Autowired
    private UserDao userDao;
    private static int authTry;

    @Override
    public boolean authenticate(String login, String pass) throws AuthenticationException {
        boolean rez = false;
        ArrayList<User> list = (ArrayList<User>)userDao.findAll();
        for (int i=0; i < list.size(); i++){
            User user = list.get(i);
            if (user.getLogin().equals(login) && user.getPass().equals(pass)){
                authTry = 0;
                rez = true;
            } else{
                authTry++;
            }
        }
        if (authTry > 3){
            throw new AuthenticationException("More than 3 wrong tries");
        }
        return rez;
    }
}
