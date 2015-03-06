package hw8.taxi.exception;

/**
 * Created by Tanya on 04.03.2015.
 */
public class AuthenticationException extends Exception{
    // классический конструктор с сообщением о характере ошибки
    public AuthenticationException(String message) {
        super(message);
    }


    public AuthenticationException() {

    }
}
