package hw_test;
import java.net.*;

import java.io.*;
/**
 * Created by sanya on 04.02.2015.
 */
public class ClientTest {
    public static final int PORT = 2080;

    public static void main(String[] args) throws IOException {

        InetAddress addr = InetAddress.getByName(null);

        System.out.println("addr = " + addr);
        Socket socket = new Socket(addr, PORT);
        try {
            System.out.println("socket = " + socket);
            BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            PrintWriter out = new PrintWriter(new OutputStreamWriter(socket.getOutputStream()),true);
            for (int i = 0; i < 10; i++) {
                out.println("howdy " + i);
                String str = in.readLine();
                System.out.println(str);
            }
            out.println("END");
        } finally {
            System.out.println("closing...");
            socket.close();
        }
    }
}
