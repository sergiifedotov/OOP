package JavaFX;

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Cursor;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;



/**
 * Created by sanya on 14.03.2015.
 */
public class JavaFx extends Application {

    private Double wight = 300.0;
    private Double height = 400.0;

    @Override
    public void start(Stage primaryStage) throws Exception {
        primaryStage.setTitle("My first window");
        primaryStage.setScene(creteScene());
        primaryStage.setResizable(false);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch();
    }

    public Scene creteScene() {
        GridPane gridPaneBtn = new GridPane();
        GridPane gridPaneAll = new GridPane();

        HBox hBoxText = new HBox();
        TextField textField = new TextField();
        textField.setMinWidth(200);
        textField.setMaxWidth(200);
        textField.setMinHeight(50);
        textField.setMaxHeight(50);
        textField.setEditable(false);
        hBoxText.getChildren().add(textField);

        gridPaneAll.add(hBoxText, 0, 0);
        gridPaneAll.add(createElem(gridPaneBtn),0 ,1);

        Scene scene = new Scene(gridPaneAll, wight, height);
        scene.setCursor(Cursor.HAND);
        return scene;
    }

    private GridPane createElem(GridPane gridPane){
        int name = 0;
        String[] nameBtn = {"7","4","1","+","8","5","2","0","9","6","3","-","C","/","*","="};
        for (int i = 0; i < 5; i++){
                for (int j = 0; j < 4; j++){
                    if (name < nameBtn.length) {
                        Button button = new Button(nameBtn[name]);
                        button.setMinWidth(50);
                        button.setMaxWidth(50);
                        button.setMinHeight(50);
                        button.setMaxHeight(50);
                        System.out.println((i + 1) + " " + j);
                        gridPane.add(button, i + 1, j);
                    }
                    name++;
                }
            }
        return gridPane;
    }
}
