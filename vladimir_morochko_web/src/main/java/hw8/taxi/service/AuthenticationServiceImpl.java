package hw8.taxi.service;

import hw8.taxi.exception.AuthenticationException;

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
    @Override
    public boolean authenticate(String login, String pass) throws AuthenticationException {
        return false;
    }
}
