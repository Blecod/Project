package lt.ktu.projektas.tabs;

import javafx.scene.control.TabPane;
import lt.ktu.projektas.utils.Form;

public class FormTabPane extends TabPane{

	public FormTabPane(){
		super();
	    
		setMaxSize(Double.MAX_VALUE, Double.MAX_VALUE);
	}
	public void openForm(Form form){
		
		getTabs().clear();
		switch (form.getType()) {
		case PRIVATE:
			ResultsTab tab1= new ResultsTab(form);

			DetailsTab tab2= new DetailsTab(form);

			getTabs().addAll(tab1,tab2);
			return;
		case PUBLIC:
			return;
		}
	}
}
