package hw4.chat;

import java.io.*;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;

/**
 * Created by sanya on 02.02.2015.
 */
public class Client {


    public static void main(String[] args) throws IOException{
        Socket socket = new Socket("127.0.0.1", 15000);
        String dataIn = "";
        Scanner in = new Scanner(System.in);
        PrintWriter pw = new PrintWriter(new OutputStreamWriter(socket.getOutputStream()));
        BufferedReader br = new BufferedReader(new InputStreamReader(socket.getInputStream()));

        Thread clientWrite = new Thread(new Runnable() {
            String dataOut = "";

            @Override
            public void run() {
                while (true) {
                    dataOut = in.next();
                    pw.println(dataOut);
                    pw.flush();
                }
            }
        });
        clientWrite.start();


            while (true) {

                dataIn = br.readLine();
                if (dataIn == null){
                    System.out.println("connection lost");
                    System.exit(1);
                    break;
                }
                System.out.println(dataIn);
            }

    }
}

