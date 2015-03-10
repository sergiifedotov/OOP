package hw3.chat;

import java.io.*;
import java.net.Socket;

/**
 * Created by Chuvychin on 04.02.2015.
 *  Написать чат, в котором можно отправлять и принимать сообщения в любом порядке.
 public void process()

 Класс задания hw3.chat.AsyncChat
 Класс теста hw3.chat.AsyncChatTest
 */
public class AsyncChat {
    public static void main(String[] args) throws IOException {
        new AsyncChat("193.110.76.55",30000).run();

    }


    private Socket serverSocket;
    private BufferedReader socketReader; //читаем с сервера
    private BufferedReader userInput; //читаем пользовательский ввод с консоли
    private BufferedWriter socketWriter; //ввод с консоли



    public AsyncChat(String host, int port) throws IOException {

        serverSocket = new Socket(host,port);
        socketReader = new BufferedReader(new InputStreamReader(serverSocket.getInputStream()));
        socketWriter = new BufferedWriter(new OutputStreamWriter(serverSocket.getOutputStream()));
        userInput = new BufferedReader(new InputStreamReader(System.in));
        new Thread(new Receiver()).start();
    }

    public AsyncChat(Socket serverSocket, BufferedReader socketReader, BufferedReader userInput, BufferedWriter socketWriter) {
        this.serverSocket = serverSocket;
        this.socketReader = socketReader;
        this.userInput = userInput;
        this.socketWriter = socketWriter;
    }

    public AsyncChat() {
    }

    public void run(){
        while(true){
            String userString = null;
            try {
                userString = userInput.readLine();
            } catch (IOException ignored) {       }

            if ("fuckOff".equals(userString)||/*userString == null || userString.length() == 0 ||*/ serverSocket.isClosed()){
                close();
                break;
            } else {

                try {
                    socketWriter.write(userString);
                    socketWriter.write("\n");
                    socketWriter.flush();
                } catch (IOException e) {
                    close();
                }
            }
        }
    }

    public synchronized void close(){
        if (!serverSocket.isClosed()){
            try {
                serverSocket.close();
                System.exit(0);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }


    private class Receiver implements Runnable{

        @Override
        public void run() {
            while (!serverSocket.isClosed()){
                String line = null;
                try {
                    line = socketReader.readLine(); //читаем

                } catch (IOException e) {
                    System.out.println("Connection lost...");
                    close();
                }
                if(line == null){
                    System.out.println("Server is closed connection...");
                    close();
                }
                System.out.println(line);
            }
        }
    }
}
