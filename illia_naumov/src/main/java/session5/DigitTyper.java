package session5;

/**
 * Created by user on 25.01.2015.
 */
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import javafx.beans.binding.Bindings;
import javafx.beans.property.DoubleProperty;
import javafx.beans.property.SimpleDoubleProperty;

public class DigitTyper extends Application {
    private  DoubleProperty value = new SimpleDoubleProperty();

    @Override
    public void start(Stage stage) {
        GridPane buttons = createGridPane();
        final TextField screen = createScreen();
        buttons.add(screen, 0, 0);

        BorderPane border = new BorderPane();
        stage.setTitle("DigitTyper");
        stage.initStyle(StageStyle.UTILITY);
        stage.setResizable(false);
        stage.setScene(new Scene(createLayout(screen, buttons)));
        stage.show();
    }

        private VBox createLayout(TextField screen, GridPane buttons) {
            final VBox layout = new VBox(20);
            layout.setAlignment(Pos.CENTER);
            layout.setStyle("-fx-background-color: grey; -fx-padding: 20; -fx-font-size: 20;");
            layout.getChildren().setAll(screen, buttons);
            return layout;
        }

        private TextField createScreen() {
            final TextField screen = new TextField();
            screen.setStyle("-fx-background-color: white;");
            screen.setAlignment(Pos.CENTER_RIGHT);
            screen.setEditable(false);
            screen.textProperty().bind(Bindings.format("%.0f", value));
            return screen;
        }

        private GridPane createGridPane() {
        GridPane buttons = new GridPane();
        Button btn = new Button();
        btn.setText("Start");
        buttons.add(btn, 1, 1);
        btn.setOnAction(new EventHandler<ActionEvent>() {

            @Override
            public void handle(ActionEvent event) {
                try{
                    value.set(0);
                    for(int i = 0; i < 10; i++) {
                        value.set(value.get() * 10 + 1);
                        Thread.sleep(1000);
                    }
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }


        });

        Button btn2 = new Button();
        btn2.setText("Stop");
        buttons.add(btn2, 2, 1);
        btn2.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {

            }
        });
            return buttons;
    }


    public static void main(String[] args) {
        launch(args);
    }
}

