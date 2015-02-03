package hw3.chat;

import java.io.*;
import java.net.Socket;

/**
 * Created by tsv on 31.01.15.
 */

public class AsyncChat {
    public static void main(String[] args) throws IOException {
        try {
            Socket socket = new Socket("127.0.0.1", 30000);
            AsyncRead asyncRead = new AsyncRead(socket);
            AsyncWrite asyncWrite = new AsyncWrite(socket);

            asyncWrite.start();
            asyncRead.start();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

class AsyncRead extends Thread {
    private BufferedReader br;
    private Socket sock;

    public AsyncRead(Socket sock) throws IOException {
        this.sock = sock;
        br = new BufferedReader(new InputStreamReader(sock.getInputStream()));
    }

    @Override
    public void run() {
        try {
            while (!sock.isClosed()) {
                System.out.println(br.readLine());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

class AsyncWrite extends Thread {
    private PrintWriter pw;
    private BufferedReader br;
    private Socket socket;

    public AsyncWrite(Socket socket) throws IOException {
        this.socket = socket;
        pw = new PrintWriter(new OutputStreamWriter(socket.getOutputStream()));
        br = new BufferedReader(new InputStreamReader(System.in));
    }

    @Override
    public void run() {
        try {
            while (!socket.isClosed()) {
                pw.println(br.readLine());
                pw.flush();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
