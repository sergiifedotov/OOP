package hw8.taxi.exception;

/**
 * Created by vladimir on 03.03.2015.
 */
public class AuthenticationException extends Exception {

    public AuthenticationException() {
    }

    public AuthenticationException(String message) {
        super(message);
    }
}
