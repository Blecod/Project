package lt.ktu.projektas;

import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.RowConstraints;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;

public class FormList extends GridPane{
	
	private VBox formList1, formList2;
	private ListView<String> publicList, privateList;
	private Label publicListTitle, privateListTitle;
	public FormList(){
		RowConstraints row1, row2;
		row1 = new RowConstraints();
		row1.setPercentHeight(50);
		row2 = new RowConstraints();
		row2.setPercentHeight(50);
		ColumnConstraints col1 = new ColumnConstraints();
	    col1.setPercentWidth(100);
	    setHgap(10);
		getColumnConstraints().addAll(col1);
		getRowConstraints().addAll(row1, row2);
	    
		publicListTitle = new Label("Public forms");
	    publicListTitle.setFont(new Font("Arial", 15));
	    privateListTitle = new Label("My forms");
	    privateListTitle.setFont(new Font("Arial", 15));
	    publicList = new ListView<String>();
	  
	    privateList = new ListView<String>();
	    //Testiniai duomenys
	    for(int i=0; i<10; i++)
	    	publicList.getItems().add("Testas "+i);
	    for(int i=0; i<10; i++)
	    	privateList.getItems().add("Testas "+i);
	    
	    formList1 = new VBox();
	    formList1.getChildren().addAll(publicListTitle, publicList);
	    formList1.setMaxSize(Double.MAX_VALUE, Double.MAX_VALUE);
	    formList2 = new VBox();
	    formList2.getChildren().addAll(privateListTitle, privateList);
	    formList2.setMaxSize(Double.MAX_VALUE, Double.MAX_VALUE);
	    add(formList1, 0, 0);
	    add(formList2, 0, 1);
	}
}