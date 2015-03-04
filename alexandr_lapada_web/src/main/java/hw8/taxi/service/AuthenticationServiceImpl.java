package hw8.taxi.service;


import hw8.taxi.exception.AuthenticationException;


import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by sanya on 03.03.2015.
 */
public class AuthenticationServiceImpl implements AuthenticationService {

    private SimpleDateFormat dateFormat = new SimpleDateFormat("dd.MM.yyyy");
    private final String dateChangePassStr = "04.03.2015";
    private Date date = null;
    private static int numberOfWrongTries = 0;
    private final int maxWrongTries = 3;

    private Map<String, String> mapUsers;

    public AuthenticationServiceImpl() {
        mapUsers = new HashMap<String, String>();

        mapUsers.put("zagebenge", "123456");
        mapUsers.put("Alex", "alex");
        mapUsers.put("login", "password");
        mapUsers.put("AA", "123456");
        mapUsers.put("Petya", "12EE12");
    }

    @Override
    public boolean authenticate(String login, String pass) throws AuthenticationException {
        boolean rez = false;
        if(mapUsers.containsKey(login) && mapUsers.get(login).equals(pass)){
            numberOfWrongTries = 0;
            rez = true;
        } else {
            numberOfWrongTries++;
        }
        if (numberOfWrongTries >= maxWrongTries) {
            throw new AuthenticationException("Превышено число не верных попыток!.");
        }
        return rez;
    }

    public boolean changePass(){
        date = new Date();
        boolean rez = false;
        try {
            Date dateChangePass = dateFormat.parse(dateChangePassStr);
            if (dateFormat.format(date).compareTo(dateFormat.format(dateChangePass)) == 0){
                rez = true;
            } else if (dateFormat.format(date).compareTo(dateFormat.format(dateChangePass)) == 1){
                rez = true;
            }
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return rez;
    }
}
