package hw3.chat;

/**
 Написать чат, в котором можно отправлять и принимать сообщения в любом порядке.
 public void process()

 Класс задания hw3.chat.AsyncChat
 Класс теста hw3.chat.AsyncChatTest
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class AsyncChat {

    public static final String CLIENT = "c";
    public static final String SERVER = "s";
    public static final String EXIT = "exit";
    public static final String EMPTY_STRING = "";

    public static void main(String[] args) {
        if (args.length > 0) {
            if (CLIENT.equals(args[0])) {
                System.out.println(CLIENT);
                Client client = new Client();
                if (args.length > 1) {
                    client.setName(args[1]);
                    client.go();
                } else {
                    System.out.println("Not set User name");
                }
            } else if (SERVER.equals(args[0])) {
                System.out.println(SERVER);
                Server server = new Server();
                server.process();
            } else {
                System.out.println("Incorrect chat role: " + args[0]);
            }
        } else {
            System.out.println("Not entered chat role: client or server (c/s)");
        }
    }

    static class Client {
        Socket socket;
        PrintWriter writer;
        String clientName = null;

        public void go() {
            BufferedReader reader = setUpNetworking();
            Thread readerThread = new Thread(new IncomingReader(reader));
            readerThread.start();
            BufferedReader keyboard = new BufferedReader(new InputStreamReader(System.in));
            String line = EMPTY_STRING;
            String output;
            try {
                while (!EXIT.equals(line)) {
                    line = keyboard.readLine();
                    output = clientName + ": " + line;
                    writer.println(output);
                    writer.flush();
                }
                socket.close();
            } catch (IOException e) {
                System.out.println(e);
            }
        }

        private BufferedReader setUpNetworking() {
            BufferedReader reader = null;
            try {
                socket = new Socket("localhost", 2006);

                InputStreamReader in = new InputStreamReader(socket.getInputStream());
                reader = new BufferedReader(in);

                writer = new PrintWriter(socket.getOutputStream());
                System.out.println("Networking is established");
            } catch (Exception e) {
                System.out.println(e);
            }
            return reader;
        }


        public void setName(String name) {
            clientName = name;
        }
    }

    static class Server {
        public void process(  ) {

            try {
                ServerSocket serverSocket = new ServerSocket(2006);
                System.out.println("Waiting for a client...");
                System.out.println();
                Socket clientSocket = serverSocket.accept();
                System.out.println("Got new Client");
                PrintWriter writer = new PrintWriter(clientSocket.getOutputStream());
                Thread t = new Thread(new ClientHandler(clientSocket));
                t.start();
                BufferedReader keyboard = new BufferedReader(new InputStreamReader(System.in));
                String line = EMPTY_STRING;
                String output;
                while (!EXIT.equals(line)) {
                    line = keyboard.readLine();
                    output = "Server: " + line;
                    writer.println(output);
                    writer.flush();
                }
                clientSocket.close();
                serverSocket.close();
            } catch (IOException e) {
                System.out.println(e);
            }
        }
    }

    static class ClientHandler implements Runnable {

        Socket s;
        BufferedReader reader;

        public ClientHandler(Socket clientSocket) {
            try {
                s = clientSocket;
                InputStreamReader in = new InputStreamReader(s.getInputStream());
                reader = new BufferedReader(in);
            } catch (IOException e) {
                System.out.println(e);
            }
        }

        @Override
        public void run() {
            String mes;
            try {
                while ((mes = reader.readLine()) != null) {
                    System.out.println(mes);
                }
            } catch (IOException e) {
                System.out.println(e);
            }
        }
    }

    static class IncomingReader implements Runnable {

        private BufferedReader reader;

        public IncomingReader(BufferedReader reader) {
            this.reader = reader;
        }

        @Override
        public void run() {
            String mes;
            try {
                while ((mes = reader.readLine()) != null) {
                    System.out.println(mes);
                }
            } catch (IOException e) {
                System.out.println(e);
            }
        }
    }
}
