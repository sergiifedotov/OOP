package Weekend_4_1;

import java.io.*;
import java.net.Socket;
import java.util.Scanner;

/**
 * Created by sanya on 31.01.2015.
 */
public class Client {
    public static void main(String[] args) {
        try {
            Socket sock = new Socket("192.168.1.161", 30000);
            PrintWriter pw = new PrintWriter(new OutputStreamWriter(sock.getOutputStream()));
            BufferedReader br = new BufferedReader(new InputStreamReader(sock.getInputStream()));
            Scanner in = new Scanner(System.in);
            while (true) {
                String strIn = "";
                String strOut = "";
                strOut = in.nextLine();
                pw.println(strOut);
                pw.flush();
                strIn = br.readLine();
                System.out.println(strIn);
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
