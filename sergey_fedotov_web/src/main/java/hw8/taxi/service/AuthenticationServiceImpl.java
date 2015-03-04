package hw8.taxi.service;

import hw8.taxi.exception.AuthenticationException;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

/**
 * Created by warit on 03.03.2015.
 */
public class AuthenticationServiceImpl implements AuthenticationService {

    //private Map<String,String> loginMap = new HashMap<>();
    private Map<String,Properties> loginMap = new HashMap<>();
    private final Date duration = new Date(2015, 3, 5);

    {
        Integer numberAttemptsEnter = getNumberAttemptsEnter();
        addLogin("login1","pass1", numberAttemptsEnter);
        addLogin("login2","pass2", numberAttemptsEnter);
        addLogin("login3","pass3", numberAttemptsEnter);
        addLogin("login4","pass4", numberAttemptsEnter);
        addLogin("login5","pass5", numberAttemptsEnter);
    }

    private void addLogin(String login, String pass, Integer numberAttemptsEnter){
        Properties property = new Properties();
        property.put("pass",pass);
        property.put("numberAttemptsEnter",numberAttemptsEnter);
        property.put("locked",false);
        loginMap.put(login, property);
    }

    private Integer getNumberAttemptsEnter(){
        Integer numberAttemptsEnter = 0;
        FileInputStream fis;
        Properties property = new Properties();
        try {
            fis = new FileInputStream("src/main/resources/config.properties");
            property.load(fis);

            try {
                numberAttemptsEnter = Integer.valueOf(property.getProperty("numberAttemptsEnter"));
            }catch (NumberFormatException e) {
                //System.err.println("Неверный формат строки!");
            }

        } catch (IOException e) {
            //System.err.println("ОШИБКА: Файл свойств отсуствует!");
        }
        return  numberAttemptsEnter;
    }

    @Override
    public boolean authenticate(String login, String pass) throws AuthenticationException {

        Properties properties = loginMap.get(login);
        boolean result = false;
        boolean locked = true;
        if(properties!=null){
            return result = pass.equals(properties.getProperty("pass"));
            //locked = properties.getProperty("locked");
        }

        /*if(!result){
            Integer tempNumberAttemptsEnter = (Integer)properties.get("numberAttemptsEnter");
            if(tempNumberAttemptsEnter>0){
                properties.put("numberAttemptsEnter", tempNumberAttemptsEnter-1);
            }

        }*/
        return result;
        //loginMap.put(login,)
    }

}
