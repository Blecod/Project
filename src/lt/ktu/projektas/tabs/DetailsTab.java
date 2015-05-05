package lt.ktu.projektas.tabs;





import javafx.geometry.HPos;
import javafx.geometry.VPos;
import javafx.scene.control.Label;
import javafx.scene.control.Tab;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.RowConstraints;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import lt.ktu.projektas.utils.Form;

public class DetailsTab extends Tab{
	private final GridPane pane;
	public DetailsTab(Form form){
		
		
		setText("Details");
		setClosable(false);
		
		pane = new GridPane();
		RowConstraints row = new RowConstraints();
		row.setPercentHeight(100);
		row.setValignment(VPos.CENTER);
		ColumnConstraints col = new ColumnConstraints();
		col.setPercentWidth(100);
		col.setHalignment(HPos.CENTER);
		pane.getColumnConstraints().addAll(col);
		pane.getRowConstraints().addAll(row);

		VBox info = new VBox(5);
		Label titles[] = new Label[]{
			new Label("Form title:"),
			new Label("Created by:")
		};
		Label values[] = new Label[]{
				new Label(form.getTitle()),
				new Label(form.getUser().getFirstName()+" "+form.getUser().getSecondName()),
				new Label(form.getUser().getEmail())
		};
		for(Label t:titles)
			t.setFont(Font.font("Arial", FontWeight.BOLD, 14));
		
		for(Label v:values)
			v.setFont(new Font(13));
		
		info.getChildren().addAll(titles[0], values[0], titles[1], values[1], values[2]);		
		
	    pane.add(info, 0, 0);
	    pane.setMaxSize(Double.MAX_VALUE, Double.MAX_VALUE);
	    pane.getStyleClass().add("details");
	    setContent(pane);
	    
	}
}
