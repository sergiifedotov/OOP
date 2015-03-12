package hw9.taxi.dao;

/**
 * Created by warit on 03.03.2015.
 */
public interface UserDao {

    boolean authenticate(String login, String pass);

}
