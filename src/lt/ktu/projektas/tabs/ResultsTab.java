package lt.ktu.projektas.tabs;




import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Control;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.Tab;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextArea;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.RowConstraints;
import javafx.scene.layout.VBox;
import lt.ktu.projektas.AlertGUI;
import lt.ktu.projektas.field.Field;
import lt.ktu.projektas.field.FilledData;
import lt.ktu.projektas.utils.Form;

public class ResultsTab extends Tab{
	private final GridPane pane;
	private final TableView<FilledData<Object>> table;
	private final Form form;
	private final VBox view;
	private final ScrollPane scrllView;
	public ResultsTab(Form form){
		
		this.form = form;
		
		setText("Results ("+form.getData().length+")");
		setClosable(false);
		
		pane = new GridPane();
		RowConstraints row1, row2;
		row1 = new RowConstraints();
		row1.setPercentHeight(50);
		row2 = new RowConstraints();
		row2.setPercentHeight(50);
		ColumnConstraints col1 = new ColumnConstraints();
	    col1.setPercentWidth(100); 
	    pane.setHgap(10);
		pane.getColumnConstraints().addAll(col1);
		pane.getRowConstraints().addAll(row1, row2);
	    
		table = new TableView<>();
	    table.setEditable(true);
	   
	    TableColumn<FilledData<Object>, String> fullName = new TableColumn<>("Submitted By");
       	TableColumn<FilledData<Object>, String> date = new TableColumn<>("Date");
       	fullName.setResizable(false);
       	fullName.setCellValueFactory(new PropertyValueFactory<FilledData<Object>,String>("userFullName"));
       	date.setCellValueFactory(new PropertyValueFactory<FilledData<Object>,String>("date"));
       	date.setResizable(false);
        fullName.prefWidthProperty().bind(table.widthProperty().multiply(0.7));
        date.prefWidthProperty().bind(table.widthProperty().multiply(0.3));
        date.getStyleClass().add("cell");
        table.getColumns().addAll(date, fullName);
        table.setItems(form.getObservableList());
        table.getSelectionModel().select(0);
        
        view = new VBox(0);
        view.setPadding(new Insets(10));
        view.setMaxWidth(Double.MAX_VALUE);
        
        scrllView = new ScrollPane();
        scrllView.setContent(view);
        scrllView.setFitToWidth(true);
        Field[] fields = form.getFields();
        FilledData<Object> data = form.getData()[0];
        for(int i = 0; i < fields.length; i++){
        	try { view.getChildren().addAll(fields[i].getDisplay()); } catch (Exception e) { AlertGUI.show(e.getMessage()); }
        }
        
	    pane.add(table, 0, 0);
	    pane.add(scrllView, 0, 1);
	    setContent(pane);
	}
}
