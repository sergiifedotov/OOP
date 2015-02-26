package tools;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;

/**
 * Created by tsv on 25.02.15.
 */
public class ChatLoginMainWindow extends Application {


    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("CREATE NEW USER");
        primaryStage.isResizable();
        GridPane grid = new GridPane();
        grid.setAlignment(Pos.CENTER);
        grid.setHgap(10);
        grid.setVgap(10);
        grid.setPadding(new Insets(25, 25, 25, 25));

        Button btn = new Button("BUTTON");
        HBox hbBtn = new HBox(10);
        hbBtn.setAlignment(Pos.BOTTOM_CENTER );
        hbBtn.getChildren().add(btn);
        grid.add(hbBtn, 1, 4);

        //  final Text actionTarget = new Text();
        // grid.add(actionTarget, 1, 6);


        Scene scene = new Scene(grid, 300, 300);
        primaryStage.setScene(scene);

        Text sceneTitle = new Text("Chat Login");
//        sceneTitle.setTextAlignment(TextAlignment.CENTER);
        sceneTitle.setFont(Font.font("Verdana", FontWeight.NORMAL, 18));
        grid.add(sceneTitle, 1, 0, 1, 1);

        Label userName = new Label("Name:");
        grid.add(userName, 0, 1);

        TextField userTextField = new TextField();
        grid.add(userTextField, 1, 1);

        Label pw = new Label("Password:");
        pw.setFont(Font.font("Verdana", FontWeight.NORMAL, 12));
        grid.add(pw, 0, 2);

        PasswordField pwBox = new PasswordField();
        grid.add(pwBox, 1, 2);

        btn.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent e) {
                /*String name = userTextField.getText();
                String password = pwBox.getText();
                UserJDBCManager userJDBCManager = new UserJDBCManager();
                User user = userJDBCManager.readByNamePass(name, password);
                if (user != null) {
                    userJDBCManager.findAll();
                } else System.out.println("Неправильный логин и пароль");*/
            }
        });

        primaryStage.show();
    }
}