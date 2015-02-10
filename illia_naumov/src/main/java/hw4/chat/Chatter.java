package hw4.chat;

import java.io.*;
import java.net.Socket;
import java.util.Scanner;

/**
 * Created by user on 03.02.2015.
 */
public class Chatter {


    public static void main(String [] args) {
        try {
            Socket sock = new Socket("127.0.0.1", 31000);
            BufferedReader bf = new BufferedReader(new InputStreamReader(sock.getInputStream()));
            PrintWriter pw = new PrintWriter(new OutputStreamWriter(sock.getOutputStream()));
            Scanner scan = new Scanner(System.in);

            new Sender(sock);

            while(true) {
                System.out.println(bf.readLine());
            }

        } catch (IOException e) {
            e.printStackTrace();
        }


    }
}
class Sender implements Runnable{
    Socket sock;
    Thread t;
    public Sender(Socket sock){
        this.sock = sock;
        t = new Thread(this, "Sender");
        t.start();
    }
    @Override
    public void run(){
        try {
            PrintWriter pw = new PrintWriter(new OutputStreamWriter(sock.getOutputStream()));
            Scanner scan = new Scanner(System.in);
            while(true) {
                String message = scan.nextLine();
                pw.println(message);
                pw.flush();
                if(message.equals("exit")){
                    sock.close();
                    pw.close();
                    break;
                }
            }
        }catch (Exception e){

        }
    }

}

