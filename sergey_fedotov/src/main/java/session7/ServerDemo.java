package session7;

import java.io.*;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.util.Scanner;

/**
 * Created by vladimir on 31.01.2015.
 */
public class ServerDemo {
    public static void main(String[] args) throws IOException {
        System.out.println("server running...");
        ServerSocketChannel sch = ServerSocketChannel.open();
        sch.socket().bind(new InetSocketAddress(30000));
        SocketChannel cch = sch.accept();
        System.out.println("accepted");

        PrintWriter printWriter = new PrintWriter(new OutputStreamWriter(cch.socket().getOutputStream()));
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(cch.socket().getInputStream()));

        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println(bufferedReader.readLine());
            printWriter.println(scanner.nextLine());
            printWriter.flush();
        }

    }
}
