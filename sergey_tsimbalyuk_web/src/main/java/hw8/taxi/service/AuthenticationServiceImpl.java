package hw8.taxi.service;

import hw8.taxi.exception.AuthenticationException;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Sergey Tsimbalyuk
 * on 02.03.15
 */
public class AuthenticationServiceImpl implements AuthenticationService {
    private static AuthenticationServiceImpl instance;
    private final int LOGIN_TRY_COUNT  = 3;
//    private int count;
//    private AuthServlet servlet;
    Map<String,String> Users = new HashMap<>();

    public AuthenticationServiceImpl(int count) {
//        this.count = count;
        Users.put("SiteOpLogin","SiteOpPwd");
    }

    @Override
    public boolean authenticate(String login, String pass) throws AuthenticationException {
        if (login.equals("")) {
            throw new AuthenticationException("enter login");
        }
        if (pass.equals("")) {
            throw new AuthenticationException("enter password");
        }
        String thisLogIn = Users.get(login);
        if(thisLogIn != null) {
            if (thisLogIn.equals(pass)) {
                return true;
            }
        }
        throw new AuthenticationException("Login/Password is incorrect.");
    }

    public int getLOGIN_TRY_COUNT() {
        return LOGIN_TRY_COUNT;
    }

//    public int getCount() {
//        return count;
//    }

}