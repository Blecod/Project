package lt.ktu.projektas;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class AlertBox {
	public static void show(String message){
		Stage window = new Stage();
		window.initModality(Modality.APPLICATION_MODAL);
		window.setTitle("Alert");
		window.setWidth(300);
		window.setResizable(false);
		
		Label msgLabel = new Label(message);
		msgLabel.setMaxWidth(Double.MAX_VALUE);
		msgLabel.setAlignment(Pos.CENTER);
		msgLabel.setFont(new Font(15));
		
		VBox box = new VBox();
		box.setPadding(new Insets(5));
		box.getChildren().addAll(msgLabel);
		box.setAlignment(Pos.CENTER);
		Scene scene = new Scene(box);
		window.setScene(scene);
		window.showAndWait();
	}
}
