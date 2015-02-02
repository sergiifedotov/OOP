package session7;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.Socket;

/**
 * Created by Yaroslav_Syrota on 31.01.2015.
 */

public class Messenger {
    public static void main(String args[]) throws Exception {
        Socket sock = new Socket("192.168.1.143", 30000);
        BufferedReader br = new BufferedReader(new InputStreamReader(sock.getInputStream()));
        PrintWriter pw = new PrintWriter(new OutputStreamWriter(sock.getOutputStream()));
        pw.print("трям значит здрасьте");
        pw.flush();
        System.out.println(br.readLine());
        br.close();
        pw.close();
    }
}
