package hw3.chat;

import java.io.*;
import java.net.Socket;
import java.util.Scanner;

/**
 * Created by sanya on 02.02.2015.
 */
public class AsyncChat {
    public void process(){

    };


    public static void main(String[] args) {

        try {
            String dataIn = "";
            Scanner in = new Scanner(System.in);
            Socket socket = new Socket("127.0.0.1",1515);
            PrintWriter pw = new PrintWriter(new OutputStreamWriter(socket.getOutputStream()));
            BufferedReader br = new BufferedReader(new InputStreamReader(socket.getInputStream()));

            Thread clientWrite = new Thread(new Runnable(){
                String dataOut = "";
                @Override
                public void run() {
                    while(true) {
                        dataOut = in.next();
                        pw.println(dataOut);
                        pw.flush();
                    }
                }
            });
            clientWrite.start();

            while(true){
                dataIn = br.readLine();
                System.out.println(dataIn);
               }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

