package hw8.taxi.exception;

/**
 * Created by illia_naumov on 06.03.2015.
 */
public class AuthenticationException extends Throwable {
    public AuthenticationException() {
    }

    public AuthenticationException(String message) {
        super(message);
    }
}
