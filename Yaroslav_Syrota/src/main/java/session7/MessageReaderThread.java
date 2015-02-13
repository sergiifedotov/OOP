package session7;

import java.io.BufferedReader;
import java.io.IOException;

/**
 * Created by Admin on 05.02.2015.
 */

public class MessageReaderThread extends Thread {
    public interface Listener {
        void newMessage(String message);
    }
    private BufferedReader reader;
    private Listener listener;

    public MessageReaderThread(BufferedReader reader) {
        this.reader = reader;
    }

    public void setListener(Listener listener) {
        this.listener = listener;
    }

    @Override
    public void run() {
        while (true) {
            String line;
            try {
                line = reader.readLine();
            } catch (IOException e) {
                break;
            }
            if (listener != null) {
                listener.newMessage(line);
            }
        }
    }
}
