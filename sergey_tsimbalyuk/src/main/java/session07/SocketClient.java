package session07;

import java.io.*;
import java.net.Socket;

/**
 * Created by tsv on 31.01.15.
 */
public class SocketClient {

    public static void main(String[] args) throws IOException {
        Socket sock = new Socket("127.0.0.1", 30000);
        BufferedReader br = new BufferedReader(new InputStreamReader(sock.getInputStream()));
        PrintWriter pw = new PrintWriter(new OutputStreamWriter(sock.getOutputStream()));

        pw.println("Hi! inet addr:192.168.1.184  Bcast:192.168.1.255");
        pw.flush();
        String str = br.readLine();
        System.out.println(str);
    }
}
