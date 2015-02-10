package session7;

import java.io.*;
import java.net.Socket;

/**
 * Created by user on 31.01.2015.
 */
public class MessageToServer {

    public static void main(String[] args) throws IOException {
        Socket sokc = new Socket("192.168.1.143", 30000);
        PrintWriter pw = new PrintWriter(new OutputStreamWriter(sokc.getOutputStream()));
        BufferedReader br = new BufferedReader(new InputStreamReader(sokc.getInputStream()));
        pw.println("bonjour, bambina");
        pw.flush();
        System.out.println(br.readLine());
    }
}
