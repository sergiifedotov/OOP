package session07;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * Created by tsv on 31.01.15.
 */
public class SocketServer {

    public static void main(String[] args) throws IOException {
        ServerSocket ss = new ServerSocket(30100);
        Socket server = ss.accept();

        BufferedReader brServer = new BufferedReader(new InputStreamReader(server.getInputStream()));
        PrintWriter pwServer = new PrintWriter(new OutputStreamWriter(server.getOutputStream()));
        String str = " ";
        while (true) {
            pwServer.println("Pong!");
            pwServer.flush();
            str = brServer.readLine();
            System.out.println(str);
        }


    }


}
