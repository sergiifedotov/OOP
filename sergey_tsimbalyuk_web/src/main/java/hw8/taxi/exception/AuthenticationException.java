package hw8.taxi.exception;

/**
 * Created by Sergey Tsimbalyuk
 * on 02.03.15
 */
public class AuthenticationException extends Exception {
    public AuthenticationException(String message) {
        super(message);
    }
}