package hw_test;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

/**
 * Created by sanya on 04.02.2015.
 */
public class Server {

    private static int PORT = 15000;
    private static int index = 0;
    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket = new ServerSocket(PORT);

        while(true){
            System.out.println("wait connection...");
            Socket socket = serverSocket.accept();
            index++;
            System.out.println(index +" connection accept - " + socket );
            new ServerClient(socket);
        }
    }
}

class ServerClient extends Thread {
    private PrintWriter pw;
    private BufferedReader br;
    private Socket socket;
    private String dataIn = "";
    private String dataOut = "";
    private Scanner scan = new Scanner(System.in);


    public ServerClient(Socket socket) throws IOException {
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
