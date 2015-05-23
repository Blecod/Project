package lt.ktu.projektas;

import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.Spinner;
import javafx.scene.control.TextField;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.stage.Modality;
import javafx.stage.Stage;
import lt.ktu.projektas.field.EmailFieldProperties;
import lt.ktu.projektas.field.Field;
import lt.ktu.projektas.field.FieldType;
import lt.ktu.projektas.field.IntegerFieldProperties;
import lt.ktu.projektas.field.MultiChoiceFieldProperties;
import lt.ktu.projektas.field.OneChoiceFieldProperties;
import lt.ktu.projektas.field.Properties;
import lt.ktu.projektas.field.StringFieldProperties;

public class CreateFieldGUI {
	private final Stage window;
	private Properties properties;
	private Field field;
	public CreateFieldGUI(FieldType type){
		this.field = null;
		window = new Stage();
		window.initModality(Modality.APPLICATION_MODAL);
		window.setTitle("Add field");
		window.setWidth(500);
		window.setResizable(false);
		
		switch(type){
		case INTEGER:
			properties = new IntegerFieldProperties();
			break;
		case STRING:
			properties = new StringFieldProperties();
			break;
		case EMAIL:
			properties = new EmailFieldProperties();
			break;
		case MULTI_CHOICE:
			properties = new MultiChoiceFieldProperties();
			break;
		case ONE_CHOICE:
			properties = new OneChoiceFieldProperties();
			break;
		default:
			break;
		}
		VBox box = properties.getPropertiesDisplay();

		Button add = new Button("Add");
		add.setPrefWidth(Double.MAX_VALUE);
		box.getChildren().add(add);
		box.setPadding(new Insets(5, 5, 0, 5));

		Scene scene = new Scene(box);
		add.setOnAction(new onAdd());
		window.setScene(scene);
	}
	public void show(){
		window.showAndWait();
	}
	public Field getField(){
		return field;
	}
	private class onAdd implements EventHandler<ActionEvent>{
		@Override
		public void handle(ActionEvent arg0) {	
			try {
				field = properties.getField();
				window.close();
			} catch (Exception e) {
				AlertGUI.show(e.getMessage());
			}
		}
	}
}
