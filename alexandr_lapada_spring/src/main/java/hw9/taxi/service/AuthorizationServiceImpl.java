package hw9.taxi.service;

import hw9.taxi.dao.UserDao;
import hw9.taxi.domain.User;
import hw9.taxi.exception.AuthenticationException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by sanya on 10.03.2015.
 */
@Service
public class AuthorizationServiceImpl implements AuthorizationService {

    @Autowired
    private UserDao userDao;

    @Override
    public boolean register(String login, String id, String pass) throws AuthenticationException {
        if (validTestIdent(id) && validTestPassword(pass) && validTestLogin(login) && unicLogin(login)) {
            return true;
        }
        if (!validTestIdent(id)){
            throw new AuthenticationException("Идентификационный код должен состоять из цифр, длиной 10 символов без пробелов");
        }
        if (!validTestPassword(pass)){
            throw new AuthenticationException("Пароль должен состоять из цифр, маленьких и больших букв, длиной не меньше 8 символов без пробелов");
        }
        if (!validTestLogin(login)){
            throw new AuthenticationException("Логин должен быть не меньше 4 символов без пробелов");
        }
        if (!unicLogin(login)){
            throw new AuthenticationException("Такой логин уже существует");
        }
        return false;
    }

    public boolean validTestIdent(String id){
        Pattern p = Pattern.compile("^[0-9]{10}$");
        Matcher m = p.matcher(id);
        return m.matches();
    }
    public boolean validTestPassword(String password){
        if (!password.contains(" ")) {
            Pattern p = Pattern.compile("^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z]).{8,}$");
            Matcher m = p.matcher(password);
            return m.matches();
        }
        return false;
    }
    public boolean validTestLogin(String login){
        if (!login.contains(" ")) {
            Pattern p = Pattern.compile("^\\w{4,}$");
            Matcher m = p.matcher(login);
            return m.matches();
        }
        return false;
    }
    public boolean unicLogin(String login){
        ArrayList<User> listUsers = (ArrayList<User>) userDao.findAll();
        for (int i = 0; i < listUsers.size(); i++){
            if (listUsers.get(i).getLogin().equals(login)){
                return false;
            }
        }
        return true;
    }



}
