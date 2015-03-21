package hw9.taxi.service;

import hw9.taxi.dao.OperatorDao;
import hw9.taxi.domain.Operator;
import hw9.taxi.exception.AuthenticationException;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;

/**
 * Created by vladimir on 09.03.2015.
 */
@Service
@Transactional
public class AuthenticationServiceImpl implements AuthenticationService {
    @Autowired(required = true)
    private OperatorDao operatorDao;
    @Value("${allowedLoginAttempts}")
    private Integer allowedLoginAttempts;

    public AuthenticationServiceImpl() {
    }

    @Override
    public boolean authenticate(String login, String password) throws AuthenticationException {
//        System.out.println(login + " " + password);
        Operator operator = operatorDao.getOperatorByLogin(login);
        System.out.println(operator);
        if (operator == null) {
            throw new AuthenticationException("Пользователь \"" + login + "\" не существует");
        }
        if (operator.isLocked()) {
            throw new AuthenticationException("Пользователь \"" + login + "\" заблокирован");
        }
        System.out.println(operator.getLoginAttempts());
        if (!operator.getPassword().equals(password)) {
            operator.setLoginAttempts(operator.getLoginAttempts() + 1);
            operatorDao.update(operator);
            if (operator.getLoginAttempts() > allowedLoginAttempts) {
                operator.setLocked(true);
                operatorDao.update(operator);
                throw new AuthenticationException("Превышено число ошибок входа, пользователь \"" + login + "\"  заблокирован");
            }
            throw new AuthenticationException("Неправильный пароль");
        }
        if (operator.getExpireDate().before(new Date())) {
            throw new AuthenticationException("Password expired");
        }
        operator.setLoginAttempts(0); // при логине неудачные попытки обнуляются
        operatorDao.update(operator);
        return true;
    }

    @Override
    public void close() {
    //    sessionFactory.close();
    }

}
