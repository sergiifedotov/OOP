package hw3.async_chat;

import java.io.*;
import java.net.Socket;
import java.util.Scanner;

/**
 * Created by @CAT_Caterpiller on 31.01.2015.
 */

public class AsyncMessanger {
    public static void main(String[] args) throws IOException {
        Socket socket = new Socket("192.168.1.2", 30000);

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
