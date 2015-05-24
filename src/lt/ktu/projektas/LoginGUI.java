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

public class LoginGUI {
	private Stage window;
	private TextField username;
	private PasswordField password;
	public LoginGUI(){
		window = new Stage();
		window.initModality(Modality.APPLICATION_MODAL);
		window.setTitle("Login");
		window.setWidth(300);

		window.setResizable(false);
		
		username = new TextField();
		password = new PasswordField();
		
		Label usernameTitle = new Label("Username:");
		Label passwordTitle = new Label("Password:");
		Button submit = new Button("Login");
		
		//submit.setOnAction(new onSubmit());
		
		username.setMaxWidth(Double.MAX_VALUE);
		password.setMaxWidth(Double.MAX_VALUE);
		submit.setMaxWidth(Double.MAX_VALUE);
		
		VBox box = new VBox(5);
		box.setPadding(new Insets(5, 5, 0, 5));
		box.getChildren().addAll(usernameTitle, username, passwordTitle, password, submit);
		Scene scene = new Scene(box);
		window.setScene(scene);
		window.showAndWait();
	}
	public void close(){
		window.close();
	}
	public String getUsername(){
		return username.getText();
	}
	public String getPassword(){
		return password.getText();
	}

}
