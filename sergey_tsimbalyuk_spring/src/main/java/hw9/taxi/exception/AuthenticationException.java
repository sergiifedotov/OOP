package hw9.taxi.exception;

/**
 * Created by Sergey Tsimbalyuk on 10.03.15.
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