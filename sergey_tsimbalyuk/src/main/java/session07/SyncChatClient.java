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
    String clientText = "";
    String serverText="";

    BufferedReader br = new BufferedReader(new InputStreamReader(sock.getInputStream()));
    PrintWriter pw = new PrintWriter(new OutputStreamWriter(sock.getOutputStream()));



    while (!serverText.equals("exit")){
//            |(clientText.compareTo("exit")!=0)

        clientText = scan.nextLine();
        pw.println(clientText);
        pw.flush();
        serverText = br.readLine();
        System.out.println(serverText);

    };
}

}