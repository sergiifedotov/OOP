package session5;

import javafx.application.*;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;
import javafx.scene.paint.Color;
import javafx.scene.paint.Paint;
import javafx.stage.Stage;


// Для работы с JavaFX нам необходимо наследовать класс Application
public class FxHello extends Application {
    // это наша точка старта -- этот метод поднимает FX стек и загружает туда наше приложение
    public static void main(String[] args) {
//        Application.launch(args);
        launch(args);
    }

    @Override
    public void start(Stage stage) {
        stage.setTitle("Hello World!");
        // здесь мы создаём сцену, которая является содержимым окна и layout manager для неё
        BorderPane border = new BorderPane();

        Button btn = new Button("Start");
        Button btn2 = new Button("Stop");


        btn.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent arg0) {
                System.out.println("Press");
            }
        });

        btn2.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent arg0) {
                System.out.println("Press");
            }
        });


        border.setCenter(btn);
        border.setRight(btn2);
//        border.setTop(btn2);



        Scene scene = new Scene(border, 400, 200, Color.BLUE);
        stage.setScene(scene);

        stage.show();

    }
}