package session7;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

/**
 * Created by vladimir on 31.01.2015.
 */
public class ServerDemo {
    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket = new ServerSocket(30000);
        Socket socket = serverSocket.accept();
        System.out.println("accepted");

        PrintWriter printWriter = new PrintWriter(new OutputStreamWriter(socket.getOutputStream()));
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(socket.getInputStream()));

        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println(bufferedReader.readLine());
            printWriter.println(scanner.nextLine());
            printWriter.flush();
        }

    }
}
