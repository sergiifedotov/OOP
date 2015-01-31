package session7;

import java.io.*;
import java.net.Socket;
import java.util.Scanner;

/**
 * Created by vladimir on 31.01.2015.
 */
public class ClientDemo {
    public static void main(String[] args) throws IOException {
        Socket socket = new Socket("192.168.1.146", 30000);

        PrintWriter printWriter = new PrintWriter(new OutputStreamWriter(socket.getOutputStream()));
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(socket.getInputStream()));

        Scanner scanner = new Scanner(System.in);
        while (true) {
            printWriter.println(scanner.nextLine());
            printWriter.flush();
            System.out.println(bufferedReader.readLine());

        }
    }
}
