package lt.ktu.projektas.field;

import javafx.scene.control.Label;
import javafx.scene.control.Spinner;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import lt.ktu.projektas.utils.Question;

public class IntegerField implements Field{
	private Question question;
	private Spinner<Integer> value;
	public IntegerField(){
		this.question = null;
	}
	public IntegerField(Question question){
		this.question = question;
		this.value = null;
	}
	@Override
	public Question getQuestion(){
		return question;
	}
	@Override
	public void setQuestion(Question question) {
		this.question = question;
	}
	@Override
	public FieldType getType() {
		return FieldType.INTEGER;
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
		value = new Spinner<Integer>(question.getMinValue(), question.getMaxValue(), (question.getMinValue()>0)?question.getMinValue():(question.getMaxValue()<0)?question.getMaxValue():0);
		box.getChildren().add(value);
		return box;
	}
	@Override
	public void checkValue() throws Exception {
		if(value == null) throw new Exception("Value of the field was not set!");
		
	}
	@Override
	public String toString() {
		String s = getType().toString().toUpperCase();
		return "["+String.format("%1$-"+12+"s", s)+"] "+question.getName()+"";
	}
	
}
