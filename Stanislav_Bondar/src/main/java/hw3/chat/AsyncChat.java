package hw3.chat;

import java.io.*;
import java.net.Socket;

/**
 * Created by stan on 13.02.15.
 * 02/31/3015.
 */
public class AsyncChat {

    public AsyncChat() throws IOException {
        process();
    }


    public void process() throws IOException {
        Socket socket = null;
        socket = new Socket("192.0.0.1", 30100);
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
        })
                .start();

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