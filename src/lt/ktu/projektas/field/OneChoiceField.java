package lt.ktu.projektas.field;

import java.util.ArrayList;

import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.Spinner;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import lt.ktu.projektas.utils.Question;

public class OneChoiceField implements Field{
	private Question question;
	private ToggleGroup group;
	private ArrayList<RadioButton> radios;
	private RadioButton r_custom;
	private TextField custom;
	public OneChoiceField(){
		this.question = null;
		this.group = new ToggleGroup();
		this.custom = new TextField();
		this.radios = new ArrayList<>();
	}
	public OneChoiceField(Question question){
		this.question = question;
		this.group = new ToggleGroup();
		this.radios = new ArrayList<>();
		this.custom = new TextField();;
	}
	@Override
	public FieldType getType() {
		return FieldType.ONE_CHOICE;
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
			RadioButton temp = new RadioButton(c);
			temp.setToggleGroup(group);
			radios.add(temp);
			box.getChildren().add(temp);
		}
		r_custom = new RadioButton();
		r_custom.setToggleGroup(group);
		r_custom.getChildrenUnmodifiable().add(custom);
		box.getChildren().add(r_custom);
		return box;
	}
	@Override
	public void checkValue() throws Exception {
		if(group.getSelectedToggle() == null) throw new Exception("Value of the field was not set!");
	}
	@Override
	public String toString() {
		String s = getType().toString().toUpperCase();
		return "[ "+String.format("%1$-"+12+"s", s)+" ] "+question.getName();
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
