package session7;

import java.io.*;
import java.net.Socket;

/**
 * Created by user on 31.01.2015.
 */
public class ChattingUser {
    public static void main(String[] args) throws IOException {
        Socket sock = new Socket("127.0.0.1", 30000);
        PrintWriter pw = new PrintWriter(new OutputStreamWriter(sock.getOutputStream()));
        BufferedReader br = new BufferedReader(new InputStreamReader(sock.getInputStream()));

        while(true){
            String line = br.readLine();
            pw.print(line);
            pw.flush();

            System.out.println(br.readLine());


        }

    }
}
