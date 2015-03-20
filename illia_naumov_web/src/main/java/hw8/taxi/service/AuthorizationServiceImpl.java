package hw8.taxi.service;

import hw8.taxi.domain.User;
import hw8.taxi.exception.AuthenticationException;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by illia_naumov on 10.03.2015.
 */
public class AuthorizationServiceImpl implements AuthorizationService{
    Map<String, User> usersMap;
    public AuthorizationServiceImpl() {
        usersMap = new HashMap<String, User>();
        usersMap.put("barbara", new User(1, "barbara"));
        usersMap.put("dima", new User(2, "dima"));
    }


    public String formValidation(String login, long id, String pass){
        if(login.contains(" ")){
            return "логин не должен содержать пробелов";
        }
        if(login.length() < 4 ){
            return "Логин должен быть более 4-х символов";
        }
        if(String.valueOf(id).length() != 10){ //checking if i contains any symbol
            return "id должен содержать 10 цифр!";
        }
        if(pass.length() < 8 ) { //no checking if contains upper-case symbol
            return "пароль должен содержать не менее 8 символов";
        }
        return null;
    }

    @Override
    public boolean register(String login, long id, String pass) throws AuthenticationException {
        if(usersMap.containsKey(login)){
            return false;
        } else {
            usersMap.put(login, new User(id, pass));
            return true;
        }
    }
}
