package lt.ktu.projektas.field;


import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javafx.scene.control.Control;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import lt.ktu.projektas.utils.Question;

public class StringField implements Field{
	private Question question;
	private Control value;
	public StringField(){
		this.question = null;
		this.value = null;
	}
	public StringField(Question question){
		this.question = question;
		this.value = null;
	}

	public String getValue() throws Exception{
		if(value instanceof TextField)
			return ((TextField)value).getText();
		if(value instanceof TextArea)
			return ((TextArea)value).getText();
		throw new Exception("Can't get value, from not created elements!");
	}
	@Override
	public FieldType getType() {
		return FieldType.STRING;
	}
	@Override
	public VBox getDisplay() throws Exception{
		if(question.getName() == null) throw new Exception("This field isn't named!");
		VBox box = new VBox(3);
		box.setPrefWidth(Double.MAX_VALUE);
		Label l_name = new Label(question.getName());
		l_name.setFont(new Font(16));
		box.getChildren().add(l_name);
		if(question.getDescription() != null){
			Label l_desc = new Label(question.getDescription());
			l_desc.setFont(new Font(12));
			box.getChildren().add(l_desc);
		}
		value = (question.getAllowNewLines()) ? new TextArea(): new TextField();
		box.getChildren().add(value);
		return box;
	}
	@Override
	public void checkValue() throws Exception {
		if(value == null) throw new Exception("Value of the field was not set!\n(Field: "+question.getName()+")");
		String result = (value instanceof TextField)?((TextField)value).getText():((TextArea)value).getText();
		Pattern pattern = Pattern.compile("\\s");
		Matcher matcher = pattern.matcher(result);
		if(!question.getAllowWhitespace() && matcher.find()) throw new Exception("Field text can not have any spaces!\n(Field: "+question.getName()+")");
		if(result.length() > question.getMinValue()) throw new Exception("Field text must have more than "+question.getMinValue()+" characters!\n(Field: "+question.getName()+")");
		if(result.length() < question.getMaxValue()) throw new Exception("Field text must have not more than "+question.getMaxValue()+" characters!\n(Field: "+question.getName()+")");
	}
	@Override
	public String toString() {
		String s = getType().toString().toUpperCase();
		return "[ "+String.format("%1$-12s", s)+" ] "+question.getName();
	}
	@Override
	public Question getQuestion() {
		return question;
	}
	@Override
	public void setQuestion(Question question) {
		this.question = question;
	}
}
