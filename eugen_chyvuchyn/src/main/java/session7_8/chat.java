package session7_8;

import java.io.*;
import java.net.Socket;
import java.util.Scanner;

/**
 * Created by Chuvychin on 04.02.2015.
 */
public class chat {
    public static void main(String[] args) throws IOException {
        Scanner scan = new Scanner(System.in);
        Socket socket = new Socket("localhost",30000);

        PrintWriter pw = new PrintWriter(new OutputStreamWriter(socket.getOutputStream()));
        BufferedReader br = new BufferedReader(new InputStreamReader(socket.getInputStream()));

        String input = "", output = "";

        while(!output.equals("exit")){

            output = scan.nextLine();
            pw.println(output);
            pw.flush();

            input = br.readLine();
            System.out.println(input);
        }
    }
}
