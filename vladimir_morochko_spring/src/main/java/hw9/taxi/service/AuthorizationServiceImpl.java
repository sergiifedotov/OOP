package hw9.taxi.service;

import hw9.taxi.dao.OperatorDao;
import hw9.taxi.domain.Operator;
import hw9.taxi.exception.AuthenticationException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;

/**
 * Created by vladimir on 09.03.2015.
 */
@Service
public class AuthorizationServiceImpl implements AuthorizationService {
    @Autowired(required = true)
    private OperatorDao operatorDao;

    public AuthorizationServiceImpl() {
    }

    @Override
    public boolean register(String login, String accessId, String password) throws AuthenticationException {
        // todo пароль должен отличаться от старого пароля
        if (login == null || login.length() < 4) {
            throw new AuthenticationException("Логин должен быть не менее 4 символов");
        }
        if (login.contains(" ")) {
            throw new AuthenticationException("Логин не должен содержать пробелы");
        }
//        if (operatorDao.getOperatorByLogin(login) != null) {
//            throw new AuthenticationException("логин \"" + login + "\" уже существует");
//        }
        if (accessId == null || !accessId.matches("^[0-9]*.{10}$")) {
            throw new AuthenticationException("Идентификационный номер должен быть из 10 цифр, без букв и других знаков");
        }
        if (password == null || password.length() < 8) {
            throw new AuthenticationException("Пароль должен быть не менее 8 символов");
        }
        if (!password.matches("^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z]).{8,}$")) {
            throw new AuthenticationException("Пароль должен включать большие и маленькие буквы, цифры");
        }
        Date expireDate = new Date();
        Long monthMilliseconds = 1000L * 60 * 60 * 24 * 31;
        expireDate.setTime(expireDate.getTime() + monthMilliseconds);
        boolean locked = false;
        Operator operator = operatorDao.getOperatorByLogin(login);
        if (operator == null) {
            operator = new Operator(login, accessId, password, expireDate, locked);
            operatorDao.create(operator);
        } else {
            operatorDao.update(operator);
        }
        System.out.println(operator);
        return true;
    }
}
