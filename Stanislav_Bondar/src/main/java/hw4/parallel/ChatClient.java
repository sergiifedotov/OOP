package hw4.parallel;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;


/**
 Created by stan on 13.02.20.
 */

public class ChatClient implements Runnable {

    public static void main(String[] args) throws Exception {
        new ChatClient();
        //kkj
    }


    private Socket clientSocket;
    private PrintWriter outputStream;
    private Scanner inputStream;
    private int port = 30100;
    private String name;

    public ChatClient() throws IOException {
        initialize();
    }

    private void initialize() throws IOException {

        Scanner keyboard = new Scanner(System.in);
        System.out.println("Enter Server's IP: ");
        String str = keyboard.next();

        System.out.println("Set your nickname: ");
        name = keyboard.next();

        InetAddress host = null;
        try {
            host = InetAddress.getByName(str);
        } catch (UnknownHostException e1) {
            System.out.println("remote node is undentified");
        }
        System.out
                .println("you are connected to the  " + host.getHostAddress());


        clientSocket = null;
        try {
            clientSocket = new Socket(host, port);
            clientSocket.setReuseAddress(true);
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("not found");
        }
        inputStream = new Scanner(clientSocket.getInputStream());
        outputStream = new PrintWriter(clientSocket.getOutputStream());


        Thread t = new Thread(this);
        t.start();


        while (keyboard.hasNextLine()) {
            String msg = keyboard.nextLine();
            outputStream.println(name + ": " + msg);
            outputStream.flush();
        }
    }


    @Override
    public void run() {
        while (true) {
            if (inputStream.hasNextLine())
                System.out.println(inputStream.nextLine());
        }
    }
}