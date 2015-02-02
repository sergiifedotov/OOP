package hw3.chat;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

import java.io.*;
import java.net.Socket;

/**
 * Created by vladimir on 02.02.2015.
 *
 * Написать приложение - асинхронный чат, позволяющее
 * выводить и отсылать сообщения в любом порядке.
 */

public class AsyncChatJFX extends Application {

//    public static void main(String[] args) {
//        Scanner scanner = new Scanner(System.in);
//
//        int receivePort = 30000;
//        String address = "localhost";
//
//        AsyncChatJFX asyncChatConsole = new AsyncChatJFX(address, receivePort);
//        asyncChatConsole.go();
//
//        int sendPort = 30001;
//        Socket socket = null;
//        PrintWriter printWriter = null;
//
//        try {
//            socket = new ServerSocket(sendPort).accept();
//            printWriter = new PrintWriter(new OutputStreamWriter(socket.getOutputStream()));
//            System.out.println("opened port " + sendPort);
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//
//        while (true) {
//            printWriter.println(scanner.nextLine());
//            printWriter.flush();
//        }
//
//    }

    ChatReceiver chatReceiver;

    public AsyncChatJFX() {
    }

    public AsyncChatJFX(String address, int receivePort) {
        chatReceiver = new ChatReceiver(address, receivePort);
    }

    public void go() {
        chatReceiver.start();
    }

    private class ChatReceiver implements Runnable {
        private Thread thread;
        String address;
        int port;
        Socket socket;
        BufferedReader bufferedReader;

        public ChatReceiver() {
            thread = new Thread(this);
        }

        public ChatReceiver(String address, int port) {
            this();
            this.address = address;
            this.port = port;
        }

        public void start() {
            thread.start();
        }

        public void interrupt() {
            thread.interrupt();
        }

        @Override
        public void run() {
            try {
                socket = new Socket(address, port);
                bufferedReader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
                System.out.println("connected to port " + port + " on " + address);
                while (!thread.isInterrupted()) {
                    System.out.println(bufferedReader.readLine());
                }
            } catch (IOException e) {
                e.printStackTrace();
             }
        }
    }

    @Override
    public void start(Stage primaryStage) throws Exception {

        TextField chatField = new TextField();
        TextField inputField = new TextField();

        Button btnSend = new Button("Send");
        btnSend.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {

            }
        });
        btnSend.setMinWidth(100);

        int sceneWidth = 600;
        int sceneHeight = 400;
        inputField.setMinWidth(sceneWidth - btnSend.getMinWidth());

        GridPane gridPane = new GridPane();
        gridPane.add(inputField, 0, 0);
        gridPane.add(btnSend, 1, 0);

        BorderPane borderPane = new BorderPane();
        borderPane.setCenter(chatField);
        borderPane.setBottom(gridPane);

        Scene scene = new Scene(borderPane, sceneWidth, sceneHeight);
        primaryStage.setScene(scene);
        primaryStage.show();

    }


}
