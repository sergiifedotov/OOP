package hw3.chat;

import java.io.*;
import java.net.Socket;

/**
 * Created by Tsimbalyuk Sergey
 * 2/3/2015.
 * <p/>
 * Написать чат, в котором можно отправлять и принимать сообщения в любом порядке.
 * public void process()
 * <p/>
 * Класс задания hw3.chat.AsyncChat
 * Класс теста hw3.chat.AsyncChatTest
 */
public class AsyncChat {

    public AsyncChat() throws IOException {
        process();
    }


    public void process() throws IOException {
        Socket socket = null;
        socket = new Socket("127.0.0.1", 30100);
        BufferedReader in = null;
        in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        PrintWriter out = null;
        out = new PrintWriter(new OutputStreamWriter(socket.getOutputStream()));

        final BufferedReader finalIn = in;
        new Thread(() -> {
            while (true) {
                try {
                    System.out.println(finalIn.readLine());
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }).start();

        BufferedReader brConsole = new BufferedReader(new InputStreamReader(System.in));
        while (true) {
            try {
                out.println(brConsole.readLine());
            } catch (IOException e) {
                e.printStackTrace();
            }
            out.flush();
        }
    }
}