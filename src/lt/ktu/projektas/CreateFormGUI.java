package lt.ktu.projektas;

import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.Spinner;
import javafx.scene.control.TextField;
import javafx.scene.input.ContextMenuEvent;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.stage.Modality;
import javafx.stage.Stage;
import lt.ktu.projektas.field.Field;
import lt.ktu.projektas.field.FieldType;
import lt.ktu.projektas.field.IntegerFieldProperties;

public class CreateFormGUI {
	private final MainGUI main;
	private final Stage window;
	private ComboBox<FieldType> combo;
	private TextField name, desc, tags;
	private CheckBox allow_anon, allow_public, show_results;
	private ListView<Field> fields;
	public CreateFormGUI(MainGUI main){
		this.main = main;
		
		window = new Stage();
		window.initModality(Modality.APPLICATION_MODAL);
		window.setTitle("Create form");
		window.setWidth(500);
		window.setHeight(600);
		window.setMinWidth(500);
		//window.setResizable(false);
		combo = new ComboBox<FieldType>();
		fields = new ListView<Field>();
		fields.getStylesheets().add("fieldList.css");
		fields.setOnContextMenuRequested(new onD());
		fields.setMaxHeight(Double.MAX_VALUE);
		fields.setMaxWidth(Double.MAX_VALUE);
		combo.setPromptText("Select type...");
		combo.setItems(FXCollections.observableArrayList(FieldType.getAllTypes()));
		combo.setMaxWidth(Double.MAX_VALUE);
		Button add = new Button("Add");
		combo.setMaxWidth(Double.MAX_VALUE);
		add.setMaxSize(Double.MAX_VALUE, Double.MAX_VALUE);
		
		GridPane box = new GridPane();
		ColumnConstraints col1 = new ColumnConstraints();
		ColumnConstraints col2 = new ColumnConstraints();
	    col1.setPercentWidth(90);
	    col2.setPercentWidth(10);
   
	    box.setHgap(5);
	    box.setVgap(5);
	    box.getColumnConstraints().addAll(col1, col2);
	    Label l_name = new Label("Name:");
	    Label l_desc = new Label("Description(Optional):");
	    Label l_tags = new Label("Tags(Separate with ,)(Optional):");
		Label l_combo = new Label("Select field type:");
		
		name = new TextField();
		desc = new TextField();
		tags = new TextField();
		allow_anon = new CheckBox("Allow for anonymous to fill in this form");
	    allow_public = new CheckBox("Allow this form to be found publicly");
	    show_results = new CheckBox("Allow everyone to see results");
	    box.add(l_name, 0, 0, 2, 1);
	    box.add(name, 0, 1, 2, 1);
	    box.add(l_desc, 0, 2, 2, 1);
	    box.add(desc, 0, 3, 2, 1);
	    box.add(l_tags, 0, 4, 2, 1);
	    box.add(tags, 0, 5, 2, 1);
	    box.add(allow_anon, 0, 6, 2, 1);
	    box.add(allow_public, 0, 7, 2, 1);
	    box.add(show_results, 0, 8, 2, 1);
		box.add(l_combo, 0, 9);
		box.add(combo, 0, 10);
		box.add(add, 1, 10);
		box.add(fields, 0, 11, 2, 1);
		
		box.setPadding(new Insets(5, 5, 0, 5));
		box.setMaxWidth(Double.MAX_VALUE);
		Scene scene = new Scene(box);
		add.setOnAction(new onAdd());
		window.setScene(scene);
		window.showAndWait();
	}
	private class onD implements EventHandler<ContextMenuEvent>{

		@Override
		public void handle(ContextMenuEvent arg0) {
			System.out.println(fields.getSelectionModel().getSelectedItem().toString());
			
		}
	
	}
	private class onAdd implements EventHandler<ActionEvent>{
		@Override
		public void handle(ActionEvent arg0) {	
			if(combo.getValue() == null) return;
			CreateFieldGUI temp = new CreateFieldGUI(combo.getValue());
			temp.show();
			if(temp.getField() != null)
				fields.getItems().add(temp.getField());
		}
	}
}

