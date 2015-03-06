package hw8.taxi.service;

import hw8.taxi.exception.AuthorizationException;

import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

/**
 *
 */
public class AuthorizationServiceImpl implements AuthorizationService {

    private Map<String,Properties> loginMap = new HashMap<>();

    private void addLogin(String login, String pass, String id){
        Properties property = new Properties();
        property.put("pass",pass);
        property.put("id",id);
        loginMap.put(login, property);
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

        if (pass == null || pass.length() > 7) {
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
    public boolean register(String login, String id, String pass) throws AuthorizationException {

        if(!checkLogin(login)||!checkId(id)||!checkPass(pass)) {
            return false;
        }

        Properties properties = loginMap.get(login);
        if(properties!=null){
            return false;
        }
        addLogin(login, pass, id);

        return true;
    }
}
