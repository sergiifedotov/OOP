package session07;

import java.io.*;
import java.net.Socket;
import java.util.Scanner;

/**
 * Created by tsv on 31.01.15.
 */
public class SyncChatClient {public static void main(String[] args) throws IOException {
    Socket sock = new Socket("127.0.0.1", 30000);
    Scanner scan = new Scanner(System.in);
    String message2 = "";
    String str="";

    BufferedReader br = new BufferedReader(new InputStreamReader(sock.getInputStream()));
    PrintWriter pw = new PrintWriter(new OutputStreamWriter(sock.getOutputStream()));



    while ((str.compareTo("exit")!=0)|(message2.compareTo("exit")!=0)) {

        message2 = scan.nextLine();
        pw.println(message2);
        pw.flush();
        str = br.readLine();
        System.out.println(str);

    };
}

}