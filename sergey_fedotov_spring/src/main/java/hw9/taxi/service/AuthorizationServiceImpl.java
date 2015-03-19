package hw9.taxi.service;


import hw9.taxi.dao.UserDao;
import hw9.taxi.domain.User;
import hw9.taxi.exception.AuthenticationException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 */
@Service
@Transactional
public class AuthorizationServiceImpl implements AuthorizationService {

    @Autowired(required = true)
    private UserDao userDao;

    public AuthorizationServiceImpl() {
    }

    public AuthorizationServiceImpl(UserDao dao) {
        userDao = dao;
    }

    private boolean checkLogin(String login){

        return (login==null||login.length()<4||login.indexOf(" ")!=0);

    }

    private boolean checkId(String id) {

        if (id == null || id.length() != 10) {
            return false;
        }

        char[] tempVector = id.toCharArray();
        for (char elVector : tempVector) {
            if (!Character.isDigit(elVector)){
                return false;
            }
        }

        return true;
    }

    private boolean haveSymbolOfString(String line, String sourceString){
        char[] tempVector = line.toCharArray();
        for (char elVector : tempVector) {
            if (sourceString.indexOf(elVector)!=0){
                return true;
            }
        }
        return false;
    }

    private boolean checkPass(String pass) {

        if (pass == null || pass.length() < 7) {
            return false;
        }

        if (!haveSymbolOfString("ABCDEFGHIJKLMNOPQRSTUVWXYZ", pass)) {
            return false;
        }

        if (!haveSymbolOfString("abcdefghijklmnopqrstuvwxyz", pass)) {
            return false;
        }

        if (!haveSymbolOfString("0123456789", pass)) {
            return false;
        }

        return true;
    }

    @Override
    public boolean register(String login, String id, String pass) throws AuthenticationException {

        if(!checkLogin(login)){
            throw new AuthenticationException("err login");
        }

        if(!checkId(id)){
            throw new AuthenticationException("err id");
        }

        if(!checkPass(pass)){
            throw new AuthenticationException("err pass");
        }

        if(userDao.read(login)!=null){
            throw new AuthenticationException("err duplication login");
        }

        userDao.create(new User(login, pass, id));

        return true;
    }
}
