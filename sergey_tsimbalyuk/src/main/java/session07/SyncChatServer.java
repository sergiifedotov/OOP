package session07;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

/**
 * Created by tsv on 31.01.15.
 */
public class SyncChatServer {
    public static void main(String[] args) throws IOException {
        Scanner scan = new Scanner(System.in);
        String serverText = "";
        String clientText = "";

        ServerSocket ss = new ServerSocket(31000);
        Socket ssocket = ss.accept();


        BufferedReader br = new BufferedReader(new InputStreamReader(ssocket.getInputStream()));
        PrintWriter pw = new PrintWriter(new OutputStreamWriter(ssocket.getOutputStream()));


        while (!serverText.equals("exit")) {
            clientText = br.readLine();
            System.out.println(clientText);
            serverText = scan.nextLine();
            pw.println(serverText);
            pw.flush();

        }


    }
}