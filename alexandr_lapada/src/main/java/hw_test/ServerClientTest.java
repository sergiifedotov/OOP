package hw_test;

import java.io.*;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.UnknownHostException;

/**
 * Created by sanya on 04.02.2015.
 */
public class ServerClientTest {
        public static final int PORT = 2080;

    public static void main(String[] args) throws IOException {
        ServerSocket s = new ServerSocket(PORT);
        System.out.println("Started: " + s);
        try {
            // Блокирует до тех пор, пока не возникнет соединение:
            Socket socket = s.accept();
            try {
                System.out.println("Connection accepted: " + socket);
                BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
                // Вывод автоматически выталкивается из буфера PrintWriter'ом
                PrintWriter out = new PrintWriter(new OutputStreamWriter(socket.getOutputStream()),true);
                while (true) {
                    String str = in.readLine();
                    if (str.equals("END"))
                        break;
                    System.out.println("Echoing: " + str);
                    out.println(str);
                }
                // Всегда закрываем два сокета...
            }
            finally {
                System.out.println("closing...");
                socket.close();
            }
        }
        finally {
            s.close();
        }
    }
}


