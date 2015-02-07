package hw3.chat;

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

public class AsyncChatServer {

    public static void main(String[] args) {

        int sendPort = 30000;
        Socket socket;
        PrintWriter printWriter = null;

        try {
            System.out.println("waiting on port " + sendPort);
            socket = new ServerSocket(sendPort).accept();
            System.out.println("opened port " + sendPort);
            printWriter = new PrintWriter(new OutputStreamWriter(socket.getOutputStream()));
        } catch (IOException e) {
            e.printStackTrace();
        }

        int receivePort = 30001;
        String address = "localhost";

        AsyncChatServer asyncChat = new AsyncChatServer(address, receivePort);
        asyncChat.process();

        Scanner scanner = new Scanner(System.in);
        while (true) {
            printWriter.println(scanner.nextLine());
            printWriter.flush();
        }
    }

    ChatReceiver chatReceiver;

    public AsyncChatServer() {
    }

    public AsyncChatServer(String address, int receivePort) {
        chatReceiver = new ChatReceiver(address, receivePort);
    }

    public void process() {
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
                    String message = bufferedReader.readLine();
                    if (message == null) {
                        break;
                    }
                    System.out.println("incoming: " + message);
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

}
