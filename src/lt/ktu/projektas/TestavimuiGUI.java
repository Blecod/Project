package lt.ktu.projektas;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.control.Tab;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.RowConstraints;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import javax.ws.rs.client.Client;

import lt.ktu.project.client.FormActions;
import lt.ktu.projektas.tabs.FormTabPane;
import lt.ktu.projektas.utils.User;
import lt.ktu.projektas.utils.User2Container;

public class TestavimuiGUI extends Application{
	Stage stage;

	FormTabPane tabs;
	Tab tab1, tab2;
	GridPane pane;
	FormList formList;
	
	static private FormActions formActions;
	private Client client;
	User currentUser;
	
	
	
	public static void main(String[] args){
		launch(args);
	}
	@Override
	public void start(Stage stage) throws Exception {
	
		
		
		VBox all = new VBox(10);
		all.setMaxHeight(Double.MAX_VALUE);
		all.setMaxWidth(Double.MAX_VALUE);
		
		Button btn = new Button("Button");
		btn.setMaxHeight(Double.MAX_VALUE);
		btn.setMaxWidth(Double.MAX_VALUE);
		btn.setOnAction(e -> {
			//tavo kodas
			
		});
		
		all.getChildren().add(btn);


		Scene scene = new Scene(all);
		
		stage.setScene(scene);
		
		stage.setTitle("Testavimo GUI");
		stage.show();
		
		this.stage = stage;
	}
}
