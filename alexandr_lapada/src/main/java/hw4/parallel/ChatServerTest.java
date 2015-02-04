package hw4.parallel;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * Created by sanya on 04.02.2015.
 */
public class ChatServerTest {
    private static int PORT = 15000;
    private static int index = 0;

    public static void listenConnections()throws IOException{
        ServerSocket serverSocket = new ServerSocket(PORT);
        while(true){
            System.out.println("wait connection...");
            Socket socket = serverSocket.accept();
            index++;
            System.out.println(index +" connection accept - " + socket );
            new ChatServer(socket);
        }
    }
    public static void main(String[] args) throws IOException {

        listenConnections();

    }
}
