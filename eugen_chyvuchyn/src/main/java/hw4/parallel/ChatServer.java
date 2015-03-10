package hw4.parallel;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

/**
 * Created by Chuvychin on 05.02.2015.
 */
public class ChatServer {

    public static void main(String[] args) {
        try {
            new ChatServer(30000).run();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private ServerSocket serverSocket;
    private Thread serverTread;
    private int port;
    BlockingQueue<SocketProcessor> q = new LinkedBlockingQueue<>();

    public ChatServer(){

    }

    public ChatServer(int port) throws IOException {
        serverSocket = new ServerSocket(port);
        this.port = port;
    }
    void listenConnections( int port ){

    }
    public void run(){
        serverTread = Thread.currentThread();
        while (true){
            try {
                Socket s = serverSocket.accept();
                if (s!=null){
                    final SocketProcessor processor = new SocketProcessor(s);
                    final Thread thread = new Thread(processor);
                    thread.setDaemon(true);
                    thread.start();
                    q.offer(processor);
                }
            } catch (IOException ignored) {

            }

        }
    }

    private class SocketProcessor implements Runnable{
        Socket socket;
        BufferedReader br;
        BufferedWriter bw;

        SocketProcessor(Socket socketParam) throws IOException {
            socket = socketParam;
            br = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            bw = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
        }

        @Override
        public void run() {
            while (!socket.isClosed()){
                String line = null;
                try {
                    line = br.readLine();
                } catch (IOException e) {
                        e.printStackTrace();
                        close();
                }
                if ("fuckOff".equals(line)){
                    close();
                } else{
                    for (SocketProcessor sp:q){
                        sp.send(line);
                    }
                }
            }
        }

        public synchronized void send (String line){
            try {
                bw.write(line);
                bw.write("\n");
                bw.flush();
            } catch (IOException e) {
               close();
            }

        }

        public synchronized void close(){
            q.remove(this);
            if (!socket.isClosed()){
                try {
                    socket.close();
                } catch (IOException ignored) {

                }
            }
        }
    }
}
