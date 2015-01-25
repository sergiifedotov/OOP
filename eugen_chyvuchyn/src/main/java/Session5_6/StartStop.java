package Session5_6;


import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.FlowPane;
import javafx.stage.Stage;

/**
 * Created by Chuvychin on 24.01.2015.
 */
public class StartStop extends Application implements Runnable {
    public static void main (String...args){
        launch(args);

    }
    @Override
    public void start(Stage stage) throws Exception {

        TextField textField = new TextField();

        Button btnStart = new Button("START");
        Button btnStop = new Button("STOP");

        btnStart.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {


                /*try{
                    value.set(0);

                    for(int i = 0; i < 10; i++) {
                        value.set(value.get() * 10 + 1);
                        Thread.sleep(1000);
                    }
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }*/
            }
        });
        FlowPane pane = new FlowPane();
        pane.getChildren().add(textField);
        pane.getChildren().add(btnStart);
        pane.getChildren().add(btnStop);

        Scene scene = new Scene(pane,600,600);
        stage.setScene(scene);
        stage.show();
    }

    @Override
    public void run() {
        for (int i=1;i<=10;i++){

        }
    }
}
