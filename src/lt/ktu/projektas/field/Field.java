/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package lt.ktu.projektas.field;


import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.EventHandler;
import javafx.scene.control.*;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.VBox;
import lt.ktu.formbackend.model.Question;


public interface Field{
	public Question getQuestion();
	public void setQuestion(Question question);
	public FieldType getType();
	public VBox getDisplay() throws Exception;
	public void checkValue() throws Exception;
	public String toString();
}
