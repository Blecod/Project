package lt.ktu.projektas;




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
/*
 * 	Naudojimas:
 * 	Runnable run = new Runnable() {
		@Override
		public void run() {
			//Kodas, kuris vykdomas kol rodomas loading langas, ir jam pasibaigus langas iðjungiamas	
		}
	};
	LoadingGUI.show(run); // Kol bus atidarytas langas, kodas po ðios eilutës nevyks kol langas nebus uþdarytas, ar jam duotas kodas pabaigtas
 */
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
			window.close();
		}
	}
}
