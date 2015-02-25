package session7;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.stage.Stage;

/**
 * Created by warit on 24.02.2015.
 */
public class FX extends Application {

    @Override
    public void start(Stage stage)throws  Exception{
        String message = "Hello JavaFX!";
        Scene scene = new Scene(new Label(message),600,400);
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }

}
