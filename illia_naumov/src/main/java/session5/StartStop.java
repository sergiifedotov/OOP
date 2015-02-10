package session5;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.FlowPane;
import javafx.stage.Stage;

/**
 * Created with IntelliJ IDEA.
 * User: al1
 * Date: 24.01.15
 */
public class StartStop extends Application {
    public static void main(String[] args) {
        launch(args);
    }
    @Override
    public void start(Stage stage) throws Exception {
        TextField text = new TextField();
        Button btnStart = new Button("Start");
        Button btnStop = new Button("Stop");
        btnStart.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                for (int i=0; i < 10; i++) {
                    text.setText(text.getText() + "1");
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        });
        FlowPane pane = new FlowPane();
        pane.getChildren().add(text);
        pane.getChildren().add(btnStart);
        pane.getChildren().add(btnStop);
        Scene scene = new Scene(pane, 600, 400);
        stage.setScene(scene);
        stage.show();
    }
}
