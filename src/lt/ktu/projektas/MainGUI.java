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
	
		ServerCommunication toServer = new ServerCommunication();
	
		//DABARTINIO USERIO TESTAS
		//User Tuser = currentUser;
		//String test = currentUser.getSurname();
		//System.out.println(test);
		User2Container formsContainer;
		
		//TESTAS IMTI FORMAS   (404) kaþkokie papildomi simboliai atsiranda
//		try{
//			formsContainer = toServer.getForms("?author=Lukas&q=&sort=&order=&limit=100");
//		} catch (InternalServerErrorException e) {
//
//		//	System.out.println(e.getResponse().getEntity());
//	          ByteArrayInputStream stream =(ByteArrayInputStream) e.getResponse().getEntity();
//	          int n = stream.available();
//	          byte[] bytes = new byte[n];
//	          stream.read(bytes, 0, n);
//	          String s = new String(bytes, StandardCharsets.UTF_8);
//	          System.out.println(s);
//			
//		}
		
		
		
//		try {  //TEST Pridëti naujà formà
//			ArrayList<String> tags = new ArrayList<String>();
//			tags.add("Tag un");
//			tags.add("Tag deux");
//			tags.add("Tag trois");
//			ArrayList<Question> questions = new ArrayList<Question>();
//			Question question = new Question();
//			question.setName("Ze name");
//			question.setType("integer");
//			question.setAllowEmpty(false);
//			question.setAllowCustom("umm");
//			questions.add(question);
//			Form newForm = new Form("Name", "Author", "description", tags, "Date", true, true, true, true, questions, 100);
//			toServer.PostForm(newForm);
//			//System.out.println("succes?");
//		} catch (BadRequestException e) {
//			System.out.println(e.getResponse().getEntity());
//	          ByteArrayInputStream stream =(ByteArrayInputStream) e.getResponse().getEntity();
//	          int n = stream.available();
//	          byte[] bytes = new byte[n];
//	          stream.read(bytes, 0, n);
//	          String s = new String(bytes, StandardCharsets.UTF_8);
//	          System.out.println(s);
//		}
		
		
		
		
		
		
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
		//Testavimui sukuriama temp forma
//        User userr = new User("Vardenis", "Pavardenis", "vardenis.pavardenis@ktu.edu");
//        Form temp = new Form(FormType.PRIVATE, "Straipsniai", userr, "2014.03.24");
//        temp.setFields(new Field[]{new Field(FieldType.TEXTAREA, "Straipsnis"), new Field(FieldType.DOUBLE, "Ilgis")});
//        temp.setData(new FilledData[]{
//        		new FilledData<>(userr, "2014.03.24 12:33", new Object[]{"Lorem ipsum dolor sit amet, consectetur adipiscing elit. \nMaecenas a laoreet lorem, at viverra erat. Aenean venenatis libero at lectus pellentesque bibendum. Duis rhoncus tortor quis elementum fermentum. Phasellus sollicitudin scelerisque luctus. Nullam vestibulum interdum rhoncus.a</textarea>", 0.0}),
//        		new FilledData<>(userr, "2014.03.24 12:33", new Object[]{"ectetur adipiscing elit. \nMaecm rhoncus.a</textarea>", 0.0}),
//        		new FilledData<>(userr, "2014.03.24 12:33", new Object[]{"L4psum dolor sit amet, consectetur adipiscing elit. \nMaecm rhoncus.a</textarea>", 0.0}),
//        		new FilledData<>(userr, "2014.03.24 12:33", new Object[]{"L5dolor sit amet, consectetur adipiscing elit. \nMaecm rhoncus.a</textarea>", 0.0}),
//
//        		new FilledData<>(userr, "2014.03.24 12:33", new Object[]{"Lorem it. \nMaecena viverra erat. Aenean venenatis libero at lectus pellentum interdum rhoncus.a</textarea>", 0.0})});
//        
	    
        
//        tabs.openForm(temp);
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
			System.out.println(box.getEmail()+":"+box.getPassword());
		});
		MenuItem menuUserRegister = new MenuItem("Register");
		menuUserRegister.setOnAction(e -> {
			RegisterGUI box = new RegisterGUI();
			System.out.println(box.getEmail()+":"+box.getPassword());
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
	private class onAction implements EventHandler<ActionEvent>{
		@Override
		public void handle(ActionEvent arg0) {	
			
		}
	}

}
