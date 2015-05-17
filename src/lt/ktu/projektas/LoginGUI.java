package lt.ktu.projektas;




import java.io.ByteArrayInputStream;
import java.nio.charset.StandardCharsets;

import javax.ws.rs.BadRequestException;
import javax.ws.rs.InternalServerErrorException;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.stage.Modality;
import javafx.stage.Stage;
import lt.ktu.project.client.ServerCommunication;

public class LoginGUI {
	private Stage window;
	private TextField email;
	private PasswordField password;
	public LoginGUI(){
		window = new Stage();
		window.initModality(Modality.APPLICATION_MODAL);
		window.setTitle("Login");
		window.setWidth(300);

		window.setResizable(false);
		
		email = new TextField();
		password = new PasswordField();
		
		Label emailTitle = new Label("E-mail:");
		Label passwordTitle = new Label("Password:");
		Button submit = new Button("Login");
		
		submit.setOnAction(new onSubmit());
		
		email.setMaxWidth(Double.MAX_VALUE);
		password.setMaxWidth(Double.MAX_VALUE);
		submit.setMaxWidth(Double.MAX_VALUE);
		
		VBox box = new VBox(5);
		box.setPadding(new Insets(5, 5, 0, 5));
		box.getChildren().addAll(emailTitle, email, passwordTitle, password, submit);
		Scene scene = new Scene(box);
		window.setScene(scene);
		window.showAndWait();
	}
	public String getEmail(){
		return email.getText();
	}
	public String getPassword(){
		return password.getText();
	}
	private class onSubmit implements EventHandler<ActionEvent>{
		@Override
		public void handle(ActionEvent arg0) {	
			if(email.getText().length()==0){
				AlertGUI.show("Fill in  your e-mail!");
				return;
			}
			if(password.getText().length()==0){
				AlertGUI.show("Fill in  your password!");
				return;
			}
			
			String nick = "Testy9";
			String pass = "Passy3";
			ServerCommunication toServer = new ServerCommunication();
			try {
				toServer.LogInUser(nick, pass);
			} catch (BadRequestException e) {
				System.out.println(e.getResponse().getEntity());
		          ByteArrayInputStream stream =(ByteArrayInputStream) e.getResponse().getEntity();
		          int n = stream.available();
		          byte[] bytes = new byte[n];
		          stream.read(bytes, 0, n);
		          String s = new String(bytes, StandardCharsets.UTF_8);
		          System.out.println(s);
		          
		        	  	//window.close();
		          AlertGUI.show("Fill in  your password!");
				  return;
			}
			
			window.close();
		}
	}
}
