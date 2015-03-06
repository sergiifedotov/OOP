package hw8.taxi.service;

import hw8.taxi.dao.OperatorDaoImpl;
import hw8.taxi.domain.Operator;
import hw8.taxi.exception.AuthenticationException;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;
import java.util.Properties;

/**
 * Created by Tanya on 04.03.2015.
 */
public class AuthenticationServiceImpl implements AuthenticationService {


    public AuthenticationServiceImpl() {
    }


    public boolean authenticate(String login, String pass) throws AuthenticationException {
        String loginInBase = null;
        String passInBase = null;
        OperatorDaoImpl operatorDaoImpl = new OperatorDaoImpl();
        List<Operator> list = operatorDaoImpl.findAll();

        for(int i=0; i<list.size(); i++){
            loginInBase = list.get(i).getLogin();
            passInBase = list.get(i).getPassword();
            if(loginInBase.equals(login) && passInBase.equals(pass)){
                return true;
            }
        }
        return false;
    }

    public int frequency() throws IOException {
        Properties props = new Properties();
        InputStream fis = getClass().getResourceAsStream("/config.properties");
        props.load(fis);
        String frequency = (String) props.get("FREQUENCY");
        int freq = Integer.parseInt(frequency);
        return freq;
    }

    // метод для блокировки логина в базе данных Example: "login blocked"
    public void blocked(String login) throws IOException {
        String loginInBase = null;
        OperatorDaoImpl operatorDaoImpl = new OperatorDaoImpl();
        List<Operator> list = operatorDaoImpl.findAll();

        for(int i=0; i<list.size(); i++){
            loginInBase = list.get(i).getLogin();
            if(loginInBase.equals(login)){
                String loginBlocked = login+" blocked";
                Operator operator = list.get(i);
                operator.setLogin(loginBlocked);
                operatorDaoImpl.update(operator);
            }
        }

    }




    public Long create (Operator operator){
        OperatorDaoImpl operatorDaoImpl = new OperatorDaoImpl();
        Long id = operatorDaoImpl.create(operator);
        return id;
    }

    public boolean findLoginInBase(String login){
        String loginInBase = null;
        OperatorDaoImpl operatorDaoImpl = new OperatorDaoImpl();
        List<Operator> list = operatorDaoImpl.findAll();

        for(int i=0; i<list.size(); i++){
            loginInBase = list.get(i).getLogin();
            if(loginInBase.equals(login)){
                return false;
            }
        }
        return true;
    }



}
