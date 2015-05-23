package lt.ktu.projektas.field;

import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.control.Spinner;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import lt.ktu.projektas.utils.Question;

public class StringFieldProperties implements Properties{
	private VBox box;
	private TextField name, desc, def;
	private Spinner<Integer> min, max;
	private CheckBox c_min, c_max, allow_ws, allow_nl;
	public StringFieldProperties(){
		box = new VBox(2);
		Label l_name = new Label("Field name:");
		Label l_desc = new Label("Description(Optional):");
		Label l_min = new Label("Minimum lenght:");
		Label l_max = new Label("Maximum lenght:");
		Label l_def = new Label("Default value(Optional):");
		
		name = new TextField();
		desc = new TextField();
		def = new TextField();
		c_min = new CheckBox("Enable");
		c_max = new CheckBox("Enable");
		allow_ws = new CheckBox("Allow whitespaces");
		allow_nl = new CheckBox("Allow new lines");
		
		min = new Spinner<Integer>(0, Integer.MAX_VALUE, 0);
		max = new Spinner<Integer>(0, Integer.MAX_VALUE, 0);
		
		name.setPrefWidth(Double.MAX_VALUE);
		desc.setPrefWidth(Double.MAX_VALUE);
		box.setPrefWidth(Double.MAX_VALUE);
		
		box.getChildren().addAll(l_name, name, l_desc, desc, l_def, def, l_min, c_min, min, l_max, c_max, max, allow_ws, allow_nl);
	}
	@Override
	public Field getField() throws Exception {
		if(name.getText().length() == 0) throw new Exception("Please enter field name!");
		if(c_min.isSelected() && c_max.isSelected() && min.getValue() > max.getValue()) throw new Exception("Minimum value cannot be higher than maximum!");
		
		Question question = new Question();
		question.setName(name.getText());
		if(desc.getText().length()>0) question.setDescription(desc.getText());
		if(c_min.isSelected()) question.setMinValue(min.getValue());
		if(c_max.isSelected()) question.setMaxValue(max.getValue());
		question.setAllowNewLines(allow_nl.isSelected());
		question.setAllowWhitespace(allow_ws.isSelected());
		
		StringField field = new StringField();
		field.setQuestion(question);
		return field;
	}

	@Override
	public VBox getPropertiesDisplay(){
		return box;
	}


}
