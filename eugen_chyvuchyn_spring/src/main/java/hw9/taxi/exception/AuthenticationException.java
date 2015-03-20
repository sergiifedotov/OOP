package hw9.taxi.exception;

/**
 * Created by Chuvychin on 13.03.2015.
 */
public class AuthenticationException extends Exception {
    private String message = "";
    public AuthenticationException(String message) {
        super(message);
    }

    @Override
    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
