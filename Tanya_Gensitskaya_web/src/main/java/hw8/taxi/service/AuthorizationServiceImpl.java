package hw8.taxi.service;

import hw8.taxi.exception.AuthenticationException;

/**
 * Created by Tanya on 05.03.2015.
 */
public class AuthorizationServiceImpl implements  AuthorizationService{
    public boolean register(String login, String id, String pass) throws AuthenticationException {
        if (checkLogin(login) && checkId(id) && checkPass(pass)) {
            return true;
        }
        return false;
    }

    //    - логин (должен быть не менее 4 символов, не должен содержать пробелы)
//    - пользователь с таким логином должен быть уникальным
    private boolean checkLogin(String login) {
        String[] array = login.split(" ");
        if (login.length() > 4 && array.length == 1) {
            return true;
        }
        return false;
    }

    //    - идентификационный номер (10 цифр, без букв и других знаков)
    private boolean checkId(String id) {
        if (id.length() == 10) {
            try {
                Integer.parseInt(id);
                return true;
            } catch (NumberFormatException e) {
                return false;
            }
        } else {
            return false;
        }
    }
    //    - пароль (должен быть не менее 8 символов,
//      включать большие и маленькие буквы, цифры)
    private boolean checkPass(String pass) {
        if(pass.length()>7){
            return true;
        }
        return false;
    }
}
