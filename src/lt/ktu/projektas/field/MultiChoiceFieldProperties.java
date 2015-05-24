package lt.ktu.projektas.field;

import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.control.Spinner;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import lt.ktu.projektas.utils.Question;

public class MultiChoiceFieldProperties implements Properties{
	private VBox box;
	private TextField name, desc;
	private Spinner<Integer> min, max;
	private CheckBox c_min, c_max, allow_custom, allow_empty;
	private TextArea choices;
	public MultiChoiceFieldProperties(){
		box = new VBox(2);
		Label l_name = new Label("Field name:");
		Label l_desc = new Label("Description(Optional):");
		Label l_choices = new Label("Choices(You must write every choice in diffrent line):");
		Label l_min = new Label("Minimum lenght:");
		Label l_max = new Label("Maximum lenght:");
		
		name = new TextField();
		desc = new TextField();
		choices = new TextArea();
		choices.setPrefHeight(150);
		allow_custom = new CheckBox("Allow custom");
		allow_empty = new CheckBox("Allow empty");
		c_min = new CheckBox("Enable");
		c_max = new CheckBox("Enable");
		
		
		min = new Spinner<Integer>(0, Integer.MAX_VALUE, 0);
		max = new Spinner<Integer>(0, Integer.MAX_VALUE, 0);

		
		
		box.getChildren().addAll(l_name, name, l_desc, desc, allow_custom, allow_empty, l_min, c_min, min, l_max, c_max, max, l_choices, choices);
	}
	@Override
	public Field getField() throws Exception {
		if(name.getText().length() == 0) throw new Exception("Please enter field name!");
		
		Question question = new Question();
		question.setName(name.getText());
		if(desc.getText().length()>0) question.setDescription(desc.getText());

		//question.setAllowCustom(allow_custom.isSelected());
		question.setAllowEmpty(allow_empty.isSelected());
		if(c_min.isSelected())question.setMinChoices(min.getValue());
		if(c_max.isSelected())question.setMinChoices(max.getValue());
		MultiChoiceField field = new MultiChoiceField();
		field.setQuestion(question);
		return field;
	}

	@Override
	public VBox getPropertiesDisplay(){
		return box;
	}


}
