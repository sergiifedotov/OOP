package hw3.chat;

import java.io.*;
import java.net.Socket;
import java.util.Scanner;

/**
 * Created by @CAT_Caterpiller on 05.02.2015.
 */

public class AsynchroneMessenger {
    public static void main(String[] args) throws IOException {
        Socket socket = new Socket("127.0.0.1", 30000);

        PrintWriter printWriter = new PrintWriter(new OutputStreamWriter(socket.getOutputStream()));
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(socket.getInputStream()));

        MessageReaderThread readerThread = new MessageReaderThread(bufferedReader);
        readerThread.setListener(new MessageReaderThread.Listener() {
            @Override
            public void newMessage(String message) {
                System.out.println(message);
            }
        });
        readerThread.start();

        Scanner scanner = new Scanner(System.in);
        while (true) {
            printWriter.println(scanner.nextLine());
            printWriter.flush();
            //System.out.println(bufferedReader.readLine());

        }
    }
}

/*
class MessageReaderThread extends Thread {
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
*/
