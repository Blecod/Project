package lt.ktu.projektas.field;

import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.control.Spinner;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import lt.ktu.formbackend.model.Question;

public class OneChoiceFieldProperties implements Properties{
	private VBox box;
	private TextField name, desc;
	private CheckBox allow_custom, allow_empty;
	private TextArea choices;
	public OneChoiceFieldProperties(){
		box = new VBox(2);
		Label l_name = new Label("Field name:");
		Label l_desc = new Label("Description(Optional):");
		Label l_choices = new Label("Choices(You must write every choice in diffrent line):");

		
		name = new TextField();
		desc = new TextField();
		choices = new TextArea();
		choices.setPrefHeight(150);
		allow_custom = new CheckBox("Allow custom");
		allow_empty = new CheckBox("Allow empty");
		

		
		
		box.getChildren().addAll(l_name, name, l_desc, desc, allow_custom, allow_empty, l_choices, choices);
	}
	@Override
	public Field getField() throws Exception {
		if(name.getText().length() == 0) throw new Exception("Please enter field name!");
		
		Question question = new Question();
		question.setName(name.getText());
		if(desc.getText().length()>0) question.setDescription(desc.getText());

		//question.setAllowCustom(allow_custom.isSelected());
		question.setAllowEmpty(allow_empty.isSelected());
		
		OneChoiceField field = new OneChoiceField();
		field.setQuestion(question);
		return field;
	}

	@Override
	public VBox getPropertiesDisplay(){
		return box;
	}


}
