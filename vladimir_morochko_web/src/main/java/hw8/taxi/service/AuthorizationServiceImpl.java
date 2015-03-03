package hw8.taxi.service;

import hw8.taxi.exception.AuthorizationException;

/**
 * Created by vladimir on 03.03.2015.
 *
 * Реализовать авторизацию пользователя системы (оператора).
 Пользователь вводит:
 - логин (должен быть не менее 4 символов, не должен содержать пробелы)
 - идентификационный номер (10 цифр, без букв и других знаков)
 - пароль (должен быть не менее 8 символов,
 включать большие и маленькие буквы, цифры, должен совпадать с подтверждением)
 - подтверждение пароля
 - пользователь с таким логином должен быть уникальным

 hw8.taxi.service.AuthorizationService
 boolean register(String login, String id, String pass) throws AuthorizationException

 */
public class AuthorizationServiceImpl implements AuthorizationService {
    @Override
    public boolean register(String login, String id, String pass) throws AuthorizationException {
        return false;
    }
}
