package hw8.taxi.service;

import hw8.taxi.dao.OperatorDao;
import hw8.taxi.domain.User;
import hw8.taxi.exception.AuthenticationException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by illia_naumov on 06.03.2015.
 */
@Service
public class AuthenticationServiceImpl implements AuthenticationService {
    @Autowired(required = true)
    private OperatorDao operatorDao;
    @Value("${allowedLoginAttempts}")
    private Integer allowedLoginAttempts;

    private Date expireDate;

    public AuthenticationServiceImpl() throws ParseException {
        expireDate = new SimpleDateFormat("DD/MM/YYYY").parse("20/03/2015");
    }

    @Override
    public boolean authenticate(String login, String pass) throws AuthenticationException {
        User operator = operatorDao.getOperatorByLogin(login);
        System.out.println(operator);
        if (operator == null) {
            throw new AuthenticationException("Пользователь \"" + login + "\" не существует");
        }
        if (operator.isBlocked()) {
            throw new AuthenticationException("Пользователь \"" + login + "\" заблокирован");
        }

        if (!operator.getPassword().equals(pass)) {
            operator.setAuthTries(operator.getAuthTries() + 1);
            operatorDao.update(operator);
            if (operator.getAuthTries() > allowedLoginAttempts) {
                operator.setBlocked(true);
                operatorDao.update(operator);
                throw new AuthenticationException("Превышено число ошибок входа, пользователь \"" + login + "\"  заблокирован");
            }
            throw new AuthenticationException("Неправильный пароль");
        }
        if (operator.getPassDate().before(expireDate)) {
            throw new AuthenticationException("Password expired");
        }
        operator.setAuthTries(0); // при логине неудачные попытки обнуляются
        operatorDao.update(operator);
        return true;
    }


}
