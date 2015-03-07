package hw8.taxi.exception;

/**
 * Created by Konstantin on 02.03.2015.
 */
public class AuthorizationException extends Exception  {
    public AuthorizationException(String message){
        super(message);
    }
}
