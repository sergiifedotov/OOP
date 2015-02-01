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
        String str2 = "";

        ServerSocket ss = new ServerSocket(30000);
        Socket ssocket = ss.accept();


        BufferedReader br = new BufferedReader(new InputStreamReader(ssocket.getInputStream()));
        PrintWriter pw = new PrintWriter(new OutputStreamWriter(ssocket.getOutputStream()));

        String str = "";


        while ((str2.compareTo("exit") != 0)) {
            str = br.readLine();
            System.out.println(str);
            str2 = scan.nextLine();
            pw.println(str2);
            pw.flush();

        }


    }
}