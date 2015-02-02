package hw4.chat;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

/**
 * Created by vladimir on 02.02.2015.
 *
 * Написать приложение - асинхронный чат, позволяющее
 * выводить и отсылать сообщения в любом порядке.
 */

public class AsyncChatConsole {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int receivePort = 30000;
        String address = "localhost";

        AsyncChatConsole asyncChatConsole = new AsyncChatConsole(address, receivePort);
        asyncChatConsole.go();

        int sendPort = 30001;
        Socket socket = null;
        PrintWriter printWriter = null;

        try {
            socket = new ServerSocket(sendPort).accept();
            printWriter = new PrintWriter(new OutputStreamWriter(socket.getOutputStream()));
            System.out.println("opened port " + sendPort);
        } catch (IOException e) {
            e.printStackTrace();
        }

        while (true) {
            printWriter.println(scanner.nextLine());
            printWriter.flush();
        }

    }

    ChatReceiver chatReceiver;

    public AsyncChatConsole() {
    }

    public AsyncChatConsole(String address, int receivePort) {
        chatReceiver = new ChatReceiver(address, receivePort);
    }

    public void go() {
        chatReceiver.start();
    }

    private class ChatReceiver implements Runnable {
        private Thread thread;
        String address;
        int port;
        Socket socket;
        BufferedReader bufferedReader;

        public ChatReceiver() {
            thread = new Thread(this);
        }

        public ChatReceiver(String address, int port) {
            this();
            this.address = address;
            this.port = port;
        }

        public void start() {
            thread.start();
        }

        public void interrupt() {
            thread.interrupt();
        }

        @Override
        public void run() {
            try {
                socket = new Socket(address, port);
                bufferedReader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
                System.out.println("connected to port " + port + " on " + address);
                while (!thread.isInterrupted()) {
                    System.out.println(bufferedReader.readLine());
                }
            } catch (IOException e) {
                e.printStackTrace();
             }
        }
    }

}
