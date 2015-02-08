package OOP.homework16;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

/**
 * Написать калькулятор, сверху Text
 * в центре GridPane с кнопками
 * 123+
 * 456-
 * 789/
 * =0С*
 *
 */

public class CalcDemo extends Application{
	public static void main(String[] args) {
		launch(args);
	}

	@Override
	public void start(Stage stage) throws Exception {
		stage.setTitle("Calculator");
		BorderPane bp = new BorderPane();
		GridPane gp = new GridPane();
		Button bt1 = new Button("1");
		bt1.setMinWidth(70);
		gp.add(bt1, 1, 1);
		Button bt2 = new Button("2");
		bt2.setMinWidth(70);
		gp.add(bt2, 2, 1);
		Button bt3 = new Button("3");
		bt3.setMinWidth(70);
		gp.add(bt3, 3, 1);
		Button bt4 = new Button("4");
		bt4.setMinWidth(70);
		gp.add(bt4, 1, 2);
		Button bt5 = new Button("5");
		bt5.setMinWidth(70);
		gp.add(bt5, 2, 2);
		Button bt6 = new Button("6");
		bt6.setMinWidth(70);
		gp.add(bt6, 3, 2);
		Button bt7 = new Button("7");
		bt7.setMinWidth(70);
		gp.add(bt7, 1, 3);
		Button bt8 = new Button("8");
		bt8.setMinWidth(70);
		gp.add(bt8, 2, 3);
		Button bt9 = new Button("9");
		bt9.setMinWidth(70);
		gp.add(bt9, 3, 3);
		Button bt0 = new Button("0");
		bt0.setMinWidth(70);
		gp.add(bt0, 2, 4);

		Button btPlus = new Button("+");
		btPlus.setMinWidth(100);
		gp.add(btPlus, 4, 1);
		Button btMinus = new Button("+");
		btMinus.setMinWidth(100);
		gp.add(btMinus, 4, 2);
		Button btDivide = new Button("/");
		btDivide.setMinWidth(100);
		gp.add(btDivide, 4, 3);
		Button btMultiply = new Button("*");
		btMultiply.setMinWidth(100);
		gp.add(btMultiply, 4, 4);
		Button btClear = new Button("C");
		btClear.setMinWidth(70);
		gp.add(btClear, 3, 4);
		Button btCompute = new Button("=");
		btCompute.setMinWidth(70);
		gp.add(btCompute, 1, 4);
		
		

		
		TextField text = new TextField("qwerty");
		bp.setTop(text);
		bp.setCenter(gp);
		
		
		Scene scene = new Scene(bp);
		stage.setScene(scene);
		stage.show();
	}
	
}
