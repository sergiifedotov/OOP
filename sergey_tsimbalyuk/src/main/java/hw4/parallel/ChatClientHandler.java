package hw4.parallel;

import java.io.IOException;
import java.net.Socket;
import java.util.Scanner;

/**
 * Created by tsv on 05.02.15.
 */
public class ChatClientHandler implements Runnable {

    // runnable для каждого потока

    private Socket client;
    private ChatServer server;
    private Scanner inputStream;

    public ChatClientHandler(Socket client, ChatServer server) {
        this.client = client;
        this.server = server;
    }

    @Override
    public void run() {
        try {
            inputStream = new Scanner(client.getInputStream());
            while(true)
            {
                if(!inputStream.hasNext())
                    return;
                String chatLine = inputStream.nextLine();
                System.out.print(client.getRemoteSocketAddress() + " said: " + chatLine);
                server.sendChatMessageToAll(chatLine);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}