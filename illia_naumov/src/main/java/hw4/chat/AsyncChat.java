package main.java.hw4.chat;

import java.io.*;
import java.net.Socket;

/**
 * Created by illia_naumov
 */
public class AsyncChat {
    public void process() {
        Client client = new Client("Iskusitel'");

    }
}


class Client implements Runnable {
    Thread client;
    String name;
    Socket sock;
    PrintWriter pw;
    BufferedReader bf;

    public Client(String name) {
        this.name = name;
        client = new Thread(this, name);
        client.start();
    }

    @Override
    public void run() {
        try {
            sock = new Socket("127.0.0.1", 31000);
            bf = new BufferedReader(new InputStreamReader(sock.getInputStream()));
            pw = new PrintWriter(new OutputStreamWriter(sock.getOutputStream()));


            Thread sender = new Thread() {
                @Override
                public void run() {
                    BufferedReader bufer = new BufferedReader(new InputStreamReader(System.in));
                    while (true) {
                        String message = null;
                        try {
                            message = bufer.readLine();
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                        pw.print(message);
                        pw.flush();
                    }
                }
            };
            sender.start();
            Thread printer = new Thread() {
                @Override
                public void run() {
                    try {
                        while (true) {
                            String message = bf.readLine();
                            System.out.println(message);
                        }
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            };
            printer.start();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

