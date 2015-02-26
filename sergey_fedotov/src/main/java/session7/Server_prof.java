package session7;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: al1
 * Date: 4/21/13
 */
public class Server_prof {
    private int serverPort = 30000; // default port

    public Server_prof(int serverPort) {
        this.serverPort = serverPort;
    }

    public static void main(String[] args) {
        Server_prof server11 = new Server_prof(30000);
        server11.runServer();

    }

    private void runServer() {
        ServerSocket srvSocket;
        try {
            srvSocket = new ServerSocket(serverPort);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        System.out.println("Server is ran");

        while (true) {
            Socket socket;
            try {
                socket = srvSocket.accept();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }

            //runClientThread(socket);
       }
    }

    private void runClientThread(final Socket socket) {
        System.out.println("--- Connection accepted " + socket.getRemoteSocketAddress());
        new Thread() {
            @Override
            public void run() {
                String address = "";
                try (
                        BufferedReader br = new BufferedReader(new InputStreamReader(socket.getInputStream()));
                        PrintWriter pw = new PrintWriter(new OutputStreamWriter(socket.getOutputStream()))) {

                    String inputMessage = "";
                    address = socket.getRemoteSocketAddress().toString();
                    while (inputMessage != null) {
                        try {
                            inputMessage = br.readLine();
                            if (inputMessage.contains("null")) {
                                break;
                            }
                            System.out.println(">>> " + address + ":\t" + inputMessage);
                            String messageToClient = getNextMessage();
                            System.out.println("<<< server:\t" + messageToClient);
                            pw.write(messageToClient + address + '\n');
                            pw.flush();
                            messages.add(0, inputMessage);
                        } catch (Exception e) {
                            break;
                        }
                    }
                    socket.close();

                } catch (IOException e) {
                    e.printStackTrace();
                }
                System.out.println("--- Connection finished from " + address);
            }
        }.start();
    }

    private String getNextMessage() {
        int rndIdx = (int) (Math.random() * (messages.size() % 3));
        return messages.get(rndIdx);
    }

    private List<String> messages = new ArrayList<>(Arrays.asList(
            "опа-па!",
            "почему ты так думаешь?",
            "поехали в Краматорск?"
    ));
}