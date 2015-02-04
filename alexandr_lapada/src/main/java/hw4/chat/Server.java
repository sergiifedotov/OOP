package hw4.chat;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.FlowPane;
import javafx.stage.Stage;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

/**
 * Created by sanya on 02.02.2015.
 */
public class Server {
    public static void main(String[] args) {

        String dataOut = "";
        Scanner in = new Scanner(System.in);
        try {
            ServerSocket ss = new ServerSocket(1515);
            System.out.println("wait connection:");
            Socket socket = ss.accept();
            System.out.println("accept connection");
            PrintWriter pw = new PrintWriter(new OutputStreamWriter(socket.getOutputStream()));
            BufferedReader br = new BufferedReader(new InputStreamReader(socket.getInputStream()));

            Thread serverReader = new Thread(new Runnable() {
                String dataIn = "";

                @Override
                public void run() {
                    while (true) {
                        try {
                            System.out.println(br.readLine());
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    }
                }
            });

            serverReader.start();

            while (true) {
                dataOut = in.next();
                pw.println(dataOut);
                pw.flush();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}







