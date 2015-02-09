package hw4.chat;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

import java.awt.*;
import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

/**
 * Created by sanya on 02.02.2015.
 */
public class JavaFx extends Application {
    Socket socket = null;
    PrintWriter pw = null;
    BufferedReader br = null;
    String dataIn = "";
    String dataOut = "";
    static ClientRead clientRead;

    public static void main(String[] args) {
        launch();
    }

    //////////////////////--JAVAFX--///////////////////////

    @Override
    public void start(Stage primaryStage) throws Exception {

        primaryStage.setTitle("Chat");
        Button buttonSend = new Button("send");
        Button buttonConnect = new Button("Add connecton");
        TextField textFieldOut = new TextField();
        TextField textFieldIn = new TextField();
        TextArea textArea = new TextArea();


        buttonSend.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                dataOut = textFieldOut.getText();
                dataIn = dataIn + " " + dataOut;
                textFieldOut.setText("");
                textFieldIn.setText(dataIn);
                pw.println(dataOut);
                pw.flush();
            }
        });

        buttonConnect.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                boolean noConnection = false;
                try {
                    socket = new Socket("localhost", 1515);
                    pw = new PrintWriter(new OutputStreamWriter(socket.getOutputStream()));
                    br = new BufferedReader(new InputStreamReader(socket.getInputStream()));
                    clientRead = new ClientRead(dataIn, br, textFieldIn);
                    // clientWrite.start();
                } catch (IOException e) {
                    noConnection = true;
                    textFieldIn.setText("no connection");
                }
                if (!noConnection) {
                    textFieldIn.setText("");
                    buttonConnect.setDisable(true);
                } else {
                    noConnection = false;
                }
            }
        });

        FlowPane pane = new FlowPane();
        pane.getChildren().add(textFieldOut);
        pane.getChildren().add(buttonSend);
        pane.getChildren().add(textFieldIn);
        pane.getChildren().add(buttonConnect);
        primaryStage.setScene(new Scene(pane, 300, 300));
        primaryStage.show();
        /*while (socket == null) {
            try {
                clientRead.start();
            } catch (NullPointerException e) {
                System.out.println("dd");
            }
        }

    }*/
    }
}
class ClientRead extends Thread{
    private String dataIn = "";
    private BufferedReader br;
    private TextField textFieldIn;

    public ClientRead(String dataIn, BufferedReader br, TextField textFieldIn){
        this.dataIn = dataIn;
        this.br = br;
        this.textFieldIn = textFieldIn;
    }

    @Override
    public void run() {
        while(true) {
            try {
                dataIn = dataIn +" "+br.readLine();
                System.out.println("gg");
                textFieldIn.setText(dataIn);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}