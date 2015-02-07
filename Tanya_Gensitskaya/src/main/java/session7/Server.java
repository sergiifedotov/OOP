package session7;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

/**
 * Created by ZaR on 31.01.15.
 */
public class Server {
    public static void main(String[] args) throws IOException {
        ServerSocket ss = new ServerSocket(30000);
        Socket cs = ss.accept();

        PrintWriter pw = new PrintWriter(new OutputStreamWriter(cs.getOutputStream()));
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(cs.getInputStream()));

        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println(bufferedReader.readLine());
            pw.println(scanner.nextLine());
            pw.flush();
        }
    }
}
