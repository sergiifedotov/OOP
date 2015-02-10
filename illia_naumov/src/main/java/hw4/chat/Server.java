package hw4.chat;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

/**
 * Created by user on 03.02.2015.
 */
class Server{
    public static void main(String[] args) {
        new Server();
    }
    //public static Server instance = new Server();
    private List<Connection> connections =
            Collections.synchronizedList(new ArrayList<Connection>());
    private ServerSocket server;


    public Server(){
        try {
            server = new ServerSocket(31000);
            while(true){
                Socket socket = server.accept();
                Connection con = new Connection(socket);
                connections.add(con);
                con.start();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }finally{
            closeAll();
        }
    }

    private void closeAll(){
        try{
            server.close();

            synchronized(connections){
                Iterator <Connection> iterator = connections.iterator();
                while(iterator.hasNext()){
                    ((Connection) iterator.next()).close();
                }
            }
        } catch(Exception e){
            System.err.println("Threads are not closed");
        }
    }
    private class Connection extends Thread {
        private BufferedReader br;
        private PrintWriter pw;
        private Socket socket;
        private String name = "";

        public Connection(Socket socket) {
            this.socket = socket;

            try {
                br = new BufferedReader(new InputStreamReader(socket.getInputStream()));
                pw = new PrintWriter(new OutputStreamWriter(socket.getOutputStream()), true);
            } catch (IOException e) {
                e.printStackTrace();
                close();
            }
        }

        @Override
        public void run() {
            try {
                name = br.readLine();
                // Отправляем всем клиентам сообщение о том, что зашёл новый пользователь
                synchronized(connections) {
                    Iterator<Connection> iter = connections.iterator();
                    while(iter.hasNext()) {
                        ((Connection) iter.next()).pw.println(name + " cames now");
                    }
                }

                String str = "";
                while (true) {
                    str = br.readLine();
                    if(str.equals("exit")) {
                        break;
                    }

                    // Отправляем всем клиентам очередное сообщение
                    synchronized(connections) {
                        Iterator<Connection> iter = connections.iterator();
                        while(iter.hasNext()) {
                            ((Connection) iter.next()).pw.println(name + ": " + str);
                        }
                    }
                }

                synchronized(connections) {
                    Iterator<Connection> iter = connections.iterator();
                    while(iter.hasNext()) {
                        ((Connection) iter.next()).pw.println(name + " has left");
                    }
                }
            } catch (IOException e) {
                e.printStackTrace();
            } finally {
                close();
            }
        }


        /**
         * public static void main(String [] args) {
         * try {
         * <p/>
         * BufferedReader bf = new BufferedReader(new InputStreamReader(cs.getInputStream()));
         * PrintWriter pw = new PrintWriter(new OutputStreamWriter(cs.getOutputStream()));
         * <p/>
         * while(true) {
         * String message = bf.readLine();
         * System.out.println(message);
         * pw.println(message);
         * pw.flush();
         * }
         * <p/>
         * <p/>
         * } catch (IOException e) {
         * e.printStackTrace();
         * }
         * }
         */

        /**public static Server getInstance() {
            return instance;
        }*/

        public void close() {
            try {
                br.close();
                pw.close();
                socket.close();

                // Если больше не осталось соединений, закрываем всё, что есть и
                // завершаем работу сервера
                connections.remove(this);
                if (connections.size() == 0) {
                    Server.this.closeAll();
                    System.exit(0);
                }
            } catch (Exception e) {
                System.err.println("Потоки не были закрыты!");
            }
        }
    }
}
