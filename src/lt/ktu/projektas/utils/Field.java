/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package lt.ktu.projektas.utils;


import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.EventHandler;

import javafx.scene.control.*;
import javafx.scene.input.KeyEvent;

/**
 *
 * @author Domas
 */
public class Field{
    private final FieldType type;
    private final String  title;
    private Control component;
    public Field(FieldType type, String title){
        this.type = type;
        this.title = title;
        createComponent();
    }
    public FieldType getType(){
        return type;
    }
    public String getTitle(){
        return title;
    }
    @Override
    public String toString(){
        return title;
    }
    public void setComponentValue(Object value){
	    switch(type){
	    case TEXTAREA:
	        ((TextArea)component).setText(value.toString());
	        break;
	    case INTEGER:
	        ((IntegerField)component).setText(value.toString());
	        break;
	    case DOUBLE:
	        ((DoubleField)component).setText(value.toString());
	        break;
	    case BOOLEAN:
	        ((CheckBox)component).setSelected((Boolean) value);
	        break;
	    default:
	        ((TextField)component).setText(value.toString());
	        break;
        }
    }
    public void setComponentEditable(boolean value){
	    switch(type){
	    case TEXTAREA:
	        ((TextArea)component).setEditable(value);
	        break;
	    case INTEGER:
	        ((IntegerField)component).setEditable(value);
	        break;
	    case DOUBLE:
	        ((DoubleField)component).setEditable(value);
	        break;
	    case BOOLEAN:
	        ((CheckBox)component).setDisable(value);
	        break;
	    default:
	        ((TextField)component).setEditable(value);
	        break;
        }
    }    
    public String getValue(){
	    switch(type){
	    case TEXTAREA:
	        return ((TextArea)component).getText();
	    case INTEGER:
	    	return ((IntegerField)component).getText();
	    case DOUBLE:
	    	return ((DoubleField)component).getText();
	    case BOOLEAN:
	    	return (((CheckBox)component).isSelected())?"YES":"NO";
	    default:
	    	return ((TextField)component).getText();
        }
    }

    public void clearComponentValue(){
        switch(type){
            case TEXTAREA:
                ((TextArea)component).setText("");
                break;
            case INTEGER:
                ((IntegerField)component).setText("");
                break;
            case DOUBLE:
                ((DoubleField)component).setText("");
                break;
            case BOOLEAN:
                ((CheckBox)component).setSelected(false);
                break;
            default:
                ((TextField)component).setText("");
                break;
        }
    }
    public Control getComponent(){
        return component;
    }
    public void createComponent(){
        switch(type){
            case TEXTAREA:
                component = new TextArea();
                component.setMaxWidth(Double.MAX_VALUE);
                component.setPrefHeight(150);
                break;
            case INTEGER:
                component = new IntegerField();
                ((IntegerField)component).setText("");
                component.setMaxWidth(Double.MAX_VALUE);
                component.setPrefHeight(25);
                break;
            case DOUBLE:
            	component = new DoubleField();
                ((DoubleField)component).setText("");
                component.setMaxWidth(Double.MAX_VALUE);
                component.setPrefHeight(25);
                break;
            case BOOLEAN:
                component = new CheckBox();
                break;
            default:
                component = new TextField();
                component.setMaxWidth(Double.MAX_VALUE);
                component.setPrefHeight(25);
                break;
        }
    }
    private class IntegerField extends TextField
    {
        @Override
        public void replaceText(int start, int end, String text)
        {
            if (validate(text))
            	super.replaceText(start, end, text);
        }

        @Override
        public void replaceSelection(String text)
        {
            if (validate(text))
            	super.replaceSelection(text);
        }

        private boolean validate(String text)
        {
            return ("".equals(text) || text.matches("[0-9]"));
        }
    }
    private class DoubleField extends TextField
    {
    	public DoubleField() {
    		super();
    	      addEventFilter(KeyEvent.KEY_TYPED, new EventHandler<KeyEvent>() {
    	         @Override
    	         public void handle(KeyEvent event) {
    	            if (!validate(getText())) event.consume();
    	         }
    	      });
    	      textProperty().addListener(new ChangeListener<String>() {
    	         @Override
    	         public void changed(ObservableValue<? extends String> observableValue, String oldValue, String newValue) {
    	            if(!validate(newValue)) setText(oldValue);
    	         }
    	      });		
    	}
    	private boolean validate(final String value) {
    		if (value.length() == 0 || value.equals("")) return true;
    		Pattern pattern = Pattern.compile("([.])");
    		Matcher matcher = pattern.matcher(value);
    		int count = 0;
    		while (matcher.find()) count++;
    		if(count >1) return false;
    		if (value.endsWith("."))return true;
    		try {
    		   Double.parseDouble(value);
    		   return true;
    		}catch (NumberFormatException ex) {
    		   return false;
    		 }
    	}
    }
}
