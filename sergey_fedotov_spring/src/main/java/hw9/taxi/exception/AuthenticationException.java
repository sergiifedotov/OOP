package hw9.taxi.exception;

/**
 * Created by warit on 03.03.2015.
 */
public class AuthenticationException extends Exception  {
    public AuthenticationException() {
    }

    public AuthenticationException(String message) {
        super(message);
    }
}
