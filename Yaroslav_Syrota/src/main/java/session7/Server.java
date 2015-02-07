package session7;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

/**
 * Created by @CAT_Caterpiller on 31.01.2015.
 */

public class Server {
    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket = new ServerSocket(30000);
        Socket socket = serverSocket.accept();

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
            //System.out.println(bufferedReader.readLine());
            printWriter.println(scanner.nextLine());
            printWriter.flush();
        }


    }


}
