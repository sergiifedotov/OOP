package session5;

import javafx.application.Application;
import javafx.scene.control.Button;
import javafx.scene.layout.FlowPane;
import javafx.stage.Stage;

/**
 * Created by warit on 24.01.2015.
 */
public class StartStop extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        Button btnOk = new Button("Ok");
        FlowPane pane = new FlowPane();
        pane.getChildren().add(btnOk);
    }
}
