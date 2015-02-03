package hw3.chat;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.event.ActionEvent;

import javafx.event.EventHandler;

import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;
import javafx.stage.WindowEvent;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * Created by vladimir on 02.02.2015.
 *
 * Написать приложение - асинхронный чат, позволяющее
 * выводить и отсылать сообщения в любом порядке.
 */

public class AsyncChatJFX extends Application {

    ChatReceiver chatReceiver;

    TextArea chatArea;
    PrintWriter printWriter = null;
    Socket sendSocket = null;

    public AsyncChatJFX() {
        chatArea = new TextArea();
    }


    private class ChatReceiver implements Runnable {
        private Thread thread;
        String address;
        int port;
        Socket receiveSocket = null;
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
                receiveSocket = new Socket(address, port);
                bufferedReader = new BufferedReader(new InputStreamReader(receiveSocket.getInputStream()));
                System.out.println("connected to port " + port + " on " + address);
                while (!thread.isInterrupted()) {

                    String message = bufferedReader.readLine();
                    if (message == null) {
                        break;
                    }
                    System.out.println(message);
                    Platform.runLater(new Runnable() {
                        @Override
                        public void run() {
                            chatArea.appendText("incoming: " + message);
                        }
                    });

                    //TODO что здесь?
                }

            } catch (IOException e) {
                e.printStackTrace();
            } finally {
                if (receiveSocket != null) {
                    try {
                        receiveSocket.close();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
    }

    @Override
    public void start(Stage primaryStage) throws Exception {

        int receivePort = 30000;
        String address = "localhost";
        chatReceiver = new ChatReceiver(address, receivePort);
        chatReceiver.start();

        int sendPort = 30001;


        try {
            sendSocket = new ServerSocket(sendPort).accept();
            printWriter = new PrintWriter(new OutputStreamWriter(sendSocket.getOutputStream()));
            printWriter.println("hello server");
            printWriter.flush();
            System.out.println("opened port " + sendPort);
        } catch (IOException e) {
            e.printStackTrace();
            if (sendSocket != null) {
                try {
                    sendSocket.close();
                } catch (IOException e2) {
                    e2.printStackTrace();
                }
            }
        }

        TextField inputField = new TextField();

        Button btnSend = new Button("Send");
        btnSend.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                printWriter.println(inputField.getText());
                printWriter.flush();
                chatArea.appendText(inputField.getText() + "\n");
                inputField.setText("");
            }
        });

        int sceneWidth = 600;
        int sceneHeight = 400;
        int inputFieldHeight = sceneHeight / 10;

        btnSend.setMinWidth(sceneWidth / 6);
        btnSend.setMinHeight(inputFieldHeight);

        inputField.setMinWidth(sceneWidth - btnSend.getMinWidth());
        inputField.setMinHeight(inputFieldHeight);
        chatArea.setMinHeight(sceneHeight - inputFieldHeight);
        chatArea.setWrapText(true);
        chatArea.setEditable(false);


        GridPane gridPane = new GridPane();
        gridPane.add(btnSend, 1, 0);
        gridPane.add(inputField, 0, 0);

        BorderPane borderPane = new BorderPane();
        borderPane.setCenter(chatArea);
        borderPane.setBottom(gridPane);

        Scene scene = new Scene(borderPane, sceneWidth, sceneHeight);
        primaryStage.setScene(scene);
        primaryStage.setTitle("AsyncChatJFX client");
        primaryStage.setResizable(false);
        primaryStage.setOnCloseRequest(new EventHandler<WindowEvent>() {
            @Override
            public void handle(WindowEvent event) {
                System.out.println("closing...");
                chatReceiver.interrupt();
                if (sendSocket != null) {
                    try {
                        sendSocket.close();
                    } catch (IOException e2) {
                        e2.printStackTrace();
                    }
                }

            }
        });
        primaryStage.show();
    }
}
