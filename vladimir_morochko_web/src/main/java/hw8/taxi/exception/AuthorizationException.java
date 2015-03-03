package hw8.taxi.exception;

/**
 * Created by vladimir on 03.03.2015.
 */
public class AuthorizationException extends Exception {

    public AuthorizationException() {
    }

    public AuthorizationException(String message) {
        super(message);
    }
}
