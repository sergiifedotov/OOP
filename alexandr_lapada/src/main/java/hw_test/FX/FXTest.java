package hw_test.FX;

import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
import javafx.scene.control.Button;

import javafx.event.ActionEvent;


/**
 * Created by sanya on 12.02.2015.
 */
public class FXTest extends Application {
    public static void main(String[] args) {
        launch();
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        primaryStage.setTitle("FX");
        StackPane pane = new StackPane();

        Button button = new Button("Hi");

        button.setOnAction(new EventHandler < ActionEvent > (){
            @Override
            public void handle(ActionEvent event){
                System.out.println("Hi");
            }
        });

        pane.getChildren().add(button);
        primaryStage.setScene(new Scene(pane,300,300));
        primaryStage.show();
    }
}
