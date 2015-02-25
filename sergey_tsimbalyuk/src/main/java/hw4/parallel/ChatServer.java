package hw4.parallel;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.Iterator;

/**
 * Created by tsv on 05.02.15.
 *
 * Написать чат сервер. При подключении, пользователь передает на сервер свое имя и получает список всех подключенных к серверу пользователей. Каждый участник может начать чат с любым участником, кроме себя. Реализовать передачу файлов.
 * Метод:
 * public void listenConnections()
 *
 * Класс задания:
 * hw4.parallel.ChatServer
 *
 * Класс теста:
 * hw4.parallel.ChatServerTest
 *
 */

// -- fileHandler ++ send / receive
public class ChatServer {

    private final int port = 30100;
    private ServerSocket serverSocket;
    private ArrayList<Socket> clientList;

    public ChatServer() {
        try {
            serverSocket = new ServerSocket(port);
            serverSocket.setReuseAddress(true);
        } catch (IOException e) {
            System.out.println(e.getStackTrace());
        }
        clientList = new ArrayList<>();
    }

    public static void main(String[] args) throws IOException {
        new ChatServer().startServer();
    }

    public void listenConnections(int port) {
        try (ServerSocket serverSocket = new ServerSocket(port)){
            while (true) {
                try {
                    new ConnectionHandler(serverSocket.accept());
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void startServer() throws IOException {
        System.out.println("Accepting clients...");
        while(true)
        {
            // wait for a client
            Socket client = serverSocket.accept();
            clientList.add(client);
            System.out.println("New client accepted..." + client.getRemoteSocketAddress());
            System.out.println("Total users: " + clientList.size());
            ChatClientHandler handler = new ChatClientHandler(client,this);
            Thread t = new Thread(handler);
            t.start();
        }
    }

    public synchronized void sendChatMessageToAll(String msg) throws IOException {
        for(Iterator<Socket> it=clientList.iterator(); it.hasNext();)
        {
            Socket client = it.next();
            if( !client.isClosed() )
            {
                PrintWriter pw = new PrintWriter(client.getOutputStream());
                pw.println(msg);
                pw.flush();
                System.out.println("Sent to: " + client.getRemoteSocketAddress());
            }
        }
    }

    public class ConnectionHandler {
        Socket socket;
        public ConnectionHandler(Socket socket) throws IOException {
            this.socket = socket;
        }

    }

}