package hw8.taxi.exception;

/**
 * Created by Tanya on 05.03.2015.
 */
public class ClientException extends Exception {
    // классический конструктор с сообщением о характере ошибки
    public ClientException(String message) {
        super(message);
    }


    public ClientException() {

    }
}
