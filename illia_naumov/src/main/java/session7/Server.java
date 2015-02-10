package session7;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

/**
 * Created by user on 31.01.2015.
 */
public class Server {

    public static void main(String[] args) throws IOException {
        ServerSocket ss = new ServerSocket(30000);
        Socket cs = ss.accept();
        PrintWriter pw = new PrintWriter(new OutputStreamWriter(cs.getOutputStream()));
        BufferedReader br = new BufferedReader(new InputStreamReader(cs.getInputStream()));
        Scanner scan = new Scanner(System.in);
        while(true){

            String line = br.readLine();
            System.out.println(line);
            // read from keyboard
            pw.println(scan.nextLine());
            pw.flush();
        }

    }
}

