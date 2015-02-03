package hw3.chat;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;


/**
 * Created by Tsimbalyuk Sergey
 * 2/3/2015.
 */
public class AsyncChatServ {
    public static void main(String[] args) throws IOException {
        try {
            ServerSocket serverSocket = new ServerSocket(30000);
            Socket socket = serverSocket.accept();
            ServerRead serverRead = new ServerRead(socket);
            ServerWrite serverWrite = new ServerWrite(socket);

            serverWrite.start();
            serverRead.start();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

class ServerRead extends Thread {
    private BufferedReader bufferedReader;
    private Socket socket;

    public ServerRead(Socket socket) throws IOException {
        this.socket = socket;
        bufferedReader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
    }

    @Override
    public void run() {
        try {
            while (!socket.isClosed()) {
                System.out.println(bufferedReader.readLine());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

class ServerWrite extends Thread {
    private PrintWriter printWriter;
    private BufferedReader br;
    private Socket socket;

    public ServerWrite(Socket socket) throws IOException {
        this.socket = socket;
        printWriter = new PrintWriter(new OutputStreamWriter(socket.getOutputStream()));
        br = new BufferedReader(new InputStreamReader(System.in));
    }

    @Override
    public void run() {
        try {
            while (!socket.isClosed()) {
                printWriter.println(br.readLine());
                printWriter.flush();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}