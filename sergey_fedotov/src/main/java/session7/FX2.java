package session7;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.stage.Stage;

/**
 * Created by warit on 24.02.2015.
 */
public class FX2 extends Application {

    @Override
    public void start(Stage stage)throws  Exception{
        String message = "Hello JavaFX!";
        Button parent = new Button(message);
        parent.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                parent.setText("Clicked");
            }
        });
        Scene scene = new Scene(parent,600,400);
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }

}
