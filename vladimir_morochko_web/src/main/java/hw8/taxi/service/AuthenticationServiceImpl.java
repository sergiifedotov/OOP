package hw8.taxi.service;

import hw8.taxi.domain.Operator;
import hw8.taxi.exception.AuthenticationException;

import java.util.Date;

/**
 * Created by vladimir on 03.03.2015.
 *
 * Оператор вводит логин и пароль.
 Если пароль с логином не совпадает то повторить ввод. Передача осуществляется методом POST.
 Колличество попыток ввода задается в properties файле. После последней неудачной попытки пользователь блокируется.
 Время действия пароля задается в сервисе
 После истечения действия пароля, пользователь должен поменять пароль. Предыдущий вводить нельзя

 hw8.taxi.service.AuthenticationService
 boolean authenticate(String login, String pass) throws AuthenticationException
 */
public class AuthenticationServiceImpl implements AuthenticationService {

    public static AuthenticationService authenticationService = new AuthenticationServiceImpl();

    AuthorizationService authorizationService = AuthorizationServiceImpl.authorizationService;
    int allowedLoginAttempts = 3; // todo

    @Override
    public boolean authenticate(String login, String password) throws AuthenticationException {
        Operator operator = authorizationService.getOperatorByLogin(login);
        if (operator == null) {
            throw new AuthenticationException("Пользователь \"" + login + "\" не существует");
        }
        if (operator.isLocked()) {
            throw new AuthenticationException("Пользователь \"" + login + "\" заблокирован");
        }
        if (!operator.getPassword().equals(password)) {
            operator.setLoginAttempts(operator.getLoginAttempts() + 1);
            if (operator.getLoginAttempts() > allowedLoginAttempts) {
                operator.setLocked(true);
                throw new AuthenticationException("Превышено число ошибок входа, пользователь \"" + login + "\"  заблокирован");
            }
            throw new AuthenticationException("Неправильный пароль");
        }
        if (operator.getExpireDate().before(new Date())) {
            throw new AuthenticationException("Password expired");
        }
        operator.setLoginAttempts(0); // при логине неудачные попытки обнуляются
        return true;
    }
}
