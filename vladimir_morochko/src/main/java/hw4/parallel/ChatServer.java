package hw4.parallel;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;

/**
 * Created by vladimir on 02.02.2015.
 * <p/>
 * Написать чат сервер.
 * При подключении пользователь передает на сервер
 * свое имя и получает список всех подключенных к серверу
 * пользователей. Каждый участник может начать чат с любым
 * участником, кроме себя.
 * <p/>
 * Реализовать передачу файлов.
 * Метод:
 * public void listenConnections()
 * <p/>
 * Класс задания:
 * hw4.parallel.ChatServer
 * <p/>
 * Класс теста:
 * hw4.parallel.ChatServerTest
 */
public class ChatServer {

    public static void main(String[] args) {

        int sendPort = 30000;
        Socket sendSocket = null;
        ObjectOutputStream objOut = null;

        try {
            System.out.println("waiting for connections on port " + sendPort);
            sendSocket = new ServerSocket(sendPort).accept();
            System.out.println("opened port " + sendPort);
            objOut = new ObjectOutputStream(sendSocket.getOutputStream());
        } catch (IOException e) {
            e.printStackTrace();
        }

        try {
            TimeUnit.MILLISECONDS.sleep(500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        int receivePort = 30001;
        String address = "localhost";

        ChatServer chatServer = new ChatServer(address, receivePort);
        chatServer.process();

        Scanner scanner = new Scanner(System.in);
        try {
            while (true) {
                Message message = new Message();
                message.text = scanner.nextLine();
                System.out.println("sending message: \"" + message.text + "\"");

                objOut.writeObject(message);
                objOut.flush();
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (sendSocket != null) {
                try {
                    System.out.println("closing port " + sendPort);
                    sendSocket.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    ChatReceiver chatReceiver;

    public ChatServer() {
    }

    public ChatServer(String address, int receivePort) {
        chatReceiver = new ChatReceiver(address, receivePort);
    }

    public void process() {
        chatReceiver.start();
    }

    private class ChatReceiver implements Runnable {
        private Thread thread;
        String address;
        int receivePort;
        Socket receiveSocket;

        public ChatReceiver() {
            thread = new Thread(this);
        }

        public ChatReceiver(String address, int receivePort) {
            this();
            this.address = address;
            this.receivePort = receivePort;
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
                receiveSocket = new Socket(address, receivePort);
                ObjectInputStream objIn = new ObjectInputStream(receiveSocket.getInputStream());
                System.out.println("connected to port " + receivePort + " on " + address);
                while (!thread.isInterrupted()) {
                    Message message = (Message) objIn.readObject();
//                    if (message == null) {break;}
                    System.out.println("incoming: " + message.text);
                }
            } catch (IOException e) {
                e.printStackTrace();
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            }finally {
                if (receiveSocket != null) {
                    try {
                        System.out.println("closing port " + receivePort);
                        receiveSocket.close();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
    }



    public void listenConnections(int i) {
    }
}
