package hw8.taxi.exception;

/**
 * Created by Tanya on 05.03.2015.
 */
public class AuthorizationException extends Exception {
    // классический конструктор с сообщением о характере ошибки
    public AuthorizationException(String message) {
        super(message);
    }


    public AuthorizationException() {

    }
}
