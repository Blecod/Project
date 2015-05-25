package lt.ktu.projektas.field;

import java.util.ArrayList;

import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.Spinner;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import lt.ktu.formbackend.model.Question;

public class MultiChoiceField implements Field{
	private Question question;
	private ArrayList<CheckBox> cBoxes;
	private CheckBox c_custom;
	private TextField custom;
	public MultiChoiceField(){
		this.question = null;
		this.custom = new TextField();
		this.cBoxes = new ArrayList<>();
	}
	public MultiChoiceField(Question question){
		this.question = question;
		this.cBoxes = new ArrayList<>();
		this.custom = new TextField();;
	}
	@Override
	public FieldType getType() {
		return FieldType.MULTI_CHOICE;
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
		for(String c : question.getChoices()){
			CheckBox temp = new CheckBox(c);
			cBoxes.add(temp);
			box.getChildren().add(temp);
		}
		c_custom = new CheckBox();
		c_custom.getChildrenUnmodifiable().add(custom);
		box.getChildren().add(c_custom);
		return box;
	}
	@Override
	public void checkValue() throws Exception {

	}
	@Override
	public String toString() {
		String s = getType().toString().toUpperCase();
		return "["+String.format("%1$-"+12+"s", s)+"] "+question.getName();
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
