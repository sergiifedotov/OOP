package hw8.taxi;

import hw8.taxi.domain.Operator;
import hw8.taxi.service.AuthenticationServiceImpl;

/**
 * Created by Tanya on 05.03.2015.
 */
public class Menu {
    public static void main(String[] args) {
        AuthenticationServiceImpl ua = new AuthenticationServiceImpl();
        Operator o = new Operator("trert", "1", "2", "3");
        ua.create(o);
    }
}
