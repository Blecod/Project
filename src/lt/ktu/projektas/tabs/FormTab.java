package lt.ktu.projektas.tabs;

import javafx.geometry.Insets;
import javafx.scene.control.Control;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.Tab;
import javafx.scene.layout.VBox;
import lt.ktu.projektas.utils.Field;
import lt.ktu.projektas.utils.FilledData;
import lt.ktu.projektas.utils.Form;

public class FormTab  extends Tab{
	private final Form form;
	private final VBox view;
	private final ScrollPane scrllView;
	public FormTab(Form form){
		setText(form.getTitle());
		this.form = form;
        view = new VBox(0);
        view.setPadding(new Insets(10));
        view.setMaxWidth(Double.MAX_VALUE);
        view.getStyleClass().add("submitPage");
        scrllView = new ScrollPane();
        scrllView.setContent(view);
        scrllView.setFitToWidth(true);
        Field[] fields = form.getFields();
        FilledData<Object> data = form.getData()[0];
        for(int i = 0; i < fields.length; i++){
        	Label title = new Label(fields[i].getTitle());
        	fields[i].setComponentValue(data.getData()[i]);
        	fields[i].setComponentEditable(true);
        	Control control = fields[i].getComponent();
        	
        	view.getChildren().addAll(title, control);
        }
        
	    setContent(view);
	}
}
