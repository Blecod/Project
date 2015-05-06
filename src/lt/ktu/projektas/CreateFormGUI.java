package lt.ktu.projektas;

import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.stage.Modality;
import javafx.stage.Stage;
import lt.ktu.projektas.utils.FieldType;

public class CreateFormGUI {
	private final MainGUI main;
	private final Stage window;
	private ComboBox<FieldType> combo;
	public CreateFormGUI(MainGUI main){
		this.main = main;
		
		window = new Stage();
		window.initModality(Modality.APPLICATION_MODAL);
		window.setTitle("Create form");
		window.setWidth(500);
		window.setHeight(600);
		window.setResizable(false);
		TextField title = new TextField("Title...");
		combo = new ComboBox<FieldType>();
		combo.setPromptText("Select type...");
		combo.setItems(FXCollections.observableArrayList(FieldType.getAllTypes()));
		combo.setMaxWidth(Double.MAX_VALUE);
		Button add = new Button("Add");
		title.setMaxWidth(Double.MAX_VALUE);
		combo.setMaxWidth(Double.MAX_VALUE);
		add.setMaxSize(Double.MAX_VALUE, Double.MAX_VALUE);
		
		
	
		
		

		
		GridPane box = new GridPane();
		
		
		ColumnConstraints col1 = new ColumnConstraints();
		ColumnConstraints col2 = new ColumnConstraints();
	    col1.setPrefWidth(440);
	    col2.setPrefWidth(70);
	    box.setHgap(5);
	    box.setVgap(5);
	    box.getColumnConstraints().addAll(col1);
		
		box.add(title, 0, 0);
		box.add(combo, 0, 1);
		box.add(add, 1, 0, 1, 2);

		box.setPadding(new Insets(5, 5, 0, 5));
		box.setMaxWidth(Double.MAX_VALUE);
		Scene scene = new Scene(box);
		
		window.setScene(scene);
		window.showAndWait();
	}

	private class onSubmit implements EventHandler<ActionEvent>{
		@Override
		public void handle(ActionEvent arg0) {	

		}
	}
}
