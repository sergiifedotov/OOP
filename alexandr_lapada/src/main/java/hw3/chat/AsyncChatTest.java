package hw3.chat;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

/**
 Написать чат, в котором можно отправлять и принимать сообщения в любом порядке.
 public void process()

 Класс задания hw3.chat.AsyncChat
 Класс теста hw3.chat.AsyncChatTest
 */
public class AsyncChatTest {

    public static void main(String[] args) {

        String dataOut = "";
        Scanner in = new Scanner(System.in);
        try {
            ServerSocket ss = new ServerSocket(1515);
            System.out.println("wait connection:");
            Socket socket = ss.accept();
            System.out.println("accept connection");
            PrintWriter pw = new PrintWriter(new OutputStreamWriter(socket.getOutputStream()));
            BufferedReader br = new BufferedReader(new InputStreamReader(socket.getInputStream()));

            Thread serverReader = new Thread(new Runnable() {
                String dataIn = "";

                @Override
                public void run() {
                    while (true) {
                        try {
                            System.out.println(br.readLine());
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    }
                }
            });

            serverReader.start();

            while (true) {
                dataOut = in.next();
                pw.println(dataOut);
                pw.flush();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}







