package hw8.taxi.service;

import hw8.taxi.exception.AuthenticationException;

/*
 * Created by Sergey Tsimbalyuk
 * on 02.03.15
 */

public class AuthorizationServiceImpl implements AuthorizationService {
    @Override
    public boolean register(String login, String id, String pass) throws AuthenticationException {
//
        if (login.equals("")) {
            throw new AuthenticationException("enter login");
        }
//        - логин (должен быть не менее 4 символов, не должен содержать пробелы
        if (login.split(" ").length != 1 || login.toCharArray().length < 4) {
            System.out.println("login contains spaces or shorter than 4 characters");
            throw new AuthenticationException("login contains spaces or shorter than 4 characters");
        }
//        - идентификационный номер (10 цифр, без букв и других знаков)
        char[] idChars = id.toCharArray();
        if (idChars.length < 10) {
            throw new AuthenticationException("ID length less than 10");
        }
        for (int i = 0; i < idChars.length; i++) {
            if (!isNumber(idChars[i])) {
                throw new AuthenticationException("ID should contain numbers only.");
            }
        }
//         - пароль (должен быть не менее 8 символов,
        char[] PassChars = id.toCharArray();
        if (idChars.length < 8) {
            throw new AuthenticationException("Password length less than 8");
        }
        return true;
    }

    public boolean isNumber(char c) {
        if (((int) c < '0') || ((int) c > '9')) {
            return false;
        }
        return true;
    }

}
