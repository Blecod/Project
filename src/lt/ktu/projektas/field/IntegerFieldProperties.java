package lt.ktu.projektas.field;

import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.control.Spinner;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import lt.ktu.projektas.utils.Question;

public class IntegerFieldProperties implements Properties{
	private VBox box;
	private TextField name, desc;
	private Spinner<Integer> min, max;
	private CheckBox c_min, c_max, c_def;
	private Spinner<Integer> def;
	public IntegerFieldProperties(){
		box = new VBox(2);
		Label l_name = new Label("Field name:");
		Label l_desc = new Label("Description(Optional):");
		Label l_min = new Label("Minimum value:");
		Label l_max = new Label("Maximum value:");
		Label l_def = new Label("Default value(Optional):");
		
		name = new TextField();
		desc = new TextField();
		def = new Spinner<Integer>(Integer.MIN_VALUE, Integer.MAX_VALUE, 0);
		c_min = new CheckBox("Enable");
		c_max = new CheckBox("Enable");
		c_def = new CheckBox("Enable");
		
		min = new Spinner<Integer>(Integer.MIN_VALUE, Integer.MAX_VALUE, 0);
		max = new Spinner<Integer>(Integer.MIN_VALUE, Integer.MAX_VALUE, 0);
		
		name.setPrefWidth(Double.MAX_VALUE);
		desc.setPrefWidth(Double.MAX_VALUE);
		box.setPrefWidth(Double.MAX_VALUE);
		
		box.getChildren().addAll(l_name, name, l_desc, desc, l_def, c_def, def, l_min, c_min, min, l_max, c_max, max);
	}
	@Override
	public Field getField() throws Exception {
		if(name.getText().length() == 0) throw new Exception("Please enter field name!");
		if(c_min.isSelected() && c_max.isSelected() && min.getValue() > max.getValue()) throw new Exception("Minimum value cannot be higher than maximum!");
		if(c_min.isSelected() && c_max.isSelected() && (def.getValue() < min.getValue() || def.getValue() > max.getValue())) throw new Exception("Your selected default value, doesn't fit \nbetween minimum and maximum values!");
		
		Question question = new Question();
		question.setName(name.getText());
		if(desc.getText().length()>0) question.setDescription(desc.getText());
		if(c_min.isSelected()) question.setMinValue(min.getValue());
		if(c_max.isSelected()) question.setMaxValue(max.getValue());
		
		IntegerField field = new IntegerField();
		field.setQuestion(question);
		
		return field;
	}

	@Override
	public VBox getPropertiesDisplay(){
		return box;
	}

}
