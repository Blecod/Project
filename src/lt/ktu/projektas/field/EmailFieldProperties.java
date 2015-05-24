package lt.ktu.projektas.field;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.sun.javafx.binding.StringFormatter;

import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.control.Spinner;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import lt.ktu.projektas.utils.Question;

public class EmailFieldProperties implements Properties{
	private VBox box;
	private TextField name, desc, def, pro;
	private Spinner<Integer> min, max;
	private CheckBox c_min, c_max;
	public EmailFieldProperties(){
		box = new VBox(2);
		Label l_name = new Label("Field name:");
		Label l_desc = new Label("Description(Optional):");
		Label l_min = new Label("Minimum lenght:");
		Label l_max = new Label("Maximum lenght:");
		Label l_def = new Label("Default value(Optional):");
		Label l_pro = new Label("Providers(Separate with ',')(Optional):");
		
		name = new TextField();
		desc = new TextField();
		def = new TextField();
		pro = new TextField();
		c_min = new CheckBox("Enable");
		c_max = new CheckBox("Enable");

		min = new Spinner<Integer>(0, Integer.MAX_VALUE, 0);
		max = new Spinner<Integer>(0, Integer.MAX_VALUE, 0);
		
		name.setPrefWidth(Double.MAX_VALUE);
		desc.setPrefWidth(Double.MAX_VALUE);
		box.setPrefWidth(Double.MAX_VALUE);
		
		box.getChildren().addAll(l_name, name, l_desc, desc, l_def, def, l_pro, pro, l_min, c_min, min, l_max, c_max, max);
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
		if(!pro.getText().isEmpty()){
			String temp = pro.getText();
			temp = temp.replaceAll("\\s", "");
			String[] providers = temp.split(",");
			for(String provider:providers){
				Pattern pattern = Pattern.compile(".+\\..+$");
				Matcher matcher = pattern.matcher(provider);
		        if(!matcher.find()) throw new Exception("Incorrect providers!"); 
			}
		}
		EmailField field = new EmailField();
		field.setQuestion(question);
		return field;
	}

	@Override
	public VBox getPropertiesDisplay(){
		return box;
	}


}
