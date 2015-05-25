package lt.ktu.projektas;

import java.io.ByteArrayInputStream;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;

import javax.ws.rs.BadRequestException;
import javax.ws.rs.InternalServerErrorException;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.RowConstraints;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import lt.ktu.project.client.FormActions;
import lt.ktu.project.client.RestFormActions;
import lt.ktu.project.client.ServerCommunication;
import lt.ktu.projektas.TESTmaterial.Form;
import lt.ktu.projektas.TESTmaterial.Question;
import lt.ktu.projektas.tabs.FormTabPane;

//import lt.ktu.projektas.utils.Form;
import lt.ktu.projektas.utils.FormType;
import lt.ktu.projektas.utils.User;
import lt.ktu.projektas.utils.User;
import lt.ktu.projektas.utils.User2Container;



public class MainGUI extends Application{
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
	
		User2Container formsContainer;
		
		RowConstraints row1;
		row1 = new RowConstraints();
		row1.setPercentHeight(100);
		ColumnConstraints col1 = new ColumnConstraints();
	    col1.setPercentWidth(25);
	    ColumnConstraints col2 = new ColumnConstraints();
	    col2.setPercentWidth(75);
	    
	    pane = new GridPane();
		pane.setHgap(10);
		pane.getColumnConstraints().addAll(col1, col2);
		pane.getRowConstraints().addAll(row1);
		
	    tabs = new FormTabPane();


	    pane.add(tabs, 1, 0);
		formList = new FormList();
		pane.add(formList, 0, 0);
		
		pane.getStyleClass().add("warp");
		pane.setMaxSize(Double.MAX_VALUE, Double.MAX_VALUE);

		MenuBar menuBar = new MenuBar();
		Menu menuUser = new Menu("User");
		Menu menuEdit = new Menu("Edit forms");
		MenuItem menuUserLogout = new MenuItem("Logout");
		MenuItem menuUserLogin = new MenuItem("Login");
		menuUserLogin.setOnAction(e -> {
			LoginGUI box = new LoginGUI();
		});
		MenuItem menuUserRegister = new MenuItem("Register");
		menuUserRegister.setOnAction(e -> {
			RegisterGUI box = new RegisterGUI();
		});
		MenuItem menuCreate = new MenuItem("Create");
		menuCreate.setOnAction(e -> {
			CreateFormGUI box = new CreateFormGUI(this);
		});
		MenuItem menuDelete = new MenuItem("Delete");
		menuUser.getItems().addAll(menuUserLogout, menuUserLogin, menuUserRegister);
		menuEdit.getItems().addAll(menuCreate, menuDelete);
		menuBar.getMenus().addAll(menuUser, menuEdit);
		
		VBox all = new VBox();
		all.getChildren().add(menuBar);
		all.getChildren().add(pane);
		all.setMaxSize(Double.MAX_VALUE, Double.MAX_VALUE);

		Scene scene = new Scene(all, 600, 500);

		stage.setScene(scene);
		stage.setMinWidth(600);
		stage.setMinHeight(500);
		
		scene.getStylesheets().add("style.css");
		stage.setTitle("Projektas");
		stage.show();
		
		this.stage = stage;
	}

}
