package hw4.parallel;

import java.io.*;
import java.net.Socket;
import java.util.Scanner;

/**
 * Created by sanya on 04.02.2015.
 */
public class ChatServer extends Thread {
    private PrintWriter pw;
    private BufferedReader br;
    private Socket socket;
    private String dataIn = "";
    private String dataOut = "";
    private Scanner scan = new Scanner(System.in);


    public ChatServer(Socket socket) throws IOException {
        this.socket = socket;
        pw = new PrintWriter(new OutputStreamWriter(this.socket.getOutputStream()));
        br = new BufferedReader(new InputStreamReader(this.socket.getInputStream()));
        run();
    }

    @Override
    public void run() {

        Thread dataWrite = new Thread(new Runnable() {
            @Override
            public void run() {
                while (true) {
                    try {
                        dataIn = br.readLine();
                    } catch (IOException e) {
                        System.err.println("connection lost");
                        break;
                    } finally {
                        try {
                            socket.close();
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    }
                    System.out.println(dataIn);
                }
            }
        });

        dataWrite.start();

        while (true) {
            dataOut = scan.next();
            pw.println(dataOut);
            pw.flush();

        }
    }
}
