package lt.ktu.projektas;

import javafx.application.Platform;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Cursor;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
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
public class LoadingGUI {
	private static Stage window;
	private static Label msgLabel;
	private static Thread animation;
	public static void show(Runnable task){
		window = new Stage();
		window.initModality(Modality.APPLICATION_MODAL);
		window.setTitle("Connecting");
		window.setWidth(300);
		window.setResizable(false);
		
		msgLabel = new Label("Please wait");
		msgLabel.setMaxWidth(Double.MAX_VALUE);
		msgLabel.setAlignment(Pos.CENTER);
		msgLabel.setFont(new Font(15));
		
		VBox box = new VBox();
		box.setPadding(new Insets(5));
		box.getChildren().addAll(msgLabel);
		box.setAlignment(Pos.CENTER);
		Scene scene = new Scene(box);
		scene.setCursor(Cursor.WAIT);
		window.setScene(scene);
		
		animation = new Thread(new Runnable() {
			public void auto(int c){
				String suffix = "";
				for(int i = 0; i < c; i++) suffix += ".";
				final String msg = "Please wait"+suffix;
				Platform.runLater(() -> msgLabel.setText(msg));
				try{ Thread.sleep(1000); }catch(Exception e){ System.out.println(e.getMessage()); }
				auto((c<3)?++c:0);
			}
			@Override
			public void run() {
				auto(0);
			}
		});
		new Thread(new Runnable() {
			@Override
			public void run() {
				task.run();
				Platform.runLater(() ->close());
			}
		}).start();
		animation.start();	
		window.setOnCloseRequest(e -> close());		
		window.showAndWait();	
	}
	private static void close(){
		animation.stop();
		animation = null;
		window.close();
	}
	
}