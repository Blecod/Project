package lt.ktu.projektas.tabs;

import javafx.geometry.Insets;
import javafx.scene.control.Control;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.Tab;
import javafx.scene.layout.VBox;
import lt.ktu.projektas.AlertGUI;
import lt.ktu.projektas.field.Field;
import lt.ktu.projektas.field.FilledData;
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
        	try { view.getChildren().addAll(fields[i].getDisplay()); } catch (Exception e) { AlertGUI.show(e.getMessage()); }
        }
        
	    setContent(view);
	}
}
