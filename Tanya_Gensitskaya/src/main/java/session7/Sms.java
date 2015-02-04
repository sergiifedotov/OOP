package session7;

import java.io.*;
import java.net.Socket;
import java.util.Scanner;

/**
 * Created by ZaR on 31.01.15.
 */
public class Sms {
    public static void main(String[] args) throws IOException {
        Socket sock = new Socket("192.168.1.154", 30000);
        PrintWriter pw = new PrintWriter(new OutputStreamWriter(sock.getOutputStream()));
        BufferedReader br = new BufferedReader(new InputStreamReader((sock.getInputStream())));

        Scanner scanner = new Scanner(System.in);
        while (true) {
            pw.println(scanner.nextLine());
            pw.flush();
            System.out.println(br.readLine());
        }

    }

}
