package hw8.taxi.exception;

/**
 * Created by illia_naumov on 10.03.2015.
 */
public class AuthorizationException extends Throwable {
    public AuthorizationException() {
    }

    public AuthorizationException(String message) {
        super(message);
    }
}
